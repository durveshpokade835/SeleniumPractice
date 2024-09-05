import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String date = "15";
		String month = "6";
		String year = "2024";
		String[] expectedDate = {month,date,year};
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.xpath("//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']")).click();
		driver.findElement(By.xpath("//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		List <WebElement> actualDate = driver.findElements(By.xpath("//input[@autocomplete='off']"));
		
		for (int i=0; i<3 ;i++) {
		
		System.out.println(actualDate.get(i).getAttribute("value"));
		Assert.assertEquals(actualDate.get(i).getAttribute("value"), expectedDate[i]);
		
				
		}
		
		
		
		
		
		
		
		
	}
	
}
