package edu.harvard.i2b2.fhir.converter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
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
	 * if conversion.getWebRequestXmlTemplate() is null GET is done or else POST
	 * s performed
	 * 
	 */
	public List<String> fetchWebServiceData(FetchRequest req)// (String
																// resourceName,
																// String
																// patientId,
																// Date startDT,
																// Date endDT)
			throws ConverterException {
		List<String> respList = new ArrayList<String>();
		String responseTransformed = null;

		List<Conversion> list = repository.findByResourceNames(req.getResourceName());
		if (list.size() == 0)
			throw new ConverterException("no Conversion found for resourseName" + req.getResourceName());
		Collections.sort(list);//sort by priority
		for (Conversion conversion : list) {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = null;
			HttpHeaders headers = new HttpHeaders();
			Conversion composed = compose(conversion, req);

			HttpEntity<String> entity = new HttpEntity<String>(composed.getWebRequestXmlTemplate(), headers);
			logger.info("Request:" + composed.getUri());
			logger.info("RequestXml:"
					+ ((composed.getWebRequestXmlTemplate() == null) ? "" : composed.getWebRequestXmlTemplate()));

			try {
				if (composed.getUri() != null) {
					response = restTemplate.exchange(composed.getUri(), HttpMethod.GET, // (composed.getWebRequestXmlTemplate()
																						// ==
																						// null)
																						// ?
																						// HttpMethod.GET
																						// :
																						// HttpMethod.PUT,
							entity, String.class);
					logger.info("Response:" + response.toString());
					responseTransformed = transformXml(response.getBody(), composed);
				} else {
					responseTransformed = transformXml("", composed);
				}

			} catch (HttpClientErrorException e) {
				logger.error("error is:" + e.getMessage());
				throw new ConverterException(e);
			} catch (XQueryUtilException e) {
				logger.error("error is:" + e.getMessage());
				respList.add(e.getMessage());
			}
			logger.debug("transformed response:" + responseTransformed);
			respList.add(responseTransformed);
		}
		return respList;
	}

	private Conversion compose(Conversion conversion, FetchRequest req) throws ConverterException {
		logger.info("composing conversion:" + conversion.toString());
		Conversion composed = new Conversion();
		composed.setUri(putProps(conversion.getUri(), req, conversion));
		composed.setWebRequestXmlTemplate(putProps(conversion.getWebRequestXmlTemplate(), req, conversion));
		composed.setxQueryScript(putProps(attachxQueryLib("fhir.xqm", conversion.getxQueryScript()), req, conversion));
		logger.info("composed conversion:" + conversion.toString());
		return composed;
	}

	private String putProps(String input, FetchRequest req, Conversion conversion) {
		String props = conversion.getProperties();
		if (props == null)
			props = "";
		String format = conversion.getDateTimeFormat();
		if (format == null) {
			format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return putProps(input, "PATIENT_ID=" + req.getPatientId() + "\nSTART_DATE_TIME="
				+ sdf.format(req.getStartDate()) + "\nEND_DATE_TIME=" + sdf.format(req.getEndDate()));
	}

	private String putProps(String input, String props) {

		// String props = conversion.getProperties();
		if (input == null)
			return input;
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

	private String attachxQueryLib(String libname, String xquery) throws ConverterException {
		String path = "lib/" + libname;
		try {
			return removeFirstLine(FileUtils.readFileToString(LocalUtils.getFile(path))) + removeFirstLine(xquery);
		} catch (IOException | URISyntaxException e) {
			throw new ConverterException(e);
		}
	}

	private String removeFirstLine(String txt) {
		String out = "";
		if (txt == null || (!txt.contains("\n")))
			return txt;
		String[] lines = txt.split("\n");

		for (int i = 1; i < lines.length; i++) {
			out += "\n" + lines[i];
		}
		return out;
	}

	private String transformXml(String inputXml, Conversion conversion) throws XQueryUtilException {
		String query = conversion.getxQueryScript().replaceAll("f:", "local:");
		logger.debug("query:" + query);
		return XQueryUtil.processXQuery(query, inputXml);
	}

	@PostConstruct
	public void init() throws Exception {
		// try {
		ConvertersFromDir list = new ConvertersFromDir("confidential/converterRootDir");
		for (Conversion c : list.getList()) {
			logger.trace("c:" + c.toString());
			repository.save(c);
		}
		if (1 == 1)
			return;
		Conversion conversion = new Conversion();

		conversion.setCategory("i2b2-Demographics");
		conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
		conversion.setWebRequestXmlTemplate(Utils.getFile("conversions/i2b2/Patient/getPatient.xml")
		// new
		// String(Files.readAllBytes(Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xml").toURI())))
		);
		conversion.setxQueryScript(Utils.getFile("conversions/i2b2/Patient/getPatient.xquery"));
		// new String(Files.readAllBytes(
		// Paths.get(getClass().getResource("/conversions/i2b2/Patient/getPatient.xquery").toURI()))));
		conversion.setResourceNames("Patient");
		conversion.setProperties("DOMAIN=i2b2demo\nUSER=demo");
		repository.save(conversion);

		conversion = new Conversion();
		conversion.setCategory("i2b2-Labs");
		conversion.setUri("http://services.i2b2.org:9090/i2b2/services/QueryToolService/pdorequest");
		conversion.setWebRequestXmlTemplate(
				Utils.getFile("conversions/i2b2/Observation/i2b2RequestTemplateForAPatient.xml"));
		// new String(Files.readAllBytes(Paths.get(getClass()
		// .getResource("/conversions/i2b2/Observation//i2b2RequestTemplateForAPatient.xml").toURI()))));
		conversion.setxQueryScript(Utils.getFile("conversions/i2b2/Observation/i2b2ToFHIR_default.xquery"));
		// new String(Files.readAllBytes(Paths
		// .get(getClass().getResource("/conversions/i2b2/Observation/i2b2ToFHIR_default.xquery").toURI()))));
		conversion.setResourceNames("Observation");
		conversion.setProperties(
				"DOMAIN=i2b2demo\nUSERNAME=demo\nPASSWORD=demouser\nXCATX=labs\nXPATHX=\\\\i2b2_LABS\\i2b2\\Labtests\\\n(:RESOURCE_FUNCTION:)={local:processLabObs(<A>{$labObs}</A>)/entry}");
		repository.save(conversion);

		// } catch (IOException e) {
		// logger.error(e.getMessage(), e);
		// }
	}

}
