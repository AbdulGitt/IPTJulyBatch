package org.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectorr {
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://help.blazemeter.com/docs/guide/getting-started-continuous-testing-journey.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//id--#idvalue
//		WebElement txtUsername = driver.findElement(By.cssSelector("#username"));
//		txtUsername.sendKeys("qwertyu");
		
		//class  .classvalue
//		driver.findElement(By.cssSelector(".form-control.private-form__control.login-email")).sendKeys("qwertyu");
		
		//tagname[attname=attvalue]
//		driver.findElement(By.cssSelector("input[type=email]")).sendKeys("qwertyu");
		
		//prefix
		//tagname[attname^=prefixattvalue]
		
//		driver.findElement(By.cssSelector("input[class^=form]")).sendKeys("qwertyu");
		
		//sufix
		//tagname[attname$=suffixvalue]
	
//		driver.findElement(By.cssSelector("	input[class$=email]")).sendKeys("qwertyu");
		
		//contains
		//tagname[attname*=partialvalue]
//		driver.findElement(By.cssSelector("	input[class*=email]")).sendKeys("qwertyu");
		
		//parent to child
		//parent>child
		List<WebElement> findElements = driver.findElements(By.cssSelector("ul.off-canvas-accordion.vertical.menu.sidenav>li"));
		System.out.println(findElements.size());
		
		
		//first-of-type
		WebElement findElement = driver.findElement(By.cssSelector("ul.off-canvas-accordion.vertical.menu.sidenav>li:first-of-type"));
		System.out.println(findElement.getText());
		
		////last-of-type
		WebElement last = driver.findElement(By.cssSelector("ul.off-canvas-accordion.vertical.menu.sidenav>li:last-of-type"));
		System.out.println(last.getText());
		
		//nth-of-type()
		WebElement nthType = driver.findElement(By.cssSelector("ul.off-canvas-accordion.vertical.menu.sidenav>li:nth-of-type(8)"));
		System.out.println(nthType.getText());
		
		//sibling(+)
		driver.findElement(By.cssSelector("nav.sidenav-wrapper+div"));
		
		//not operator
		WebElement txtUsername = driver.findElement(By.cssSelector("input.form-control.private-form__control:not(#password)"));
		txtUsername.sendKeys("qwerty");
	
	}

}
