package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTables {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).sendKeys("demo");
		driver.findElement(By.name("password")).sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebDriverWait w=new WebDriverWait(driver, 20);
		WebElement until = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-close")));
		until.click();
		
		driver.findElement(By.id("menu-customer")).click();
		
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[text()='Customers']")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(text);
		
		System.out.println(text.indexOf('('));
		System.out.println(text.indexOf("Pages"));
		
		int total_pages = Integer.parseInt(text.substring(text.indexOf('(')+1, text.indexOf("Pages")-1));
		System.out.println("Total pages :"+total_pages);
		
		
		
		
		
	}

}
