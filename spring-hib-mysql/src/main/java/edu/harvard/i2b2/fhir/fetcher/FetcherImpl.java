package edu.harvard.i2b2.fhir.fetcher;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatusServiceImpl;

/*
 * Checks if the cache is updated for that resource
 * If not it calls converter to get delta of the data and updates cache
 * else it gets data from cache
 */
@Component
public class FetcherImpl {
	private static final long SLEEP_DURATION = 1000;// milliseconds
	private static final long CACHE_DELAY = 1;// milliseconds
	static Logger logger = LoggerFactory.getLogger(FetcherImpl.class);

	
	@Autowired
	FetchStatusServiceImpl fetchStatusService;

	

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
		
			// lock fetchStatus

			// Date lastFetchDT = fetchStatusService.getLastFetchDT(fsId);
			

			Thread.sleep(15000);
			
		
			
			
	
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

	
}
