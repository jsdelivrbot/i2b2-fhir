package edu.harvard.i2b2.fhir.fetcher;

import java.util.Arrays;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import edu.harvard.i2b2.fhir.modules.Cache;

//@Component
public class CacheImpl1 implements Cache {

	static Logger logger = LoggerFactory.getLogger(Cache.class);

	String cacheUri;
	
	
	public String getCacheUri() {
		return cacheUri;
	}

	public void setCacheUri(String cacheUri) {
		this.cacheUri = cacheUri;
	}

	public String put(String xml) {
		
		return "SUCCESS";
	}

	public String get(String uri) {
		
		return "<Patient></Patient>";
	}
}
