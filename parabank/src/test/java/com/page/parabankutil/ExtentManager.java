package com.page.parabankutil;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			//extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/Report.html", true);
			
			extent = new ExtentReports("C:\\report\\"+fileName, true, DisplayOrder.NEWEST_FIRST);
			//extent = new ExtentReports("C:\\report\\"+"/test-output/Report.html", true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportConfig.xml"));
//			extent.loadConfig(new File("C://Users//anand//eclipse-workspace//Module20Part3//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			