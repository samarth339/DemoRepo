package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing4 {
		SoftAssert softAssert = new SoftAssert();    // inbuild class softassert 
		
		@Test (priority = 1)
	  public void homeTest() 
	  {
			System.out.println("I am in Home test");
			System.out.println("Before Assertion");
			// Assert.assertTrue(4<3,"Verifying Element");  // works same as JUnit assertion  , test code stops after assertion fails
			Assert.assertTrue(2>3,"Verifying Element");
			
			
			System.out.println("After Assertion");
			Assert.assertEquals("abc", "abc");
			
			
	  }
	  
	  @Test (priority = 2  , dependsOnMethods = "homeTest" , groups = {"smoke", "sanity"})    // adding dependencies, if homeTest fails, it will skip this Test
	  public void mainTest() 
	  {
			System.out.println("I am in Main test");
			System.out.println("Before Assertion");
			
			softAssert.assertTrue(2<10,"Verifying Element");
			
			
			System.out.println("After Assertion");
			Assert.assertEquals("abc", "abc");
			
			softAssert.assertAll();   // similar to collector in Junit
		
	  }
	  
	  
	  @Test (priority = 3 , dependsOnMethods = "mainTest" , groups ="sam")   // adding dependencies, if mainTest fails, it will skip this Test
	  public void deleteUser() 
	  {
			System.out.println("I am in End test");
			System.out.println("Before Assertion");
			
			softAssert.assertTrue(2<10,"Verifying Element");
			System.out.println("After Assertion");
			softAssert.assertEquals("abc", "abc1");
			System.out.println("After Second Assertion");
				
			softAssert.assertAll();   // similar to collector in Junit
		
	  }

}
