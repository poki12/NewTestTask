package com.phptravels.pages;
import org.apache.log4j.Logger;
import java.awt.Desktop;
import java.net.URI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.phptravels.base.BasePageObject;

public class RegistrationPage extends BasePageObject<RegistrationPage> {
	private static final String URL ="https://www.phptravels.net/register";

	private By firstname=By.xpath("//input[@name='firstname']");
	private By lastname=By.xpath("//input[@name='lastname']");
	private By phone=By.xpath("//input[@name='phone']");
	private By email=By.xpath("//input[@name='email']");
	private By password=By.xpath("//input[@name='password']");
	private By confirmpassword=By.xpath("//input[@name='confirmpassword']");
	private By submitButton=By.xpath("//button[@type='submit']");
	private By errorMessage =By.xpath("//div[@class='alert alert-danger']");
	
	
	public RegistrationPage(WebDriver driver,Logger log) {
		super(driver,log);
		
	}
	
public void openRegestrationPage(){
		
	getPage(URL);
	}


public void fillUpRegestrationData(String fname, String lname,String phon ,String emaill ,String pass ,String confirmpass ) {
	log.info("filling up regestration data");
	type(fname,firstname);
	type(lname,lastname);
	type(phon,phone);
	type(emaill,email);
	type(pass,password);
	type(confirmpass,confirmpassword);
	
}
	
public ProfilePage pushSignInButton(){
	log.info("Click on sign in Button");
	click(submitButton);
	return new ProfilePage(driver,log);
}

public String getLoginErrorMessage() {
	waitForVisiblityOf(errorMessage,10);
	return getText(errorMessage);
}
}
