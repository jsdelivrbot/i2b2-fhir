package edu.harvard.i2b2.fhir.Cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.harvard.i2b2.fhir.cache.CacheImpl;

@Configuration
public class AppConfig {
	@Bean
	public CacheImpl getCache() {
		return new CacheImpl();
	}
}