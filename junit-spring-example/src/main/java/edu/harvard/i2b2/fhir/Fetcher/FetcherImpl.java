package edu.harvard.i2b2.fhir.fetcher;

import java.sql.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.converter.ConverterException;
import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatusService;
import edu.harvard.i2b2.fhir.modules.Cache;
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
	public String getData(String resourceName, String patientId, String startDate, String endDate) throws FetcherException {
		String fsId = resourceName + "-" + patientId;
		String fhirBundleXml = null;

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
					fhirBundleXml = fetchData(fsId,resourceName, patientId,lastFetchDT,null);
				} catch (ConverterException e) {
					logger.error(e.getMessage(),e);
				}
				updateCache(fsId, fhirBundleXml);
			}

			// find last update date of cache

			// update cache

			// return data from cache
			fetchStatusService.setUnlocked(fsId);
			return "FETCHED:SUCCESS";
		

	}

	private void updateCache(String fsId, String fhirBundleXml) {
		fetchStatusService.setCaching(fsId);
		cache.put(fhirBundleXml);
	}

	private String fetchData(String fsId,String resourceName, String patientId, Date startDT,Date endDT) throws ConverterException {
		fetchStatusService.setFetching(fsId);
		converter.getWebServiceResponse(resourceName, patientId, startDT, endDT);
		return null;
	}
}
