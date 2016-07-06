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
	
	String composedUri;
	
	String resourceNames;
	
	@Lob
	String properties;
	
	@Lob
	String webRequestXmlTemplate;
	
	@Lob
	String composedWebRequestXml;
	
	@Lob
	String xQueryScript;
	
	@Lob
	String composedXQueryScript;

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

	public String getComposedUri() {
		return composedUri;
	}

	public void setComposedUri(String composedUri) {
		this.composedUri = composedUri;
	}

	public String getComposedWebRequestXml() {
		return composedWebRequestXml;
	}

	public void setComposedWebRequestXml(String composedWebRequestXml) {
		this.composedWebRequestXml = composedWebRequestXml;
	}

	public String getComposedXQueryScript() {
		return composedXQueryScript;
	}

	public void setComposedXQueryScript(String composedXQueryScript) {
		this.composedXQueryScript = composedXQueryScript;
	}

	@Override
	public String toString() {
		return "Conversion [category=" + category + ", uri=" + uri + ", composedUri=" + composedUri + ", resourceNames="
				+ resourceNames + ", properties=" + properties + ", webRequestXmlTemplate=" + webRequestXmlTemplate
				+ ", composedWebRequestXml=" + composedWebRequestXml + ", xQueryScript=" + xQueryScript
				+ ", composedXQueryScript=" + composedXQueryScript + ", dateTimeFormat=" + dateTimeFormat + "]";
	}

	


	
	
	//public String getFhirXmlBundle(String pid) throws ConversionException;
}
