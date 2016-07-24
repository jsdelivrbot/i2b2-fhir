package edu.harvard.i2b2.fhir.fetcher.fetchstatus;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import org.springframework.transaction.annotation.Transactional;

@Entity
public class FetchStatus {
	@Id
	String id;// resourceName+patientID

	
	
	int count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FetchStatus [id=" + id + ", count=" + count + "]";
	}

	

	
	

}
