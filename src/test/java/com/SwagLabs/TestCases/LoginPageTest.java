package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyCurrentUrl()
  {
	  String actUrl=lp.getAppUrl();
	  Assert.assertTrue(actUrl.contains("demo"),"Url is not valid");
	  System.out.println("Application url is: "+actUrl);
  }
  
  @Test(priority=2)
  public void verifyTitle() 
  {
	  System.out.println("Application title is: "+lp.getAppTitle());
  }
  
  @Test(priority=3)
  public void verifyLogin() 
  {
	  lp.doLogin("standard_user","secret_sauce");
  }
}
