package locatorsdataofRediff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	
public WebDriver driver;


 @FindBy(id="login1")
 private WebElement emailaddress;

 @FindBy(name="passwd")
 private WebElement passwordaddress;
 
 @FindBy(xpath="//input[@class='signinbtn']")
 private WebElement sibutton;
 
 @FindBy(xpath="//div[@id='div_login_error']/b")
 private WebElement errormessage;
 
 
 
public LoginPage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver,this);
	
}



public AccountPage NavigateToAccountPage(String emailtext, String passwordtext) 
{
	emailaddress.sendKeys(emailtext);
	passwordaddress.sendKeys(passwordtext);
	sibutton.click();
	return new AccountPage(driver);
}

public void SigBtn() 
{
	sibutton.click();
}

public boolean ErrorMessage()
{
	boolean resu= errormessage.isDisplayed();
	return resu;
}

}

