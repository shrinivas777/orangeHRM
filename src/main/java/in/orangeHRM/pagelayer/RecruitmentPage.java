package in.orangeHRM.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class RecruitmentPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement recruitLink;
	
	@FindBy(xpath="//a[text()='Vacancies']")
	private WebElement vacanciesLink;
	
	@FindBy(xpath="//a[text()='Candidates']")
	private WebElement candidatesLink;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
	private WebElement jobTitleBtn;
	
	@FindBy(xpath="//div[@class='oxd-select-option']/span")
	private List<WebElement> jotTitles;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[2]")
	private WebElement vacancyBtn;  
	
	@FindBy(xpath="//div[@role='listbox']/div/span")
	private List<WebElement> vacancies;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[3]")
	private WebElement hiriMangeBtn;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> hiriManagers;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[4]")
	private WebElement statusBtn;
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> allstatus;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement confirmTxt;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addBtn;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement txtFirName;
	
	@FindBy(xpath="//input[@name='middleName']")
	private WebElement txtMidName;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//div[@class='oxd-select-text--after']")
	private WebElement seleVacancyBtn; 
	
	@FindBy(xpath="//div[@role='option']/span")
	private List<WebElement> allVacancies;
	
	@FindBy(xpath="(//input[@placeholder='Type here'])[1]")
	private WebElement txtEmailId;
	
	@FindBy(xpath="(//input[@placeholder='Type here'])[2]")
	private WebElement txtContaNumb;
	
	@FindBy(xpath="//input[@placeholder='yyyy-mm-dd']")
	private WebElement dateOfApplicaBtn;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-icon-button__icon'])[2]")
	private List<WebElement> allyears;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-icon-button__icon'])[1]")
	private List<WebElement> allMonths;
	
	@FindBy(xpath="//div[contains(@class,'oxd-calendar-date-wrapper')]/div")
	private List<WebElement> allDates;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement saveBtn1;
	
	@FindBy(xpath="//p[text()='Status: Application Initiated']")
	private WebElement coinfirMesssge;
	
	@FindBy(xpath="//div[@class='orangehrm-recruitment-actions']/button")
	private List<WebElement> recruitActionBtns;
	
	@FindBy(xpath="//div/h6[text()='Shortlist Candidate']")
	private WebElement headingShortlistCandidate;
	
	@FindBy(xpath="//div[@class='oxd-form-actions']/button")
	private List<WebElement> actionsBtns;
	
	@FindBy(xpath="//div[@class='orangehrm-recruitment-status']/p")
	private WebElement txtShortLitsed;
	
	@FindBy(xpath="//div[@class='orangehrm-recruitment-actions']/button")
	private List<WebElement> btnsReject_ScheduInte;
	
	public RecruitmentPage(WebDriver driver)
	{
		RecruitmentPage.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnRecruitLink()
	{
		recruitLink.click();
	}
	
	public void clickOnVacanciesLink()
	{
		vacanciesLink.click();
	}
	
	public void clickOnCandidatesLink()
	{
		candidatesLink.click();
	}
	
	public void clickOnJobTitleBtn()
	{
		jobTitleBtn.click();
	}
	
	public List<WebElement> getAllJobTitles()
	{
		return jotTitles;
	}
	
	public void clickOnVacancyBtn1()
	{
		vacancyBtn.click();
	}
	
	public List<WebElement> getAllVacancies()
	{
		return vacancies;
	}
	
	public void clickOnHiriManagerBtn()
	{
		hiriMangeBtn.click();
	}
	
	public List<WebElement> getAllHiriManagers()
	{
		return hiriManagers;
	}
	
	public void clickOnStatusBtn()
	{
		statusBtn.click();
	}
	
	public List<WebElement> getAllStatus()
	{
		return allstatus;
	}
	
	public void clickOnSearchBtn()
	{
		searchBtn.click();
	}
	
	public WebElement getConfirmTxt()
	{
		return confirmTxt; 
	}
	
	public void clickOnAddBtn()
	{
		addBtn.click();
	}
	
	public void enterFirName()
	{
		txtFirName.sendKeys("aksah");
	}
	
	public void enterMidName()
	{
		txtMidName.sendKeys("pandurang");
	}
	
	public void enterLastName()
	{
		txtLastName.sendKeys("yadav");
	}
	
	public void clickOnVacancyBtn2()
	{
		seleVacancyBtn.click();
	}
	
	public List<WebElement> getAllVacancies2()
	{
		return allVacancies;
	}
	
	public void enterEmailId()
	{
		txtEmailId.sendKeys("akash123@gmail.com");
	}
	
	public void enterContaNumb()
	{
		txtContaNumb.sendKeys("9874563210");
	}

	public void clickOnDateOfApplica()
	{
		dateOfApplicaBtn.click();
	}
	
	public List<WebElement> getAllYears()
	{
		return allyears;
	}
	
	public List<WebElement> getAllMonths()
	{
		return allMonths;
	}
	
	public List<WebElement> getAllDates()
	{
		return allDates;
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn1.click();
	}
	
	public WebElement getConfirMessage()
	{
		return coinfirMesssge;
	}
	
	public List<WebElement> getRecruitActionBtns()
	{
		return recruitActionBtns;
	}
	
	public WebElement getHeadingShortlistCandidate()
	{
		return headingShortlistCandidate;
	}
	
	public List<WebElement> getActionBtns()
	{
		return actionsBtns;
	}
	
	public WebElement getShortListedTxt()
	{
		return txtShortLitsed;
	}
	
	public List<WebElement> getBtnsReject_ScheduleInte()
	{
		return btnsReject_ScheduInte;
	}
}
