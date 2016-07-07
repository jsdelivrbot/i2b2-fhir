package edu.harvard.i2b2.fhir.fetcher.fetchstatus;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.LockModeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.harvard.i2b2.fhir.converter.ConverterImpl;
import edu.harvard.i2b2.fhir.fetcher.FetcherException;

@Component
@Transactional(readOnly=true)
public class FetchStatusServiceImpl implements FetchStatusService {
	static Logger logger = LoggerFactory.getLogger(FetchStatusServiceImpl.class);

	
	@Autowired
	FetchStatusRespository fetchStatusRespository;

	@Transactional(readOnly = true)
	@Lock(LockModeType.READ)
	public boolean isLocked(String id) {
		logger.trace("Checking if locked for id:"+id);
		FetchStatus fs = fetchStatusRespository.findOne(id);
		if (fs == null) {
			
			logger.trace("no fs for id:"+id);
			return false;}
		
		else{ logger.trace("Checking if locked for id:"+fs+"<"+fetchStatusRespository.findById(id).size()); }
		
		//fetchStatusRespository.delete(fs);
		//fetchStatusRespository.save(fs);
		
		if(fs.getCount()>0) return true;
		else return false;
		
		//if (fs.getStatus().equals("fetching") || fs.getStatus().equals("caching")) {return true;}
		//else if (fs.getStatus().equals("unlocked") ) {return false;}
		//else throw new RuntimeException("ERROR in locking");
	}

	@Transactional(readOnly = false)
	@Lock(LockModeType.WRITE)
	public void setFetching(String id) {
		
		FetchStatus fs = fetchStatusRespository.findOne(id);
		if(fs==null) {
			fs= new FetchStatus();fs.setId(id);fs.setCount(0);
			fs.setLastFetchDT();
		}else{
			//fetchStatusRespository.delete(fs);
		}
		//fs.setStatus("fetching");
		fs.setCount(fs.getCount()+1);
		logger.trace("Set status to fetching:"+fs+"<"+fetchStatusRespository.findById(id).size());
	
		fetchStatusRespository.save(fs);

	}

	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Lock(LockModeType.WRITE)
	public void setUnlocked(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		
		fs.setCount(fs.getCount()-1);
		logger.trace("Set status to unlock:"+fs+"<"+fetchStatusRespository.findById(id).size());
		//fetchStatusRespository.delete(fs);
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

	
	public FetchStatus getFetchStatus(String id){
		return fetchStatusRespository.findOne(id);
	}
	
	

	
	
	
}
