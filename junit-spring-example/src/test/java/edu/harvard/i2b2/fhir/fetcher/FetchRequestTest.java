package edu.harvard.i2b2.fhir.fetcher;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import edu.harvard.i2b2.fhir.modules.Cache;


public class FetchRequestTest {
	static Logger logger = LoggerFactory.getLogger(FetchRequestTest.class);
	FetchRequest f;
	@Test
	public void test() {
		f = new FetchRequest("Patient?id=example");
		assertEquals("Patient",f.getPath());
		assertEquals("id=example",f.getQueryString());
		assertEquals("example",f.getResourceId());
		
		f = new FetchRequest("Patient/example");
		assertEquals("Patient/example",f.getPath());
		assertEquals(null,f.getQueryString());
		assertEquals("example",f.getResourceId());
		
		f = new FetchRequest("Observation?subject=1");
		assertEquals("Observation",f.getPath());
		assertEquals("subject=1",f.getQueryString());
		assertEquals("1",f.getResourceId());
		
		f = new FetchRequest("Observation?subject=1");
		assertEquals("1",f.getResourceId());
		
		f = new FetchRequest("MedicationPrescription?patient=1000000005&_include=MedicationPrescription.Medication");
		assertEquals("1000000005",f.getResourceId());
		assertEquals("1000000005",f.getPatientId());
		//FetchRequest f = new FetchRequest("/Patient/example");
		logger.debug("id:");
		//fail("Not yet implemented");
	}

}
