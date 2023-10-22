package com.SwagLabs.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.SwagLabs.Pages.*;
import com.SwagLabs.Utility.PropertiesUtil;
import com.SwagLabs.Utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public AddToCartPage ap;
	public CheckoutPage cp;
	public OverviewPage op;
	public PropertiesUtil ps;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public  ExtentTest test;
	
	
	@BeforeSuite
	public void reportSetUp()
	{
		extent=new ExtentReports();
		//path for report
		   spark = new ExtentSparkReporter("Reports/SwagLabs.html");
		  
		  //configuration for report
		  spark.config().setReportName("SwagLabs_Automation_Report");
		  spark.config().setDocumentTitle("Sprint1 report");
		  spark.config().setTheme(Theme.DARK);
		  
		    
		  //attached the report
		  extent.attachReporter(spark);
		  
		  //create a test
		  test=extent.createTest("SwagLabsTest");
		  
		
	}
	
	@BeforeTest
	public void broswerSetUp()
	{
		driver=new ChromeDriver();
		Reporter.log("Log:WebDriver session is Created!",true);
		test.pass("Driver session is created!");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Log:Swaglabs application Open!",true);
		test.pass("Application Open Successfully!");
		ps=new PropertiesUtil();
		lp=new LoginPage(driver);
		ip=new InventoryPage(driver);
		ap=new AddToCartPage(driver);
		cp=new CheckoutPage(driver);
		op=new OverviewPage(driver);
		
		
	}

	
	@BeforeClass
	public void pageSetUp()
	{
		System.out.println("*********Login functionality*************");
		System.out.println("Application title: "+lp.getAppTitle());
		
		System.out.println("Application Url: "+lp.getAppUrl());
		
		lp.doLogin(ps.getData("un"),ps.getData("psw"));
		Reporter.log("Log:User Login is completed!",true);
		test.pass("User login is completed!");
		Utility.getScreenshot(driver);
		pause();
		System.out.println("***********Inventory page**************");
		System.out.println("Total Products are: "+ip.getProductCount());
		pause();
		Reporter.log("Log:Total Product count is calculated!",true);
		test.pass("Total Product count is calculated!");
		ip.getProductLables();
		ip.addProductToCart(ps.getData("pname"));
		Reporter.log("Log:Product added into cart");
		test.pass("Product added into cart");
		pause();
		Utility.getScreenshot(driver);
		System.out.println("**********Cart Page************");
		ap.openCartPage();
		Utility.getScreenshot(driver);
		ap.doCheckout();
		Utility.getScreenshot(driver);
		test.pass("Check Out is completed!");
		System.out.println("*********Checkout Page**********");
		cp.doContinue(ps.getData("fname"),ps.getData("lname"),ps.getData("zcode"));
		Utility.getScreenshot(driver);
		System.out.println("***************Overview Page******");
		Reporter.log("Log:Order completed!",true);
		test.pass("Order placed!");
	}
	
	
	
	public void pause()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterSuite()
	
	public void exitReport()
	{
		extent.flush();
	}
	
}
