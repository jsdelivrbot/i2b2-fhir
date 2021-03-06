package edu.harvard.i2b2.fhir.fetcher;

import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchRequest {

	static Logger logger = LoggerFactory.getLogger(FetchRequest.class);
	String fullUrl;
	String path;
	String queryString;
	String resourceName;
	String patientId;
	String resourceId;
	Date startDate;
	Date endDate;

	public FetchRequest(String fullUri) {
		this.fullUrl = fullUri;
		
		Pattern p = Pattern.compile("^(.+)\\?(.+)");
		Matcher m = p.matcher(fullUri);
		if (m.matches()) {
			logger.trace("found ?");
			this.setPath(m.group(1));
			this.setQueryString(m.group(2));
		} else {
			this.setPath(fullUri);
		}
		this.setResourceId((getResourceIdFromPath() != null) ? getResourceIdFromPath() : getResourceIdFromQuery());
		logger.trace("ran");
		this.patientId = (this.getResourceId() + "-").split("-")[0];
		this.setResourceName(resourceNameFromPath());
		
		setStartDate(java.sql.Date.valueOf("2001-01-01"));
		setEndDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

		logger.trace(this.toString());

	}

	private String getResourceIdFromPath() {
		Pattern p = Pattern.compile("(\\w*)/([^?]*)");
		Matcher m = p.matcher(this.getPath());
		while (m.matches()) {
			return m.group(2);
		}
		return null;
	}

	String getResourceIdFromQuery() {
		String txt = this.getQueryString() + "&";
		for (String q : txt.split("&")) {
			logger.trace("checking:" + q);
			Pattern p = Pattern.compile("(id)=(\\w*)$");
			Matcher m = p.matcher(q);
			while (m.matches()) {
				return m.group(2);
			}
		}
		for (String q : txt.split("&")) {
			logger.trace("checking:" + q);
			Pattern p = Pattern.compile("(patient|subject)=(\\w*)");

			Matcher m = p.matcher(q);
			while (m.matches()) {
				return m.group(2);
			}
		}
		return null;
	}

	
	String resourceNameFromPath(){
		logger.info("path:"+getPath());
		return (this.getPath()+"/").split("/")[0];
	}
	
	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String genId() {
		return this.getPatientId()+"-"+this.getResourceName();
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "FetchRequest [fullUrl=" + fullUrl + ", path=" + path + ", queryString=" + queryString
				+ ", resourceName=" + resourceName + ", patientId=" + patientId + ", resourceId=" + resourceId
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
