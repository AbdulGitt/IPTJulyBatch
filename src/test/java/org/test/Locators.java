package org.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {
		
		//id,name,classname,tagname,xpath,linkText,PartialLinkText,CssSelectors
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://omayo.blogspot.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		WebElement txtUsername = driver.findElement(By.id("email"));
//		txtUsername.sendKeys("qwerty");
//	
////		WebElement txtPassword = driver.findElement(By.name("pass"));
////		txtPassword.sendKeys("23456");
//		
//		//classname
////		WebElement txtPassword = driver.findElement(By.className("inputtext _55r1 _6luy _9npi"));
////		txtPassword.sendKeys("23456");
//		
//		//tagname
//		List<WebElement> findElements = driver.findElements(By.tagName("input"));
//		System.out.println(findElements.size());
//		
////		WebElement forgot = driver.findElement(By.linkText("Forgotten password?"));
////		forgot.click();
//		
//		WebElement findElement = driver.findElement(By.partialLinkText("Forgotten"));
//		findElement.click();
//		
//		//Absolute & Relative Xpath
//		//tagname[@attname='attvalue']
//		//(//tagname[@attname='attvalue'])[index]
//		//tagname[text()='text']
//		//tagname[contains(text(),'partial text')]
//		//tagname[contains(@attname,'partialattrvalue')]
		
		System.out.println(driver.findElement(By.id("rotb")).getAttribute("value"));
		
		
		
	}
	
	
}
