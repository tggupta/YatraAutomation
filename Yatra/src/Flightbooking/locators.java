package Flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class locators {

	WebDriver driver;
	public void locator(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='BE_flight_origin_city']")
	WebElement source;
	
	@FindBy(xpath="//*[@id='BE_flight_arrival_city']")
	WebElement destination;
	
	@FindBy(xpath="//*[@id='BE_flight_form']/div/div[2]/ul/li[3]/i")
	WebElement DepartDate;
	
	@FindBy(xpath="//*/div[@class='month-title' and text()='February']/following-sibling::div[1]//table/tbody//span[text()=1]")
	WebElement SelDate;
	
	@FindBy(xpath="//*[@id='BE_flight_flsearch_btn']")
	WebElement SearchButton;
	
	@FindBy(xpath="//*/p[@class='fl price-value fm-lb' and @title='Fare Summary']")
	WebElement lowestprice;
	
/*	@FindBy(xpath="//*[@id='PegasusCal-0']/div[3]/div[1]/ul/li[6]/a")
	WebElement Month;*/
	
	@FindBy(xpath="//*/a[@href='#PegasusCal-0-month-2-2018']")
	WebElement FindMonth;
	
	@FindBy(xpath="//*/div[@class='depart-radio']/following-sibling::p[@class='full fm-lsb time-detail']")
	WebElement departDate;
	
	@FindBy(xpath="//*/div[@class='fl fly-duration']/p[@class='full duration']")
	WebElement duration;
	
	@FindBy(xpath="//*/p[@class='full airline-name']")
	WebElement aircraftcarrier;
	
	@FindBy(xpath="//*/li[@class='fs-sm mr7 active' and @ng-class='{'active':flt.freemeal||!flt.freemeal}']/i[@class='ytfi-free-meal']")
	WebElement meals;
	
	
	public void sendkeys(String str)
	{
	driver.findElement(By.xpath("//*[@id='BE_flight_origin_city']")).sendKeys(str);	
	}

	
	
	
}

