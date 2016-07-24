package edu.harvard.i2b2.fhir.web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.harvard.i2b2.fhir.fetcher.FetcherException;
import edu.harvard.i2b2.fhir.fetcher.FetcherImpl;
import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatus;
import edu.harvard.i2b2.fhir.fetcher.fetchstatus.FetchStatusJdbcRepository;
import javassist.bytecode.analysis.Util;

@Controller
@RequestMapping("/fs")
public class WebControllerFS {

	static Logger logger = LoggerFactory.getLogger(WebControllerFS.class);
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	@Autowired
	private FetchStatusJdbcRepository repo;

	@Value("${cache.url}")
	String cacheUrl;

	@RequestMapping(value = "/create/{id:.*}", method = RequestMethod.GET)
	public ResponseEntity create(HttpServletRequest request, @PathVariable String id) {

		logger.debug("getContextPath()" + request.getContextPath());
		FetchStatus fs = new FetchStatus();
		fs.setId(id);
		fs.setCount(0);
		repo.save(fs);

		return new ResponseEntity<>(fs.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/view/{id:.*}", method = RequestMethod.GET)
	public ResponseEntity view(HttpServletRequest request, @PathVariable String id) {

		logger.debug("getContextPath()" + request.getContextPath());
		FetchStatus fs=repo.findOne(id);
		return new ResponseEntity<>((fs!=null)?fs.toString():"not found fs with id:"+id, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/fetch/{id:.*}", method = RequestMethod.GET)
	public ResponseEntity fetch(HttpServletRequest request, @PathVariable String id) throws InterruptedException {

		logger.debug("getContextPath()" + request.getContextPath());
		
		FetchStatus fs=repo.findOne(id);
		fs.setCount(fs.getCount()+1);
		repo.save(fs);
		
		Thread.sleep(10000);
		
		fs=repo.findOne(id);
		fs.setCount(fs.getCount()-1);
		repo.save(fs);
		
		
		return new ResponseEntity<>((fs!=null)?fs.toString():" not found fs with id:"+id, HttpStatus.OK);

	}
	
	

}