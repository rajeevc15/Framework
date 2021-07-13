package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimecardPage {
	
	//Timecard page
	
	WebDriver driver;
	
	public TimecardPage(WebDriver driver) {
		this.driver=driver;
	}
	//div[contains(text(),'JCP Timecard User')]
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'JCP Timecard User')]")
	WebElement timecarduser;
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Create Timecard')]")
	WebElement createTimecard;
	
	
	
	public void clickTimeCardUser() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'JCP Timecard User')]")));
		timecarduser.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Create Timecard')]")));
		createTimecard.click();
	}

}
