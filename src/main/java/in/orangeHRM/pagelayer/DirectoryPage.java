package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class DirectoryPage extends BaseClass{
	
	@FindBy(xpath="//span[text()='Directory']")
	private WebElement directoryLink;
	
	@FindBy(xpath="//div[@class='orangehrm-container']/div/div/div")
	private List<WebElement> allDirectoryUser;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement txtEmpName;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> allAutoSuggeUsers;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement LoggedUser;
	
	@FindBy(xpath="//div[@class='oxd-form-actions']/button")
	private List<WebElement> ActionsBtns;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement confirmTxt;
	
	@FindBy(xpath="//div[@class='orangehrm-container']/div/div/div")
	private WebElement loggedUserDirectory;
	
	public DirectoryPage(WebDriver driver)
	{
		DirectoryPage.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnDirectoryLink()
	{
		directoryLink.click();
	}
	
	public List<WebElement> getAllDirectoryUser()
	{
		return allDirectoryUser;
	}
	
	public WebElement getTxtEmpName()
	{
		return txtEmpName;
	}
	
	public List<WebElement> getAllAutoSuggesUsers()
	{
		return allAutoSuggeUsers;
	}
	
	public WebElement getLoggedUser()
	{
		return LoggedUser;
	}
	
	public List<WebElement> getActionsBtns()
	{
		return ActionsBtns;
	}
	
	public WebElement getConfirmTxt()
	{
		return confirmTxt;
	}
	
	public WebElement getLoggedUserDirectory()
	{
		return loggedUserDirectory;
	}
}
