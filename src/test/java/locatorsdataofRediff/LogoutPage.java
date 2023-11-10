package locatorsdataofRediff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
 public WebDriver driver;
 
	@FindBy(xpath="//div[@class='panel']/p")
	private WebElement displaymessage;
	
	
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public boolean NotificationMessage()
	{
		boolean res = displaymessage.isDisplayed();
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
