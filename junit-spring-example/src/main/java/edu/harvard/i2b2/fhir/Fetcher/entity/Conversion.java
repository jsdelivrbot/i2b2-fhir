package edu.harvard.i2b2.fhir.Fetcher.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import edu.harvard.i2b2.fhir.modules.ConversionException;

@Entity
public class Conversion{
	
	@Id
	String category;
	
	String resourceNames;
	
	String webRequestXmlTemplate;
	
	String xQueryScript;

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

	@Override
	public String toString() {
		return "Conversion [category=" + category + ", resourceNames=" + resourceNames + ", webRequestXmlTemplate="
				+ webRequestXmlTemplate + ", xQueryScript=" + xQueryScript + "]";
	}
	
	
	
	//public String getFhirXmlBundle(String pid) throws ConversionException;
}
