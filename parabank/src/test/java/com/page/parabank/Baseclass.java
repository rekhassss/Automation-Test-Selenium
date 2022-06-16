package com.page.parabank;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.parabankutil.ExtentManager;
import com.page.parabankutil.PBconstants;
import com.page.parabankutil.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class Baseclass {
	
	public Xls_Reader xls = new Xls_Reader( PBconstants.DATA_XLS_PATH);
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public WebDriver driver;
	
	@Test
	public void init(){
		
		//browser.value is read from POM file
		String bType= System.getProperty("browser.value");
		System.out.println(bType);
		//test.log(LogStatus.INFO, "Opening browser - "+ bType);
		
			if(bType.equalsIgnoreCase("Mozilla"))
				driver= new FirefoxDriver();
			else if(bType.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver",  PBconstants.CHROME_DRIVER_EXE);

				Map<String, Object> prefs = new HashMap<String, Object>();
	            
	            // Set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 2);

	            // Create object of ChromeOption class
		ChromeOptions options = new ChromeOptions();
		
		 // Set the experimental option
		options.setExperimentalOption("prefs", prefs);
				driver=new ChromeDriver(options);
			}
			}
	
	public Baseclass(){}
	
	public Baseclass(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
}
	
	@BeforeClass
	public void openconnDB() throws ClassNotFoundException, SQLException {
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	    String dbUrl = "jdbc:mysql://localhost:3306/bank_schema";					

	    String actualResult="";
		String expectedResult="";
		
		//Database Username		
		String username = "root";	
	    
		//Database Password		
		String password = "surya";				

		//Query to Execute		
		String query = "select *  from cred;";	
	    
		    //Load mysql jdbc driver		
		    Class.forName("com.mysql.jdbc.Driver");			

			//Create Connection to DB		
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		  Statement stmt = con.createStatement();
		  ResultSet rs= stmt.executeQuery(query);							
		  //
		
		try {
			 // Step 3 - Execute statement
		      stmt = con.createStatement();
		      rs = stmt.executeQuery("select * from cred where USERNAME='praveen';");
		      
		      
		   //   stmt.setString(1, username);
			//	ResultSet rs=stmt.executeQuery(title);
				
				if(!rs.next())
					expectedResult="LoginFailure";
				else{// something is present
					String pwdDB = rs.getString("PASSWORD");
					System.out.println("Password from DB-> "+ pwdDB);
					if(pwdDB.equals(password))
						
						System.out.println("LOGINSUCCESS");
						//expectedResult="LoginSuccess";
					else
						expectedResult="LoginFailure";
				}
	    } catch (SQLException e) {
		      e.printStackTrace();
		    }
	 }
	
	
	
	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=PBconstants.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
}
