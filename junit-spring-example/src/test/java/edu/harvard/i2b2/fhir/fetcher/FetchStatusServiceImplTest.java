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
import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatus;
import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatusRespository;
import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatusService;
import edu.harvard.i2b2.fhir.modules.Cache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class},loader=AnnotationConfigContextLoader.class)
public class FetchStatusServiceImplTest {

	static Logger logger = LoggerFactory.getLogger(FetchStatusServiceImplTest.class);
	
	@Autowired
	FetchStatusRespository fetchStatusRepo;
	
	@Autowired
	FetchStatusService fetchStatusService;
	
	
	@Test
	public void create() {
		FetchStatus fs = new FetchStatus();fs.setId("id1");
		fetchStatusRepo.save(fs);
		logger.debug("count:"+fetchStatusRepo.count());
		fetchStatusService.createFetchStatus("Patient"+"-"+123);
		
	}
	
	
}
