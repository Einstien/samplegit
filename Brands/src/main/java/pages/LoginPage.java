package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase
{

	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='txtUsername']")
	WebElement username;
	public void username(String un)
	{
		username.sendKeys(prop.);
	}
	
	@FindBy(how=How.XPATH, using= "//span[@id='spnPassword']")
	WebElement password;
	public void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	@FindBy(how=How.NAME, using = "Button1")
	WebElement loginbtn;
	public DashboardMainPage loginbtn()
	{
		
		loginbtn.click();
		return new DashboardMainPage();
	}
}
