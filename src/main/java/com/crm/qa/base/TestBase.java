package com.crm.qa.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/krupalpatel/Desktop/Workspace2/CRMHybridFramework/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		
		String browser =prop.getProperty("browser");
		if (browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/krupalpatel/Desktop/SeleniumJars/chromedriver");
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/krupalpatel/Desktop/SeleniumJars/geckodriver");
			driver = new FirefoxDriver(); 
		}
		
		else {
			System.setProperty("webdriver.safari.driver", "/Users/krupalpatel/Desktop/SeleniumJars/safaridriver");
			driver = new SafariDriver(); 
		}
		
		
		
		
		  e_driver = new EventFiringWebDriver(driver); // Now create object of EventListerHandler to register it with EventFiringWebDriver 
		  eventListener = new WebEventListener(); 
		  e_driver.register(eventListener);
		  driver = e_driver;
		 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
