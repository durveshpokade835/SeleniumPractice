package registerFunctionality;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_REG_009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test case description...
		/*
		 * Test case ID- TC_REG_009 test case scenario - (TS_UI_003) Register Functionality
		 * Validate that proper notification messages are displayed for the mandatory fields when no information is provided on the 'Register Account' page and the form is submitted..
		 */
		
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

 
        
        //Accessing The local host website
        driver.get("http://localhost/opencart/upload/");
        //Go to Register Page
        driver.findElement(By.xpath("(//span[@class='d-none d-md-inline'])[3]")).click();
		driver.findElement(By.xpath("//a[@href='http://localhost/opencart/upload/index.php?route=account/register&language=en-gb']")).click();
		//comment out the above code if you want to use the global site
		
		// Access The Website
//      driver.get("https://demo.opencart.com/en-gb?route=account/register");
		
		// Scroll to the submit button and click
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        js.executeScript("arguments[0].click();", submitButton);
		
        
//        .alert.alert-danger.alert-dismissible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("dirv")));
        String alertMsg= driver.findElement(By.tagName("dirv")).getText();
        System.out.println(alertMsg);
        String expAlertMsg= "Warning: You must agree to the Privacy Policy!";
        
		//List of Locators and expected error messages
        List<String[]> listOfErrors = new ArrayList<>();
        listOfErrors.add(new String[]{"error-firstname","First Name must be between 1 and 32 characters!"});
        listOfErrors.add(new String[]{"error-lastname","Last Name must be between 1 and 32 characters!"});
        listOfErrors.add(new String[]{"error-email","E-Mail Address does not appear to be valid!"});
        listOfErrors.add(new String[]{"error-password","Password must be between 6 and 20 characters!"});
		
        //Scroll to the Login Container div
        WebElement loginContainer = driver.findElement(By.id("account"));
        js.executeScript("arguments[0].scrollIntoView(true);", loginContainer);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account")));
        
        //Initialise SoftAssert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alertMsg, expAlertMsg, "Test Case Failed for : Terms And Condition Alert box");
        
        //Interate through the list and validate the error messages using Soft Assert
        
        for(int i=0; i<listOfErrors.size();i++) {
        String[] errorData = listOfErrors.get(i);
        String locator = errorData[0];
        String expMsg = errorData[1];
        
        WebElement errorEle = driver.findElement(By.id(locator));
        String actMsg= errorEle.getText();
        System.out.println(actMsg);
        
        softAssert.assertEquals(actMsg, expMsg, "Test Case Failed for :" +locator);
        
        }
        softAssert.assertAll();
        
        driver.quit();
	}

}
