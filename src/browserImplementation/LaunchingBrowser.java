package browserImplementation;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Configurations;

public class LaunchingBrowser {
	WebDriver driver;
	Configurations cr;
	
	public WebDriver browserChrome() throws IOException
	{
		//configurations for chrome browser
	 cr=new Configurations();
	 System.setProperty(cr.get_ChromeKey(),cr.get_ChromePath());
	 driver= new ChromeDriver();
	 return driver;
	}
	public WebDriver browserFirefox() throws IOException
	{
		//configurations for firefox browser
	 cr=new Configurations();
	 System.setProperty(cr.get_FirefoxKey(),cr.get_FirefoxPath());
	 driver= new FirefoxDriver();
	 return driver;
	}
	public WebDriver browserSelection() throws IOException 
	{
		//Selecting the browser through user input
		cr=new Configurations();
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose the browser you want to select");
		System.out.println("Enter 1 for Chrome");
		System.out.println("Enter 2 for Firefox");
		int browserSelect=sc.nextInt();
		if(browserSelect==1)
		{
			driver=browserChrome();
		}
		else if(browserSelect==2)
		{
			driver=browserFirefox();
		}
	 //maximizing the screen 
	 driver.manage().window().maximize();
	 sc.close();
	 return driver;
	 
	}
	
}

