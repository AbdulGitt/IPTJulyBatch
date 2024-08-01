package org.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//active link
		List<WebElement> total_links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links:"+total_links.size());
		
		for(int i=0;i<total_links.size();i++) {
				WebElement w = total_links.get(i);
				String u = w.getAttribute("href");
				
				URL url=new URL(u);
				URLConnection oc = url.openConnection();
				HttpURLConnection http=(HttpURLConnection)oc;
				
				int responseCode = http.getResponseCode();
				System.out.println(u+"=="+responseCode);
				
			
		}
		
//		active image
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		for(int i=0;i<images.size();i++) {
			String text = images.get(i).getAttribute("src");
			URL url=new URL(text);
			URLConnection oc = url.openConnection();
			HttpURLConnection http=(HttpURLConnection)oc;
			int responseCode = http.getResponseCode();
			System.out.println(responseCode);
			
		}
		
		
	}

}
