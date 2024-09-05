import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//footer links
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//footer-> 1st column links count
		
		WebElement subFooterDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(subFooterDriver.findElements(By.tagName("a")).size());
		
		for (int i=1; i< subFooterDriver.findElements(By.tagName("a")).size();i++) {
			
			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			subFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
			Thread.sleep(5000L);
			
		}
		
		Set<String> abc= driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		 
		
		
	}

}
