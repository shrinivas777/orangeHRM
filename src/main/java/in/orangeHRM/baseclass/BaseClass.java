package in.orangeHRM.baseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import in.orangeHRM.pagelayer.BuzzPage;
import in.orangeHRM.pagelayer.DirectoryPage;
import in.orangeHRM.pagelayer.HomePage;
import in.orangeHRM.pagelayer.LeavePage;
import in.orangeHRM.pagelayer.LoginPage;
import in.orangeHRM.pagelayer.MaintenancePage;
import in.orangeHRM.pagelayer.PIMPage;
import in.orangeHRM.pagelayer.PerformancePage;
import in.orangeHRM.pagelayer.RecruitmentPage;
import in.orangeHRM.pagelayer.TimePage;


public class BaseClass {

	public static WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public PIMPage pp;
	public LeavePage leP;
	public TimePage tp;
	public RecruitmentPage rp;
	public PerformancePage perP;
	public DirectoryPage dp;
	public MaintenancePage mp;
	public BuzzPage bp;
	
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtentReport()
	{
		String path=".\\test-output\\orangeHRM_2_Report.html";
		reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("OrangeHRM  Automation Report");
		reporter.config().setReportName("TestingReport");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("TesterName","Shrinivas");
		extent.setSystemInfo("OS","Windows10");
		
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
		
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","H:\\Shrinivas Devkate\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// create objects of PO classes
	    lp=new LoginPage(driver);
	    hp=new HomePage(driver);
	    pp=new PIMPage(driver);
	    leP=new LeavePage(driver);
	    tp=new TimePage(driver);
	    rp=new RecruitmentPage(driver);
	    perP=new PerformancePage(driver);
	    dp=new DirectoryPage(driver);
	    mp=new MaintenancePage(driver);
	    bp=new BuzzPage(driver);
	    
	    lp.enterUsername();
	    lp.enterPassword();
	    lp.clickOnLogin();
	    
	}   
	    
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"TEST CASE FAILED IS "+result.getName());   // name of the failed test case
			test.log(Status.FAIL,"TEST CASE FAILED IS "+result.getThrowable());  // throwing exception when failed
		    
			String screenshotPath=BaseClass.getScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"TEST CASE PASSED IS "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,"TEST CASE SKIPPED IS "+result.getName());
		}
    	driver.quit();
	}
	
	public static String getScreenshot(String screenshortName) throws IOException
	{
		String datetime=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"_"+screenshortName+datetime+".png";
		File finalDestination=new File(destination);
		FileHandler.copy(src,finalDestination);
		
		return destination;
	}
}
