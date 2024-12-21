package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {



public LoginPage(WebDriver driver )

{
	super(driver);
}


@FindBy (xpath="//input[@id='input-email']")
WebElement input_email;
@FindBy (xpath="//input[@id='input-password']")
WebElement input_password;
@FindBy (xpath="//button[normalize-space()='Login']")
WebElement btn_login;


public void input_email(String email)
{
	input_email.sendKeys(email);
	
}
public void input_password(String Password)
{
	input_password.sendKeys(Password);
}
public void btn_login()
{
	btn_login.click();
}









}
