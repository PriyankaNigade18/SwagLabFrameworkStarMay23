package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyCheckOut() 
  {
	  cp.doContinue("Priyanka","Nigade","411047");
  }
}
