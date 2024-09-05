package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	
	@BeforeClass
	public void BefoClass() {
		System.out.println("Before executing any methods in the class ");
	}
	
	@Parameters({"URL", "APIKey/usrname"})
	@Test
	public void WebLoginCarLoan(String urlName, String key) {
		//
		System.out.println("WebLoginCar");
		System.out.println(urlName);
		System.out.println(key);
	}
	@BeforeMethod
	public void beforeEvery() {
		System.out.println("I will execute before every method in day 3 class");
	}
	@AfterMethod
	public void afterEvery() {
		System.out.println("I will execute after every mathod in day 3 class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Executing all methods in the class i will execute");
	}
	
	@Test(groups= {"Smoke"})
	public void MobileLoginCarLoan() {
		//Appium
		System.out.println("Mobile Login Car Loan");
	}
	
	@BeforeSuite
	public void BfSuite() {
		System.out.println("I am no. 1");
	}
	
	@Test(enabled = false)
	public void MobileSignInCarLoan() {
		System.out.println("Mobile Sign In");
	}
	
	@Test(dataProvider="getData")
	public void MobileSignOutCarLoan(String username, String password) {
		System.out.println("Mobile Sign Out"); 
		System.out.println(username);
		System.out.println(password);
	}
	@Test(dependsOnMethods= {"WebLoginCarLoan","MobileSignOutCarLoan"})
public void APICarLoan() {
		System.out.println("APILoginCar");
	}
	
	@DataProvider
	public Object[][] getData(){
		//1st combination - username password - good credit history
		//2nd combination - username password - no credit history
		//3rd combination - username password - fradulent credit history
		
		Object[][] data = new Object[3][2];
		//1st Set
		data[0][0]  = "FirstSetUsername";
		data[0][1]  = "FirstPassword";
		
		//columns in the row are nothing but values for that particular combination(row)
		
		//2nd Set
		data[1][0]  = "SecondSetUsername";
		data[1][1]  = "SecondPassword";
		
		//3rd Set
		data[2][0]  = "ThirdSetUsername";
		data[2][1]  = "ThirdPassword";
		
		return data;
	}
	
	
	
	
	
	
}
