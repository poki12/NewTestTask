package com.phptravels.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	
protected WebDriver driver;
protected WebDriverWait wait;
protected Logger log;
	
public BasePageObject(WebDriver driver,Logger log){
	
	this.driver=driver;
	this.log=log;
	wait= new WebDriverWait(driver,40);
}

@SuppressWarnings("unchecked")
protected T getPage(String url){
	driver.get(url);
	return (T) this;
}

protected void type(String text,By element){
	
	find(element).sendKeys(text);
}

protected void click(By element){
	
	find(element).click();
}
protected WebElement find(By element) {
	return driver.findElement(element);
}

protected void waitForVisiblityOf(By locator,Integer...timeOutInSeconds ){
	int attempts=0;
	while (attempts<2){
		try{
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeOutInSeconds.length>0 ? timeOutInSeconds[0]: null));
		}
		catch(StaleElementReferenceException e){
			
		}
		attempts ++;
	}
	
}
private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds ){
	timeOutInSeconds = timeOutInSeconds !=null ? timeOutInSeconds:30;
	WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
	wait.until(condition);
}

public String getTitle() {
	return driver.getTitle();
	
}

protected String getText(By element){
	return find(element).getText();
	
}

protected Alert switchToAlert(){
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.alertIsPresent());
	return driver.switchTo().alert();
	
	
}
}