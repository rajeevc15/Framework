package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	
		driver=this.driver;
		
	}
	
	@FindBy(how=How.ID,using="usernameField")
	WebElement username;
	
	@FindBy(how=How.ID,using="passwordField")
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Login')]")
	WebElement submit;
	
	public void submitlogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
	}
	
	
	

}
