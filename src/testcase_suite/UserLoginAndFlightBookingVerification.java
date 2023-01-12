package testcase_suite;

import java.io.IOException;
import org.testng.annotations.Test;
import browserImplementation.LaunchingBrowser;
import utilities.Configurations;
import webpages.FlightBookingPage;
import webpages.HomePage;
import webpages.LoginPage;


public class UserLoginAndFlightBookingVerification {
	LoginPage lp;
	LaunchingBrowser lb;
    Configurations cr;
    HomePage hp;
    FlightBookingPage fb;
    
    @Test
    public void initializeHomePage() throws IOException, InterruptedException
    {
    	//Navigating to Home Page
    	lb= new LaunchingBrowser();
    	hp= new HomePage(lb.browserSelection());
    }
    
    @Test(dependsOnMethods="initializeHomePage")
	public void loggingInUserWithValidData() throws InterruptedException, IOException
	{
    	//Login Process
		lp=new LoginPage(hp.getHomePageDriver());
		lp.LoggingInUser();
		lp.verifyLoginOnValidData();
	}
	
    @Test
    public void loggingInUserWithInvalidData() throws IOException, InterruptedException
    {
    	lp=new LoginPage(hp.getHomePageDriver());
		lp.LoggingInUser();
		lp.verifyLoginOnInvalidData();
    }
	@Test(dependsOnMethods="loggingInUser", enabled=false)
	  public void xflightBooking() throws InterruptedException, IOException {
	  //Navigating to Flight Booking on successful login
	  fb=new FlightBookingPage(lp.getLoginPageDriver()); 
	  fb.journeyDetails(); 
	  fb.journeyDetailsVerification();
	  fb.flightConfirmation();
	  fb.fillingPassengerDetails();
	  fb.confirmPaymentMethod();
	  fb.bookingConfirmation();
	  fb.closingBrowser();
	}
}

