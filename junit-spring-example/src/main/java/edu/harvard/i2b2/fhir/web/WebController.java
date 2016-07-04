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

import edu.harvard.i2b2.fhir.Utils;
import edu.harvard.i2b2.fhir.fetcher.FetcherException;
import edu.harvard.i2b2.fhir.modules.Cache;
import edu.harvard.i2b2.fhir.modules.Fetcher;
import javassist.bytecode.analysis.Util;

@Controller
@RequestMapping("/bs")
@EnableJpaRepositories
public class WebController {

	static Logger logger = LoggerFactory.getLogger(WebController.class);
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	@Autowired
	private Fetcher fetcher;
	
	@Value("${cache.url}")
	String cacheUrl;
	
	@RequestMapping(value = "/fhir/{path:.*}", method = RequestMethod.GET)
	public ResponseEntity fhirEndpoint(HttpServletRequest request, @PathVariable String path) throws FetcherException{
		
		String fullUri=path+"?"+request.getQueryString();
		logger.debug("fullPath:"+fullUri+"?"+request.getQueryString());
		logger.debug("getContextPath()"+request.getContextPath());
		String basePath=request.getRequestURL().toString().replace(path,"");
		logger.debug("basePath:"+basePath);
		return new ResponseEntity<>(fetcher.getData(fullUri),HttpStatus.OK);
		
		//return new ResponseEntity<>(cache.get(cacheUrl+"/"+path+"?"+request.getQueryString()).replace(cacheUrl, basePath),HttpStatus.OK);
		
	}

	@RequestMapping(value = "/fetch/{pid}", method = RequestMethod.GET)
	public ResponseEntity getBundleBlocking(@PathVariable("pid") String pid)  {

		logger.debug("...fetch:" + pid);
		
		try {
			return new ResponseEntity<>(fetcher.getData("ddd"),HttpStatus.OK);
		} catch (FetcherException e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	
	}

	

}