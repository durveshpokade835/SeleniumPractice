import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Section12Scroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List <WebElement> values = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		int sum =0;
		
		for(int i=0; i<values.size();i++) {
		
		sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		
	int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ")[3].trim());
	Assert.assertEquals(sum, total);
		
		}
		
		
	}


