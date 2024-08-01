package org.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//url Launch
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//getTitle
		String title = driver.getTitle();
		System.out.println(title);
		
		//getCurrentUrl
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//findElement ctrl+2,release L
		WebElement txtUsername = driver.findElement(By.id("email"));
		
//		List<WebElement> findElements = driver.findElements(By.id("email"));
		
		//getWindowHandle
//		String windowHandle = driver.getWindowHandle();
//		
//		//getWindowHandles
//		Set<String> windowHandles = driver.getWindowHandles();
		
		//WebElements methods
		//sendKeys
		txtUsername.sendKeys("Ram");
		
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("qwertyu");
		
//		txtPassword.submit();
		
		//click
		WebElement btnLogin = driver.findElement(By.name("login"));
//		btnLogin.click();
		
		WebElement facebook = driver.findElement(By.xpath("//h2[contains(text(),'Facebook')]"));
		//getText
		System.out.println(facebook.getText());
		
		//getAttribute
		String attribute = txtUsername.getAttribute("value");
		System.out.println(attribute);
		
		//clear
		txtUsername.clear();
		
		//isDisplayed
		boolean displayed = txtUsername.isDisplayed();
		System.out.println(displayed);
		
		//isEnabled
//		WebElement enabled = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
//		System.out.println(enabled.isEnabled());
//		enabled.click();
//		
//		WebElement radio = driver.findElement(By.xpath("//input[@value='2']"));
//		
//		System.out.println(radio.isSelected());
//		radio.click();
//		System.out.println(radio.isSelected());
		
		Point p = txtUsername.getLocation();
		System.out.println("X is "+p.getX());
		System.out.println("Y is "+p.getY());
		
		
		String cssValue = btnLogin.getCssValue("background-color");
		
		System.out.println(cssValue);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
