package edu.harvard.i2b2.fhir.fetcher;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import edu.harvard.i2b2.fhir.Oldconverter.ConverterController;
import edu.harvard.i2b2.fhir.cache.CacheImpl;
import edu.harvard.i2b2.fhir.modules.Cache;
import edu.harvard.i2b2.fhir.modules.Fetcher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class},loader=AnnotationConfigContextLoader.class)
public class FetcherImplTest {

	static Logger logger = LoggerFactory.getLogger(FetcherImplTest.class);
	
	@Autowired
	Fetcher fetcher;
	
	@Test
	public void getData() {
		try {
			logger.debug(">>>>"+fetcher.getData("Patient", "sample", "01-01-2015", "01-01-2016"));
		} catch (FetcherException e) {
			logger.error(e.getMessage(),e);
		}
		//logger.debug("count:"+fetchStatusRepo.count());
		
		
	}
	
	
}
