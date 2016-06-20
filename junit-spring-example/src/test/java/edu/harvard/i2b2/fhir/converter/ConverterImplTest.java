package edu.harvard.i2b2.fhir.converter;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.google.common.io.Resources;

import edu.harvard.i2b2.fhir.modules.Converter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class},loader=AnnotationConfigContextLoader.class)
public class ConverterImplTest {
	static Logger logger = LoggerFactory.getLogger(ConverterImplTest.class);
	
	@Autowired
	ConversionRepository repository;
	
	
	@Autowired
	Converter converter;
	
	@Before
	public void setup(){
		Conversion conversion= new Conversion();
		try {
			conversion.setCategory("i2b2-Demographics");
			conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
			conversion.setWebRequestXmlTemplate(new String(Files.readAllBytes(Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xml").toURI()))));
			conversion.setxQueryScript(new String(Files.readAllBytes(Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xquery").toURI()))));
			conversion.setResourceNames("Patient");
			conversion.setProperties("DOMAIN=i2b2demo\nUSER=demo");
			repository.save(conversion);
			
			conversion= new Conversion();
			conversion.setCategory("i2b2-Labs");
			conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
			conversion.setWebRequestXmlTemplate(new String(Files.readAllBytes(Paths.get(getClass().getResource("/conversions/i2b2/Observation//i2b2RequestTemplateForAPatient.xml").toURI()))));
			conversion.setxQueryScript(new String(Files.readAllBytes(Paths.get(getClass().getResource("/conversions/i2b2/Observation/i2b2ToFHIR_default.xquery").toURI()))));
			conversion.setResourceNames("Observation");
			conversion.setProperties("DOMAIN=i2b2demo\nUSERNAME=demo\nPASSWORD=demouser\nXCATX=labs\nXPATHX=\\\\i2b2_LABS\\i2b2\\Labtests\\\n(:RESOURCE_FUNCTION:)={local:processLabObs(<A>{$labObs}</A>)/entry}");
			repository.save(conversion);
		} catch (IOException | URISyntaxException e) {
			logger.error(e.getMessage(),e);
		}
		
	}
	
	@Test
	public void test() {
		logger.debug("count:"+repository.count());
		try {
			//logger.debug(converter.getWebServiceResponse("Patient", "1000000005", java.sql.Date.valueOf("2001-01-01"), java.sql.Date.valueOf("2016-01-01")));
			logger.debug("FHIR BUNDLE OUTPUT:"+converter.getWebServiceResponse("Observation", "1000000005", java.sql.Date.valueOf("2001-01-01"), java.sql.Date.valueOf("2016-01-01")));
			
		} catch (ConverterException e) {
			logger.error(e.getMessage(),e);
		}
	}

}
