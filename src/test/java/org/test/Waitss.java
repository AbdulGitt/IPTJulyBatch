package org.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waitss {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		
		//Static wait
		Thread.sleep(5000);
		
		driver.findElement(By.name("firstname")).sendKeys("8237293");
		
		WebDriverWait w=new WebDriverWait(driver, 50);
		
		FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver);
		f.withTimeout(Duration.ofSeconds(50));
	}

}
