package webpages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import utilities.Configurations;
import utilities.ExcelConfigurations;

public class RegistrationPage {
	Configurations cr;
	WebDriver driver;
	ExcelConfigurations ecr;
	
	//Registration Page selectors
	By account= By.id("ACCOUNT");
	By signup= By.linkText("Customer Signup");
	By firstName = By.name("first_name");
	By lastName =By.name("last_name");
	By phone = By.name("phone");
	By email = By.name("email");
	By password = By.name("password");
	By submit= By.id("button");
	By signinMessage= By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/div");
	
	
	public RegistrationPage(WebDriver driver) throws InterruptedException
	{
		//Navigating to registration page
		this.driver=driver;
		driver.findElement(account).click();   
        driver.findElement(signup).click();
        System.out.println("Opened Registration Page");
        Reporter.log("Opened_Registration_Page");
	}
	
	public WebDriver getRegistrationPageDriver() {
		return driver;
	}
	
	
	public void registeringUserWithValidExcelData() throws InterruptedException, IOException
    {
    	//using excel sheet to read data to proceed with registration
		ecr=new ExcelConfigurations();
    	driver.findElement(firstName).sendKeys(ecr.getData(0, 0, 0));
       
        driver.findElement(lastName).sendKeys(ecr.getData(0, 0, 1));
        
        driver.findElement(phone).sendKeys(ecr.getData(0, 4, 0));
        
        driver.findElement(email).sendKeys(ecr.getData(0, 2, 0));
                
        driver.findElement(password).sendKeys(ecr.getData(0, 3, 0));
        
        Select accounttype=new Select(driver.findElement(By.xpath("//*[@id=\"account_type\"]")));
       accounttype.selectByVisibleText("Customer");
        Thread.sleep(150000);
        
        driver.findElement(submit).click();
    }
	
	public void registeringUserUsingDataProvider(String fname, String lname, String phno, String emailid, String pass) throws InterruptedException
	{
		driver.findElement(firstName).sendKeys(fname);
	       
        driver.findElement(lastName).sendKeys(lname);
        
        driver.findElement(phone).sendKeys(phno);
        
        driver.findElement(email).sendKeys(emailid);
                
        driver.findElement(password).sendKeys(pass);
        
        Select accounttype=new Select(driver.findElement(By.xpath("//*[@id=\"account_type\"]")));
       accounttype.selectByVisibleText("Customer");
        Thread.sleep(50000);
        
        driver.findElement(submit).click();
        
        if(driver.findElement(signinMessage).isDisplayed()==true)
		{
			//On successful sign up			
			String signupstatus= driver.findElement(signinMessage).getText();
			Assert.assertEquals(signupstatus, "Signup successfull please login.");
			System.out.println(signupstatus);		
			Reporter.log(signupstatus+" (Successfully registered)");
		}
        
        //navigating back to signup page
        driver.findElement(account).click();   
        driver.findElement(signup).click();
	}
	
	public void verifyingUserRegistration() throws IOException, InterruptedException 
	{
		//verifying user registration
		cr=new Configurations();
		Thread.sleep(2000);
		if(driver.findElement(signinMessage).isDisplayed()==true)
		{
			//On successful sign up			
			String signupstatus= driver.findElement(signinMessage).getText();
			Assert.assertEquals(signupstatus, "Signup successfull please login.");
			System.out.println(signupstatus);		
			Reporter.log(signupstatus+" (Successfully registered)");
			cr.takeScreenShot("RegistrationPageVerification", driver);
		}
		else
		{
			//On failed registration
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			cr.takeScreenShot("RegistrationPageVerification", driver);
			System.out.println("Please fill out all fields");
			Reporter.log("Incomplete_details");
		}
	}
	
	public void closingBrowser() throws InterruptedException
	{
		//closing browser
		Thread.sleep(1500);
		driver.quit();
	}

}
