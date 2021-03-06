package com.appium.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class LoginPage {
	
	public ExtentTest logger;
	public ExtentReports report;

	public WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		
	}
	
	@FindBy(xpath="//*[@text = 'My Bookings (As Expert)' and @index = '1']") WebElement homeHeading;
	
	@FindBy(xpath="//*[@text = 'Chat with expert' and @index = '0']") WebElement Chatwithexpertbtn;
	
	@FindBy(xpath="//*[@text = 'Login' and @index = '0']") WebElement Loginbtn1;
	
	@FindBy(xpath="//*[@text = 'E-mail address' and @index = '3']") WebElement Email;
	
	@FindBy(xpath="//*[@text = 'Password' and @index = '4']") WebElement Password;
	
	@FindBy(xpath="//*[@text = 'LOGIN' and @index = '0']") WebElement Loginbtn2;
	
	@FindBy(xpath="//*[@text = '󰍜' and @index = '0']") WebElement sidemenu1;
	
	@FindBy(xpath="//*[@class = 'android.widget.TextView' and @index = '0']") List<WebElement> sidemenu;
	
	@FindBy(xpath="//*[@class = 'android.view.ViewGroup' and @index = '8']") WebElement switchToCustomer;
	
	@FindBy(xpath="//*[@text = 'Logout' and @index = '0']") WebElement logout;
	
	@FindBy(xpath="//*[@text = 'Login as Guest' and @index = '0']") WebElement logoutSuccessWin;
	
	@FindBy(xpath="//*[@class = 'android.view.ViewGroup' and @index = '2']") WebElement settingsbtn;
	
	
	
	
	
	public void login(String email, String password) throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.HorizontalScrollView']])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]/*[@class='android.widget.ImageView'])[1]")).click();
		System.out.println("----->>main category clicked.........>>");
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView' and ./parent::*[./parent::*[@class='android.widget.ScrollView']]]]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();		System.out.println("----->>main category clicked.........>>");
		System.out.println("----->>Sub category clicked.........>>");
		Thread.sleep(4000);
		
		Chatwithexpertbtn.click();
		System.out.println("----->>Chat with expert button clicked.........>>");
		Thread.sleep(4000);
		
		Loginbtn1.click();
		System.out.println("----->>Login button clicked.........>>");
		Thread.sleep(4000);
       
		Email.sendKeys(email);
		System.out.println("----->>Email entered.........>>");
		Thread.sleep(4000);
		
		Password.sendKeys(password);
		System.out.println("----->>Password entered.........>>");
		Thread.sleep(4000);
		
		Loginbtn2.click();
		System.out.println("----->>Login button clicked.........>>");
		Thread.sleep(4000);
	}
	
	public  String LoginValidation()
	{
		return  homeHeading.getText();
		
	}
	
	public void logout() throws InterruptedException
	{
		
		sidemenu.get(0).click();
		System.out.println("----->>Side menu clicked.........>>");
		Thread.sleep(4000);
		
		switchToCustomer.click();
		System.out.println("----->>From Side menu Switch to Customer clicked.........>>");
		Thread.sleep(4000);
		
		settingsbtn.click();
		System.out.println("----->>Side menu settings clicked.........>>");
		Thread.sleep(4000);
		
		logout.click();
		System.out.println("----->>Logout clicked.........>>");
		Thread.sleep(4000);
	}
	
	public  String logoutVerify()
	{
		return  logoutSuccessWin.getText();
		
	}
	
}
