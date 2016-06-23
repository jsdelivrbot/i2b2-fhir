package edu.harvard.i2b2.fhir.modules;

import edu.harvard.i2b2.fhir.fetcher.FetcherException;

public interface Fetcher {
	
	String getData(String fullUri) throws FetcherException;

	
}
