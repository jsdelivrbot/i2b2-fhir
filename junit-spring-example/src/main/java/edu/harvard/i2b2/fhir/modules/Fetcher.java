package edu.harvard.i2b2.fhir.modules;

import edu.harvard.i2b2.fhir.Fetcher.FetcherException;

public interface Fetcher {
	
	String getData(String resourceCategory,String patientId, String startDate, String endDate) throws FetcherException;

	
}
