package practice_TestNg;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Testcase2_page {
	
	//Test to be ENABLED for some purpose.
	//@Test(enabled=false)
	//@Test
	public void printextmethod() {
	System.out.println("This is Test Case 2");
	}
	
	

	//not ready to test
	@Test
	public void open_browser()
	{
		String p="skip_test";
		if(p.equals("skip_test")) {
		throw new SkipException("Skipping - This is not ready for testing ");}
		else {
			System.out.println("This is else  condition");}	
	}


}
