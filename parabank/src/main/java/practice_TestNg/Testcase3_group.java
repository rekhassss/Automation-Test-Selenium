package practice_TestNg;

import org.testng.annotations.Test;

public class Testcase3_group {
	
	@Test(groups= {"functional_test","smoke_test"})
	public void login() {
		System.out.println("you are in LOGIN_PAGE");
	}

	@Test(groups= {"smoke_test"})
	public void login_title() {
		System.out.println("you are validatign LOGIN_TITLE");
	}
}
