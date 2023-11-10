package reportmanager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager
{

	public static ExtentReports GenerateExtentRepots()
	{
		ExtentReports extent = new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\java\\ExtentReportSample\\");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Rediff_Report");
		spark.config().setTimeStampFormat("MM:dd:yy  HH:mm:ss");
		spark.config().setDocumentTitle("ProjectN_JiraStory_QA/ExtentRep");
		
		
		extent.attachReporter(spark);
		
		return extent;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
