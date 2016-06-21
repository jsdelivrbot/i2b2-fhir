package edu.harvard.i2b2.fhir.converter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import edu.harvard.i2b2.fhir.modules.Converter;

@Component
public class ConverterImpl implements Converter {
	static Logger logger = LoggerFactory.getLogger(ConverterImpl.class);

	@Autowired
	ConversionRepository repository;

	@Override
	public String getWebServiceResponse(String resourceName, String patientId, Date startDT, Date endDT)
			throws ConverterException {
		String responseTransformed = null;
		Conversion conversion = repository.findByResourceNames(resourceName).get(0);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		HttpHeaders headers = new HttpHeaders();
		String requestXml = composeRequestXml(conversion, resourceName, patientId, startDT, endDT);

		HttpEntity<String> entity = new HttpEntity<String>(requestXml, headers);
		try {
			response = restTemplate.exchange(conversion.getUri(), HttpMethod.PUT, entity, String.class);
			logger.debug(response.toString());
			responseTransformed = transformXml(conversion, response.getBody());
			logger.trace("converted:"+responseTransformed);
		} catch (HttpClientErrorException e) {
			logger.error("error is:" + e.getMessage());
			throw new ConverterException(e);
		} catch (XQueryUtilException e) {
			logger.error("error is:" + e.getMessage());
			return responseTransformed;
		}
		logger.trace("converted completed:"+responseTransformed);
		return responseTransformed;
	}

	private String composeRequestXml(Conversion conversion, String resourceName, String patientId, Date startDT,
			Date endDT) {
		String props = conversion.getProperties();
		String format = conversion.getDateTimeFormat();
		format = (format == null) ? "yyyy-MM-dd'T'HH:mm:ss.SSSZ" : "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String composed = conversion.getWebRequestXmlTemplate().replace("PATIENT_ID", patientId);
		if(startDT!=null) composed=composed.replace("START_DATE_TIME", sdf.format(startDT));
		if(endDT!=null) composed=composed.replace("END_DATE_TIME", sdf.format(endDT));
		
		composed = putProps(composed, conversion);
		return composed;
	}

	private String transformXml(Conversion conversion, String inputXml) throws XQueryUtilException {
		String query = conversion.getxQueryScript();
		query = putProps(query, conversion);
		logger.debug("query:"+query);
		
		return XQueryUtil.processXQuery(query, inputXml);
	}

	private String putProps(String input, Conversion conversion) {
		String props = conversion.getProperties();
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
					logger.debug("replacing:" + key + " with " + val);
				}
			}
		}
		return composed;
	}

	@PostConstruct
	public void init() throws Exception {
		Conversion conversion = new Conversion();
		//try {
			conversion.setCategory("i2b2-Demographics");
			conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
			conversion.setWebRequestXmlTemplate(
					Utils.getFile("/conversions/i2b2/Patient/getPatient.xml")
					//new String(Files.readAllBytes(Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xml").toURI())))
					);
			conversion.setxQueryScript(
					Utils.getFile("/conversions/i2b2/Patient/getPatient.xquery"));
					//new String(Files.readAllBytes(
					//Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xquery").toURI()))));
			conversion.setResourceNames("Patient");
			conversion.setProperties("DOMAIN=i2b2demo\nUSER=demo");
			repository.save(conversion);

			conversion = new Conversion();
			conversion.setCategory("i2b2-Labs");
			conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
			conversion.setWebRequestXmlTemplate(
					Utils.getFile("/conversions/i2b2/Observation/i2b2RequestTemplateForAPatient.xml"));
					//new String(Files.readAllBytes(Paths.get(getClass()
					//.getResource("/conversions/i2b2/Observation//i2b2RequestTemplateForAPatient.xml").toURI()))));
			conversion.setxQueryScript(
					Utils.getFile("/conversions/i2b2/Observation/i2b2ToFHIR_default.xquery"));
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
