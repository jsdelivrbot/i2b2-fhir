package edu.harvard.i2b2.fhir.converter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String GroupName;
	
	String webServiceGroupName;
	
	String regexTriggers;
	
	String requestWebServiceXml;
	
	String endPointUrl;
	
	String xQueryScript;
}
