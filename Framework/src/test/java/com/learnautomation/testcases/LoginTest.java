package com.learnautomation.testcases;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.CreateTimeCardPage;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.TimecardPage;


public class LoginTest extends BaseClass {
	
		
	
	
	@Test(priority=1)
	public void loginApp() throws InterruptedException {
		
		logger=reports.createTest("Loging to Timesheet");
				
		
		LoginPage lpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Login Started");
		
		lpage.submitlogin(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login Success");
		
		Thread.sleep(8000);
		
	}
	
	@Test(priority=2)
	public void clickTimeCardUser() {
		
		logger=reports.createTest("Timecarduser");
		TimecardPage tpage=PageFactory.initElements(driver, TimecardPage.class);
		tpage.clickTimeCardUser();
		logger.pass("Timecarduser successful ");
	}
	
	
	@Test(priority=3)
	public void selectTimecard() {
		logger=reports.createTest("Enter Project details/type");
		CreateTimeCardPage cpage=PageFactory.initElements(driver, CreateTimeCardPage.class);
		cpage.enterProjectDetails();
		logger.pass("Project code,type entered successfully");
	}
	
	@Test(priority=4)
	public void enterProjectHours() {
		logger=reports.createTest("Enter hours");
			CreateTimeCardPage cpage=PageFactory.initElements(driver, CreateTimeCardPage.class);
		double monday=excel.getintData("Hours", 0, 0);
		String mon1=Double.toString(monday);
		double tuesday=excel.getintData("Hours", 0, 1);
		String tue1=Double.toString(tuesday);
		double wednesday=excel.getintData("Hours", 0, 2);
		String wed1=Double.toString(wednesday);
		double thursday=excel.getintData("Hours", 0, 3);
		String thu1=Double.toString(thursday);
		double friday=excel.getintData("Hours", 0, 4);
		String fri1=Double.toString(friday);
		cpage.enterHours(mon1,tue1,wed1,thu1,fri1 );
		logger.pass("Hours entered successfully");
	}
	
	@Test(priority=5)
	public void submitFinalTimesheet() {
		logger=reports.createTest("Submit Timesheet");
		CreateTimeCardPage cpage=PageFactory.initElements(driver, CreateTimeCardPage.class);
		cpage.submitTimesheet();
		logger.pass("Timesheet submitted successfully");
	}
	
	}
	


