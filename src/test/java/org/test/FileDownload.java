package org.test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {
	
	public static void main(String[] args) {
		
//		System.out.println(System.getProperty("user.dir"));
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();		
		
		String location=System.getProperty("user.dir")+"\\src\\test\\resources";
		
		Map<String,Object> mp=new LinkedHashMap<>();
		mp.put("profile.default_content_settings.popups", 0);
		mp.put("download.default_directory", location);
		op.setExperimentalOption("prefs", mp);
		
		WebDriver driver=new ChromeDriver(op);
		
		driver.get("https://samplelib.com/sample-jpeg.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement download = driver.findElement(By.xpath("//a[@href='https://download.samplelib.com/jpeg/sample-clouds-400x300.jpg']"));
		download.click();
		
	}

}
