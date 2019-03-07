package com.phptravels.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.phptravels.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage> {
	private String fullname;
	private By profileContactNameText = By.xpath("//h3[contains(.,fullname)]");
	public ProfilePage(WebDriver driver ,Logger log) {
		super(driver, log);
		
		// TODO Auto-generated constructor stub
	}
	
	public String setProfileName(String fname, String lname){
		String firstName=fname;
		String lastName=lname;
		fullname="Hi, "+firstName+" "+lastName;
		return fullname;
	}

	public void waitForProfileToLoad(){
		System.out.println("waiting For Profile To Load");
		waitForVisiblityOf(profileContactNameText,10);
	}
	
	public boolean isCorrectProfileLoaded(String correctProfileName){
		if(getText(profileContactNameText).equals(correctProfileName)){
			return true;
		}
		return false;
		
	}

}
