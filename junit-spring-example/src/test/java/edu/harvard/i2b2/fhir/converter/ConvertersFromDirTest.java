package edu.harvard.i2b2.fhir.converter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertersFromDirTest {
	static Logger logger = LoggerFactory.getLogger(ConvertersFromDirTest.class);

	@Test
	public void test() {
		try {
			ConvertersFromDir cd = new ConvertersFromDir("confidential/converterRootDir");
			logger.trace("list" + cd.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}
