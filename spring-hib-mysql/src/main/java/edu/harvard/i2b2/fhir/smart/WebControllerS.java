package edu.harvard.i2b2.fhir.smart;

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
import javassist.bytecode.analysis.Util;

@Controller
@RequestMapping("/sclient")
public class WebControllerS {

	static Logger logger = LoggerFactory.getLogger(WebControllerS.class);
	private static final String MAX_LONG_AS_STRING = "434922337203685423807";

	@Autowired
	private SClientJdbcRepository repo;

	@Value("${cache.url}")
	String cacheUrl;

	@RequestMapping(value = "/create/{id:.*}", method = RequestMethod.GET)
	public ResponseEntity create(HttpServletRequest request, @PathVariable String id) {

		logger.debug("getContextPath()" + request.getContextPath());
		SClient c = new SClient();
		c.setId(id);
		c.setSecret("secret"+id);
		c.setRedirectUrl(id+"url");
		c.setUserId("userId"+id);
		c.setCreateDT(new java.sql.Timestamp( (new java.util.Date()).getTime() ));
		repo.save(c);

		return new ResponseEntity<>(c.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/view/{id:.*}", method = RequestMethod.GET)
	public ResponseEntity view(HttpServletRequest request, @PathVariable String id) {

		logger.debug("getContextPath()" + request.getContextPath());
		SClient c=repo.findOne(id);
		return new ResponseEntity<>((c!=null)?c.toString():"not found c with id:"+id, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/delete/{id:.*}", method = RequestMethod.GET)
	public ResponseEntity delete(HttpServletRequest request, @PathVariable String id) {

		logger.debug("getContextPath()" + request.getContextPath());
		SClient c=repo.findOne(id);
		if(c!=null) repo.remove(id);
		c=repo.findOne(id);
		return new ResponseEntity<>((c!=null)?c.toString():"not found c with id:"+id, HttpStatus.OK);

	}
	
	

}