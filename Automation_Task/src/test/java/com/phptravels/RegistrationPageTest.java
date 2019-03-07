package com.phptravels;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.base.CsvDataProvider;
import com.phptravels.base.TestUtilities;
import com.phptravels.pages.RegistrationPage;
import com.phptravels.pages.ProfilePage;

public class RegistrationPageTest extends TestUtilities{
	
	
	@Test(dataProvider="CsvDataProvider",dataProviderClass=CsvDataProvider.class )
	public void possitiveRegistrationTest(Map<String,String> testData){
		
		String testNumber=testData.get("no");
		String fname=testData.get("fname");
		String lname=testData.get("lname");
		String phon=testData.get("phon");
		String emaill=testData.get("emaill");
		String pass=testData.get("pass");
		String confirmpass=testData.get("confirmpass");
		
		log.info("Test No # "+testNumber+" For First name:  "+fname+ "and Last name: "+lname+" Where \n Email: "+emaill+"and Password: "+ pass);
		
		RegistrationPage regestrationPage = new RegistrationPage(driver,log);
		
		regestrationPage.openRegestrationPage();
		
		//fill Up Registration Data from csv file
		
		regestrationPage.fillUpRegestrationData(fname,lname,phon ,emaill ,pass ,confirmpass);
		takeScreenshot("filling test data ...");
		
		//push sign in button
		regestrationPage.pushSignInButton();
		
		takeScreenshot("LoginPage opened");
		
		
		//push sign in button
		ProfilePage profilePage = regestrationPage.pushSignInButton();
		profilePage.setProfileName(fname,lname);
		profilePage.waitForProfileToLoad();
		
		
		takeScreenshot("profile page loaded");
		//verifications for the registered user opened his profile successfully
		log.info("verifications");
		
		//-verify correct name on profile page
		Assert.assertTrue(profilePage.isCorrectProfileLoaded("Hi, "+fname+" "+ lname),"Profile Name is not expected .");
		
	}
	
	@Test(dataProvider="CsvDataProvider",dataProviderClass=CsvDataProvider.class )
	public void negativeRegistrationTest(Map<String,String> testData){
		//String expectedErrorMessage="Email and/or password incorrect";
		log.info("negative test started");
		
		String testNumber=testData.get("no");
		String fname=testData.get("fname");
		String lname=testData.get("lname");
		String phon=testData.get("phon");
		String emaill=testData.get("emaill");
		String pass=testData.get("pass");
		String confirmpass=testData.get("confirmpass");
		
		log.info("Test No # "+testNumber+" For First name:  "+fname+ "and Last name: "+lname+" Where \n Email: "+emaill+"and Password: "+ pass);
		
		RegistrationPage regestrationPage = new RegistrationPage(driver,log);
		
		regestrationPage.openRegestrationPage();
		
		//fill Up Regestration Data from csv file
		
		regestrationPage.fillUpRegestrationData(fname,lname,phon ,emaill ,pass ,confirmpass);
		takeScreenshot("filling test data ...");
		//push sign in button
		regestrationPage.pushSignInButton();
		
		//String errorMessage = regestrationPage.getLoginErrorMessage();
		
		//Assert.assertTrue(expectedErrorMessage.contains(expectedErrorMessage), 
				//"Error message is not expected. Expected: "+expectedErrorMessage+"\nActual: "+errorMessage+" . ");		
	}

}
