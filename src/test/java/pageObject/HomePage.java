package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {



public HomePage(WebDriver driver)
{
	super(driver);
}

@FindBy (xpath="//a[@class='dropdown-toggle']" )
WebElement lnk_myaccount;
@FindBy (xpath="//a[@class='dropdown-item'][normalize-space()='Register']")
WebElement lnk_register;
@FindBy (xpath="//a[normalize-space()='Login']")
WebElement lnk_login;


public void clickOnMyAccount ()
{
	lnk_myaccount.click();
}

public void clickOnRegister()
{
	lnk_register.click();
}


public void clockonlogin()
{
	lnk_login.click();
}




}
