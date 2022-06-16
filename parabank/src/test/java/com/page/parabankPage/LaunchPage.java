package com.page.parabankPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.page.parabank.Baseclass;
import com.page.parabankutil.PBconstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends Baseclass {
	
	
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver,test);
		
		
		
	}
	
	
	public LoginPage gotoLoginPage(){
		// log
		test.log(LogStatus.INFO, "Opening the url - ");
		//+FBConstants.getEnvDetails().get("url"));
		driver.get(PBconstants.HOMEPAGE_URL);
		//driver.get(FBConstants.getEnvDetails().get("url"));
		//test.log(LogStatus.PASS, "URL Opened - "+FBConstants.getEnvDetails().get("url"));
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}
}
