package com.page.parabankPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.parabank.Baseclass;
import com.page.parabankutil.PBconstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AccountsOverview  extends Baseclass{
	
	
		@FindBy(xpath=PBconstants.OPEN_NEW_ACCOUNT_LINK)
		public WebElement profilelink;
		
		public  AccountsOverview (WebDriver driver,ExtentTest test){
			super(driver,test);

}

		public void verifyProfile() {
			// TODO Auto-generated method stub
			test.log(LogStatus.INFO, "Verifying profile");
			
		}
		
			
			public void accountdetails() {
				test.log(LogStatus.INFO, "Checking account details");
			}
			public void accountActivity() {
				test.log(LogStatus.INFO, "Testing inside accountActivity");
			}
			
			public OpenNewAccount    gotonewaccountage() throws InterruptedException {
				test.log(LogStatus.INFO, "Going to NEW ACCOUNT page");
					Thread.sleep(1000);
					profilelink.click();
					
			        OpenNewAccount OpenNewAccount = new OpenNewAccount (driver,test);
					PageFactory.initElements(driver, OpenNewAccount);
					return OpenNewAccount;
				}
		}
	
