package org.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElements {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
			
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.numbeo.com/quality-of-life/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement quality = driver.findElement(By.xpath("(//*[local-name()='svg' and @aria-label]/*[name()='g'])[1]"));
		System.out.println(quality.getText());
		
		List<WebElement> bar = driver.findElements(By.xpath("((//*[name()='svg' and @aria-label]/*[name()='g'])[2]/*[name()='g' and @clip-path]/*[name()='g'])[2]/*[name()='rect']"));
		for(WebElement x:bar) {
			Actions a=new Actions(driver);
			a.moveToElement(x).perform();
			
			WebElement datas = driver.findElement(By.xpath("(//*[name()='svg' and @aria-label]/*[name()='g'])[3]/*[name()='g' and @class]"));
			System.out.println(datas.getText());
			System.out.println("-----------------------------");
			
		}
		
		
		
	}

}
