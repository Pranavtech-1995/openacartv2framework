package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {




public MyAccountPage (WebDriver driver) 
{
	super(driver);
}


@FindBy (xpath="//h2[normalize-space()='My Account']")
WebElement exist_myaccountpage;
@FindBy (xpath="//div[@class='list-group mb-3']//a[text()='Logout']")
WebElement btn_logout;



public boolean exist_myaccountpage()
{
	try 
	{
	return exist_myaccountpage.isDisplayed();
	}
	catch (Exception e)
	{
		return false;
	}
}
	
public void btn_logout() {
    try {
        // Scroll the logout button into view
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", btn_logout);
        btn_logout.click();
        
        //WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(btn_logout));

        // Perform the click using Actions
       // Actions act = new Actions(driver);
       // act.moveToElement(btn_logout).click().build().perform();
    } catch (Exception e) {
        // Fallback to JavaScript click if Actions fails//all fail this is working
        JavascriptExecutor js = (JavascriptExecutor) driver;///use this as in best practice ///it will work
        js.executeScript("arguments[0].click();", btn_logout);
        System.out.println("print");
    }

}}








