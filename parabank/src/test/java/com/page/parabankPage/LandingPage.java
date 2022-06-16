package com.page.parabankPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.parabank.Baseclass;
import com.page.parabankutil.PBconstants;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LandingPage extends Baseclass {
	@FindBy(xpath=PBconstants.ACCOUNT_NUMBER_LINK)
	public WebElement accountlink;
	
	public LandingPage(WebDriver driver,ExtentTest test){
		super(driver,test);

}
	
	public AccountsOverview gotoaccountnumber() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to ACCOUNTS OVERVIEW page");
		accountlink.click();
		System.out.println("NEW ACCOUNT page clicked");
        takeScreenShot();
        AccountsOverview accountsoverview=new AccountsOverview (driver,test);
        PageFactory.initElements(driver, accountsoverview);
        		
		return accountsoverview;
		
	}
	
	
}
