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

	String resourceName;
	String patientId;
	Date lastFetchDT;
	Date lastCacheUpdateDT;
	
	//String status;// Fetching, Caching or unlocked
	
	int count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getLastFetchDT() {
		return lastFetchDT;
	}

	public void setLastFetchDT(Date lastFetchDT) {
		this.lastFetchDT = lastFetchDT;
	}
	public void setLastFetchDT() {
		setLastFetchDT(new Date(Calendar.getInstance().getTime().getTime()));
	}		
	public Date getLastCacheUpdateDT() {
		return lastCacheUpdateDT;
	}

	public void setLastCacheUpdateDT(Date lastCacheUpdateDT) {
		this.lastCacheUpdateDT = lastCacheUpdateDT;
	}
	
	public void setLastCacheUpdateDT() {
		setLastCacheUpdateDT(new Date(Calendar.getInstance().getTime().getTime()));
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FetchStatus [id=" + id + ", resourceName=" + resourceName + ", patientId=" + patientId
				+ ", lastFetchDT=" + lastFetchDT + ", lastCacheUpdateDT=" + lastCacheUpdateDT + ", count=" + count
				+ "]";
	}	

	
	

}
