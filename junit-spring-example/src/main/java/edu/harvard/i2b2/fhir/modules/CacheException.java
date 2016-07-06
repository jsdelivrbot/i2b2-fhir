package edu.harvard.i2b2.fhir.modules;

public class CacheException extends Exception {

	public CacheException(String message, InterruptedException e) {
		super(message,e);
	}

	public CacheException(String message) {
		super(message);
	}
}
