package com.test.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.internal.org.objectweb.asm.commons.Method;

public class CommonActions extends CommonUtils{

	public static Properties prop;
	public static String browserName;
	public static String url;
	public static String driverName;
	public static String userName;
	public static String passWord;
	public static WebDriver driver;
	
	Logger logger = Logger.getLogger(CommonActions.class);
	
	public void TakeScreenShot(String methodName) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\Samsung\\eclipse-workspace\\myproject\\Snapshots\\"+methodName+".jpg"));
		} catch (IOException ele) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false, "Unable to takesnapshot "+ele); 
		}
	}
	
	public static void setProp() throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Samsung\\eclipse-workspace\\myproject\\src\\main\\resources\\config.properties");
		prop = new Properties();

		prop.load(file);

		browserName = prop.getProperty("BROWSER");
		url = prop.getProperty("URL");
		driverName = prop.getProperty("DRIVER");
		userName = prop.getProperty("USERNAME");
		passWord = prop.getProperty("PASSWORD");

	}

	@BeforeTest
	public void InitialStartUp() throws IOException {
		PropertyConfigurator.configure("C:\\Users\\Samsung\\eclipse-workspace\\myproject\\src\\main\\resources\\log4j.properties");
		setProp();

				if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverName);
			logger.info("launching chrome driver");
			driver = new ChromeDriver();
						
		
			
			
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverName);
		
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", driverName);
			driver = new InternetExplorerDriver();
		}

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, driverName);
		logger.info("maximising the browser");
		driver.manage().window().maximize();
		logger.info("waiting for the browser to load through implicit wait");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);


	}

	@AfterTest
	public void TearDown() {
		logger.info("closing the browser");
		driver.quit();
	}


}
