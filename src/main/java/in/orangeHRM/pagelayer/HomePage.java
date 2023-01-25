package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.*;

public class HomePage extends BaseClass{

	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement txtLoggedUser;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashboardLink;
	
	@FindBy(xpath="//span[text()='Admin']")  // xpath--->(//a[@class='oxd-main-menu-item toggle'])[1]
	private WebElement adminLink;
	
	@FindBy(xpath="//span[text()='User Management ']")
	private WebElement getUserMamageLink;
	
	@FindBy(xpath="//a[text()='Users']")
	private WebElement getUsersLink;
	
	@FindBy(xpath="//div[@class='oxd-table']//div[@class='oxd-table-row oxd-table-row--with-border']")
	private List<WebElement> users;
	
	@FindBy(xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div/div[2]/div[3]/div/div[2]")
	private List<WebElement> usersStatus;
	
	@FindBy(xpath="//img[@alt='profile picture']")  // xpath-->//img[@alt='profile picture']/following-sibling::p
	private WebElement getTextLoggedUser;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement getLinkLogOut;
	
	public HomePage(WebDriver driver)
	{
		HomePage.driver=driver;   // or BaseClass.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getTxtLoggedUser()
	{
		return txtLoggedUser;
	}
	public boolean dashboard()
	{
		boolean isDisplayed=dashboardLink.isDisplayed();
		return isDisplayed;
	}
	
	public void clickOnAdmin()
	{
		adminLink.click();
	}
	
	public String getUrl()
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public void clickOnUserManageLink()
	{
		getUserMamageLink.click();
	}
	
	public void clickOnUsersLink()
	{
		getUsersLink.click();
	}
	
	public List<WebElement> getusers()
	{
		return users;
	}
	
	public void getLogoutLink()
	{
		getLinkLogOut.click();
	}
	
	public WebElement getLoggedUserText()
	{
        return getTextLoggedUser;
	}
	
	public List<WebElement> getAllUserStatus()
	{
		return usersStatus;
	}
	
	
}
