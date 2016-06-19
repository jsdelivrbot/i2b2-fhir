package edu.harvard.i2b2.fhir.Fetcher.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.Fetcher.entity.FetchStatus;
import edu.harvard.i2b2.fhir.Fetcher.repository.FetchStatusRespository;

@Component
public class FetchStatusServiceImpl implements FetchStatusService {

	@Autowired
	FetchStatusRespository fetchStatusRespository;

	public boolean isLocked(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		return fs == null ? false : !(fs.getStatus().equals("fetching") || fs.getStatus().equals("caching"));
	}

	public void setFetching(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		fs.setStatus("fetching");
		fetchStatusRespository.save(fs);

	}

	public void setCaching(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		fs.setStatus("caching");
		fetchStatusRespository.save(fs);

	}

	public void setUnlocked(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		fs.setStatus("unlocked");
		fetchStatusRespository.save(fs);
	}

	public Date getLastCacheUpdateDT(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		return fs.getLastCacheUpdateDT();
	}

	public Date getLastFetchDT(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		return fs.getLastFetchDT();
	}

	public void createFetchStatus(String id){
		FetchStatus fs= new FetchStatus();
		fs.setId(id);
		fetchStatusRespository.save(fs);
	
	}

	
	

	
	
	
}
