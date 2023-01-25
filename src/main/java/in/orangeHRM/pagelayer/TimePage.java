package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class TimePage extends BaseClass {

	@FindBy(xpath="//span[text()='Time']")
	private WebElement linkTime;
	
	@FindBy(xpath="//span[text()='Attendance ']")
	private WebElement linkAttendance;
	
	@FindBy(xpath="//span[text()='Reports ']")
	private WebElement linkReports;
	
	@FindBy(xpath="//span[text()='Project Info ']")
	private WebElement linkProjectInfor;
	
	@FindBy(xpath="//ul/li/a[@role='menuitem']")
	private List<WebElement> allLinksUnderReports;
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
    private WebElement empName;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement loggedUserText;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> autosuggeTxt;
	
	@FindBy(xpath="//button[text()=' View ']")
	private WebElement btnView;
	
	@FindBy(xpath="//div[@class='rgRow']")
	private List<WebElement> records;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-text--count']")
	private WebElement confirTxt;
	
	public TimePage(WebDriver driver)
	{
		TimePage.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnTimeLink()
	{
		linkTime.click();
	}
	
	public void clickOnLinkAttendance()
	{
		linkAttendance.click();
	}
	
	public void clickOnLinkReports()
	{
		linkReports.click();
	}
	
	public void clickOnLinkProjectInfor()
	{
		linkProjectInfor.click();
	}
	
	public List<WebElement> getAllLinksUnderReports()
	{
		return allLinksUnderReports;
	}
	
	public WebElement enterEmpName()
	{
		return empName;
	}
	
	public WebElement getTxtLoggedUser()
	{
		return loggedUserText;
	}
	
	public List<WebElement> getAutosuggesTxt()
	{
		return autosuggeTxt;
	}
	
	public void clickOnBtnView()
	{
		btnView.click();
	}
	
	public List<WebElement> getRecords()
	{
		return records;
	}
	
	public WebElement getConfirmTxt()
	{
		return confirTxt;
	}
}

