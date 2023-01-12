package utilities;

import org.testng.annotations.DataProvider;

public class RegistrationsDataProvider {
	@DataProvider
	 public Object[][] registrationData()
	 {
		 Object[][] data= new Object[2][5];
		 //First User Registration
		 data[0][0]="Priyanka";
		 data[0][1]="Naarlapuram";
		 data[0][2]="9382342323";
		 data[0][3]="priya62131@gmail.com";
		 data[0][4]="Priyanka@123";
		 
		 //Second User Registration
		 data[1][0]="test";
		 data[1][1]="case";
		 data[1][2]="9312342323";
		 data[1][3]="priya2121@gmail.com";
		 data[1][4]="Priyanka@123";
		 
		return data;		 
	 }
}
