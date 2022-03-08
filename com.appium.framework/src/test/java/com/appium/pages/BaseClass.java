package com.appium.pages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.appium.Utility.Excel_Data_Provider;
import com.appium.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseClass {

	public AppiumDriver<MobileElement> driver;
	public ExtentTest logger;
	public ExtentReports report;
	public Excel_Data_Provider excel;
	
	
	@BeforeSuite
	public void setUpexcelSuite()
	{
		Reporter.log("Setting up reports and test is getting ready", true);
		
		excel = new Excel_Data_Provider();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/XPUB_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done - Test can be started", true);
		
	}
	
	
	
	@BeforeClass
	public void setup()
	{
		try {
		DesiredCapabilities cap = new DesiredCapabilities ();
		//cap.setCapability("deviceName", "OPPO A5 2020");
		//cap.setCapability("platformVersion", "11");
		//cap.setCapability("platformName", "Android");
		//cap.setCapability("udid", "e2345f5");
	
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OPPO A5 2020");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.UDID, "e2345f5");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		//cap.setCapability(MobileCapabilityType.APP, "");
		cap.setCapability("noReset",true);
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//cap.setCapability("appPackage", "com.google.android.calculator");
		//cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		cap.setCapability("appPackage", "io.serw.app");
		cap.setCapability("appActivity", "io.serw.app.MainActivity");
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application started");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(20000);
		
		}catch(Exception exp) {
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			exp.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws FileNotFoundException, IOException
	{
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.captureScreenshots(driver)).build());

		}
		
		
		report.flush();
		
		Reporter.log("Test completed >> Report Generated", true);
	}
}
