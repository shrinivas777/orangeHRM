package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class LeavePage extends BaseClass {

	@FindBy(xpath="//span[text()='Leave']")
	private WebElement linkLeave;
	
	@FindBy(xpath="//a[text()='Apply']")
	private WebElement linkApply;
	
	@FindBy(xpath="//a[text()='My Leave']")
	private WebElement linkMyleave;
	
	@FindBy(xpath="//span[text()='Entitlements ']")
	private WebElement linkEntitlements;
	
	@FindBy(xpath="//ul/li/a[@role='menuitem']")
	private List<WebElement> allLinkUnderEntitments;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement txtTypeHint;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement loggedUsertext;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> autosuggeUserText;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	private WebElement txtLeaveTyep;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> leaveTypeOption;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement entitleBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnSave;
	
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']/button")
	private List<WebElement> dialogueBtns;
	
	@FindBy(xpath="//h5[text()='Leave Entitlements']")
	private WebElement txtLeaveEntitHeading; 
	
	@FindBy(xpath="//span[text()='Configure ']")
	private WebElement linkConfigure;
	
	@FindBy(xpath="//ul/li/a[@role='menuitem']")
	private List<WebElement> allLinksUnderConfigure;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
	private WebElement selectBtn1;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> allMonths;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[2]")
	private WebElement selectBtn2;
	
	@FindBy(xpath="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div")
	private List<WebElement> allDates;
	
	@FindBy(xpath="(//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2 orangehrm-leave-period'])[1]")
	private WebElement confimText;
	public LeavePage(WebDriver driver)
	{
		LeavePage.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnLeavLink()
	{
		linkLeave.click();
	}
	
	public void clickOnApplyLink()
	{
		linkApply.click();
	}
	
	public void clickOnMyleaveLink()
	{
		linkMyleave.click();
	}
	
	public void clickOnEntitmentsLink()
	{
		linkEntitlements.click();
	}
	
	public List<WebElement> getAllLinks()
	{
		return allLinkUnderEntitments;
	}
	
	public WebElement enterTypeHint()
	{
		
		return txtTypeHint;
	}
	
	public void clickOnLeaveType()
	{
		txtLeaveTyep.click();
	}
	
	public List<WebElement> getAllLeaveTypeOption()
	{
		return leaveTypeOption;
	}
	
	public void clickOnSaveBtn()
	{
		btnSave.click();
	}
	
	public void enterEntitlements()
	{
		entitleBtn.sendKeys("2");
	}
	
	public WebElement getLoggedUsertext()
	{
		return loggedUsertext;
	}

	public List<WebElement> clickOnAutosuggeUserText()
	{
		return autosuggeUserText;
	}
	
	public List<WebElement> getPopBtns()
	{
		return dialogueBtns;
	}
	
	public boolean getTxtLeaveEntitHeading()
	{
		boolean isDispla=txtLeaveEntitHeading.isDisplayed();
		return isDispla;
	}
	
	public void clickOnConfigureLink()
	{
		linkConfigure.click();
	}
	
	public List<WebElement> getAllLinkUnderConfigure()
	{
		return allLinksUnderConfigure;
	}
	
	public void clickOnSelectBtn1()
	{
		selectBtn1.click();
	}
	
	public List<WebElement> getAllMonths()
	{
		return allMonths;
	}
	
	public void clickOnSelectBtn2()
	{
		selectBtn2.click();
	}
	
	public List<WebElement> getAllDates()
	{
		return allDates;
	}
	
	public WebElement getConfimTxt()
	{
		return confimText;
	}
}
