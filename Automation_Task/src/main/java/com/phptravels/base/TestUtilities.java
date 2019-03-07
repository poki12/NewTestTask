package com.phptravels.base;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtilities extends BaseTest{
	
	protected void takeScreenshot(String fileName){
		
		
		File srcFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ 
					File.separator + "test-output"+
					File.separator + "screenshots"+
					File.separator + getTodaysDate() + 
					File.separator + testSuiteName +
					File.separator + testName +
					File.separator + testMethodName + 
					File.separator + getSystemTime()+
					" "+fileName + ".png";
					
					try{
						FileUtils.copyFile(srcFile, new File(path));
					}
					catch(IOException e){
						e.printStackTrace();
					}
					}
					
		private static String getTodaysDate(){
			
			return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
						
		}
		private String getSystemTime() {
		
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	  

			
	}

}
