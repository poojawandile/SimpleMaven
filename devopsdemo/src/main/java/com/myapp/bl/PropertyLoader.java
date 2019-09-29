package com.myapp.bl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	Properties prop = new Properties();
	public String appUrl;
	public String browserHead;
	public String chromeDriver;
	public String chromeExe;
	
	public void readProperty() {
	
		try {
			String projectPath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(projectPath + "/src/main/resources/config.properties");
			prop.load(input);
			appUrl = prop.getProperty("appUrl");
			browserHead = prop.getProperty("browserHead");
			
			chromeDriver = prop.getProperty("chromeDriver");
			chromeExe = prop.getProperty("chromeExe");
			
			System.out.println(chromeDriver);
			System.out.println(chromeExe);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyLoader pl = new PropertyLoader();
		pl.readProperty();

	}

}
