package com.appium.testcases;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.appium.Utility.Helper;
import com.appium.pages.BaseClass;
import com.appium.pages.LoginPage;



public class LoginToExpertRepublicApp extends BaseClass {

	
	@Test(priority = 1 )
	public void LoginToApp() throws InterruptedException, IOException
	{
		 // creates a toggle for the given test, adds all log events under it    
		logger= report.createTest("Login to App");
        
		logger.pass("---> App started and going to loging to the app<---");
        Thread.sleep(4000);
        
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        
       
        loginPage.login(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
        logger.pass("---> Successfully logged in <---");
        
        Thread.sleep(7000);
        
        String Actualtext = loginPage.LoginValidation();
        String expectedText = "My Bookings (As Expert)";
        
        if (Actualtext.contains(expectedText))
        {
        	logger.pass("Login success and the opened window is correct :- " + Actualtext);
        }else
        	
        {
        	logger.fail("Didn't move to the correct window after logged in");
        }
      
         
        Helper.captureScreenshots(driver);
        
        Thread.sleep(7000);
		
	
	}
	
	@Test(priority = 2 )
	public void LogOutFromApp() throws InterruptedException, IOException
	{
		
		logger= report.createTest("Logout from App");
        
		logger.pass("---> Going to log out from the app <---");
        Thread.sleep(4000);
        
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        
        loginPage.logout();
        
        Thread.sleep(6000);
        
        String Actualtext = loginPage.logoutVerify();
        String expectedText = "Login as Guest";
        
        if (Actualtext.contains(expectedText))
        {
        	logger.pass("Successfully logged out the button is visible :- " + Actualtext);
        }else
        	
        {
        	logger.fail("Login as Guest button is missing" +Actualtext);
        }
      
        
        Thread.sleep(7000);
        
        Helper.captureScreenshots(driver);
	}
	
}
