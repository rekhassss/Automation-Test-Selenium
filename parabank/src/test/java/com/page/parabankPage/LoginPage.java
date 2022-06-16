package com.page.parabankPage;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.parabank.Baseclass;
import com.page.parabankutil.PBconstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage  extends Baseclass{

	
	@FindBy(xpath=PBconstants.LOGIN_USERNAME)
	public WebElement email;
	
	@FindBy(xpath=PBconstants.LOGIN_PASSWORD)
	public WebElement password;

	

public LoginPage(WebDriver driver, ExtentTest test){
	super(driver,test);
}

public Object doLogin(String name, String pWord) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
    openconnDB() ;
	test.log(LogStatus.INFO, "Logging in -"+name+"/"+pWord);
	email.sendKeys(name);
	password.sendKeys(pWord);
	password.sendKeys(Keys.ENTER);
	takeScreenShot();
	System.out.println("LOGINSUCCESS");
	takeScreenShot();
	return null;
}




}
