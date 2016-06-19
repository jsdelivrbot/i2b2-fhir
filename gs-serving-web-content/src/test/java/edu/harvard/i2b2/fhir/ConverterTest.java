package edu.harvard.i2b2.fhir;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.harvard.i2b2.fhir.cache.Cache;
import edu.harvard.i2b2.fhir.converter.Application;
import edu.harvard.i2b2.fhir.converter.ConverterController;
import edu.harvard.i2b2.fhir.converter.ConverterException;
import hello.SpringWebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebConfig.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class ConverterTest {

	static Logger logger = LoggerFactory.getLogger(ConverterTest.class);
	
	@Autowired
	ConverterController converterController;
	
	
	
	
	@Test
	public void testWebserviceCall() {
		logger.debug("completed");
		 try {
			converterController.getBundleBlocking("1000000005");
		} catch (InterruptedException | ConverterException e) {
			logger.error(e.getMessage(),e);
		}
		logger.debug("completed");
		assert(true);
	}

}
