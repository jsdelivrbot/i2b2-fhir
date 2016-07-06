package edu.harvard.i2b2.fhir.converter;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import edu.harvard.i2b2.basex.XQueryUtil;
import edu.harvard.i2b2.basex.XQueryUtilException;
import edu.harvard.i2b2.fhir.LocalUtils;
import edu.harvard.i2b2.fhir.Utils;
import edu.harvard.i2b2.fhir.fetcher.FetchRequest;
import edu.harvard.i2b2.fhir.modules.Converter;

@Component
public class ConverterImpl implements Converter {
	static Logger logger = LoggerFactory.getLogger(ConverterImpl.class);

	@Autowired
	ConversionRepository repository;

	@Override
	/*
	 * if conversion.getWebRequestXmlTemplate() is null GET is done or else POST s performed
	 * 
	 */
	public String getWebServiceResponse(FetchRequest req)//(String resourceName, String patientId, Date startDT, Date endDT)
			throws ConverterException {
		String responseTransformed = null;
		List<Conversion> list= repository.findByResourceNames(req.getResourceName());
		if (list.size()==0) throw new ConverterException("no Conversion found for resourseName"+req.getResourceName());
		Conversion conversion = list.get(0);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		HttpHeaders headers = new HttpHeaders();
		compose(conversion, req);

		HttpEntity<String> entity = new HttpEntity<String>(conversion.getComposedWebRequestXml(), headers);
		logger.info("Request:"+conversion.getComposedUri());
		logger.info("RequestXml:"+((conversion.getComposedWebRequestXml()==null)?"":conversion.getComposedWebRequestXml()));
		
		
		
		try {
			response = restTemplate.exchange(conversion.getComposedUri(), 
					(conversion.getWebRequestXmlTemplate()==null)?HttpMethod.GET:HttpMethod.PUT,
							entity, String.class);
			logger.info("Response:"+response.toString());
			responseTransformed = transformXml(response.getBody(),conversion);
		} catch (HttpClientErrorException e) {
			logger.error("error is:" + e.getMessage());
			throw new ConverterException(e);
		} catch (XQueryUtilException e) {
			logger.error("error is:" + e.getMessage());
			return responseTransformed	;
		}
		logger.debug("transformed response:"+responseTransformed);
		return responseTransformed;
	}

	private void compose(Conversion conversion, FetchRequest req) {
		logger.info("composing conversion:"+conversion.toString());
		conversion.setComposedUri(putProps(conversion.getUri(),req,conversion));
		conversion.setComposedWebRequestXml(putProps(conversion.getWebRequestXmlTemplate(),req,conversion));
		conversion.setComposedXQueryScript(putProps(conversion.getxQueryScript(),req,conversion));
		logger.info("composed conversion:"+conversion.toString());
			
	}
	
	private String putProps(String input, FetchRequest req, Conversion conversion){
		String props = conversion.getProperties();
		if(props==null) props="";
		String format = conversion.getDateTimeFormat();
		if (format == null) {format= "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; }
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return putProps(input,"PATIENT_ID="+req.getPatientId()+"\nSTART_DATE_TIME="+sdf.format(req.getStartDate())+"\nEND_DATE_TIME="+sdf.format(req.getEndDate()));
	}
	
	private String putProps(String input, String props) {
		
		//String props = conversion.getProperties();
		if(input==null) return input;
		logger.debug("Props:" + props);
		logger.debug("Input:" + input);
		String composed = input;
		if (props != null) {
			for (String prop : props.split("\n")) {
				logger.debug("Prop:" + prop);
				Pattern p = Pattern.compile("([^=]+)=([^=]+)");
				Matcher m = p.matcher(prop);
				String key;
				String val;
				while (m.find()) {
					key = m.group(1);
					val = m.group(2);
					composed = composed.replace(key, val);
					logger.trace("replacing:" + key + " with " + val);
				}
			}
		}
		return composed;
	}

	
	private String transformXml( String inputXml,Conversion conversion) throws XQueryUtilException {
		String query = conversion.getComposedXQueryScript();
		logger.debug("query:"+query);
		return XQueryUtil.processXQuery(query, inputXml);
	}
	
	@PostConstruct
	public void init() throws Exception {
		//try {
		ConvertersFromDir list = new ConvertersFromDir("confidential/converterRootDir");
		for(Conversion c:list.getList()){
			logger.trace("c:"+c.toString());
			repository.save(c);
		}
		if(1==1) return;
		Conversion conversion = new Conversion();
		
			conversion.setCategory("i2b2-Demographics");
			conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
			conversion.setWebRequestXmlTemplate(
					Utils.getFile("conversions/i2b2/Patient/getPatient.xml")
					//new String(Files.readAllBytes(Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xml").toURI())))
					);
			conversion.setxQueryScript(
					Utils.getFile("conversions/i2b2/Patient/getPatient.xquery"));
					//new String(Files.readAllBytes(
					//Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xquery").toURI()))));
			conversion.setResourceNames("Patient");
			conversion.setProperties("DOMAIN=i2b2demo\nUSER=demo");
			repository.save(conversion);

			conversion = new Conversion();
			conversion.setCategory("i2b2-Labs");
			conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
			conversion.setWebRequestXmlTemplate(
					Utils.getFile("conversions/i2b2/Observation/i2b2RequestTemplateForAPatient.xml"));
					//new String(Files.readAllBytes(Paths.get(getClass()
					//.getResource("/conversions/i2b2/Observation//i2b2RequestTemplateForAPatient.xml").toURI()))));
			conversion.setxQueryScript(
					Utils.getFile("conversions/i2b2/Observation/i2b2ToFHIR_default.xquery"));
					//new String(Files.readAllBytes(Paths
					//.get(getClass().getResource("/conversions/i2b2/Observation/i2b2ToFHIR_default.xquery").toURI()))));
			conversion.setResourceNames("Observation");
			conversion.setProperties(
					"DOMAIN=i2b2demo\nUSERNAME=demo\nPASSWORD=demouser\nXCATX=labs\nXPATHX=\\\\i2b2_LABS\\i2b2\\Labtests\\\n(:RESOURCE_FUNCTION:)={local:processLabObs(<A>{$labObs}</A>)/entry}");
			repository.save(conversion);
			
			
			
		//} catch (IOException e) {
			//logger.error(e.getMessage(), e);
		//}
	}

}
