package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver browserLaunch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		return driver;		

	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	
	public static String getAttribute(WebElement e,String name) {
		String attribute = e.getAttribute(name);
		return attribute;
	}
	
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();		
	}
	
	public static void draganddrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();		
	}
	
	public static void selectByIndex(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	
	public static void frames(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void frames(String idorname) {
		driver.switchTo().frame(idorname);
	}
	
	public static void frames(WebElement e) {
		driver.switchTo().frame(e);
	}
	
	public static String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public static Set<String> getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;

	}
	
	public static void getScreeshot(String name) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\"+name+".png");
		FileUtils.copyFile(src, des);
	}
	
	public static void jsSendKeys(WebElement e,String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"')", e);

	}
	

	
//	public static String getExcel(String excelname,String sheet,int rowno,int cellno) throws IOException {
//		File f=new File("C:\\Users\\abdul\\eclipse-workspace\\MavenFeb8PmBatch24\\src\\test\\resources\\"+excelname+".xlsx");
//		FileInputStream fi=new FileInputStream(f);
//		Workbook w=new XSSFWorkbook(fi);
//		Sheet s = w.getSheet(sheet);
//		Row r = s.getRow(rowno);
//		Cell c = r.getCell(cellno);
//		int cellType = c.getCellType();
//		
//		String value=null;
//		if(cellType==1) {
//			 value = c.getStringCellValue();
//			
//		}
//		else if(DateUtil.isCellDateFormatted(c)) {
//			Date d = c.getDateCellValue();
//			SimpleDateFormat sm=new SimpleDateFormat("DD-MM-YYYY");
//			 value = sm.format(d);
//		}
//		else {
//			double nv = c.getNumericCellValue();
//			long l=(long)nv;
//			 value = String.valueOf(l);
//		}
//		return value;
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
