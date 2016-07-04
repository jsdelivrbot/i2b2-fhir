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
import edu.harvard.i2b2.fhir.fetcher.AppConfigFetcher;
import edu.harvard.i2b2.fhir.modules.Fetcher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfigFetcher.class},loader=AnnotationConfigContextLoader.class)
public class FetcherImplTest {

	static Logger logger = LoggerFactory.getLogger(FetcherImplTest.class);
	
	@Autowired
	Fetcher fetcher;
	
	@Test
	public void getPatient() {
		try {
			logger.debug(">>>>"+fetcher.getData("Patient/1000000009"));
		} catch (FetcherException e) {
			logger.error(e.getMessage(),e);
		}
		
	}
	
	@Test
	public void getObservation() {
		try {
			logger.debug(">>>>"+fetcher.getData("Observation?subject=1000000009"));
		} catch (FetcherException e) {
			logger.error(e.getMessage(),e);
		}
	}	
}
