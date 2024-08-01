package org.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionsClass {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions op=new ChromeOptions();
		
		op.addArguments("--start-maximized");	
		
//		op.addArguments("--incognito");	
		
//		op.addArguments("--headless");
		
		op.addArguments("--disable-notifications");
		
		op.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		
		WebDriver driver=new ChromeDriver(op);
		
//		#http://user:pass@url
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//		System.out.println(driver.getCurrentUrl());
		
//		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
//		
//		Alert a = driver.switchTo().alert();
//		a.accept();
//		
		
		driver.get("https://www.facebook.com/");
		
		WebElement btn = driver.findElement(By.cssSelector("._42ft._4jy0._6lti._4jy6._4jy2.selected._51sy"));
		String cssValue = btn.getCssValue("background-color");
		System.out.println(cssValue);
		
		Color c = Color.fromString(cssValue);
		String asHex = c.asHex();
		System.out.println(asHex);
		
		
	}

}
