package edu.harvard.i2b2.fhir.Oldconverter;


public interface Converter {

	public String getFhirXmlBundle(String pid) throws ConverterException;
}
