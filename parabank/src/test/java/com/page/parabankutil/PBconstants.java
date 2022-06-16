package com.page.parabankutil;

import java.util.Hashtable;

public class PBconstants {
	

	//paths
	public static final String CHROME_DRIVER_EXE="C:\\selenium driver\\chromedriver.exe";
	
	
	// locators
	public static final String LOGIN_USERNAME = "//input[@type='text']";
	public static final String LOGIN_PASSWORD = "//input[@type='password']";
	public static final String LOGIN_BUTTON = "//input[@class='button']";
	public static final String ACCOUNT_NUMBER_LINK="/html/body/div[1]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]/a";
	public static final String OPEN_NEW_ACCOUNT_LINK="/html/body/div[1]/div[3]/div[1]/ul/li[1]/a";
	
	
	
	//paths
	public static final String DATA_XLS_PATH="C://Users//anand//eclipse-workspace//Module20Part3//Se.xlsx";
	public static final String REPORTS_PATH = "C://report//";


	public static final String HOMEPAGE_URL = "https://parabank.parasoft.com/parabank/index.htm";
	public static final String TESTDATA_SHEET = "data";
	public static final String TESTCASES_SHEET = "TestCase";
	
	public static Hashtable<String,String> table;
}
