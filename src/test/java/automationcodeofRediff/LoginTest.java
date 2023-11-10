package automationcodeofRediff;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import commondataofRediff.CommonCode;
import incorrectdataofRediff.Details;
import locatorsdataofRediff.AccountPage;
import locatorsdataofRediff.LandingPage;
import locatorsdataofRediff.LoginPage;
import locatorsdataofRediff.LogoutPage;
import testcasesdataofRediff.DatProvForLoginRediff;

public class LoginTest extends CommonCode
{
  
   public WebDriver driver;
   public ChromeOptions opt;
   public LandingPage lan;
   public LoginPage log;
   public AccountPage ap;
   public LogoutPage lg;
   public SoftAssert soft;
   public Alert alert;
  
   
   
   
   
   public LoginTest() throws Exception
   {
		super();
   }

   
   
	@BeforeMethod
	public void setup()
	{
		driver= ValidateToApplication();
		
		lan= new LandingPage(driver);
		
		log=lan.NavigateToLoginPage();
	
	}
	
	
	@Test(priority=1, dataProvider ="Red", dataProviderClass= DatProvForLoginRediff.class)
	public void verifyingLoginWithValidCredentials(String Excelail, String Excelsword)
	{
	  //ap= log.NavigateToAccountPage(pr1.getProperty("Correctemail"),pr1.getProperty("Correctpassword"));
	  ap =log.NavigateToAccountPage(Excelail, Excelsword);
	  lg = ap.NavigateToLogoutPage(); 
	  soft = new SoftAssert();
	  soft.assertTrue(lg.NotificationMessage());
	  soft.assertAll();
	}
	
	
	@Test(priority=2)
	public void verifyingLoginWithValidEmailInvalidPassword()
	{
		  log.NavigateToAccountPage(pr1.getProperty("Correctemail"),pr2.getProperty("Wrongpassword"));
		  soft = new SoftAssert();
		  soft.assertTrue(log.ErrorMessage());
		  soft.assertAll();
	}
	
	
	
	@Test(priority=3)
	public void verifyingLoginWithInvalidEmailValidPassword()
	{
		 log.NavigateToAccountPage(Details.GenerateEmailByUsingDate(),pr1.getProperty("Correctpassword"));
		 soft = new SoftAssert();
		 soft.assertTrue(log.ErrorMessage());
		 soft.assertAll();
	}
	
	
	
	@Test(priority=4)
	public void verifyingLoginWithInValidCredentials()
	{
		 log.NavigateToAccountPage(Details.GenerateEmailByUsingDate(),pr2.getProperty("Wrongpassword"));
		 soft = new SoftAssert();
		 soft.assertFalse(log.ErrorMessage());
		 soft.assertAll();
	}
	
	
	
	@Test(priority=5, dependsOnMethods = "verifyingLoginWithInValidCredentials")
	public void verifyingLoginWithNoCredentials()
	{
		log.SigBtn();
		
		alert= driver.switchTo().alert();
		String actalertmessage= alert.getText();
		String expalertmessage= pr2.getProperty("Popup");
		soft= new SoftAssert();
		soft.assertEquals(actalertmessage, expalertmessage);
		alert.accept();
		soft.assertAll();
		  

	}
	
	
	@AfterMethod
	public void close()
	{
			driver.quit();
	}
	
	
	
}
