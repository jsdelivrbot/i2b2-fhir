package edu.harvard.i2b2.fhir.modules;

public interface Cache {
	public String put(String xml) ;
	public String get(String url) ;
}
