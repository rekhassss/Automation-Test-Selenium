package com.page.parabankutil;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {
	ExtentReports extent;
	ExtentTest logger;
	
	@Test
	public void init() {
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
		
		//extent.addSystemInfo("Environment","Environment Name")

		extent
        .addSystemInfo("Host Name", "Reke Testing")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "Rekha");
		
		 //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent.xml"));
	}

}
