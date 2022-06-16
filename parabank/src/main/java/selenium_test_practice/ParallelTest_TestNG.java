package selenium_test_practice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.page.parabankutil.PBconstants;

public class ParallelTest_TestNG {
	
	@Test
	public void openbroser_firefox() {
		
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
//System.setProperty("webdriver.gecko.driver", "D://Selenium Environment//Drivers//geckodriver.exe");
        //System.out.println("GetFirefox Method is running on Thread : " + Thread.currentThread().getId());
		System.setProperty("webdriver.chrome.driver",  PBconstants.CHROME_DRIVER_EXE);
		WebDriver driver = new ChromeDriver();
driver.get("https://www.softwaretestingmaterial.com");
SoftAssert softAssertion= new SoftAssert();
System.out.println("softAssert Method Was Started");
softAssertion.assertTrue(false);
driver.close();
}
		
	
	@Test
	public void openbroser_chrome() {
		
		System.setProperty("webdriver.chrome.driver",  PBconstants.CHROME_DRIVER_EXE);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String actualtitle="Google";
		Assert.assertEquals(driver.getTitle(), actualtitle);
		//driver.findElement(By.xpath("//a[@class='gb']")).click();
		//assertEquals(driver.getTitle(),actualtext);
		driver.close();
	}
}//*[@id='Email']



