package Flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class random {
	
	WebDriver driver=null;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\Tarun\\Documents\\Git\\Yatra\\lib1\\geckodriver.exe");
		FirefoxProfile fp=new FirefoxProfile();
		fp.setPreference("dom.webnotifications.enabled", false);
		driver=new FirefoxDriver(fp);
	}
	}
	
	@Test
	public void toplinkSupport() throws InterruptedException
	{
		driver.get("http://www.yatra.com");
		String superheading = driver.findElement(By.xpath("//*[@id='booking_engine_activities']/span[2]")).getText();
		System.out.println(superheading);
	}
	
}
