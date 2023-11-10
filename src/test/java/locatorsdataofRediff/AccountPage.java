package locatorsdataofRediff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage 
{

	public WebDriver driver;
	
	
	@FindBy(xpath="//a[contains(@class, 'rd_logout')]")
	private WebElement logoutlink;
	
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public LogoutPage NavigateToLogoutPage() 
	{
		logoutlink.click();
		return new LogoutPage(driver);
	}
	
	
	
	
	
	
	
	
	
}
