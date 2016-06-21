package edu.harvard.i2b2.fhir;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;

import org.apache.commons.io.IOUtils;

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
}
