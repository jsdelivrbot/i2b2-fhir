package edu.harvard.i2b2.fhir.modules;

public class ConversionException extends Exception {

	public ConversionException(Exception e) {
		super(e.getMessage(),e);
	}

}
