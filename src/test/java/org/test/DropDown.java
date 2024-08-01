package org.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.geodatasource.com/software/country-region-dropdown-menu-demo");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement drp = driver.findElement(By.xpath("//select[@country-data-region-id='gds-cr-one']"));
		
		Select s=new Select(drp);
		
		List<WebElement> op = s.getOptions();
//		op.remove(0);
		
		for(WebElement x:op) {
			if(x.isEnabled()){
				System.out.println(x.getText());
			} 
		}
		
		for(WebElement x:op) {
			if(!x.getText().equals("Please select a country.")) {
			System.out.println(x.getText());
			}
		}
		
//		System.out.println(op.get(0).getAttribute("value"));
		
		
		
		
		
	}

}
