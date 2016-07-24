package edu.harvard.i2b2.fhir.fetcher.fetchstatus;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component

public class FetchStatusServiceImpl  {
	static Logger logger = LoggerFactory.getLogger(FetchStatusServiceImpl.class);

	
	@Autowired
	FetchStatusJdbcRepository fetchStatusRespository;

	
	public boolean isLocked(String id) {
		logger.trace("Checking if locked for id:"+id);
		FetchStatus fs = fetchStatusRespository.findOne(id);
		if (fs == null) {
			
			logger.trace("no fs for id:"+id);
			return false;}
		
		else{ logger.trace("Checking if locked for id:"+fs+"<"+fetchStatusRespository.findOne(id)); }
		
		//fetchStatusRespository.delete(fs);
		//fetchStatusRespository.save(fs);
		
		if(fs.getCount()>0) return true;
		else return false;
		
		//if (fs.getStatus().equals("fetching") || fs.getStatus().equals("caching")) {return true;}
		//else if (fs.getStatus().equals("unlocked") ) {return false;}
		//else throw new RuntimeException("ERROR in locking");
	}

	
	public void setFetching(String id) {
		
		FetchStatus fs = fetchStatusRespository.findOne(id);
		if(fs==null) {
			fs= new FetchStatus();fs.setId(id);fs.setCount(0);
			
		}else{
			//fetchStatusRespository.delete(fs);
		}
		//fs.setStatus("fetching");
		fs.setCount(fs.getCount()+1);
		logger.trace("Set status to fetching:"+fs+"<"+fetchStatusRespository.findOne(id));
	
		fetchStatusRespository.save(fs);

	}

	
	
	public void setUnlocked(String id) {
		FetchStatus fs = fetchStatusRespository.findOne(id);
		
		fs.setCount(fs.getCount()-1);
		logger.trace("Set status to unlock:"+fs+"<"+fetchStatusRespository.findOne(id));
		
		
		//fetchStatusRespository.delete(fs);
		fetchStatusRespository.save(fs);
	}

	

	
	public FetchStatus getFetchStatus(String id){
		return fetchStatusRespository.findOne(id);
	}
	
	

	
	
	
}
