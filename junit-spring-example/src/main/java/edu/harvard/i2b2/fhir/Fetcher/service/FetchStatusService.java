package edu.harvard.i2b2.fhir.Fetcher.service;

import java.sql.Date;

public interface FetchStatusService {

	boolean isLocked(String string);

	void setFetching(String fetchStatusId);

	void setCaching(String fetchStatusId);

	void setUnlocked(String fetchStatusId);

	Date getLastCacheUpdateDT(String fetchStatusId);

	Date getLastFetchDT(String fetchStatusId);

	void createFetchStatus(String id);
	
	
	
}
