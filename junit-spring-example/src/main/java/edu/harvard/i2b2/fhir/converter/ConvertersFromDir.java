package edu.harvard.i2b2.fhir.converter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.i2b2.fhir.LocalUtils;
import edu.harvard.i2b2.fhir.Utils;

public class ConvertersFromDir {
	static Logger logger = LoggerFactory.getLogger(ConvertersFromDir.class);
	List<Conversion> list;
	String dirRoot;

	ConvertersFromDir(String dirRoot) throws IOException, URISyntaxException {
		list = new ArrayList<Conversion>();

		String pRoot = Utils.getFilePath(dirRoot);
		logger.trace("root File Path:"+pRoot);
		File f = new File(pRoot);

		String rp="confidential/converterRootDir/oncall-pulse";
		//for (File category : f.listFiles()) {
			File category=LocalUtils.getFile("confidential/converterRootDir/oncall-pulse");
			Conversion conversion = new Conversion();
			conversion.setCategory(category.getName());
			
			String p = rp + "/uri.txt";
			logger.trace("p:"+p);
			File file=null;
			if (exists(p)) {
				conversion.setUri(getFile(p));
			}

			p = rp + "/webRequestTemplate.xml";
			if (exists(p)) {
				conversion.setWebRequestXmlTemplate(getFile(p));
			}

			p = rp + "/xQueryScript.xquery";
			if (exists(p)) {
				conversion.setxQueryScript(getFile(p));
			}

			p =rp + "/resourceNames.txt";
			if (exists(p)) {
				conversion.setResourceNames(getFile(p));
			}else{ throw new RuntimeException("resource Names not preset:"+p);}

			p = rp + "/properties.txt";
			if (exists(p)) {
				conversion.setProperties(getFile(p));
			}

			p = rp+ "/dateTimeFormat.txt";
			if (exists(p)) {
				conversion.setDateTimeFormat(getFile(p));
				
			}else{ throw new RuntimeException("date time format not preset:"+p);}
			list.add(conversion);
		//}
		
		
	}

	private String getFile(String p) throws IOException, URISyntaxException {
		//File file=new File(p);
		File file=LocalUtils.getFile(p);
		String text= FileUtils.readFileToString(file);

		if(text.length()>1){
			char ch = text.charAt(text.length()-1);
			if (Character.isWhitespace(ch)  ) text=text.substring(0, text.length()-1);
		}
		return text;
	}

	boolean exists(String	 path)  {
		File f;
		try {
			f = LocalUtils.getFile(path);
		} catch (URISyntaxException | IOException e) {
			return false;
		}
		return f.exists();
	}

	public List<Conversion> getList() {
		return list;
	}

}
