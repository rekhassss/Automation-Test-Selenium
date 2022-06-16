package com.page.parabanktTESTRUNCASE;

import java.sql.SQLException;
import java.util.Hashtable;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.parabank.Baseclass;
import com.page.parabankPage.AccountsOverview;
import com.page.parabankPage.LandingPage;
import com.page.parabankPage.LaunchPage;
import com.page.parabankPage.LoginPage;
import com.page.parabankPage.OpenNewAccount;
import com.page.parabankutil.DataUtil;
import com.page.parabankutil.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentTest;


public class LoginTest  extends Baseclass{
	
	
	Xls_Reader xls = new Xls_Reader("C://Users//anand//eclipse-workspace//Module20Part3//Se.xlsx");
	String testCaseName="LoginTest";
	@Test(dataProvider = "getData")
	
	public void readrunningmode(Hashtable<String, String> data) throws InterruptedException, ClassNotFoundException, SQLException {
		// System.out.println("entered");
		test = extent.startTest("FBLoginPage");
		test.log(LogStatus.INFO, "Starting the test test LOGIN");

	//	test.log(LogStatus.INFO, data.toString());
		//1st run DataUtil file
		if (!DataUtil.isTestExecutable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			// if(data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
		
		test.log(LogStatus.INFO, "Starting login test");
		test.log(LogStatus.INFO, "Opening browser");
		
		//2nd runs init from basepage opens browser
		init();
		
		//3rd runs launchpage opens web page and go to loginpage
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		// 4th login page runs with DBconn validating login succes
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.takeScreenShot();
		test.log(LogStatus.INFO, "Logging in");
		//5t looged in assertion
		Object page=loginPage.doLogin(data.get("USERNAME"), data.get("PASSWORD"));
		test.log(LogStatus.INFO, "LoggedIN PASSWORD AND DB PASSWORD MATCHES");
		String actualResult="";
		// if i am logged in
		
		
		if(page instanceof LoginPage)
			Assert.fail("Login failed ");
		else if(page instanceof LandingPage)
			System.out.println("Logged in successfully");
		
////		//6t landing page
LandingPage landingPage=new LandingPage(driver, test);
PageFactory.initElements(driver, landingPage);
		//landingPage.getMenu().search();
		//landingPage.verifyTitle("xxxxxx");\
//AccountsOverviewPAGE class inside landingPAGE class.gotoaccountnumber	
AccountsOverview newaccountsoverviewPage=landingPage.gotoaccountnumber();

AccountsOverview  accountsoverview=new  AccountsOverview(driver,test);
PageFactory.initElements(driver,accountsoverview);
accountsoverview.gotonewaccountage();	

OpenNewAccount newaccountPage=accountsoverview.gotonewaccountage();
		newaccountsoverviewPage.verifyProfile();
	test.log(LogStatus.PASS, "Test Passed");
//		//profPage.getMenu().logout();
newaccountsoverviewPage.takeScreenShot();
//SendMail d=new SendMail();
//		
//	TopMenu topmenu=new TopMenu(driver, test);
//	PageFactory.initElements(driver,topmenu );

	//GeneralSettingsPage generalsetting=topmenu.gotoSettings();
		
	}
	@AfterTest
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.close();
	}
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
	

//	@AfterTest
//	public void sendmail() {
//		
//		SendMailSSLWithAttachment se=new SendMailSSLWithAttachment();
//		PageFactory.initElements(driver,se );
//
//	}
}

	


