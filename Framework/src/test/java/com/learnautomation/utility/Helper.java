package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshots, alerts, frames, window handles, java script, sync issue
	
	public  static String  captureScreenshot(WebDriver driver) {
		
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/Screenshot_" +getCurrentDate() + ".png";
		System.out.println(screenshotPath);
		try {
			FileHandler.copy(scr, new File(screenshotPath));
			System.out.println("Taken Screenshot");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotPath;
	}
	
	public static String getCurrentDate() {
		DateFormat customdate=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currDate=new Date();
		return customdate.format(currDate); 
	}

}
