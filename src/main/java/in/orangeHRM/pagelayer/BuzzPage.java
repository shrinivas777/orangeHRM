package in.orangeHRM.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.orangeHRM.baseclass.BaseClass;

public class BuzzPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='Buzz']")
	private WebElement linkBuzz;
	
	@FindBy(xpath="//a[text()='Click here']")
	private WebElement linkClickHere;
	
	public BuzzPage(WebDriver driver)
	{
		BuzzPage.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnBuzzLink()
	{
		linkBuzz.click();
	}
	
	public void clickOnLinkClickHere()
	{
		linkClickHere.click();
	}
}
