package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utility.Utility;

public class CheckoutPage
{

	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Locator
	private By fname=By.id("first-name");
	private By lname=By.id("last-name");
	private By zcode=By.name("postalCode");
	private By cancelbtn=By.id("cancel");
	private By continuebtn=By.id("continue");
	
	
	//Methods
	public void doCancel()
	{
		driver.findElement(cancelbtn).click();
	}
	
	public void doContinue(String fn,String ln,String zc)
	{
		
		driver.findElement(fname).sendKeys(fn);
		driver.findElement(lname).sendKeys(ln);
		driver.findElement(zcode).sendKeys(zc);
		System.out.println("User details are entered");
		Utility.getScreenshot(driver);
		driver.findElement(continuebtn).click();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
