package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadaws {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.alodokter.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		WebElement txtSrch = driver.findElement(By.id("searchinput"));
//		txtSrch.sendKeys("qwerty");
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].setAttribute('value','qwerty')",txtSrch);
		
		Object srch = js.executeScript("return document.querySelector('#top-navbar-view').shadowRoot.querySelector('#searchinput')");
		
		WebElement btn=(WebElement)srch;
		btn.sendKeys("qwertyu");
		
		
	}

}
