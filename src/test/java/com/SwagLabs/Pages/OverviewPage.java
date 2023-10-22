package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utility.Utility;

public class OverviewPage
{
	
	private WebDriver driver;
	public OverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By productDetails=By.id("checkout_summary_container");
	private By finishbtn=By.id("finish");
	private By msg=By.tagName("h2");
	
	
	//Methods
	public void getDetails()
	{
		String text=driver.findElement(productDetails).getText();
		System.out.println("Product Order Details are:");
		System.out.println(text);
	}
				
	
	public void doFinish()
	{
		driver.findElement(finishbtn).click();
		Utility.getScreenshot(driver);
		System.out.println("Final Result: "+driver.findElement(msg).getText());
	}

}
