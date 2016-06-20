package edu.harvard.i2b2.fhir.modules;

import java.sql.Date;

import edu.harvard.i2b2.fhir.converter.Conversion;
import edu.harvard.i2b2.fhir.converter.ConverterException;

public interface Converter {
	public String getWebServiceResponse(String resourceName,String patientId,Date startDT,Date endDT ) throws ConverterException;

//	String composeRequestXml(Conversion conversion,String resourceName, String patientId, Date startDT, Date endDT);
}
