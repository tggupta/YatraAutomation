package Flightbooking;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class flightbooking extends Excel {

	WebDriver driver=null;
		//this is just a sample
	@BeforeMethod
	public void beforebookticket()
	{
		System.setProperty("webdriver.firefox.marionette", "user.path"+"\\lib\\geckodriver.exe");
		FirefoxProfile fp=new FirefoxProfile();
		fp.setPreference("dom.webnotifications.enabled", false);

		driver=new FirefoxDriver(fp);
		driver.get("http://www.yatra.com");
		}
	
	@Test
	public void booktickets() throws InterruptedException, IOException
	{
		locators loc=PageFactory.initElements(driver, locators.class);
		flightbooking fb=new flightbooking();	
		int trows=fb.totalrows("Sheet2");
		for(int i=1;i<=trows;i++)
		{	
		driver.manage().timeouts().implicitlyWait(7000,TimeUnit.SECONDS);	
			
//		Thread.sleep(4000);
			//<tg> Do we need - Thread.sleep ???
/*		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BE_flight_flsearch_btn']")));
		*/	//<tg> Can we remove Explicitwait
/*		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(40, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement Sourcevisiblity = wait.until(new Function<WebDriver, WebElement>()
			{
				@Override
				public WebElement apply(WebDriver driver) 
				{
					return(driver.findElement(By.xpath("//*[@id='BE_flight_origin_city']")));
				}
			}
		);*/
				
		loc.source.clear();
		loc.source.sendKeys("Delhi");
		loc.source.sendKeys(Keys.ENTER);
		loc.destination.clear();
		loc.destination.sendKeys("Bangkok");
		loc.destination.sendKeys(Keys.ENTER);
		loc.DepartDate.click();
		loc.FindMonth.click();
		int rowvalue=fb.readExcel("Sheet2", i);
		driver.findElement(By.xpath("//*/div[@class='month-title' and text()='February']/following-sibling::div[1]//table/tbody//span[text()="+rowvalue+"]")).click();
		//loc.SelDate.click();
		loc.SearchButton.click();
		
		WebDriverWait wait1=new WebDriverWait(driver, 15);
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/span[@class='block']")));
		
		System.out.println("pass");
		
		String price=loc.lowestprice.getText();
		System.out.println(price);
		String departDate=loc.departDate.getText();
		System.out.println(departDate);
		String duration=loc.duration.getText();
		System.out.println(duration);		
		System.out.println("going in excel function");
		
		System.out.println("reading excel");System.out.println("A");
		fb.setCellData("Sheet2",1, i, price); System.out.println("B");
		fb.setDepartDate("Sheet2", 2, i, departDate);
		fb.setDuration("Sheet2", 3, i, duration);
		
		Thread.sleep(2000);
		driver.navigate().back();System.out.println("C");
		}
	}
	
}
