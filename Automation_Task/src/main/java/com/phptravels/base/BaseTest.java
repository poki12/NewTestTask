package com.phptravels.base;

import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
	
	protected WebDriver driver;
	protected Logger log;
	
	protected String testSuiteName;
	protected String testMethodName;
	protected String testName;
	
	@BeforeClass(alwaysRun= true)
	protected void setUpClass(ITestContext ctx){
		String testName = ctx.getCurrentXmlTest().getName();
		log= Logger.getLogger(testName);
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	
	
	
	protected void methodSetUp(Method method,@Optional("chrome") String browser,ITestContext ctx){
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		//log.info("Method Set up");
		driver = BrowserFactory.getDriver(browser, log);
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException e){
			
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		
		this.testSuiteName=ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

	@AfterMethod(alwaysRun= true)
	protected void methodTeardown(){
		driver.quit();
		log.info("methodTeardown");
	}
		

}
