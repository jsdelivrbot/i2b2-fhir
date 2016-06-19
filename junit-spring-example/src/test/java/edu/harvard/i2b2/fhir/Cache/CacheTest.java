package edu.harvard.i2b2.fhir.Cache;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import edu.harvard.i2b2.fhir.cache.CacheImpl;
import edu.harvard.i2b2.fhir.modules.Cache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class CacheTest {

	@Autowired
	Cache cache;
	
	@Test
	public void test() {
		//cache= new CacheImpl();
		cache.get("Patient");
	}

}
