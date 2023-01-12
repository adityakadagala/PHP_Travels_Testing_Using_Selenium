package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;


//Reading data from object repository
//write comments for each method
public class Configurations {
	Properties pro;
    public Configurations() throws IOException {
        File file = new File("/home/ubuntu/Desktop/Training/PHPTravels_Testing_Using_Selenium/ObjectsRepository/Objects.properties");
        FileReader fr = new FileReader(file);
        pro = new Properties();
        pro.load(fr);
    }
    public String get_ChromeKey() {
    	//This method returns the key for edge driver
        return pro.getProperty("ChromeKey");
    }
    public String get_ChromePath() {
    	//This method returns the path of the edge driver
        return pro.getProperty("ChromePath");
    }
    
    public String get_FirefoxKey()
    {
    	//This method returns the key of the Firefox driver
    	return pro.getProperty("FirefoxKey");
    }
    
    public String  get_FirefoxPath()
    {
    	//This method returns the path of the firefox driver
    	return pro.getProperty("FirefoxPath");
    }
    public String get_URL() {
    	//This method returns the base URL
        return pro.getProperty("BaseURI");
    }
    public String get_user() {
    	//This method returns the username
        return pro.getProperty("username");
    }
    public String get_password() {
    	//This method returns
        return pro.getProperty("password");
    }
    
    public String get_excelpath()
    {
    	//This method returns excelpath
    	return pro.getProperty("excelpath");
    }
    
	
	 public void takeScreenShot(String fileName, WebDriver driver) throws IOException 
	 {
		 File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file, new File("/home/ubuntu/Desktop/Training/PHPTravels_Testing_Using_Selenium/screenshots/"+fileName+"_"+timeStamp()+".png")); 
	 }
	 
	 public String timeStamp()
	 {
		 return new SimpleDateFormat("yyyy-MM-DD-HH-mm-ss").format(new Date());
	 }

}
