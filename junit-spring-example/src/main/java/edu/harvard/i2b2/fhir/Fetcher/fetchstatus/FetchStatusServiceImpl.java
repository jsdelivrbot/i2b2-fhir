package edu.harvard.i2b2.fhir.fetcher.fetchstatus;

import java.sql.Date;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.converter.ConverterImpl;

@Component
public class FetchStatusServiceImpl implements FetchStatusService {
	static Logger logger = LoggerFactory.getLogger(FetchStatusServiceImpl.class);

	
	@Autowired
	FetchStatusRespository fetchStatusRespository;

	public boolean isLocked(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		return fs == null ? false : !(fs.getStatus().equals("fetching") || fs.getStatus().equals("caching"));
	}

	public void setFetching(String id) {
		logger.trace("Set status to fetching");
		FetchStatus fs = fetchStatusRespository.findOne(id);
		if(fs==null) {
			fs= new FetchStatus();fs.setId(id);
			fs.setLastFetchDT();
		}
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
