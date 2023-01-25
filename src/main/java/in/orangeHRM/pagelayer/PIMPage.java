package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class PIMPage extends BaseClass{

	@FindBy(xpath="//span[text()='PIM']")
	private WebElement linkPIM;
	
	@FindBy(xpath="//div[@class='oxd-table-filter']")
	private WebElement empInfor;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	private WebElement addEmpLink;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='middleName']")
	private WebElement txtMidName;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement txtLastName;
			
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement empId;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement btnSave;
	
	@FindBy(xpath="//a[text()='Contact Details']")
	private WebElement contDetailLink;
	
	@FindBy(xpath="//a[text()='Emergency Contacts']")
	private WebElement emergencyContLink;
	
	@FindBy(xpath="//a[text()='Dependents']")
	private WebElement depedentsLink;
	
	@FindBy(xpath="//a[text()='Immigration']")
	private WebElement immigrationLink;
	
	@FindBy(xpath="//a[text()='Job']")
	private WebElement jobLink;

	@FindBy(xpath="//a[text()='Salary']") 
	private WebElement salaryLink;
	
	@FindBy(xpath="//a[text()='Qualifications']") 
	private WebElement qualificationsLink;
	
	@FindBy(xpath="//a[text()='Memberships']") 
	private WebElement membershipsLink;
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee']")
	private WebElement editEmpData;
	
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[2]")
	private WebElement txtDOB;
	
	@FindBy(xpath="(//p[@class='oxd-text oxd-text--p'])[2]")   // 
	private WebElement year;
	
	@FindBy(xpath="//li[@class='oxd-calendar-dropdown--option']")
	private List<WebElement> allyears;
	
	@FindBy(xpath="(//p[@class='oxd-text oxd-text--p'])[1]")
	private WebElement month;
	
	@FindBy(xpath="//li[contains(@class,'oxd-calendar-dropdown--option')]")
	private List<WebElement> allMonths;
	
	@FindBy(xpath="//div[@class='oxd-calendar-date']")
	private List<WebElement> dates;
	
	@FindBy(xpath="//input[@type='radio']")
	private List<WebElement> btnRadios;
	
	@FindBy(xpath="(//button[text()=' Save '])[1]")
	private WebElement btnSave1;
	
	public PIMPage(WebDriver driver)
	{
		PIMPage.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPIMLink()
	{
		linkPIM.click();
	}
	
	public WebElement empInforma()
	{
		return empInfor;
	}
	
	public void clickOnAddEmpLink()
	{
		addEmpLink.click();
	}
	
	public void enterFirstName()
	{
		txtFirstName.sendKeys("akash");
	}
	
	public void entermidName()
	{
		txtMidName.sendKeys("vasant");
	}
	
	public void enterLastName()
	{
		txtLastName.sendKeys("jadhav");
	}
	
	public WebElement enterEmpId()
	{
			return empId;
	}
	
	public void clickOnSaveBtn()
	{
		btnSave.click();
	}
	
	public WebElement editEmpData()
	{
		return editEmpData;
	}
	
	public WebElement clickOnDOB()
	{
		return txtDOB;
	}
	
	public List<WebElement> clickOnYear()
	{
		year.click();
		return allyears;
	}
	
	public List<WebElement> clickOnMonth()
	{
		month.click();
		return allMonths;
	}
	
	public List<WebElement> selectDate()
	{
		return dates;
	}
	
	public List<WebElement> selectRadioBtn()
	{
		return btnRadios;
	}
	
	public WebElement clickOnSave()
	{
		return btnSave1;
	}
	
	public WebElement contDetailLink()
	{
		return contDetailLink;
	}
	
	public void clickOnEmergLink()
	{
		emergencyContLink.click();
	}
	
	public void clickOnDepenLink()
	{
		depedentsLink.click();
	}
	
	public void clickOnImmigraLink()
	{
		immigrationLink.click();
	}
	
	public void clickOnJobLink()
	{
		jobLink.click();
	}
	
	public void clickOnSalaryLink()
	{
		salaryLink.click();
	}
	
	public void clickOnQualifiLink()
	{
		qualificationsLink.click();
	}
	
	public void clickOnMembershLink()
	{
		membershipsLink.click();
	}
	public String getUrl()
	{
		String url=driver.getCurrentUrl();
		return url;
	}
}
