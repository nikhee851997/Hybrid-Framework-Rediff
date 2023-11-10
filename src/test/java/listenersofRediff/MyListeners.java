package listenersofRediff;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reportmanager.ExtentReportManager;

public class MyListeners implements ITestListener
{
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;

	@Test(priority=1)
	public void onStart(ITestContext context) 
	{
		String Testcase = context.getName();
		extent = ExtentReportManager.GenerateExtentRepots();
		test= extent.createTest(Testcase);
		test.log(Status.INFO, Testcase+ "------------->started");
		
	}

	@Test(priority=2)
	public void onTestStart(ITestResult result) 
	{
	     String TestCases = result.getName();
	     test= extent.createTest(TestCases);
	     test.log(Status.INFO, TestCases+"------------>Execution is going on");	
	}

	@Test(priority=3)
	public void onTestSuccess(ITestResult result)
	{
	   String TestCasesu = result.getName();
	
	   test.log(Status.PASS, TestCasesu+"-------------->passed Execution");
	}

	@Test(priority=4)
	public void onTestFailure(ITestResult result)
	{
		String TestCaselu = result.getName();
	
	    
		driver= null;
		
	try 
	{
	  driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());		
	} 
	catch (IllegalArgumentException e) 
	{
		e.printStackTrace();
	} 
	catch (IllegalAccessException e) 
	{
		e.printStackTrace();
	} 
	catch (NoSuchFieldException e) 
	{
		e.printStackTrace();
	}
	catch (SecurityException e)
	{
		e.printStackTrace();
	}

		
	   File srce= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	               
	   String dest=  System.getProperty("user.dir")+"\\test-output\\Screenshots\\" + TestCaselu + ".png";
	
		try 
		{
			FileHandler.copy(srce, new File(dest));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(dest);
		test.log(Status.FAIL, TestCaselu+"-------------->Failed Execution");
		
	}

	@Test(priority=5)
	public void onTestSkipped(ITestResult result) 
	{
	   String TestCaseip = result.getName();
	 
	   test.log(Status.SKIP, TestCaseip+"------------->Skipped Execution");
	   
	}
	
	@Test(priority=6)
	public void onFinish(ITestContext context) 
	{
	    String TestCasela = context.getName();
	    test = extent.createTest(TestCasela);
	    test.log(Status.INFO, TestCasela+"----------->Finished");
	    extent.flush();
	    
	 String existingpath =  System.getProperty("user.dir")+"\\src\\test\\java\\ExtentReportSample\\Index.html";
    
	 File desktopath = new File(existingpath);
	 
	  try 
	  {
		Desktop.getDesktop().browse( desktopath.toURI());
	  } 
	  catch (IOException e)
	  {
		e.printStackTrace();
	  }
	   
	}

}
