package edu.harvard.i2b2.fhir.fetcher;

import java.sql.Date;


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
	private static final long CACHE_DELAY = 1000;// milliseconds
	static Logger logger = LoggerFactory.getLogger(Fetcher.class);
	
	
	@Autowired
	Cache cache;

	@Autowired
	FetchStatusService fetchStatusService;

	@Autowired
	Converter converter;

	@Override
	public String getData(String fullUri) throws FetcherException {
		
		String fhirBundleXml = null;
		FetchRequest req=new FetchRequest(fullUri);
		String fsId=req.getId();
		try{
		// wait for fetchStatus to unlock
		while (fetchStatusService.isLocked(fsId)) {
			try {
				Thread.sleep(SLEEP_DURATION);
			} catch (InterruptedException e) {
				throw new FetcherException(e.getMessage(),e);
			}
		}
			// lock fetchStatus
			fetchStatusService.setFetching(fsId);

			Date lastFetchDT = fetchStatusService.getLastFetchDT(fsId);
			Date lastCacheUpdateDT = fetchStatusService.getLastCacheUpdateDT(fsId);
			
			
			if ((lastFetchDT==null)||
					lastCacheUpdateDT==null||
					((lastCacheUpdateDT.getTime() - lastFetchDT.getTime()) > CACHE_DELAY)
					) {
				// retrieve delta
				try {
					fhirBundleXml = fetchData(req);
					logger.debug("fhirBundleXml:"+fhirBundleXml);
				} catch (ConverterException e) {
					logger.error(">>>"+e.getMessage(),e);
				}
				//updateCache(fsId, fhirBundleXml);
			}

			// find last update date of cache

			// update cache

			// return data from cache
			//fhirBundleXml=cache.get(fullUri);
		} catch (Exception e) {
			throw new FetcherException(e.getMessage(),e);
		}
			fetchStatusService.setUnlocked(fsId);
			return fhirBundleXml;
			
	}

	private void updateCache(String fsId, String fhirBundleXml) throws CacheException {
		fetchStatusService.setCaching(fsId);
		logger.trace("will put:"+fhirBundleXml);
		cache.put(fhirBundleXml);
	}

	private String fetchData(FetchRequest req) throws ConverterException {
		fetchStatusService.setFetching(req.fullUrl);
		return converter.getWebServiceResponse(req);
		
	}
}
