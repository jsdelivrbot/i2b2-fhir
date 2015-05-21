package edu.harvard.i2b2;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import junit.framework.Assert;

import org.hl7.fhir.Medication;
import org.hl7.fhir.MedicationStatement;
import org.hl7.fhir.Patient;
import org.hl7.fhir.Resource;
import org.hl7.fhir.ResourceReference;
import org.junit.Test;

import edu.harvard.i2b2.fhir.core.MetaData;
import edu.harvard.i2b2.fhir.core.MetaResource;
import edu.harvard.i2b2.fhir.core.MetaResourceSet;
import edu.harvard.i2b2.fhir.FhirUtil;
import edu.harvard.i2b2.fhir.MetaResourceDb;
import edu.harvard.i2b2.fhir.MetaResourceSetTransform;
import edu.harvard.i2b2.fhir.Utils;
import edu.harvard.i2b2.fhir.XQueryUtil;

public class xmlIOMetaResourceSet {

	// @Test
	public void test2() throws JAXBException, IOException,
			DatatypeConfigurationException {
		final String BOOKSTORE_XML = "./tmp.xml";

		MetaResourceSet s1 = new MetaResourceSet();
		ArrayList<MetaResource> list = new ArrayList<MetaResource>();

		// create books
		MetaResource r1 = new MetaResource();
		MetaData md1 = new MetaData();
		//md1.setId("medication/1");
		GregorianCalendar gc = new GregorianCalendar();

		md1.setLastUpdated(DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gc));

		Medication m1 = new Medication();
		org.hl7.fhir.String str1 = new org.hl7.fhir.String();
		str1.setValue("med1");
		m1.setName(str1);

		r1.setMetaData(md1);
		r1.setResource(m1);
		list.add(r1);
		s1.getMetaResource().add(r1);
		s1.getMetaResource().add(r1);

		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(MetaResourceSet.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to System.out
		m.marshal(s1, System.out);

		// Write to File
		m.marshal(s1, new File(BOOKSTORE_XML));

		// get variables from our xml file, created before
		System.out.println();
		System.out.println("Output from our XML File: ");
		Unmarshaller um = context.createUnmarshaller();
		System.out.println("FhirResourceSet: ");
		MetaResourceSet s2 = (MetaResourceSet) um.unmarshal(new FileReader(
				BOOKSTORE_XML));
		System.out.println("FhirResourceSet: "
				+ s2.getMetaResource().get(0).getResource().getId());

	}

	//@Test
	public void Test2() throws JAXBException, FileNotFoundException {
		final String xmlFileName = "example/fhir/MetaResourceSet3.xml";
		String xmlString = Utils.getFile(xmlFileName);
		
		MetaResourceSet s2 = MetaResourceSetTransform.MetaResourceSetFromXml(xmlString); 
		// System.out.println("FhirResourceSet: "
		// +s2.getMetaResource().get(0).getMetaData().getId());
		System.out.println("FhirResourceSet: "
				+ ((Medication) s2.getMetaResource().get(0).getResource())
						.getName().getValue());
		assertEquals("NDC:00641276641","FhirResourceSet: "
				+ ((Medication) s2.getMetaResource().get(0).getResource())
						.getCode().getCoding().get(0).getCode().getValue());

	}

	
	//@Test
		public void printXqueryResult() throws JAXBException {
			String xmlString = PdoEGtoFhirBundle.defaultread();
			System.out.println(xmlString);
		}
	//@Test
	public void testI2b2toFhirMedPDOtransform() throws JAXBException {
		String xmlString = PdoEGtoFhirBundle.defaultread();
		System.out.println(xmlString);
		MetaResourceSet s = MetaResourceSetTransform.MetaResourceSetFromXml(xmlString); 
		testResources(s);
	}

