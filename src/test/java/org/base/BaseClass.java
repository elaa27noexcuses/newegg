package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			driver = new ChromeDriver();
		}else if (bname.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
			else if(bname.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		return driver;
			
		}
	public static WebDriver browserLaunch2(String bname) {
		switch(bname) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		default:
			System.out.println("browser name is invalid");
		}
		return driver;
			
		}

	public static void urlLaunch(String url) {
		driver.get(url);
		
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void implicitWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	public static void click(WebElement b) {
		try {
			b.click();
			}catch(Exception e){
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", b);
			}
		
	}
	public static void refresh() {
		driver.navigate().refresh();
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
	
	public static String text(WebElement e) {
		String text1 = e.getText();
		return text1;
		
	}
	public static String getAttribue(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
		
	}	
	public static boolean waitUrl(long sec ,String val){
		WebDriverWait w = new WebDriverWait(driver,sec);
		return w.until(ExpectedConditions.urlContains(val));
	}

}
