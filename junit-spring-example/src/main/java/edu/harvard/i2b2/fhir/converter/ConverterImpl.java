package edu.harvard.i2b2.fhir.converter;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import edu.harvard.i2b2.fhir.modules.Converter;

@Component
public class ConverterImpl implements Converter {
	static Logger logger = LoggerFactory.getLogger(ConverterImpl.class);

	@Autowired
	ConversionRepository repository;

	@Override
	public String getWebServiceResponse(String resourceName, String patientId, Date startDT, Date endDT)
			throws ConverterException {
		String responseTransformed=null;
		Conversion conversion = repository.findByResourceNames(resourceName).get(0);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		HttpHeaders headers = new HttpHeaders();
		String requestXml = composeRequestXml(conversion, resourceName, patientId, startDT, endDT);
		
		HttpEntity<String> entity = new HttpEntity<String>(requestXml, headers);
		try {
			response = restTemplate.exchange(conversion.getUri(), HttpMethod.PUT, entity, String.class);
			//logger.debug(response.toString());
			responseTransformed = transformXml(conversion,response.getBody());
			
		} catch (HttpClientErrorException|XQueryUtilException  e) {
			//logger.error("error is:" + e.getMessage());
			throw new ConverterException(e);
		}
		
		return responseTransformed;
	}

	private String composeRequestXml(Conversion conversion, String resourceName, String patientId, Date startDT,
			Date endDT) {
		String props=conversion.getProperties();
		String format = conversion.getDateTimeFormat();
		format=(format==null)?"yyyy-MM-dd'T'HH:mm:ss.SSSZ":"";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		
		
		String composed= conversion.getWebRequestXmlTemplate().replace("PATIENT_ID", patientId)
				.replace("START_DATE_TIME", sdf.format(startDT)).replace("END_DATE_TIME", sdf.format(endDT));

		if(props!=null){
			for(String prop:props.split("\n")){
				logger.debug("Prop:"+prop);
				Pattern p = Pattern.compile("(\\w+)=(\\w+)");
				Matcher m= p.matcher(prop);
				String key;String val;
				while(m.find()){
					key=m.group(1);
					val=m.group(2);
					composed.replace(key, val);
					logger.debug("replacing:"+key+" with "+ val);
				}
			}
		}
		return composed;
	}
	
	private String transformXml(Conversion conversion, String inputXml) throws XQueryUtilException{
		String query=conversion.getxQueryScript();
		//logger.debug("input:"+inputXml);
		return XQueryUtil.processXQuery(query, inputXml);
	}

}
