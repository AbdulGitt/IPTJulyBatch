package org.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//self
		WebElement self = driver.findElement(By.xpath("//a[contains(text(),'Jyothy Labs')]/self::a"));
		System.out.println(self.getText());
		
		//parent
		WebElement parent = driver.findElement(By.xpath("//a[contains(text(),'Jyothy Labs')]/parent::td"));
		System.out.println(parent.getText());
		
		//ancestor
		WebElement ancestor = driver.findElement(By.xpath("//a[contains(text(),'Jyothy Labs')]/ancestor::tr"));
		System.out.println(ancestor.getText());
		
		//child
		List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'Jyothy Labs')]/ancestor::tr/child::td"));
		System.out.println(childs.size());
		
		//descendant
		List<WebElement> descendant = driver.findElements(By.xpath("//a[contains(text(),'Jyothy Labs')]/ancestor::tr/descendant::*"));
		System.out.println(descendant.size());
		
		
		//following
		List<WebElement>  following = driver.findElements(By.xpath("//a[contains(text(),'Jyothy Labs')]/following::*"));
		System.out.println(following.size());
		
		//following-sibling
		List<WebElement> following_siblings = driver.findElements(By.xpath("//a[contains(text(),'Jyothy Labs')]/parent::td/following-sibling::td"));
		System.out.println(following_siblings.size());
		
		//preceding
		List<WebElement> preceding = driver.findElements(By.xpath("//a[contains(text(),'Jyothy Labs')]/parent::td/preceding::td"));
		System.out.println(preceding.size());
		
		
	}

}
