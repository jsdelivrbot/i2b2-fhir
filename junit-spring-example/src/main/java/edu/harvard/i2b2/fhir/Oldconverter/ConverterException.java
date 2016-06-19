package edu.harvard.i2b2.fhir.Oldconverter;

public class ConverterException extends Exception {

	public ConverterException(Exception e) {
		super(e.getMessage(),e);
	}

}
