package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TimecardPage {
	
	//Timecard page
	
	WebDriver driver;
	
	public TimecardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'JCP Timecard User')]")
	WebElement timecarduser;
	
	public void clickTimeCardUser() {
		timecarduser.click();
	}

}
