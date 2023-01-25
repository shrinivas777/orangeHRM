package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class PerformancePage extends BaseClass{
	
	@FindBy(xpath="//span[text()='Performance']")
	private WebElement performanceLink;
	
	@FindBy(xpath="//span[text()='Configure ']")
	private WebElement configureLink;
	
	@FindBy(xpath="//span[text()='Manage Reviews ']")
	private WebElement manageReviewsLink;

	@FindBy(xpath="//a[text()='My Trackers']")
	private WebElement myTrackersLink;
	
	@FindBy(xpath="//a[text()='Employee Trackers']")
	private WebElement empTrackersLink;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement LoggedUser;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement txtEmpName;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement loggedUser;
	
	@FindBy(xpath="//div[@role='listbox']/div/span")
	private List<WebElement> allAutoSuggestEmps;
	
	@FindBy(xpath="//div[@class='oxd-form-actions']/button")
	private List<WebElement> actionsBtns1; 
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement confirmTxtOnEmpTrackers;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement confirmTxtOnMyTrackers;
	
	public PerformancePage(WebDriver driver)
	{
		PerformancePage.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnPerfoLink()
	{
		performanceLink.click();
	}
	
	public void clickOnConfiLink()
	{
		configureLink.click();
	}
	
	public void clickOnManageReviewsLink()
	{
		manageReviewsLink.click();
	}
	
	public void clickOnMyTrackersLink()
	{
		myTrackersLink.click();
	}
	
	public void clickOnEmpTrackersLink()
	{
		empTrackersLink.click();
	}
	
	public WebElement getTxtEmpName()
	{
		return txtEmpName;
	}
	
	public WebElement getLoggedUser()
	{
		return loggedUser;
	}
	
	public List<WebElement> getUserAutoSuggeti()
	{
		return allAutoSuggestEmps;
	}
	
	public List<WebElement> getActionsBtns()
	{
		return actionsBtns1;
	}
	
	public WebElement getConfirmTxtOnEmpTrackers()
	{
		return confirmTxtOnEmpTrackers;
	}
	
	public WebElement getConfirmTxtOnMyTrackers()
	{
		return confirmTxtOnMyTrackers;
	}
	
}
