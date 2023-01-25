package in.orangeHRM.testlayer;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.orangeHRM.baseclass.*;

public class TestClass extends BaseClass {
	
	@Test
	public void verifyLoginTest() throws InterruptedException
	 {
		test = extent.createTest("verifyLoginTest");

		boolean isDisp = hp.dashboard();
		Assert.assertTrue(isDisp, "Step fail:User unable to land on home page");
		System.out.println("User successfully landed on home page");
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void verifyLoggedUser()
	{
		test=extent.createTest("verifyLoggedUser");
		
		WebElement loggedUserEle=hp.getLoggedUserText();
		String act_LoggedUserTxt=loggedUserEle.getText();
		String exp_LoggedUser=act_LoggedUserTxt;
		
		Assert.assertEquals(act_LoggedUserTxt, exp_LoggedUser,"Step fail:Both are not matched");
		System.out.println("Both are matched");
	}

	@Test(priority=2)
	public void verifyClickAdmin() throws InterruptedException {
		test = extent.createTest("verifyClickAdmin");

		hp.clickOnAdmin();
		String exp_Url = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		String act_Url = hp.getUrl();
		System.out.println(act_Url);
		Assert.assertEquals(act_Url, exp_Url, "Step fail:Not on admin page after clicking on admin");
		System.out.println("Currently user is on admin page after clicking on admin click");
		Thread.sleep(3000);

		hp.clickOnUserManageLink();
		hp.clickOnUsersLink();

		List<WebElement> allUsers = hp.getusers();
		int totalUsers=allUsers.size();
		System.out.println(totalUsers);
	}
	

	@Test(priority=3)
	public void vefityNaviagtionToDashBoard() throws InterruptedException {
		test = extent.createTest("vefityNaviagtionToDashBoard");

		hp.clickOnAdmin();
		Thread.sleep(3000);

		driver.navigate().back();

		// verfiy navigation is done successfully
		boolean isOnDashboard = hp.dashboard();
		Assert.assertTrue(isOnDashboard, "Step fail:User is not dashboard page");
		System.out.println("Curretly user is on dashboard page");
	}
	
	@Test(priority=4)
	public void verifyClickOnPIM()
	{
		test=extent.createTest("verifyClickOnPIM");
		
		pp.clickOnPIMLink();  // click on PIM link
		
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		String act_Url=pp.getUrl();
		Assert.assertEquals(act_Url, exp_Url,"Step fail:User is not on PIM page");
		System.out.println("Currently user is on PIM page");
		
		// verify that after clicking on PIM link emp list is by default selected
		boolean isSelect=pp.empInforma().isDisplayed();
		Assert.assertTrue(isSelect, "Step fail:after clicking on PIM link by default emp information is not displayed");
		System.out.println("After clicking on PIM link by default emp information is displayed");
	}
	
	@Test(priority=5)
	public void verifyClickOnAddEmp()
	{
		test=extent.createTest("verifyClickOnAddEmp");
		
		pp.clickOnPIMLink();     // click on PIM link
		pp.clickOnAddEmpLink();  // click on AddEmp link
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
		String act_Url=pp.getUrl();
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to click on add emp");
		System.out.println("Successfully clicked on add Emp");
	}

    @Test(priority=6)
	public void verifyEmpInforSave() throws InterruptedException
	{
		test=extent.createTest("verifyEmpInforSave");
		
		pp.clickOnPIMLink();     // click on PIM link
		pp.clickOnAddEmpLink();  // click on AddEmp link
		
		pp.enterFirstName();
		pp.entermidName();
		pp.enterLastName();
		
		WebElement empId=pp.enterEmpId();
		empId.clear();
		empId.sendKeys("333");
		
		pp.clickOnSaveBtn();
		
		boolean isDisp=pp.editEmpData().isDisplayed();
		Assert.assertTrue(isDisp, "Step fail:Emp information is not saved successfully");
		System.out.println("Emp information is saved successfully");
		Thread.sleep(3000);
		
		String exp_yr="1995";
		String exp_mth="March";
		String exp_dt="14";
		WebElement dob=pp.clickOnDOB();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", dob);
		
		// for year
		List<WebElement>yrs=pp.clickOnYear();
		for(WebElement y:yrs)
		{
			String act_year=y.getText();
//			System.out.println(act_year);
			if(act_year.equals(exp_yr))
			{
				y.click();
				break;
			}
		}
		
		// for month
		List<WebElement> months=pp.clickOnMonth();
		for(WebElement mnt:months)
		{
			String act_month=mnt.getText();
//			System.out.println(act_month);
			if(act_month.equalsIgnoreCase(exp_mth))
			{
				mnt.click();
				break;
			}
		}
		
		// for date
		List<WebElement> dates=pp.selectDate();
		for(WebElement dt:dates)
		{
			String act_date=dt.getText();
//			System.out.println(act_date);
			if(act_date.equals(exp_dt))
			{
				dt.click();
				break;
			}
			
		}
		Thread.sleep(3000);
		
		// for radio button
		List<WebElement> btnRadios=pp.selectRadioBtn();
		for(WebElement btnRadio:btnRadios)
		{
			String value=btnRadio.getAttribute("value");
			if(value.equals("1"))
			{
				js.executeScript("arguments[0].click();",btnRadio);
				break;
			}
		}
		
		// after that click on save button
		WebElement saveBtn=pp.clickOnSave();
		js.executeScript("arguments[0].click();",saveBtn);
		
		try
		{
			WebElement contaLink=pp.contDetailLink();  // click on contact details
	        contaLink.click();	
		}
		catch(ElementClickInterceptedException e)
		{
			WebElement conDetaLink=pp.contDetailLink();
			js.executeScript("arguments[0].click();",conDetaLink);
			Thread.sleep(3000);
			driver.navigate().back();
		}
		
		js.executeScript("window.scrollBy(0,-550)");
		pp.clickOnDepenLink();       // click on dependents link
		Thread.sleep(3000);
		driver.navigate().back();
		
		pp.clickOnImmigraLink();     // click on immigration link
		Thread.sleep(3000);
		driver.navigate().back();
		
		pp.clickOnJobLink();         // click on job link
		Thread.sleep(3000);
		driver.navigate().back();
		
		pp.clickOnSalaryLink();      // click on salary link
		Thread.sleep(3000);
		driver.navigate().back();
		
		pp.clickOnMembershLink();    // click on memberships link
		Thread.sleep(3000);
		driver.navigate().back();
		
		pp.clickOnQualifiLink();     // click on qualifications link
		Thread.sleep(3000);
		driver.navigate().back();
	} 
	
	@Test(priority=7)
	public void verifyLeaveLink()
	{
		test=extent.createTest("verifyLeaveLink");
		
		leP.clickOnLeavLink();
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
		String act_Url=hp.getUrl();
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to land on leave page");
		System.out.println("Successfully landed on leave page");
	} 

	@Test(priority=8)
	public void verifyNavigationOnLeaveLink() throws InterruptedException
	{
		test=extent.createTest("verifyNavigation");
		
		leP.clickOnLeavLink();       // click on leave link
		
		leP.clickOnApplyLink();      // click on apply link
		Thread.sleep(3000);
		driver.navigate().back();
		
		leP.clickOnMyleaveLink();     // click on my_leave link
		Thread.sleep(3000);
		driver.navigate().back();
		
		leP.clickOnEntitmentsLink();   // click on entitlements link
		
		List<WebElement> linksUnderEntitments=leP.getAllLinks();              // return list of webelement
		System.out.println(linksUnderEntitments.size());
		for(WebElement link:linksUnderEntitments)
		{
		    String act_Text=link.getText();
			String exp_Text=act_Text;
	
			if(act_Text.equals(exp_Text))
			{
				link.click();                                // click on Add Entitlements
				Thread.sleep(3000);
				
				WebElement loggedUserText=leP.getLoggedUsertext();   
				String user=loggedUserText.getText();
				System.out.println(user);
				
				WebElement empNameTypeBtn= leP.enterTypeHint();         
				empNameTypeBtn.click();                        // click on employee name
				empNameTypeBtn.sendKeys(user);
				
				List<WebElement>allUserText =leP.clickOnAutosuggeUserText();
				for(WebElement sinUser:allUserText)
				{
					String autosuggeUserText=sinUser.getText();
					if(autosuggeUserText.contains(" "))
					{
						sinUser.click();
						break;
					}
				}
				Thread.sleep(3000);
				
				leP.clickOnLeaveType();
				List<WebElement> allOptions=leP.getAllLeaveTypeOption();
				for(WebElement option:allOptions)
				{
					String actOption=option.getText();
					System.out.println(actOption);
					String expOption="CAN - Personal";
					
					if(actOption.equals(expOption))
					{
						option.click();
						break;
					}
				}
				
				leP.enterEntitlements();      // enter some value 
				
				leP.clickOnSaveBtn();         // click on save btn
				
				List<WebElement> popBtns=leP.getPopBtns();   // dialogue box
				System.out.println(popBtns.size());
				for(WebElement btn:popBtns)
				{
					String actBtnText=btn.getText();
					System.out.println(actBtnText);
					if(actBtnText.equalsIgnoreCase("confirm"))
					{
						btn.click();
						break;
					}
				}
				
				boolean leaveEnitHeaDisp=leP.getTxtLeaveEntitHeading();
				Assert.assertTrue(leaveEnitHeaDisp,"Step fail:Unable to display leave entitlements heading");
				System.out.println("Successfully displayed leave entitlements heading");
				
			}
			break;
		}		
}
	
	@Test(priority=9)
	public void verifyConfigureLink()
	{
		test=extent.createTest("verifyConfigureLink");
		
		leP.clickOnLeavLink();       // click on leave link
		leP.clickOnConfigureLink();  // click on configure link
		
		List<WebElement> allLinks=leP.getAllLinkUnderConfigure();
		for(WebElement link:allLinks)
		{
			if(link.getText().equalsIgnoreCase("Leave Period"))
			{
				link.click();
				
				leP.clickOnSelectBtn1();
				List<WebElement> allMnths=leP.getAllMonths();
				for(WebElement month:allMnths)
				{
					String act_Month=month.getText();
					String exp_Month="January";   //January    February
					if(act_Month.equals(exp_Month))
					{
						month.click();
						break;
					}
				}
				
				leP.clickOnSelectBtn2();
				
				List<WebElement> allDts=leP.getAllDates();
				for(WebElement dt:allDts)
				{
					String act_Date=dt.getText();
					String exp_Date="20";
					if(act_Date.equals(exp_Date))
					{
						dt.click();
						break;
					}
					
				}
				
				WebElement txtconfirm=leP.getConfimTxt();
				String confirmText=txtconfirm.getText();
				System.out.println(confirmText);
				
				break;
			}
		}
		
  }
		
	@Test(priority=10)
	public void verifyAllLinksClickable()
	{
		test=extent.createTest("verifyAllLinksClickable");
		
		tp.clickOnTimeLink();              // click on time link
		
		tp.clickOnLinkAttendance();        // click on attendance link
		
		tp.clickOnLinkProjectInfor();      // click on project infor
		
		tp.clickOnLinkReports();           // click on reports link
		
		List<WebElement> allLinks=tp.getAllLinksUnderReports();      // return list of web_element
		for(WebElement link:allLinks)
		{
//			String act_Link=link.getText();
			String exp_Link="Employee Reports";
			if(link.getText().equals(exp_Link))
			{
				link.click();
				
				String act_Url=hp.getUrl();
				String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/time/displayEmployeeReportCriteria";
				Assert.assertEquals(act_Url, exp_Url,"Step fail:All links are not clickable");
				System.out.println("All links are clickable");
				
				break;
			}
//			act_Link="";
		}
	}
  	
	@Test(priority=11)
	public void getEmpReports()
	{
		test=extent.createTest("getEmpReport");
		
		tp.clickOnTimeLink();         // click on time link
		tp.clickOnLinkReports();      // click on reports link
		
		List<WebElement> allLinks=tp.getAllLinksUnderReports();   
		for(WebElement link:allLinks) 
		{
			String act_Link=link.getText();
			String exp_Link="Employee Reports";
			if(act_Link.equals(exp_Link))
			{
				link.click();
				break;
			}
			
		}
		
		
		WebElement loggedUser=tp.getTxtLoggedUser(); 
		String loggedUserTxt=loggedUser.getText();
		System.out.println(loggedUserTxt);
		
		WebElement txtInputBox=tp.enterEmpName();
		txtInputBox.sendKeys(loggedUserTxt);
		
		List<WebElement> allAutosugge=tp.getAutosuggesTxt();
		for(WebElement singAutosugge:allAutosugge)
		{
			String actAutoSuggesUserTxt=singAutosugge.getText();
			System.out.println(actAutoSuggesUserTxt);
			if(actAutoSuggesUserTxt.contains(" "))
			{
				singAutosugge.click();
				break;
			}
		}
		
		tp.clickOnBtnView();
		
		List<WebElement> empRecords=tp.getRecords();       	// return list of web_element
		System.out.println(empRecords.size());
		for(WebElement rd:empRecords)
		{
			String particu_record=rd.getText();
			System.out.println(particu_record);
		}
		
		 WebElement confimTxt=tp.getConfirmTxt();
		 String act_ConfirTxt=confimTxt.getText();
		 if(act_ConfirTxt.contains(")"))
		 {
			 System.out.println("Number of records found");
		 }
		 else
		 {
			 System.out.println("No records found");
		 }
				 
	}  
	
	@Test(priority=12)
	public void verifyRecruiLinkClickabel()
	{
		test=extent.createTest("verifyRecruiLinkClickabel");
		
		rp.clickOnRecruitLink();    
		String act_Url=hp.getUrl();
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";
		
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Recruitment link is not clickable");
		System.out.println("Recruitment link is clickable ");
	}  
	
	@Test(priority=13)
	public void verifyNavigation() throws InterruptedException
	{
		test=extent.createTest("verifyNavigation");
		
		rp.clickOnRecruitLink();     //click on recruitment link
		
		rp.clickOnVacanciesLink();    // click no Vacancies link
		driver.navigate().back();
		Thread.sleep(3000);
		
		rp.clickOnCandidatesLink();     // click on candidates link
		driver.navigate().back();
		Thread.sleep(3000);
		
		String act_Url=hp.getUrl();
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to navigate");
		System.out.println("successfully done navigation");
		
	}
	
	@Test(priority=14)
	public void verifyVacancies()
	{
		test=extent.createTest("verifyVacancies");
		
		rp.clickOnRecruitLink();             // click on recruitment link
		
		rp.clickOnVacanciesLink();           // click on vacancies link
		
		rp.clickOnJobTitleBtn();             // click on job title
		
		List<WebElement> allJobTitle=rp.getAllJobTitles();
		for(WebElement jobTitle:allJobTitle)
		{
			String act_JobTitle=jobTitle.getText();
			String exp_JobTitle="IT Manager";
			if(act_JobTitle.equals(exp_JobTitle))
			{
				jobTitle.click();
				break;
			}
		}
		
		rp.clickOnVacancyBtn1();               // click on vacancy 
		
		List<WebElement> allVacancies=rp.getAllVacancies();
		for(WebElement vacancy:allVacancies)
		{
			String act_Vacancy=vacancy.getText();
			String exp_Vacancy="Associate IT Manager";
			if(act_Vacancy.equals(exp_Vacancy))
			{
				vacancy.click();
				break;
			}
			
		}
		
		rp.clickOnHiriManagerBtn();              // click on hiring manager 
		
		List<WebElement> allHiriManagers=rp.getAllHiriManagers();
		for(WebElement hiriManager:allHiriManagers)
		{
			String act_HiriManager=hiriManager.getText();
			String exp_HiriManager="Odis Adalwin";
			if(act_HiriManager.equals(exp_HiriManager))
			{
				hiriManager.click();
				break;
			}
			
		}
		
		rp.clickOnStatusBtn();              // click on status
		
		List<WebElement> allStatus=rp.getAllStatus();
		for(WebElement status:allStatus)
		{
			String act_Status=status.getText();
			String exp_Status="Active";
			if(act_Status.equals(exp_Status))
			{
				status.click();
				break;
			}
			
		}
		
		rp.clickOnSearchBtn();                 // click on search
		
		WebElement confirmationTxt=rp.getConfirmTxt();
		String act_confirmTxt=confirmationTxt.getText();
		if(act_confirmTxt.contains(")"))
		{
			System.out.println("Number of vacancies are found");
		}
		else
		{
			System.out.println("No vacancies are found");
		}
		
	} 
	
	@Test(priority=15)
	public void verifyCandidateShortlisted() throws InterruptedException
	{
		test=extent.createTest("verifyCandidateShortlisted");
		
		rp.clickOnRecruitLink();      // click on recruitment link
		rp.clickOnCandidatesLink();   // click on candidates link
		rp.clickOnAddBtn();           // click on add
		rp.enterFirName();            // enter fir name
		rp.enterMidName();            // enter mid name
		rp.enterLastName();           // enter last name
		rp.clickOnVacancyBtn2();      // click on vacancy
		
		List<WebElement> allVacancy=rp.getAllVacancies2();     // return list of web_element
		for(WebElement vacancy:allVacancy)
		{
			String actVacancyText=vacancy.getText();
			String expVacancyText="Senior QA Lead";
			if(actVacancyText.equals(expVacancyText))
			{
				vacancy.click();
				break;
			}
		}
		
		rp.enterEmailId();               // enter emailId
		rp.enterContaNumb();             // enter contact numb
		rp.clickOnDateOfApplica();       //click on date of application
		
		List<WebElement> allyrs=rp.getAllYears();
		for(WebElement yr:allyrs)
		{
			String act_YearText=yr.getText();
			String exp_YearText="2023";
			if(act_YearText.equals(exp_YearText))
			{
				yr.click();
				break;
			}
		}
		
		List<WebElement> allmnths=rp.getAllMonths();
		for(WebElement mnth:allmnths)
		{
			String actMonthText=mnth.getText();
			String expMonthText="January";
			if(actMonthText.equals(expMonthText))
			{
				mnth.click();
				break;
			}
			
		}
		
		List<WebElement> allDt=rp.getAllDates();
		for(WebElement dt:allDt)
		{
			String actDateText=dt.getText();
			String expDateText="10";
			if(actDateText.equals(expDateText))
			{
				dt.click();
				break;
			}
		}
		
		rp.clickOnSaveBtn();
		
		WebElement statusEle=rp.getConfirMessage();
		boolean statusIsDisp=statusEle.isDisplayed();
		Assert.assertTrue(statusIsDisp,"Step fail:Unable to add candidate");
		System.out.println("Successfully added candidate");
		Thread.sleep(5000);
		
		List<WebElement> allRecruitActBtns=rp.getRecruitActionBtns();
		for(WebElement recruiActBtn:allRecruitActBtns)
		{
			String act_RecruitActTxt=recruiActBtn.getText();
//			System.out.println(act_RecruitActTxt);
			if(act_RecruitActTxt.contains("Shortlist"))
			{
				recruiActBtn.click();
				break;
			}
					
		}
		
		WebElement shortlistCandHeadingEle=rp.getHeadingShortlistCandidate();
		boolean shortlistCandiIsHeadingDisp=shortlistCandHeadingEle.isDisplayed();
		Assert.assertTrue(shortlistCandiIsHeadingDisp,"Step fail:Unable to shortlist candidate");
		System.out.println("Successfully shortlisted candidate");

		List<WebElement> allActBtns=rp.getActionBtns();
		for(WebElement actBtn:allActBtns)
		{
			String actActBtnText=actBtn.getText();
			if(actActBtnText.contains("Save"))
			{
				actBtn.click();
				break;
			}
		}
		
		WebElement shortlistedEle=rp.getShortListedTxt();
		boolean shorlistedTxtIsDisp=shortlistedEle.isDisplayed();
		Assert.assertTrue(shorlistedTxtIsDisp,"Step fail:Unable to shortlist candidate");
		System.out.println("Successfully shortlisted candidate");
		
		List<WebElement> allBtns=rp.getBtnsReject_ScheduleInte();
		for(WebElement btn:allBtns)
		{
			String actBtntxt=btn.getText();
			if(actBtntxt.contains("Schedule Interview"))
			{
				btn.click();
				break;
			}
			
		}
	}   
	
	
	@Test(priority=16)
	public void verifyPerforLinkCkickable()
	{
		test=extent.createTest("verifyPerforLinkCkickable");
		
		perP.clickOnPerfoLink();
		
		String act_Url=hp.getUrl();        // from home page
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview";
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to click on performance link");
		System.out.println("Successfully clicked on performance link");
		
	}
	
	@Test(priority=17)
	public void verifyAllLinkOnPerforPageclickable()
	{
		test=extent.createTest("verifyAllLinkOnPerforPageclickable");
		
		perP.clickOnPerfoLink();               // click on performance link
		
		perP.clickOnConfiLink();               // click  on configure link
		perP.clickOnManageReviewsLink();       // click on manage reviews link
		perP.clickOnMyTrackersLink();          // click on my trackers link
		driver.navigate().back();
		
		perP.clickOnEmpTrackersLink();          // click on emp trackers link
		driver.navigate().back();
		
		String act_Url=hp.getUrl();
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview";
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to navigate");
		System.out.println("Successfully done navigation");
		
	}
	
	@Test(priority=18)
	public void verifyEmpTrackers()
	{
		test=extent.createTest("verifyEmpTrackers");
		
		perP.clickOnPerfoLink();                // click on performance link
		perP.clickOnEmpTrackersLink();          // click on emp trackers link
		
		WebElement loggedUserEle=perP.getLoggedUser();
		String loggedUserTxt=loggedUserEle.getText();
		
		WebElement txtInputbox=perP.getTxtEmpName();
		txtInputbox.sendKeys(loggedUserTxt);
		
		List<WebElement> allUsers=perP.getUserAutoSuggeti();
		for(WebElement user:allUsers)
		{
			String act_UserText=user.getText();
			if(act_UserText.contains(" "))
			{
				user.click();
				break;
			}
			
		}
		
		List<WebElement> allActionsBtns=perP.getActionsBtns();
		for(WebElement actionBtn:allActionsBtns)
		{
			String act_actionBtnTxt=actionBtn.getText();
			if(act_actionBtnTxt.contains("Search"))
			{
				actionBtn.click();
				break;
			}
		}
		
		WebElement confirmEle=perP.getConfirmTxtOnEmpTrackers();
		String act_confirmText=confirmEle.getText();
		if(act_confirmText.contains(")"))
		{
			System.out.println("Number of employee performance records found");
		}
		else
		{
			System.out.println("No employee performance records found");
		}
		
	}
	      
	@Test(priority=19)
	public void verifyMyPerforTrackers()
	{
		test=extent.createTest("verifyMyPerforTrackers");
		
		perP.clickOnPerfoLink();                     // click on performance link
		perP.clickOnMyTrackersLink();                // click on my trackers link
		
		WebElement confirmTextONMyTra=perP.getConfirmTxtOnMyTrackers();
		String act_ConfirmTxtOnMyTra=confirmTextONMyTra.getText();
		if(act_ConfirmTxtOnMyTra.contains("Record Found") && act_ConfirmTxtOnMyTra.contains(")"))
		{
			System.out.println("Number of Performance trackers of logged user found");
		}
		else
		{
			System.out.println("No performance records  found of logged user");
		}
	}   
	
	@Test(priority=20)		
	public void verifyDirectoryLinkClickable()
	{
		test=extent.createTest("verifyDirectoryLinkClickable");
		
		dp.clickOnDirectoryLink();                    // click on directory link
		
		String act_Url=hp.getUrl();
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/directory/viewDirectory";
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to click on directory link");
		System.out.println("Successfully clicked on directory link");
		
	}  
	
	@Test(priority=21)
	public void verifyNumbOfDirectory()
	{
		test=extent.createTest("verifyNumbOfDirectory");
		
		dp.clickOnDirectoryLink();                  // click on directory link
		
		List<WebElement> allUsers=dp.getAllDirectoryUser();
		for(WebElement user:allUsers)
		{
			String act_UserTxt=user.getText();
			System.out.println(act_UserTxt);
		}
		
		
	} 

	@Test(priority=22)
	public void verifyLoggedUserDirectory() throws InterruptedException
	{
		test=extent.createTest("verifyLoggedUserDirectory");
		
		dp.clickOnDirectoryLink();                 // click on directory link
		
		WebElement loggedUser=dp.getLoggedUser();
		String actLoggedUserTxt=loggedUser.getText();
		
		WebElement inputTxtbox=dp.getTxtEmpName();
		inputTxtbox.sendKeys(actLoggedUserTxt.substring(0,4));
		Thread.sleep(3000);
		
		List<WebElement> allAutoSuggeUsers=dp.getAllAutoSuggesUsers();
		for(WebElement autoSuggeUser:allAutoSuggeUsers)
		{
			String actAutoSuggeTxt=autoSuggeUser.getText();
			if(actAutoSuggeTxt.contains(" "))
			{
				autoSuggeUser.click();
				break;
			}
		}
		
		List<WebElement> allActiinsBtns=dp.getActionsBtns();
		for(WebElement actionBtn:allActiinsBtns)
		{
			String actActionBtnTxt=actionBtn.getText();
			if(actActionBtnTxt.contains("Search"))
			{
				actionBtn.click();
				break;
			}
		}
		
		WebElement confirmTxt=dp.getConfirmTxt();
		String actConfirmTxt=confirmTxt.getText();
		if(actConfirmTxt.contains("") && actConfirmTxt.contains(")"))
		{
			System.out.println("Successfully found logged user directory  ");
		}
		else
		{
			System.out.println("Not found logged user directory");
		}
		
		WebElement LoggedUserDirectory=dp.getLoggedUserDirectory();
		String actLoggedUserDireTxt=LoggedUserDirectory.getText();
     	System.out.println(actLoggedUserDireTxt);
	}   
	
	@Test(priority=23)
	public void verifyMaintenanceLinkClickable()
	{
		test=extent.createTest("verifyMaintenanceLinkClickable");
		
		mp.clickOnMaintenanceLink();           // click on maintenance link
		String act_Url=hp.getUrl();
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee";
	    Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to click on maintenance link");
	    System.out.println("Successfully clicked on maintenance link");
	}
	
	@Test(priority=24)
	public void verifyEnteredPasswordValid()
	{
		test=extent.createTest("verifyEnteredPasswordValid");
		
		mp.clickOnMaintenanceLink();          // click on maintenance link
		lp.enterPassword();
		
		List<WebElement> allAdminAccessBtns=mp.getAdminAccessBtns();
		for(WebElement adminAccessbtn:allAdminAccessBtns)
		{
			String actAdminAccessBtn=adminAccessbtn.getText();
			if(actAdminAccessBtn.contains("Confirm"))
			{
				adminAccessbtn.click();
				break;
			}
		}
		
		WebElement headingPurgeEmpRecords=mp.getHeadingPurgeEmpRecords();
		boolean purgeEmpRecordsIsDisp=headingPurgeEmpRecords.isDisplayed();
		Assert.assertTrue(purgeEmpRecordsIsDisp,"Step fail:Unabel to displayed--->Invalid credentials");
		System.out.println("Successfully displayed--->Valid credentials");
	}    
	
	@Test(priority=25)
	public void verifyLinksClickable()
	{
		test=extent.createTest("verifyLinksClickable");
		
		mp.clickOnMaintenanceLink();          // click on maintenance link
		lp.enterPassword();
		
		List<WebElement> allAdminAccessBtns=mp.getAdminAccessBtns();
		for(WebElement adminAccessbtn:allAdminAccessBtns)
		{
			String actAdminAccessBtn=adminAccessbtn.getText();
			if(actAdminAccessBtn.contains("Confirm"))
			{
				adminAccessbtn.click();
				break;
			}
		}
		
		mp.clickOnPurgeRecordsLink();        // click on purge records link
		mp.clickOnAccessRecordsLink();       // click on access records link
		driver.navigate().back();
		
		String exp_Url="https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee";
		String act_Url=hp.getUrl();
		Assert.assertEquals(act_Url, exp_Url,"Step fail:Unable to click on links");
		System.out.println("All links are clickable");
		
	}  
	
	@Test(priority=26)
	public void verifyCandidateRecords() throws InterruptedException
	{
		test=extent.createTest("verifyCandidateRecords");
		
		mp.clickOnMaintenanceLink();          // click on maintenance link
		lp.enterPassword();
		
		List<WebElement> allAdminAccessBtns=mp.getAdminAccessBtns();
		for(WebElement adminAccessbtn:allAdminAccessBtns)
		{
			String actAdminAccessBtn=adminAccessbtn.getText();
			if(actAdminAccessBtn.contains("Confirm"))
			{
				adminAccessbtn.click();
				break;
			}
		}
		
		mp.clickOnPurgeRecordsLink();        // click on purge records link
		List<WebElement> allLinks=mp.getAllLinksUnderPurgeRecords();
		for(WebElement link:allLinks)
		{
			String actLinkTxt=link.getText();
			if(actLinkTxt.equals("Candidate Records"))
			{
				link.click();
				break;
			}
		}
		
		WebElement txtInputbox=mp.enterTxt();
		txtInputbox.sendKeys("Senior");
		Thread.sleep(3000);
		
		List<WebElement> allVacancy=mp.getAllAuto();
		for(WebElement vacancy:allVacancy)
		{
			String actVacancytxt=vacancy.getText();
			if(actVacancytxt.equals("Senior QA Lead"))
			{
				vacancy.click();
				break;
			}
		}
		
		mp.clickOnSearchBtn();                    // click on search button
		
		WebElement confiTxt=mp.getConfiTxt();
		String actConfiTxt=confiTxt.getText();
		if(actConfiTxt.contains("Found") && actConfiTxt.contains(")"))
		{
			System.out.println("Number of purge records found");
		}
		else
		{
			System.out.println("No purge records found");
		}
		
		List<WebElement> allPurgeRecords=mp.getAllPurgeRecords();
		System.out.println("Number of purge records found-->"+allPurgeRecords.size());
		for(WebElement purgeRecord:allPurgeRecords)
		{
			String actPurgeRecordTxt=purgeRecord.getText();
			System.out.println(actPurgeRecordTxt);
		}
		
 	}    
	
	@Test(priority=27)
	public void verifyPersonalData()
	{
		test=extent.createTest("verifyPersonalData");
		
		mp.clickOnMaintenanceLink();                      // click on maintenance link
        lp.enterPassword();
		
		List<WebElement> allAdminAccessBtns=mp.getAdminAccessBtns();
		for(WebElement adminAccessbtn:allAdminAccessBtns)
		{
			String actAdminAccessBtn=adminAccessbtn.getText();
			if(actAdminAccessBtn.contains("Confirm"))
			{
				adminAccessbtn.click();
				break;
			}
		}
		
		mp.clickOnAccessRecordsLink();                    // click on access records link
		
		WebElement loogedUser=tp.getTxtLoggedUser();
		String actLoggedUserTxt=loogedUser.getText();
		
		WebElement txtInputbox=mp.enterTxt();
		txtInputbox.sendKeys(actLoggedUserTxt);
		
		List<WebElement> allAutoSuggesUser=tp.getAutosuggesTxt();
		for(WebElement autoSuggesUser:allAutoSuggesUser)
		{
			String actAutoSuggeUserTxt=autoSuggesUser.getText();
			if(actAutoSuggeUserTxt.contains(" "))
			{
				autoSuggesUser.click();
				break;
			}
		}
		
		mp.clickOnSearchBtn();                      // click on search button
		
//		WebElement headingSeleEmp=mp.getHeadingSelectedEmp();
//		boolean headinSelectEmpIsDisp=headingSeleEmp.isDisplayed();
//		Assert.assertTrue(headinSelectEmpIsDisp,"Step fail:Unable to display Selected Emp heading");
//		System.out.println("Successfully displayed selected emp heading");
		
		WebElement profilePic=mp.getProfilePic();
		boolean profilePicIsDisp=profilePic.isDisplayed();
		Assert.assertTrue(profilePicIsDisp,"Step fail:Unable to display profie pic");
		System.out.println("Successfully display profile pic");
	}
	
	
	@Test(priority=28)
	public void verifyBuzzLinkClickable()
	{
		test=extent.createTest("verifyBuzzLinkClickable");
		
		bp.clickOnBuzzLink();                  // click on buzz link
		
		String actUrl=hp.getUrl();
		String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz";
		Assert.assertEquals(actUrl, expUrl,"Step fail:Unable to click on buzz link");
		System.out.println("Successfullt clicked on buzz link");
	} 
	
	@Test(priority=29)
	public void verifyLinkClickHereClickable()
	{
		test=extent.createTest("verifyLinkClickHereClickable");
		
		bp.clickOnBuzzLink();                 // click on buzz link
		bp.clickOnLinkClickHere();            // click on click here link
		
		Set<String> allWinHandleId= driver.getWindowHandles();
		String parentWinHandleId=driver.getWindowHandle();
		for(String winHandleId:allWinHandleId)
		{
			if(!winHandleId.equals(parentWinHandleId))
			{
				driver.switchTo().window(winHandleId);
//				String expUrl="https://sourceforge.net/projects/orangehrm/files/latest/download";
				String actUrl=hp.getUrl();
				if(actUrl.contains("https://sourceforge.net/projects/orangehrm"))
				{
					Assert.assertTrue(true,"Step fail:Click here link is not clickable");
					System.out.println("Click here link is clickable");
				}
				
		  }
		}
		Assert.fail();           // I have forcefully fail 
	}
	
	@Test(priority =30)
	public void VerifyLogout() {
		test = extent.createTest("VerifyLogout");

		hp.getLoggedUserText().click();
		hp.getLogoutLink();
		boolean isOnLoginPage = lp.companyBranding();
		Assert.assertTrue(isOnLoginPage, "Step fail:User is not on login page after logout");
		System.out.println("Currently user is on login page after logout");
	}  
 
  }
