package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage
{
	private WebDriver driver;
	
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locator
	private By cartpage=By.xpath("//a[@class='shopping_cart_link']");
	private By removebtn=By.xpath("//button[text()='Remove']");
	private By continuebtn=By.id("continue-shopping");
	private By checkoutbtn=By.xpath("//button[text()='Checkout']");
	
	
	//Methods
	public void doRemove()
	{
		driver.findElement(removebtn).click();
		System.out.println("Product got removed from Cart");
	}
	
	public void doContinue()
	{
		driver.findElement(continuebtn).click();
		System.out.println("Inventory page open");
		
	}
	
	
	public void doCheckout()
	{
		driver.findElement(checkoutbtn).click();
	}
	
	
	public void openCartPage()
	{
		driver.findElement(cartpage).click();
	}
	
	
	
	
	
	
	
}
