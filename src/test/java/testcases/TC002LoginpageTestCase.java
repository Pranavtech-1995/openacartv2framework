package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testbase.BaseClass;

public class TC002LoginpageTestCase extends BaseClass {



@Test (groups= {"sanity","master"})
public void LoginPageTestcase()
{
	try 
    {
	HomePage hp =new HomePage(driver);
	hp.clickOnMyAccount();
	hp.clockonlogin();
	LoginPage lp = new LoginPage (driver);
	lp.input_email(prop.getProperty("id"));
	lp.input_password(prop.getProperty("password"));
	lp.btn_login();
	
	
	MyAccountPage map = new MyAccountPage(driver);
     boolean status= map.exist_myaccountpage();
     logger.info("*******");
 
     
     
     if (status==true) 
     {
    	 logger.info("*******");
    	 map.btn_logout(); 
    	 Thread.sleep(2000);
    	 Assert.assertTrue(true);  
     }
     
     
     
    }
     catch (Exception e)
     {
    	 System.out.println(e.getMessage());
    	 Assert.fail();
    	 
     }
   
     



}








}
