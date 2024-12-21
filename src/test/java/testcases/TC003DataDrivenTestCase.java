package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;
@Test (dataProvider="logindata",dataProviderClass=DataProviders.class,	groups= {"Regression","master"})
public class TC003DataDrivenTestCase extends BaseClass {
	public void DataDrivenTestCase(String email, String password, String exp)
	{
		
		
		try 
	    {
		logger.info("********start********");
		HomePage hp =new HomePage(driver);
		logger.info("********start********");
		hp.clickOnMyAccount();
		hp.clockonlogin();
		logger.info("********start********");
		LoginPage lp = new LoginPage (driver);
		lp.input_email(email);
		lp.input_password(password);
		lp.btn_login();
		
		
		MyAccountPage map = new MyAccountPage(driver);
	     boolean status= map.exist_myaccountpage();
	     
	     logger.info("********");
	     
	     if (exp.equalsIgnoreCase("Valid"))
	     {
	    	if (status==true) 
	    	{
	   	     logger.info("********");
	   	  
	   	     map.btn_logout();
	    	  logger.info("****");
	    	 Assert.assertTrue(true);
	    	 
	    	 
	    	}
	    	 else 
		     {
		         Assert.assertTrue(false);
		     }
	     }
	     
	     
	     if (exp.equalsIgnoreCase("Invalid"))
	     { 
	    	 if (status==true) 
		    	{
		    	 map.btn_logout();
		    	 Assert.assertTrue(false); 
		    	 
		    	}
		    	 else 
			     {
			         Assert.assertTrue(true);
			     }
	    	
	     }
	     
	     }
	     catch (Exception e)
		
	     {
	    	 System.out.println(e.getMessage());
	    	 Assert.fail();
	     }
	}}
	   
	     

























