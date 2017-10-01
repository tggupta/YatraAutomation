package Flightbooking;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.function.Function;

public class YatraSupport {
	
	WebDriver driver=null;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\Tarun\\Documents\\Git\\Yatra\\lib1\\geckodriver.exe");
		FirefoxProfile fp=new FirefoxProfile();
		fp.setPreference("dom.webnotifications.enabled", false);
		driver=new FirefoxDriver(fp);
	}
	
	@Test
	public void toplinkSupport() throws InterruptedException
	{
		driver.get("http://www.yatra.com");
		//WebElement yatra=driver.findElement(By.xpath("//*/a[@title='yatra.com']"));

		//Thread.sleep(3000);
		
				
		WebElement support=driver.findElement(By.xpath("//*[@id='cutomerSupportNav']/a"));
		Actions act=new Actions(driver);
		act.moveToElement(support).perform();
		
		Thread.sleep(3000);
		WebElement contactus=driver.findElement(By.xpath("//*/a[@title='Contact Us']"));
		String contactustext=contactus.getText();
		act.moveToElement(contactus).build().perform();
		if(contactustext.equals("Contact Us"))
		{
			contactus.click();	
			System.out.println("contact us clicked");
		}
		else
		{
			System.out.println("text does not match");
		}
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver).
				pollingEvery(5, TimeUnit.SECONDS).
				withTimeout(30, TimeUnit.SECONDS).
				ignoring(NoSuchElementException.class);
		
		WebElement yatra1=wait.until(new Function<WebDriver,WebElement>()
		{
			public WebElement apply(WebDriver driver) 
			{
				return driver.findElement(By.xpath("//*[@id='nanorep-ew']/div/div/div/div/div[1]/div/div/div[1]/div/input"));
			}
		}
		);
		
		
	}
	
}
