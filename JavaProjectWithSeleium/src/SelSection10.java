import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class SelSection10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator <String> it= windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
//		System.out.println(driver.findElement(By.xpath("//a[@href='mailto:mentor@rahulshettyacademy.com']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		
		String emailId = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		
		
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		WebElement checkActions = driver.findElement(By.id("nav-link-accountList"));
		a.moveToElement(checkActions).build().perform();
		WebElement checkSearch = driver.findElement(By.id("twotabsearchtextbox"));
		
		a.moveToElement(checkSearch).click().keyDown(Keys.SHIFT).sendKeys("hello");
		WebElement prime = driver.findElement(By.id("nav-link-amazonprime"));
		a.moveToElement(prime).contextClick().build().perform();
	
		
	}

}
