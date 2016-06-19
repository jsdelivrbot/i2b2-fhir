package edu.harvard.i2b2.fhir.Fetcher;

public class FetcherException extends Exception {

	public FetcherException(String message, InterruptedException e) {
		super(message,e);
	}

}
