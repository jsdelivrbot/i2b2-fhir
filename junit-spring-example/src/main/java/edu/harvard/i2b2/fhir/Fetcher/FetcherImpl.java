package edu.harvard.i2b2.fhir.fetcher;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.converter.ConverterException;
import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatusService;
import edu.harvard.i2b2.fhir.modules.Cache;
import edu.harvard.i2b2.fhir.modules.CacheException;
import edu.harvard.i2b2.fhir.modules.Converter;
import edu.harvard.i2b2.fhir.modules.Fetcher;

/*
 * Checks if the cache is updated for that resource
 * If not it calls converter to get delta of the data and updates cache
 * else it gets data from cache
 */
@Component
public class FetcherImpl implements Fetcher {
	private static final long SLEEP_DURATION = 1000;// milliseconds
	private static final long CACHE_DELAY = 1;// milliseconds
	static Logger logger = LoggerFactory.getLogger(Fetcher.class);

	@Autowired
	Cache cache;

	@Autowired
	FetchStatusService fetchStatusService;

	@Autowired
	Converter converter;

	@Override
	public String getData(String fullUri) throws FetcherException {

		List<String> fhirBundles = null;
		String cacheResponse=null;
		FetchRequest req = new FetchRequest(fullUri);
		String fsId = req.genId();
		try {
			// wait for fetchStatus to unlock
			
			//if (1 == 1)
				//return fetchStatusService.getFetchStatus(fsId).toString();
			while (isFetchStatusLocked(fsId)) {
				try {
					Thread.sleep(SLEEP_DURATION);
					logger.trace("in while loop");
					// return getData(fullUri);
				} catch (InterruptedException e) {
					throw new FetcherException(e.getMessage(), e);
				}
			}
			fetchStatusService.setFetching(fsId);
			// lock fetchStatus

			// Date lastFetchDT = fetchStatusService.getLastFetchDT(fsId);
			Date  lastCacheUpdateDT=
				fetchStatusService.getLastCacheUpdateDT(fsId);
			
			if(lastCacheUpdateDT!=null){
				req.setStartDate(lastCacheUpdateDT);
				logger.debug("lastCacheUPdateDT:"+lastCacheUpdateDT.toString());
			}else{
				logger.debug("lastCacheUPdateDT is  null");
			}

			// if ((lastFetchDT==null)||
			// lastCacheUpdateDT==null||
			// ((lastCacheUpdateDT.getTime() - lastFetchDT.getTime()) >
			// CACHE_DELAY)
			// ) {
			// retrieve delta
			//Thread.sleep(15000);
			
			try {
				fhirBundles=fetchData(req);
				
				logger.debug("fhirBundleXml:" + fhirBundles);
			} catch (ConverterException e) {
				logger.error(">>>" + e.getMessage(), e);
			}
			
			 
			// }

			// find last update date of cache

			// update cache

			// return data from cache
			updateCache(fsId, fhirBundles);
			cacheResponse= cache.get(req);
	
		} catch (Exception e) {
			fetchStatusService.setUnlocked(fsId);
			throw new FetcherException(e.getMessage(), e);
		}
		fetchStatusService.setUnlocked(fsId);
		
		return cacheResponse; 

	}

	private boolean isFetchStatusLocked(String fsId) {
		 
		 
		return fetchStatusService.isLocked(fsId);

	}

	private void updateCache(String fsId, List<String> fhirBundles) throws CacheException {
		// fetchStatusService.setCaching(fsId);
		for(String xml:fhirBundles){
			logger.trace("will put in cache:" + xml);
			cache.put(xml);
		}
		
		
	}

	private List<String> fetchData(FetchRequest req) throws ConverterException {
		return converter.fetchWebServiceData(req);

	}
}
