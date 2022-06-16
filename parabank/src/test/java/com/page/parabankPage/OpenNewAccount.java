package com.page.parabankPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.parabank.Baseclass;
import com.page.parabankutil.PBconstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OpenNewAccount extends Baseclass {
//	
	@FindBy(xpath=PBconstants.OPEN_NEW_ACCOUNT_LINK)
public WebElement profileLink;
	
	public OpenNewAccount  (WebDriver driver,ExtentTest test){
		super(driver,test);}
		
}


