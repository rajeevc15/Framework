package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;


public class LoginTest extends BaseClass {
	
		
	
	
	@Test
	public void loginApp() {
		
		logger=reports.createTest("Loging to Timesheet");
				
		
		LoginPage lpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Login Started");
		
		lpage.submitlogin(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login Success");
		
	}
	
	
	
	

}
