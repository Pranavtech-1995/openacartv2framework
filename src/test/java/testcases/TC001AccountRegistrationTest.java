package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testbase.BaseClass;

public class TC001AccountRegistrationTest extends BaseClass{





@Test (groups= {"sanity","master"})
public void verify_registration_account()
{ 
	try {
	   logger.info("*****started*********");
       HomePage hp= new HomePage(driver);
       hp.clickOnMyAccount();
       logger.info("*****clicked on my account*********");
       hp.clickOnRegister();
       RegistrationPage rpage=  new RegistrationPage(driver);
       rpage.txt_firstname(randomString().toUpperCase());
       rpage.txt_lastname(randomString().toUpperCase());
      // rpage.txt_firstname(prop.getProperty("name"));
       rpage.txt_email(randomString()+"@gmail.com");
       logger.info("*****Txt_email*********");
       rpage.txt_password(randomAlphaNumericPass());
       rpage.toggle_subscribe();
       rpage.toggle_privacypolicy();
       rpage.btn_continue();
       String Confmsg =rpage.btn_Confirmationmessage();
       System.out.println(Confmsg);
       logger.info("***** enteringValidation*********");
       if (Confmsg.equals("Your Account Has Been Created!"))
       {
    	   logger.info("*****Validation*********");
    	   Assert.assertTrue(true);
       }
       else 
       {
    	   logger.error("***Test failed");
   		   logger.debug("******debug mode******"); 
   		   Assert.assertFalse(true);
       }
     
       
       
       
       
	}
	catch(Exception e)
	{
		e.getMessage();
		Assert.fail();
	}
	logger.info("*****finished*********");

}



}
