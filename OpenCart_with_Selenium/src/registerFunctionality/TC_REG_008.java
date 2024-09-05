package registerFunctionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_REG_008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test case description...
    	/*
         * Test case ID- TC_REG_008 test case scenario - (TS_UI_002) Register Functionality
         * Validate the registration of an account by providing all the required fields.
         */
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 
        
        //Accessing The local host website
        driver.get("http://localhost/opencart/upload/");
        //Go to Register Page
        driver.findElement(By.xpath("(//span[@class='d-none d-md-inline'])[3]")).click();
		driver.findElement(By.xpath("//a[@href='http://localhost/opencart/upload/index.php?route=account/register&language=en-gb']")).click();
		//comment out the above code if you want to use the global site
		
	       // Access The Website
//      driver.get("https://demo.opencart.com/en-gb?route=account/register");
        
        // Fill out the registration form
        driver.findElement(By.id("input-firstname")).sendKeys("abc");
        driver.findElement(By.id("input-lastname")).sendKeys("xyz");
        driver.findElement(By.id("input-email")).sendKeys("abc.xyz@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Abc@123");
        
     // Scroll to the subscribe checkbox using JavaScript
        WebElement subscribe = driver.findElement(By.id("input-newsletter"));
        js.executeScript("arguments[0].scrollIntoView(true);", subscribe);
        
        // Wait until the subscribe is clickable
        wait.until(ExpectedConditions.elementToBeClickable(subscribe));

        try {
            // Try clicking the checkbox
        	subscribe.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // If click is intercepted, click using JavaScript
            js.executeScript("arguments[0].click();", subscribe);
        }
        
        // Scroll to the agreement checkbox using JavaScript
        WebElement agreeCheckbox = driver.findElement(By.cssSelector("input[name='agree']"));
        js.executeScript("arguments[0].scrollIntoView(true);", agreeCheckbox);
        
        
        // Wait until the checkbox is clickable
        wait.until(ExpectedConditions.elementToBeClickable(agreeCheckbox));

        try {
            // Try clicking the checkbox
            agreeCheckbox.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // If click is intercepted, click using JavaScript
            js.executeScript("arguments[0].click();", agreeCheckbox);
        }

        // Scroll to the submit button and click
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        // Clean up and close the browser
        driver.quit();
		
	}

}
