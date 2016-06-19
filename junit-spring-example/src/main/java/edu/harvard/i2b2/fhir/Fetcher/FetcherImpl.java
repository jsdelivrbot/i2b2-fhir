package edu.harvard.i2b2.fhir.Fetcher;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import edu.harvard.i2b2.fhir.Fetcher.entity.Conversion;
import edu.harvard.i2b2.fhir.Fetcher.repository.ConversionRespository;
import edu.harvard.i2b2.fhir.Fetcher.repository.FetchStatusRespository;
import edu.harvard.i2b2.fhir.Fetcher.service.ConversionService;
import edu.harvard.i2b2.fhir.Fetcher.service.FetchStatusService;
import edu.harvard.i2b2.fhir.modules.Cache;
import edu.harvard.i2b2.fhir.modules.Fetcher;

/*
 * Checks if the cache is updated for that resource
 * If not it calls converter to get delta of the data and updates cache
 * else it gets data from cache
 */

public class FetcherImpl implements Fetcher {
	private static final long SLEEP_DURATION = 1000;// milliseconds
	private static final long CACHE_DELAY = 1000;// milliseconds

	@Autowired
	Cache cache;

	@Autowired
	Conversion conversion;

	@Autowired
	FetchStatusService fetchStatusService;

	@Autowired
	ConversionService conversionService;

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

			if ((lastCacheUpdateDT.getTime() - lastFetchDT.getTime()) > CACHE_DELAY) {
				// retrieve delta
				fhirBundleXml = fetchData(fsId, lastFetchDT);
				updateCache(fsId, fhirBundleXml);
			}

			// find last update date of cache

			// update cache

			// return data from cache
			fetchStatusService.setUnlocked(fsId);
			return null;
		

	}

	private void updateCache(String fsId, String fhirBundleXml) {
		fetchStatusService.setCaching(fsId);
		cache.put(fhirBundleXml);
	}

	private String fetchData(String fsId, Date StartDate) {
		fetchStatusService.setFetching(fsId);
		return null;
	}
}
