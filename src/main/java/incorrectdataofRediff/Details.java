package incorrectdataofRediff;

import java.util.Date;

import org.openqa.selenium.WebDriver;

public class Details 
{
public WebDriver driver;

public static String GenerateEmailByUsingDate() 
{
  Date date  = new Date();
  String TimeStamp = date.toString().replace(" ", "_").replace(":","_");
  return "seleniumpanda" +TimeStamp+ "@rediffmail.com";
 
}

public static final int IMPLICIT_WAIT=10;

}