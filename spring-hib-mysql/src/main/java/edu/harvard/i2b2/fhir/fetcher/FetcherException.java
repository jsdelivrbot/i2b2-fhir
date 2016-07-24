package edu.harvard.i2b2.fhir.fetcher;

public class FetcherException extends Exception {

	public FetcherException(String message, Exception e) {
		super(message,e);
	}

}