	private void testResources(MetaResourceSet s2){
		// System.out.println(Utils.getFile(xmlFileName));
				
				// System.out.println("FhirResourceSet: "
				// +s2.getMetaResource().get(0).getMetaData().getId());
				Resource r1 = s2.getMetaResource().get(1).getResource();
				if (Medication.class.isInstance(r1)) {

					System.out.println("FhirResourceSet: "
							+ ((Medication) r1).getCode().getCoding().get(0).getCode()
									.getValue());
					System.out.println("FhirResourceSet: "
							+ ((Medication) r1).getText().getStatus().getValue());
				} else {
					System.out.println("FhirResourceSet: "
							+ ((MedicationStatement) r1).getId());
					System.out.println("FhirResourceSet: "
							+ ((MedicationStatement) r1).getText().getDiv()
									.getContent().get(0).toString());
				}

				for (MetaResource mr : s2.getMetaResource()) {
					Resource r = mr.getResource();
					if (FhirUtil.isValid(FhirUtil.resourceToXml(r))) {
						System.out.println("#################Valid");
					} else {
						throw new RuntimeException(
								FhirUtil.getValidatorErrorMessage(FhirUtil
										.resourceToXml(r)));
					}

				}
		
	}
	
	// @Test
	public void Test4() throws JAXBException {
		String str = "<a>{fn:replace('2009-09-10T00:00:00.000Z','.000Z$','')}</a>";
		System.out.println(XQueryUtil.processXQuery(str));
	}
	
	//@Test
	public void Test5() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		MetaResourceDb mrDb= new MetaResourceDb();
		Patient p= new Patient();
		p.setId("Patient/123");
		MetaResource mrP=new MetaResource();mrP.setResource(p);
		MetaData md1=new MetaData();mrP.setMetaData(md1);
		
		
		MedicationStatement ms=new MedicationStatement();
		ms.setId("MedicationStatement/234");
		ResourceReference pRef=new ResourceReference();
		pRef.setId(p.getId());
		ms.setPatient(pRef);
		
		
		MetaResource mrMS=new MetaResource();mrMS.setResource(ms);
		MetaData md2=new MetaData();mrMS.setMetaData(md2);
		
		mrDb.addMetaResource(mrMS,MedicationStatement.class);
		mrDb.addMetaResource(mrP,Patient.class);
		
		System.out.println("child:"+mrDb.getChildOfResource(ms, "patient.id"));
		
	}
	
	/*
	 * validation needs to occur before translation to java object;
	 * Error in xml is lost after transformation of xml to java object
	 * as demonstrated here
	 */
	//@Test
	public void Test6() throws DatatypeConfigurationException{ 
		String inValidPatient=Utils.getFile("example/fhir/singlePatientInvalid.xml");
		System.out.println(FhirUtil.getValidatorErrorMessage(inValidPatient));
		Patient p=(Patient) FhirUtil.xmlToResource(inValidPatient);
		MetaResource mr= new MetaResource();
		MetaData md= new MetaData();
		GregorianCalendar gc = new GregorianCalendar();
		md.setLastUpdated(DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gc));
		mr.setMetaData(md);
		mr.setResource(p);
		
		MetaResourceSet s= new MetaResourceSet();
		List<MetaResource> list=s.getMetaResource();
		list.add(mr);
		MetaResourceDb db=new MetaResourceDb();
		
		db.addMetaResourceSet(s);
		System.out.println("---------\nERROR:"+FhirUtil.getValidatorErrorMessage(FhirUtil.resourceToXml(p)));
		
	}
	
	//@Test
	public void Test7(){ 
	String input="subject:Patient=123";
		String id=null;
		Pattern p = Pattern.compile("[P|p]atient=([a-zA-Z0-9]+)");
		Matcher m = p.matcher(input);

		if (m.find()) {
			id=m.group(1);
		    System.out.println(id);
		}
	}
	
	@Test
	public void getPatientIdFromMetaResource() throws DatatypeConfigurationException{
		MetaResourceSet s=ResourceSetup.getPatientAndMedicationStatementEg();
		MetaResource medmr=s.getMetaResource().get(1);
		assertEquals( "1000000005",FhirUtil.getPatientId(medmr));
		MetaResource ptmr=s.getMetaResource().get(0);
		assertEquals( "1000000005",FhirUtil.getPatientId(ptmr));
	
	}
	
}