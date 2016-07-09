package edu.harvard.i2b2.fhir.converter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Conversion{
	
	@Id
	String category;
	
	String uri;
	
	String resourceNames;
	
	@Lob
	String properties;
	
	@Lob
	String webRequestXmlTemplate;
	
	@Lob
	String xQueryScript;
	
	String dateTimeFormat;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public String getResourceNames() {
		return resourceNames;
	}

	public void setResourceNames(String resourceNames) {
		this.resourceNames = resourceNames;
	}

	public String getWebRequestXmlTemplate() {
		return webRequestXmlTemplate;
	}

	public void setWebRequestXmlTemplate(String webRequestXmlTemplate) {
		this.webRequestXmlTemplate = webRequestXmlTemplate;
	}

	public String getxQueryScript() {
		return xQueryScript;
	}

	public void setxQueryScript(String xQueryScript) {
		this.xQueryScript = xQueryScript;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	
	
}
