import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpagepractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\Bits New Trainning Automation\\\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div[@class='form-check-inline']//label[2]//span[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();

		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(2);
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-info']")));
//		Thread.sleep(5000);
		List<WebElement> WebElement = driver.findElements(By.xpath("//div[@class='card-footer']"));
		for(int i=0;i<WebElement.size();i++) {
		
			WebElement.get(i).click();
			
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Checkout']")));
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		
		
	
		
		
		
		
		}

}
