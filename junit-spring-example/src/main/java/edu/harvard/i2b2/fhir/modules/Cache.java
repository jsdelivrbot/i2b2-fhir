package edu.harvard.i2b2.fhir.modules;

import edu.harvard.i2b2.fhir.fetcher.FetchRequest;

public interface Cache {
	public String put(String xml) throws CacheException ;
	public String get(FetchRequest req) throws CacheException ;
}
