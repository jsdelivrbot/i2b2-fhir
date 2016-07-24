package edu.harvard.i2b2.fhir.smart;

import java.sql.Date;
import java.sql.Timestamp;

//create table suser( id varchar(50) not null, password varchar(30) not null, firstname varchar(100) not null, lastname varchar(100) not null, email varchar(100) not null, createdt DATETIME  not null, primary key (id) );


public class SUser {
	String id;
	String password;
	String firstName;
	String lastName;
	String email;
	Timestamp createDT;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreateDT() {
		return createDT;
	}
	public void setCreateDT(Timestamp createDT) {
		this.createDT = createDT;
	}
	@Override
	public String toString() {
		return "SUser [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", createDT=" + createDT + "]";
	}
	
}
