package com.qa.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.Utility.TestUtility;
import com.qa.Utility.WebEventListener;



public class BaseClass {
	
		public static Properties prop;
		public static WebDriver driver;
		EventFiringWebDriver  e_Listener;
		WebEventListener eventfiring;
	
		public  BaseClass() {
		
			try {
				prop = new Properties();
				FileInputStream file = new FileInputStream(
						"C:/Users/jatin/eclipse-workspace/qa.TechFios.Test/src/main/java/com/qa/config/config.properties");
				
				prop.load(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void Initialization() {
			TestUtility waits = new TestUtility();
			
			
			String browser = prop.getProperty("Browser");

			if (browser.equals("Chrome")) {
				

				System.setProperty("webdriver.chrome.driver", "C:/Users/jatin/eclipse-workspace/qa.TechFios.Test/driver/chromedriver.exe");
				driver = new ChromeDriver();}
			 else if (browser.equals("firefox")) {

				System.setProperty("webdriver.chrome.driver", "/crm.automation.test/driver/chromedriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equals("IE")) {

				System.setProperty("webdriver.chrome.driver", "/crm.automation.test/driver/chromedriver.exe");
				driver = new InternetExplorerDriver();
			}
			EventFiringWebDriver  e_Listener= new EventFiringWebDriver(driver);// we create this objct of EventFiringWebDriver class
			     eventfiring = new  WebEventListener();// now creat objct of our Util class  WebEventListener to register it with EventFiringWebDriver
			     e_Listener.register(eventfiring);// register
			driver =e_Listener;// Assigning to driver

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(waits .implicitiWait, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(waits .pageLoadWait, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get(prop.getProperty("AppUrl"));
		}
	}


