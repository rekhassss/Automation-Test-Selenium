package practice_TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase1_page {
	
	@Test(dependsOnMethods="printtextmethod")
	public void init() {
		System.out.println("in home page");	
	}
	
	@Test
	public void printtextmethod() {
		System.out.println("This is Test Case 1");
	}
	
	
	@Test
	@Parameters("browser") //parameter is passed in .xml file
	public void open_browser(String browser) {
		if(browser.equals("firefox"))
		System.out.println("opening broswer");
		else
			System.out.println("its not firefox browser");
	}
	
	//parameter using data provider
	
	@Test(dataProvider="getdata")
	public void login(String user_name,String user_pwd) {
		System.out.println("TestNG Parameterization Using DataProviders");
		System.out.println("--------------------------------------------");
		System.out.println("USERNAME IS:"+user_name);
				System.out.println("USER PASSWORD IS:"+user_pwd);
	}
	
	
	//If the name is not supplied, the data provider’s name automatically defaults to the method’s name.
	//A data provider returns an array of objects.
	@DataProvider(name="getdata")
	public Object data() {
	//Object [][] data = new Object [rowCount][colCount];
	Object[][] data=new Object[2][2];{
	
	data[0][0]="apple_username";
	data[0][1]="grapes_pwd";
	data[1][0]="pine";
	data[1][1]="orange";
	}
	return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// @Test annotation will show FAILED TESTCASE,SO will use EXCEPTION in annotation
	@Test(expectedExceptions=ArithmeticException.class)
	public void exception_test() {
		
		System.out.println("divide 1 with 0 handled by EXCEPTION ");
		int i=1/0;
		
	}

}
