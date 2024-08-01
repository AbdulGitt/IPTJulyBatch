package org.test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://letcode.in/table");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> tables = driver.findElements(By.tagName("table"));
		System.out.println(tables.size());
		
		WebElement t3rTable = tables.get(2);
		
//		System.out.println(t3rTable.getText());
		
		List<WebElement> tdatas = t3rTable.findElements(By.tagName("td"));
//		List<String> li=new LinkedList<>();
//		for(int i=0;i<tdatas.size();i++) {
//			li.add(tdatas.get(i).getText());
//		}
//		
//		System.out.println(li);
		
		List<WebElement> theads = t3rTable.findElements(By.tagName("th"));
		int columnIndex=1;
		
		for(int i=0;i<theads.size();i++) {
			String a = theads.get(i).getText();
			if(a.contains("Calories")) {
				break;
			}
			columnIndex++;
		}
		
		System.out.println("Fat is in "+columnIndex+" Column");
		
		List<WebElement> fats = driver.findElements(By.xpath("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']//tr//td["+columnIndex+"]"));
		
		int total=0;
		for(WebElement x:fats) {
			String a = x.getText();
			int parseInt = Integer.parseInt(a);
			total=total+parseInt;			
		}
		
		System.out.println(total);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
