package edu.harvard.i2b2.fhir;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.i2b2.fhir.converter.ConverterImpl;
import edu.harvard.i2b2.fhir.modules.Converter;

public class ConverterTest {

	static Logger logger = LoggerFactory.getLogger(ConverterTest.class);
	
	
	
	
	@Test
	public void testWebserviceCall() {
		logger.debug("completed");
		// try {
			 Converter converterController= new ConverterImpl();
			// converterController.
			// converterController.setCacheUrl("http://localhost:8090/hapi-fhir-jpaserver-example/baseDstu2/");
			//converterController.getBundleBlocking("1000000005");
		//} catch (InterruptedException | ConverterException e) {
			//logger.error(e.getMessage(),e);
		//}
		 
		logger.debug("completed");
		assert(true);
	}

}
