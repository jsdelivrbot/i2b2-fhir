package edu.harvard.i2b2.fhir.smart;

import java.sql.Timestamp;

//create table sclient( id varchar(50) not null, secret varchar(30) not null, redirecturl varchar(100) not null, userid varchar(20) not null, createdt DATETIME  not null, primary key (id) );
public class SClient {
	
	String id;
	String secret;
	String redirectUrl;
	String userId;
	
	Timestamp createDT;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public Timestamp getCreateDT() {
		return createDT;
	}

	public void setCreateDT(Timestamp createDT) {
		this.createDT = createDT;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	@Override
	public String toString() {
		return "SClient [id=" + id + ", secret=" + secret + ", redirectUrl=" + redirectUrl + ", userId=" + userId
				+ ", createDT=" + createDT + "]";
	}

	
	
	
	
	

}
