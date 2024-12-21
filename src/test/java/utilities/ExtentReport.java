package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;



public class ExtentReport implements ITestListener {

	ExtentSparkReporter sparkreporter;//UI Of report
	ExtentReports extent;// common info of the report
	ExtentTest test;// result pass or fail status test entries 
	String repname;
	
   public void onStart(ITestContext context ) {
	   
	   
	   String  timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	   repname= "TestReport"+"-"+timestamp+ ".html";
	   
       sparkreporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+repname);
        sparkreporter.config().setDocumentTitle("TESTING");
        sparkreporter.config().setReportName("Listener report");
        sparkreporter.config().setTheme(Theme.DARK);
        
        extent= new ExtentReports();
        extent.attachReporter(sparkreporter);
        
        extent.setSystemInfo("Application","opencart" );
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("SubModule", "Customer");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment ", "QA");
        
       String os =context.getCurrentXmlTest().getParameter("os");
       extent.setSystemInfo("Operating system", os);
       String browser=context.getCurrentXmlTest().getParameter("browser");
       extent.setSystemInfo("Browser", browser);
        List <String>  groups=context.getCurrentXmlTest().getIncludedGroups();
        if (!groups.isEmpty()) 
        {
        	extent.setSystemInfo("Groups", groups.toString());
        }
       
        
   }
   public void onTestSuccess(ITestResult result)
   {
	   test= extent.createTest(result.getTestClass().getName());
	   test.assignCategory(result.getMethod().getGroups());//to display group
	   test.log(Status.PASS, "Testcase passed is "+result.getName());
   }
   public void onTestFailure(ITestResult result )
   {
	   test=extent.createTest(result.getTestClass().getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.log(Status.FAIL, "Testcase fail is "+result.getName());
	   test.log(Status.INFO, "Test  case fail reason is "+result.getThrowable().getMessage());
	   
	   try
	   {
		   String imgpath=new BaseClass().capturescreenshot(result.getName());
		   test.addScreenCaptureFromPath(imgpath);
	   }
	   catch (Exception e)
	   {
		   System.out.println(e.getMessage());
	   }
	   
	   
   }
   public void onTestSkipped(ITestResult result) 
   {
	   test =extent.createTest(result.getTestClass().getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.log(Status.SKIP, "Testcase skip is"+result.getName());
	   
   }
   public void onFinish(ITestContext context)
   {
	   extent.flush();
	   
	   String outputpath =System.getProperty("user.dir")+"\\Reports\\"+repname;
	   File Extentreport = new File (outputpath);
	   
	   try 
	   {
		   Desktop.getDesktop().browse(Extentreport.toURI());
	   }
	   catch (Exception e)
	   {
		   System.out.println(e.getMessage());
	   }
     

   
   }


  




}
