import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Durvesh");
		driver.findElement(By.name("inputPassword")).sendKeys("dnp123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.className("error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Durvesh");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3) ")).sendKeys("Abc@gamil.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1234567890");
//		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		driver.findElement(By.className("reset-pwd-btn")).click();
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Durvesh");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//form/button")).click();
		
		
		
		//Intructors Code For Refference
		/*
		 * public class Locators {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait - 2 seconds time out

System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

driver.get("https://rahulshettyacademy.com/locatorspractice/");

driver.findElement(By.id("inputUsername")).sendKeys("rahul");

driver.findElement(By.name("inputPassword")).sendKeys("hello123");

driver.findElement(By.className("signInBtn")).click();

System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

driver.findElement(By.linkText("Forgot your password?")).click();

Thread.sleep(1000);//

driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

System.out.println(driver.findElement(By.cssSelector("form p")).getText());

driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

Thread.sleep(1000);

driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

driver.findElement(By.id("chkboxOne")).click();

driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

}



}
		 */
		
		
//		driver.close();
	}

}
