package org.test;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//sendkeys can be used to upload only if the upload option has name attribute
//		WebElement drop = driver.findElement(By.name("uploadfile_0"));
////		drop.click();
//		drop.sendKeys("C:\\Users\\abdul\\Downloads\\sample-clouds-400x300 (2).jpg");
		
		driver.findElement(By.id("pickfiles")).click();
		
		StringSelection s=new StringSelection("C:\\Users\\abdul\\Downloads\\tamilsd1.pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
		Thread.sleep(4000);
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
