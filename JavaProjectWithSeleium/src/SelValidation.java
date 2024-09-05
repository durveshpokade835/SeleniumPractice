import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class SelValidation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//I'm getting some errors
		//For Chrome Browser
//		System.setProperty("webdriver.chrome.driver","D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//For Edge Browser
		System.setProperty("webdriver.edge.driver", "D:\\Bits New Trainning Automation\\Drivers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		String name="Durvesh";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("submit")).click();
		Thread.sleep(2000);
//		System.out.println(driver.findElements(By.tagName("h2")).getText());
//		Assert.assertEquals(driver.findElements(By.tagName("h2")).getText(), "Hello "+name+",");
//		Assert.assertEquals(driver.findElements(By.tagName("p")).getText(), "You are successfully logged in.");
		
		
//		WebElement h2Element = driver.findElement(By.tagName("h2"));
//		String h2Text = h2Element.getText();
//		System.out.println("Text of the first <h2> element: " + h2Text);
//		Assert.assertEquals(h2Text, "Hello "+name+",");
//		WebElement pElement = driver.findElement(By.tagName("p"));
//		String pText = pElement.getText();
//		Assert.assertEquals(pText, "You are successfully logged in.", "Matched");j
		
		System.out.println(driver.findElement(By.tagName("p")).getText());

		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");

		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
//		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{

	driver.get("https://rahulshettyacademy.com/locatorspractice/");

	driver.findElement(By.linkText("Forgot your password?")).click();

	Thread.sleep(1000);

	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

	String passwordText =driver.findElement(By.cssSelector("form p")).getText();

	//Please use temporary password 'rahulshettyacademy' to Login.

	String[] passwordArray = passwordText.split("'");

	// String[] passwordArray2 = passwordArray[1].split("'");

	// passwordArray2[0]

	String password = passwordArray[1].split("'")[0];

	return password;

	//0th index - Please use temporary password

	//1st index - rahulshettyacademy' to Login.



	//0th index - rahulshettyacademy

	//1st index - to Login.
	}

}
