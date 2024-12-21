package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage{



 public RegistrationPage (WebDriver driver)
 {
	 super(driver);
 }

 
 @FindBy (xpath="//input[@id='input-firstname']")
 WebElement txt_firstname;
 @FindBy (xpath="//input[@id='input-lastname']")
 WebElement txt_lastname;
 @FindBy (xpath="//input[@id='input-email']")
WebElement txt_email;
 @FindBy (xpath="//input[@id='input-password']")
 WebElement txt_password;
 @FindBy (xpath="//input[@id='input-newsletter']")
 WebElement toggle_subscribe;
 @FindBy (xpath="//input[@name='agree']")
 WebElement toggle_privacypolicy;
 @FindBy (xpath="//button[normalize-space()='Continue']")
 WebElement btn_continue;
 @FindBy (xpath="//h1[normalize-space()='Your Account Has Been Created!']")
 WebElement btn_Confirmationmessage;
 
 
 
 
public void txt_firstname(String firstname)
{
	txt_firstname.sendKeys(firstname);
}
 public void txt_lastname(String lastname) 
 {
	 txt_lastname.sendKeys(lastname);
 }
 public void txt_email(String email_Id)
 {
	 txt_email.sendKeys(email_Id);
 }
public void txt_password(String password)
{
	txt_password.sendKeys(password);
}
public void toggle_subscribe()
{
	//toggle_subscribe.click();
	
	//JavascriptExecutor js= (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].click()", toggle_subscribe);
	//toggle_subscribe.submit();
	//WebDriverWait wb = new WebDriverWait (driver,Duration.ofSeconds(10));
	//wb.until(ExpectedConditions.elementToBeClickable(toggle_subscribe));
	Actions act= new Actions (driver);
	act.moveToElement(toggle_subscribe).click().perform();
	//toggle_subscribe.sendKeys(Keys.RETURN);
	
	
}
public void toggle_privacypolicy()
{
	Actions act= new Actions (driver);
	act.moveToElement(toggle_privacypolicy).click().perform();
	//toggle_privacypolicy.click();
}
public void  btn_continue()
{
	btn_continue.click();
}
public String btn_Confirmationmessage()
{
	try 
	{
      return btn_Confirmationmessage.getText();
   
	}
	catch (Exception e)
	{
		return e.getMessage();
	}
}

}
