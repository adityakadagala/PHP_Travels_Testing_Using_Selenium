package testcase_suite;

import java.io.IOException;


import org.testng.annotations.Test;
import browserImplementation.LaunchingBrowser;
import utilities.Configurations;
import utilities.RegistrationsDataProvider;
import webpages.HomePage;
import webpages.RegistrationPage;

public class UserRegistrationVerification {
	LaunchingBrowser lb;
    Configurations cr;
    HomePage hp;
    RegistrationPage rp;
    
    @Test
    public void initializeHomePage() throws IOException, InterruptedException
    {
    	//instantiating home page
    	lb= new LaunchingBrowser();
    	hp= new HomePage(lb.browserSelection());
    }
   
    @Test(dependsOnMethods="initializeHomePage")
    public void navigateToRegistrationPage() throws InterruptedException, IOException
    {
    	//instantiating registration page
    	rp= new RegistrationPage(hp.getHomePageDriver());
    }
    
    @Test(dependsOnMethods="navigateToRegistrationPage", dataProvider="registrationData" , dataProviderClass=RegistrationsDataProvider.class, enabled=false )
    public void registeringUserwithDataProvider(String fname, String lname, String phno, String email, String password) throws InterruptedException, IOException
    {
  
    	//Registering user using Data Provider
    	rp.registeringUserUsingDataProvider(fname, lname, phno, email, password);
    	
    	//method call to close browser
    	rp.closingBrowser();
    	
    }
    
    @Test(dependsOnMethods="navigateToRegistrationPage", enabled=true)
    public void registeringUser() throws InterruptedException, IOException
    {
    	//Registering user using Excel Sheet
    	rp.registeringUserWithValidExcelData();
    	
    	//method call to verify user registration
    	rp.verifyingUserRegistration();
    	
    	//method call to close browser
    	rp.closingBrowser();
    	
    }
	
}
