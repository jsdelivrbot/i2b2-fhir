package edu.harvard.i2b2.fhir.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.hl7.fhir.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.i2b2.fhir.MetaResourceDb;
import edu.harvard.i2b2.fhir.XQueryUtil;
import edu.harvard.i2b2.fhir.core.FhirCoreException;

public class QueryReference extends Query {
	static Logger logger = LoggerFactory.getLogger(QueryReference.class);
	String id;
	String url;

	public QueryReference(Class resourceClass, String parameter, String value, MetaResourceDb db)
			throws QueryParameterException, QueryValueException,
			FhirCoreException {
		super(resourceClass, parameter, value,db);
	}

	@Override
	protected void init() throws QueryValueException, QueryParameterException {
		this.type = QueryType.REFERENCE;
		// [parameter]=[url]
		// [parameter]=[id]
		if (this.getRawValue().contains("/")) {
			this.url = this.getRawValue();
		} else {
			this.id = this.getRawValue();
		}
	}

	@Override
	public boolean match(String resourceXml) {
		String rawId = getXmlFromParameterPath(resourceXml, "//"
				+ this.getParameterPath().replace(".", "/")
				+ "/reference/@value/string()");
		// id=this.getLastElementOfParameterPath()+"/"+id;
		Pattern p = Pattern.compile("//([^//.]*)$");
		Matcher m = p.matcher(rawId);
		if (m.matches()) {
			id = m.group(1);
		}
		// logger.info("matching "+id+" to value:"+this.getRawValue());
		if (id.equals(this.getRawValue())) {
			logger.info("matched:" + this.getRawParameter() + "="
					+ this.getRawValue());
			return true;
		}

		return false;
	}

	// CodeableConcept.text, Coding.display, or Identifier.label
	private boolean textSearch(String xml) {
		ArrayList<String> pathExtList;
		// consider "text" modifier
		pathExtList = new ArrayList<String>(
				Arrays.asList("/reference/@value/string()"));

		ArrayList<String> list = new ArrayList<String>();
		for (String ext : pathExtList) {
			list.addAll(getListFromParameterPath(xml, ext));
		}

		logger.trace("list:" + list.toString());
		for (String v : list) {
			if (v.equals(this.getRawValue())) {
				logger.info("matched:" + this.getRawParameter() + "="
						+ this.getRawValue());
				return true;
			}
		}
		return false;
	}

	@Override
	public void validateParameter() throws QueryParameterException {
		if ((this.getModifier().length() > 0)
				& (!(this.getModifier().equals("text")))) {
			throw new QueryParameterException("undefined modifier <"
					+ this.getModifier() + "> for Query of type token");
		}
	}

	@Override
	public void validateValue() throws QueryValueException {

	}

	@Override
	public String toString() {
		return "QueryReference " + super.toString() + ", id=" + id + ", url="
				+ url + "]";
	}

}
