package in.orangeHRM.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement txtBox_username;

	@FindBy(xpath="//input[@name='password']")
	private WebElement txtBox_password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='orangehrm-login-branding']")
	private WebElement company_Branding; 
	
	
	public  LoginPage(WebDriver driver)
	{
		LoginPage.driver=driver;    // or BaseClass.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterUsername()
	{
		txtBox_username.sendKeys("Admin");
	}
	
	public void enterPassword()
	{
		txtBox_password.sendKeys("admin123");
	}
	
	public void clickOnLogin()
	{
		btnLogin.click();
	}
	
	public boolean companyBranding()
	{
		boolean isDisplayed=company_Branding.isDisplayed();
		return isDisplayed;
	}
}
