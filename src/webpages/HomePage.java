package webpages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utilities.Configurations;
public class HomePage {
	WebDriver driver;
	Configurations cr;
	public HomePage(WebDriver driver) throws IOException, InterruptedException
	{
		this.driver=driver;
		cr=new Configurations();
		
		//navigating to Home Page
		driver.get(cr.get_URL());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Opened Home Page");
		Reporter.log("Opened Home Page");
		
		//screenshot of homepage
		cr.takeScreenShot("HomePage", driver);
	}
	
	public WebDriver getHomePageDriver()
	{
		return driver;
	}
}

