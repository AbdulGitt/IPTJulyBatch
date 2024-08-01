package org.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.base.BaseClass;
import org.openqa.selenium.By;

public class DatasReader extends BaseClass{
	
	public static void main(String[] args) throws IOException {
		
		Properties prop=new Properties();
		
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		
		prop.load(f);
		
//		Object object = prop.get("browser");
//		System.out.println(object);
//		
//		String br=(String)object;
//		System.out.println(br);
//		
//		String property = prop.getProperty("browser");
//		System.out.println(property);
		
		browserLaunch(prop.getProperty("browser"));
		
		urlLaunch(prop.getProperty("url"));
		
//		Logger.get
		
		implicitWait(10);
		
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("pass")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("login")).click();
		
		
		//Logger
		
		
		
	}

}
