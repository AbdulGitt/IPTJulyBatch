package org.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {
	
	public static void selectDate(WebDriver driver,String date,String month,String year) {
		while(true) {		
			String text = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(text);
			String[] sp = text.split(" ");
			String mon=sp[0];
			String yr=sp[1];
			
			if(month.equalsIgnoreCase(mon)&& year.equalsIgnoreCase(yr)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			}
			}
			
			List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
			for(WebElement x:dates) {
				if(x.getText().equalsIgnoreCase(date)) {
					x.click();
				}
			}
		
	}
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("datepicker1")).click();
		
		selectDate(driver, "12", "January", "2025");
		
	
		
		
		
	}
	

}
