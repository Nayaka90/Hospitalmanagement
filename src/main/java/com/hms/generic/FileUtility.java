package com.hms.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class FileUtility {
	/**
	 * This method is used to get data from PropertyFile
	 * @param key
	 * @return String data
	 * @throws Throwable
	 */
	
	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis= new FileInputStream(IpathConstraints.Property_Path);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		ListenerImplementation d = new ListenerImplementation();
		return data;
	
	}

	
}
