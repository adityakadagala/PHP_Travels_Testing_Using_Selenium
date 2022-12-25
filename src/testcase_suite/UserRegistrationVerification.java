package testcase_suite;

import java.io.IOException;
import org.testng.annotations.Test;
import browserImplementation.LaunchingBrowser;
import utilities.Configurations;
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
    
    @Test(dependsOnMethods="navigateToRegistrationPage")
    public void registeringUser() throws InterruptedException, IOException
    {
    	//Registering user 
    	rp.registeringUserWithValidData();
    	
    	//method call to verify user registration
    	rp.verifyingUserRegistration();
    	
    	//method call to close browser
    	rp.closingBrowser();
    	
    }
	
}
