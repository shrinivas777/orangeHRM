package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class MaintenancePage extends BaseClass{

	@FindBy(xpath="//span[text()='Maintenance']")
	private WebElement maintenanceLink;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//div[@class='orangehrm-admin-access-button-container']/button")
	private List<WebElement> adminAccesBtns;
	
	@FindBy(xpath="//div[@class='orangehrm-card-container']/h6")
	private WebElement headingPurgeEmpRecords;
	
	@FindBy(xpath="//li[contains(@class,'oxd-topbar-body-nav-tab')]/span")
	private WebElement purgeRecordsLink;
	
	@FindBy(xpath="//li[contains(@class,'oxd-topbar-body-nav-tab')]/a")
	private WebElement accessRecordsLink;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li/a")
	private List<WebElement> allLinksUnderPurgeRecords;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement txtInputBox;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> allAutoSuggesionsVacancy;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement confiTxt;
	
	@FindBy(xpath="//div[@class='orangehrm-container']/div/div/div")
	private List<WebElement> purgeRecords;
	
	@FindBy(xpath="//h6[text()='Selected Employee']")
	private WebElement headingSelectedEmp;
	
	@FindBy(xpath="(//img[@alt='profile picture'])[2]")
	private WebElement imgProfilePic;
	
	public MaintenancePage(WebDriver driver)
	{
		MaintenancePage.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMaintenanceLink()
	{
		maintenanceLink.click();
	}

	public void enterPassword()
	{
		lp.enterPassword();
	}
	
	public List<WebElement> getAdminAccessBtns()
	{
		return adminAccesBtns;
	}
	
	public WebElement getHeadingPurgeEmpRecords()
	{
		return headingPurgeEmpRecords;
	}
	
	public void clickOnPurgeRecordsLink()
	{
		purgeRecordsLink.click();
	}
	
	public void clickOnAccessRecordsLink()
	{
		accessRecordsLink.click();
	}
	
	public List<WebElement> getAllLinksUnderPurgeRecords()
	{
		return allLinksUnderPurgeRecords;
	}
	
	public WebElement enterTxt()
	{
		return txtInputBox;
	}
	
	public List<WebElement> getAllAuto()
	{
		return allAutoSuggesionsVacancy;
	}
	
	public void clickOnSearchBtn()
	{
		searchBtn.click();
	}
	
	public WebElement getConfiTxt()
	{
		return confiTxt;
	}
	
	public List<WebElement> getAllPurgeRecords()
	{
		return purgeRecords;
	}
	
	public WebElement getHeadingSelectedEmp()
	{
		return headingSelectedEmp;
	}
	
	public WebElement getProfilePic()
	{
		return imgProfilePic;
	}
}
