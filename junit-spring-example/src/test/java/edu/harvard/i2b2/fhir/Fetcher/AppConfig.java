package edu.harvard.i2b2.fhir.Fetcher;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.harvard.i2b2.fhir.Fetcher.entity.Conversion;
import edu.harvard.i2b2.fhir.Fetcher.entity.FetchStatus;
import edu.harvard.i2b2.fhir.Fetcher.repository.FetchStatusRespository;
import edu.harvard.i2b2.fhir.Fetcher.service.FetchStatusServiceImpl;
import edu.harvard.i2b2.fhir.cache.CacheImpl;

//@SpringBootApplication

@Configuration
@ComponentScan( { "edu.harvard.i2b2.fhir.Fetcher*" })
@EnableAutoConfiguration

//@Configuration
//@ComponentScan( { "edu.harvard.i2b2.fhir.Fetcher.repository","edu.harvard.i2b2.fhir.Fetcher.service" })
//@EntityScan({ "edu.harvard.Fetcher*" }) 
//@EnableJpaRepositories
//@EnableAutoConfiguration
public class AppConfig {
	
	//@Bean
	public FetchStatusServiceImpl getFetchStatusServiceImpl(){
		return new FetchStatusServiceImpl();
	}
	
	
}