package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.SwagLabs.Utility.Utility;

public class LoginPage 
{
	
	//Encapsulation=data+functions
	
	private WebDriver driver;
	
	//initialize driver
	public LoginPage(WebDriver driver)//base class driver
	{
		this.driver=driver;
	}
	
	//Locators
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginbtn=By.id("login-button");
	
	//Methods
	public void doLogin(String un,String psw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		Utility.getScreenshot(driver);
		driver.findElement(loginbtn).click();
		//validate
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Login Fail");
		System.out.println("User Login Completed!");
	}
	
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
	
	

}
