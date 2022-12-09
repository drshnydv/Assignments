package org.genriclib;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver sDriver;
	
	public WebDriver driver;
	
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	
	public static ExtentReports reports;
	
	public static ExtentTest test;
	
	@BeforeSuite
	public void bsConfig() {	
		System.out.println("Before Suite");	
	}
	
	@BeforeTest
	public void btConfig() {	
		reports = new ExtentReports("./reports/reports.html", false);	
	}
	
	@BeforeClass
	public void bcConfig() {	
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);	
		driver.manage().window().maximize();	
		sDriver = driver;	
	}
	
	@AfterClass
	public void acConfig() {	
		//driver.close();
	}
	
	@AfterTest
	public void atConfig() {	
		reports.endTest(test);	
		reports.flush();	
	}
	
	@AfterSuite
	public void asConfig() {	
		System.out.println("After Suite");	
	}

}