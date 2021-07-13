package com.learnautomation.pages;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;

public class CreateTimeCardPage {
	
	WebDriver driver;
	
	public CreateTimeCardPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	@FindBy(how=How.XPATH ,using=("//input[@id='A241N1display'][@title='Project']"))
	WebElement Project;
	
	@FindBy(how=How.XPATH ,using=("//input[@id='A251N1display'][@title='Task']"))
	WebElement Task;
	
	@FindBy(how=How.XPATH ,using=("//input[@id='A261N1display'][@title='Type']"))
	WebElement Type;
	
	@FindBy(how=How.XPATH ,using=("//input[@id='B22_1_0'][contains(@title,'Hrs Mon')]"))
	WebElement Mon;
	
	@FindBy(how=How.XPATH ,using=("//input[@id='B22_1_1'][contains(@title,'Hrs Tue')]"))
	WebElement Tue;
	
	@FindBy(how=How.XPATH ,using=("//input[@id='B22_1_2'][contains(@title,'Hrs Wed')]"))
	WebElement Wed;
	
	@FindBy(how=How.XPATH ,using=("//input[@id='B22_1_3'][contains(@title,'Hrs Thu')]"))
	WebElement Thu;
	
	@FindBy(how=How.XPATH ,using=("//input[@id='B22_1_4'][contains(@title,'Hrs Fri')]"))
	WebElement Fri;
	
	@FindBy(how=How.XPATH ,using=("//img[@alt='Search: Type']"))
	WebElement TypeSearch;
	
	@FindBy(how=How.XPATH ,using=("//button[contains(text(),'Go')]"))
	WebElement childButtonGo;
	
	@FindBy(how=How.XPATH ,using=("//table[@id='HXC_CUI_EXPTYPE_LOV_lovTable:Content']/tbody//input[@id='N1:N8:1']"))
	WebElement JCPStandadTimeRadio;
	
	
	@FindBy(how=How.XPATH ,using=("//button[contains(text(),'Select')]"))
	WebElement childButtonSelect;
	
	@FindBy(how=How.XPATH ,using=("//button[@id='review']"))
	WebElement presstoContinue;
	
	@FindBy(how=How.XPATH ,using=("//button[@id='HxcSubmit']"))
	WebElement presstoSubmit;
	
	
	
	
	
	public void enterProjectDetails()  {
		try {
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		Project.sendKeys("214816");
		Project.sendKeys(Keys.TAB);
		Thread.sleep(5000);
	   String project=Project.getText();
	   System.out.println(project);
	   //assertEquals(project, "214816 - Enterprise PO - Drop 3");
	   Task.sendKeys("52 TSTCAP");
	   Task.sendKeys(Keys.TAB);
	   Thread.sleep(5000);
	   TypeSearch.click();
	   Thread.sleep(6000);
	   Set<String>s=driver.getWindowHandles();
	   System.out.println(s);
	   System.out.println(s.size());
	   Iterator<String> I1=s.iterator();
	   
	   while(I1.hasNext())
	   {
		   System.out.println("Parent" +parent);
		   
		   String childWindow=I1.next();
		   System.out.println("Child" +childWindow);
		   
		  if(!parent.equals(childWindow))
		   {
			  Thread.sleep(5000);
			   System.out.println("Child Windows");
			   System.out.println("Child window is" + driver.switchTo().window(childWindow).getTitle());
			   System.out.println("Child window id is" + driver.switchTo().window(childWindow)); 
			   System.out.println("ChildWindow"+childWindow);
			   
			   
			   driver.switchTo().window(childWindow);
			   System.out.println(driver.getPageSource());
			   System.out.println("Title: "+driver.getTitle());
			   System.out.println("URL "+driver.getCurrentUrl());
			   Thread.sleep(3000);
			   
			   Actions action=new Actions(driver);
			   		   
			   action.moveByOffset(406, 134).click().build().perform();
			   Thread.sleep(3000);
			   
			   Actions action1=new Actions(driver);
			   
			   //driver.findElement(By.xpath("//input[@id='N1:N8:1']")).click();
			   action1.moveByOffset(-406, -134).click().build().perform();
			   action1.moveByOffset(28, 273).click().build().perform();
			   action1.moveByOffset(-28, -273).click().build().perform();
			    action1.moveByOffset(693, 26).click().build().perform();
			   
			   driver.switchTo().window(parent);
			   
			
			   
			 
			   /*int size = driver.findElements(By.tagName("iframe")).size();
			   System.out.println(size);
			   if(size>0) {
			   for(int i=0; i<=size; i++){
				   Thread.sleep(3000);
			   driver.switchTo().frame(i);
			   String frame=driver.switchTo().frame(i).getTitle();
			   String frameid=driver.switchTo().frame(i).getWindowHandle();
			   System.out.println("Frameid" +frameid);
			   System.out.println("Frame:"+frame);
			   Thread.sleep(3000);
			   childButtonGo.click();
			   }} else {
				   Thread.sleep(3000);
				   childButtonGo.click();
			   }*/
			  /*String child=driver.switchTo().window(childWindow).getTitle();
			  System.out.println(child);
			  childButtonGo.click();
			  JCPStandadTimeRadio.click();
			  childButtonSelect.click();*/
			  
		  }
	   }
	   
	   
	   
	   
		
	}catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public void enterHours(String mon, String tue, String wed, String thu, String fri) {
		Mon.sendKeys(mon);
		Tue.sendKeys(tue);
		Wed.sendKeys(wed);
		Thu.sendKeys(thu);
		Fri.sendKeys(fri);
		
	}
	
	public void submitTimesheet() {
		presstoContinue.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presstoSubmit.click();
	}

}
