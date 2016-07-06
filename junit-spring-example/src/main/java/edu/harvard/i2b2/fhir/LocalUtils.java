package edu.harvard.i2b2.fhir;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class LocalUtils {
	static public String readFile(String filePath) throws IOException {
		URL resource = Thread.currentThread().getContextClassLoader().getSystemResource(filePath);
		String text=null;
		
		try (final InputStream inputStream = resource.openStream()){
		    	StringWriter writer = new StringWriter();
				String encoding="UTF-8";
				IOUtils.copy(inputStream, writer, encoding);
				text = writer.toString();
		} catch (IOException e) {
			throw e;
		}
		return text;
	}
	
	public static File getFile(String fileName) throws URISyntaxException, IOException {

		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//return new File(classLoader.getResource(fileName).toURI());
		
			ApplicationContext appContext = 
			    	   new ClassPathXmlApplicationContext();
			
			    	Resource resource = appContext.getResource("classpath:"+fileName);
			    	return resource.getFile();

	}
}
