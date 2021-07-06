package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Header;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;

	@BeforeSuite
	public void loadExcel() {
		
		Reporter.log("Loading configurations",true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		@SuppressWarnings("deprecation")
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/Report_" + Helper.getCurrentDate() + ".html"));
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);

	}

	@BeforeClass
	public void setup() {
		Reporter.log("Browser and application is about to start",true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		System.out.println(driver.getTitle());
		Reporter.log("Browser and application is up and running",true);
	}

	// @AfterClass
	public void quitBrowser() {
		Reporter.log("Browser is about to get closed",true);
		BrowserFactory.quitBrowser(driver);
		Reporter.log("Browser closed",true);
	}

	@AfterMethod
		public void takescr(ITestResult result) {
		Reporter.log("Screenshot will be taken",true);
		try {
		if(result.getStatus()==ITestResult.FAILURE) {
	
			logger.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		 
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}				
		Reporter.log("Screenshot  taken",true);
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		reports.flush();
}}
