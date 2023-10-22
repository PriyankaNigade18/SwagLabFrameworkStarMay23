package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyPageLaunch()
  {
	  ap.openCartPage();
	  
  }
  
  @Test(priority=2)
  public void verifyRemove()
  {
	  ap.doRemove();
	  pause();
	  
  }
  
  @Test(priority=3)
  public void verifyContinue()
  {
	  ap.doContinue();
	  pause();
	  ip.addProductToCart("Sauce Labs Bolt T-Shirt");
	  pause();
	  ap.openCartPage();
	  pause();
  }
  
  @Test(priority=4)
  public void verifyCheckout()
  {
	  ap.doCheckout();
  }
}
