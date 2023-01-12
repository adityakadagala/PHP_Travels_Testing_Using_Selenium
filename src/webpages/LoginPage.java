package webpages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import utilities.Configurations;

public class LoginPage {
	Configurations cr = new Configurations();
	String username, password;
	WebDriver driver;
	By account = By.id("ACCOUNT");
	By login= By.linkText("Customer Login");
	By email=By.name("email");
	By pass=By.name("password");
	By submit = By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button");
	By failedlogin= By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/div");
	
	//Instantiating Login page
	public LoginPage(WebDriver driver) throws IOException, InterruptedException
	{
		this.driver=driver;
		username=cr.get_user();
		password= cr.get_password();
		
		//Navigating to Login page
		driver.findElement(account).click(); 
        driver.findElement(login).click();
        
        //Waiting for the element to get loaded
        WebDriverWait wait=new WebDriverWait(driver, 10);		
		WebElement login= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[1]/div/h5")));
		
		//Logging status on opening Login page
		System.out.println("Opened Login Page"+login.getText());
        Reporter.log("Opened Login page");
		//capturing screenshot of login page navigation
        cr.takeScreenShot("LoginPage", driver);
        
	}
	public WebDriver getLoginPageDriver() {
		//returning login page driver
		return driver;
	}
	
	public void LoggingInUser() throws IOException
	{
		//Logging user into the website
		driver.findElement(email).sendKeys(username);
		System.out.println(username+" "+password);
		driver.findElement(pass).sendKeys(password);
		cr.takeScreenShot("logindetailsfilled", driver);
		driver.findElement(submit).click();		
	}
	
	public void verifyLoginOnValidData() throws IOException, InterruptedException
	{
		//verifying user login
		Thread.sleep(2000);
			//On successful Login
			//screenshot showing login status
			cr.takeScreenShot("LoginStatus", driver);
			
			String username=driver.findElement(By.xpath("//*[@id='fadein']/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2/span")).getText();
			Assert.assertEquals(username, "Priyanka");
			System.out.println("Login Successful "+username);
			Reporter.log("Login Successful"+username);
	
	}
	
	public void verifyLoginOnInvalidData() throws IOException
	{
		if(driver.findElement(By.xpath(
				  "//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/div")).isDisplayed()==true)
				  { //On Login failure //screenshot showing login status
				  cr.takeScreenShot("LoginStatus", driver);
				  
				  String failedlogin=driver.findElement(By.xpath(
				  "//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/div")).getText();
				  Assert.assertEquals(failedlogin, "Wrong credentials. try again!");
				  System.out.println(failedlogin); Reporter.log(failedlogin); driver.quit(); }
				 
	}
	
	public void verifyLogin() throws IOException, InterruptedException
	{
		//verifying user login
		Thread.sleep(2000);
			//On successful Login
			//screenshot showing login status
			cr.takeScreenShot("LoginStatus", driver);
			
			String username=driver.findElement(By.xpath("//*[@id='fadein']/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2/span")).getText();
			Assert.assertEquals(username, "Priyanka");
			System.out.println("Login Successful "+username);
			Reporter.log("Login Successful"+username);
		
			
			  if(driver.findElement(By.xpath(
			  "//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/div")).isDisplayed()==true)
			  { //On Login failure //screenshot showing login status
			  cr.takeScreenShot("LoginStatus", driver);
			  
			  String failedlogin=driver.findElement(By.xpath(
			  "//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/div")).getText();
			  Assert.assertEquals(failedlogin, "Wrong credentials. try again!");
			  System.out.println(failedlogin); Reporter.log(failedlogin); driver.quit(); }
			 
	}
}
