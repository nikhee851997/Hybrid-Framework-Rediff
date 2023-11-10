package commondataofRediff;

import java.io.FileReader;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import incorrectdataofRediff.Details;

public class CommonCode 
{
public WebDriver driver;
public ChromeOptions opt;
public Properties pr1;
public FileReader fr1;
public Properties pr2;
public FileReader fr2;


public CommonCode() throws Exception 
{
	
	fr1= new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\configdataofRediff\\ConfigProperties");
	
	pr1= new Properties();
	
	pr1.load(fr1);
	
	pr2= new Properties();
	
	fr2= new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\systemdataofRediff\\SystemProperties");
	
	pr2.load(fr2);
	
	
}

public WebDriver ValidateToApplication()
{
	opt= new ChromeOptions();
	opt.addArguments("incognito");
	opt.addArguments("start-maximized");
	opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	opt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
	driver= new ChromeDriver(opt);
	driver.get(pr1.getProperty("URL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Details.IMPLICIT_WAIT));
	return driver;

}












}
