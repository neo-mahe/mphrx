package com.mphrx.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mphrx.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/maheshbhakuni/eclipse-workspace/MphrxTest/src/main/java/com/mphrx/"
					+ "qa/config/config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		 catch (IOException e)
		{
			 e.printStackTrace();
		}
		}
		
	 public static void initialization()
	 {
		 String browserName= prop.getProperty("browser");
		 if (browserName.equals("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver= new ChromeDriver();
			 
		 }
		 else if (browserName.equals("FF"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 WebDriver driver= new FirefoxDriver();
			 
		 }
		 else if (browserName.equals("Edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 WebDriver driver= new EdgeDriver();
			 
		 }
		 
		 else if (browserName.equals("IE"))
		 {
			 WebDriverManager.iedriver().setup();
			 WebDriver driver= new InternetExplorerDriver();
			 
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));
		 
		 
		 
	 
	 }
	 
	 
	}


