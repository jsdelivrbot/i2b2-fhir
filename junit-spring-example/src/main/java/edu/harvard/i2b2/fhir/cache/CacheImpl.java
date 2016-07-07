package edu.harvard.i2b2.fhir.cache;

import java.util.Arrays;

import javax.annotation.Resource;

import org.hibernate.cache.CacheException;
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


@Component
public class CacheImpl implements Cache {

	static Logger logger = LoggerFactory.getLogger(Cache.class);

	String cacheUri;
	
	
	public String getCacheUri() {
		return cacheUri;
	}

	public void setCacheUri(String cacheUri) {
		this.cacheUri = cacheUri;
	}

	public String put(String xml) {
		final String uri = "http://localhost:8090/hapi-fhir-jpaserver-example/baseDstu2/";
		logger.info("Will put:" + xml);

		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/xml+fhir");
		headers.set("Accept", "application/xml+fhir");
		HttpEntity<String> entity = new HttpEntity<String>(xml, headers);
		try {
		response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
			logger.debug(response.toString());
		} catch (HttpClientErrorException e) {
			logger.error("error is:"+e.getMessage());
			logger.error("error detail:"+e.getResponseBodyAsString());
			return e.getResponseBodyAsString();
		}catch (Exception e) {
			logger.error("error is:"+e.getMessage());
		}
		if (response==null) throw new CacheException("No response from cache");
		return response.toString();
	}

	public String get(String uri) {
		uri=uri.replaceAll("subject=", "subject=a");
		final String baseUri = "http://localhost:8090/hapi-fhir-jpaserver-example/baseDstu2/";
		uri=baseUri+uri;
		
		
		logger.info("Will get:" + uri);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/xml+fhir");
		headers.set("Accept", "application/xml+fhir");
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		logger.debug(result.toString());
		return result.getBody().trim();
	}
}
