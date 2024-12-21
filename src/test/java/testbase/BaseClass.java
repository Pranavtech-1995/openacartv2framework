package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver ;//while doing parllel testin we can't use static keyword
	public Logger  logger;
	public Properties prop;
	@Parameters({"browser","os"})
	@BeforeClass(groups= {"sanity","Regression","master"})
	 public void SetUp(String br,String os) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());
		FileReader file = new FileReader("./src//test//resources//config.properties");
	     prop= new Properties();
		prop.load(file);
		
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities= new DesiredCapabilities();
			
			//capabilities.setPlatform(Platform.WIN10);
			//capabilities.setBrowserName("chrome");
			
			if (os.equalsIgnoreCase("window"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				
				capabilities.setPlatform(Platform.MAC);
			}
			
			else if (os.equalsIgnoreCase("linux"))
			{
				
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
	       
				
		
		 switch (br.toLowerCase())
		 {
		 
		 case "chrome": capabilities.setBrowserName("chrome");break;
		 case  "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
		 case  "firefox":capabilities.setBrowserName("firefox");break;
		      default : System.out.println("invalid browser");return;
		 
		 }	
		 driver= new RemoteWebDriver(new URL("http://192.168.1.8:4444"),capabilities);
		
		
		}	
		
		if (prop.getProperty("execution_env").equalsIgnoreCase("local")) 
		{
		switch (br.toLowerCase())
		{
		case "chrome":driver= new ChromeDriver();break;
		case  "edge" : driver=new EdgeDriver();break;
	    default : System.out.println("Invalid browser");return;
		}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("appurl"));
		
		driver.manage().window().maximize();
		
		
	}

	@AfterClass (groups= {"sanity","Regression","master"})
	public void teardown()
	{
		
	        driver.quit();
	    
	}
 
	public String randomString()
	{
		String genrandomString=RandomStringUtils.randomAlphabetic(5);
		return genrandomString;
	}
	public String randomNum() 
	{
		String genrandomnum=RandomStringUtils.randomNumeric(10);
		return genrandomnum;
	}
	public String randomAlphaNumeric()
	{
		String genrandomalphanumeric=RandomStringUtils.randomAlphanumeric(7);
		return genrandomalphanumeric ;
	}
	public String randomAlphaNumericPass()
	{
		String genrandomalpha=RandomStringUtils.randomAlphabetic(5);
		String genrandomnum =RandomStringUtils.randomNumeric(5);
		return genrandomalpha+"@"+genrandomnum ;
	}
	
	public String capturescreenshot(String tname)
	{
		
		   String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	     TakesScreenshot ts= (TakesScreenshot) driver;
	     File source=ts.getScreenshotAs(OutputType.FILE);
	     
         String targetfilepath =System.getProperty("user.dir")+"\\Screenshot\\"+tname+"_"+timestamp+".png";
	     File TargetFile = new File (targetfilepath);
	     source.renameTo(TargetFile);
	     
	     return targetfilepath;
	     
	     
	     
	
	}
	

}

