package webpages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import utilities.Configurations;

public class FlightBookingPage {
	WebDriver driver;
	Configurations cr;
	By flightstab= By.xpath("//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[2]/a");
	
	//Journey details variables
	By journeytype= By.id("one-way");
	By sourceinput= By.xpath("//*[@id=\"autocomplete\"]");
	By sourcevalue= By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]/b");
	By destinationinput= By.xpath("//*[@id=\"autocomplete2\"]");
	By destinationvalue= By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/b");
	By departuredate= By.xpath("//*[@id=\"fadein\"]/div[7]/div[1]/table/tbody/tr[5]/td[2]");
	
	//Flight details
	By earliestflight= By.xpath("//*[@id=\"data\"]/ul/li[2]/div/form/div/div[2]/div/button/span");
	
	//passenger 1 variables
	By passenger1designation= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/select");
	By passenger1firstname= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/input");
	By passenger1lastname= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/input");
	By nationality1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/select");
	By month1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/select");
	By date1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]/select");
	By year1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/select");
	By passportNumber1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/input");
	By issuemonth1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[1]/select");
	By issuedate1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[2]/select");
	By issueyear1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[3]/select");
	By expirymonth1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div/div[1]/select");
	By expirydate1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div/div[2]/select");
	By expiryyear1= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div/div[3]/select");
	
	//passenger 2 variables
	By passenger2designation= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/select");
	By passenger2firstname=	By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/input");
	By passenger2lastname= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/input");
	By nationality2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/select");
	By month2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/select");
	By date2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]/select");
	By year2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/select");
	By passportNumber2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/input");
	By issuemonth2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]/select");
	By issuedate2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/select");
	By issueyear2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/select");
	By expirymonth2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/select");
	By expirydate2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/select");
	By expiryyear2= By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[3]/select");
	
	public FlightBookingPage(WebDriver driver) throws IOException	
	{
		//Instantiating Flight Booking Page
		this.driver=driver;
		cr=new Configurations();
		driver.findElement(flightstab).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);		
		WebElement flightbooking= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fadein\"]/section[1]/section/div/h2")));
		cr.takeScreenShot("FlightBookingPage", driver);
		Assert.assertEquals(flightbooking.getText(), "SEARCH FOR BEST FLIGHTS");
		System.out.println("Flight Booking Page opened");
		Reporter.log("Flight_Booking_Page_Opened");
				
	}
	
	public void journeyDetails()
	{
		//Filling in details of the journey to check Flight Availability
		driver.findElement(journeytype).click();
		Select flighttype=new Select(driver.findElement(By.xpath("//*[@id=\"flight_type\"]")));
		flighttype.selectByVisibleText("Economy");
		driver.findElement(sourceinput).sendKeys("Hyd");
		driver.findElement(sourcevalue).click();
		driver.findElement(destinationinput).sendKeys("Bom");
		driver.findElement(destinationvalue).click();
		driver.findElement(By.id("departure")).click();
		driver.findElement(departuredate).click();
		driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/div/div[1]/div/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"flights-search\"]")).click();
	}
	
	public void journeyDetailsVerification() throws IOException
	{
		cr.takeScreenShot("JourneyDetailsVerification", driver);
		if(driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div[1]/div/div/div/span/strong/h2")).isDisplayed()==true)
		{
			String flightconfirm= driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div[1]/div/div/div/span/strong/h2")).getText();
			Assert.assertEquals(flightconfirm, "HYD BOM");
			System.out.println("Journey details filled in, navigating to flight selection");
			Reporter.log("Journey_details_filled_in_Navigating_to_Flight_Selection");
		}
		else
		{
			System.out.println("Invalid Journey details");
			Reporter.log("Invalid_Journey_Details");
		}
		
	}
	
	public void flightConfirmation() throws IOException
	{
		//Selecting flight of the available options
		driver.findElement(By.id("direct")).click();
 		driver.findElement(earliestflight).click();
 		cr.takeScreenShot("FlightConfirmation", driver);
 		System.out.println("Flight Confirmation");
 		Reporter.log("FlightConfirmation");
	}
	
	public void fillingPassengerDetails() throws InterruptedException, IOException
	{
		//Passenger 1 details
		Select country=new Select(driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[1]/div[2]/div[6]/div[2]/select")));
		country.selectByValue("IN");
		driver.findElement(passenger1designation).sendKeys("MISS");
		driver.findElement(passenger1firstname).sendKeys("Priyanka");
		driver.findElement(passenger1lastname).sendKeys("Naarlapuram");
		driver.findElement(nationality1).sendKeys("India");
		driver.findElement(month1).sendKeys("12");
		driver.findElement(date1).sendKeys("30");
		driver.findElement(year1).sendKeys("2000");
		driver.findElement(passportNumber1).sendKeys("V32132F");
		driver.findElement(issuemonth1).sendKeys("12");
		driver.findElement(issuedate1).sendKeys("21");
		driver.findElement(issueyear1).sendKeys("2013");
		driver.findElement(expirymonth1).sendKeys("08");
		driver.findElement(expirydate1).sendKeys("15");
		driver.findElement(expiryyear1).sendKeys("2028");
		
		
		//Passenger 2 details
		Select gender=new Select(driver.findElement(passenger2designation));
		gender.selectByValue("Mr");
		driver.findElement(passenger2firstname).sendKeys("Aditya");
		driver.findElement(passenger2lastname).sendKeys("Kadagala");
		driver.findElement(nationality2).sendKeys("India");
		driver.findElement(month2).sendKeys("10");
		driver.findElement(date2).sendKeys("14");
		driver.findElement(year2).sendKeys("2000");
		driver.findElement(passportNumber2).sendKeys("V12454F");
		driver.findElement(issuemonth2).sendKeys("08");
		driver.findElement(issuedate2).sendKeys("12");
		driver.findElement(issueyear2).sendKeys("2015");
		driver.findElement(expirymonth2).sendKeys("10");
		driver.findElement(expirydate2).sendKeys("15");
		driver.findElement(expiryyear2).sendKeys("2031");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);		
	}
	
	public void confirmPaymentMethod() throws IOException
	{
		
		//To scroll down page and select payment method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//To check if the payment element is visible
		WebDriverWait wait=new WebDriverWait(driver, 10);		
		WebElement paymentMethod= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gateway_razorpay\"]")));
		
		
		if(driver.findElement(By.xpath("//*[@id=\"gateway_razorpay\"]")).isSelected()==false)
		{	
			 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			 paymentMethod.click();
		}
		cr.takeScreenShot("PaymentSelection", driver);
		System.out.println("Payment mode selected");
		Reporter.log("Payment_mode_selected");
	}
	
	public void bookingConfirmation() throws IOException
	{
		//Booking confirmation
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		System.out.println("Booking confirmation Pending");
		Reporter.log("Booking_Confirmation_Pending");
		
		if(driver.findElement(By.id("agreechb")).isSelected()==false)
		{
			driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[4]/div/div/div")).click();
		}
		
		WebDriverWait wait=new WebDriverWait(driver, 10);		
		WebElement Bookingbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"booking\"]")));
		Bookingbutton.click();
		cr.takeScreenShot("BookingConfirmed", driver);
		System.out.println("Booking confirmed, navigated to Payment gateway");
		Reporter.log("Booking_Confirmed");
	}
	
	public void closingBrowser()
	{
		driver.quit();
	}
}
