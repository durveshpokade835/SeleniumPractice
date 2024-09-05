import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingUsingSelenium {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		
		//Capture all the WebElements into list
		List<WebElement> li = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		//capture text of all WebElements into new original list
		List<String> originalList= li.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		//sort on the original list of step 3 -> sorted list
		List<String> sortedList =originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original list with sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		//scan the name column with getText ->Beans -> print the price of the rice
//		List<String> price= li.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		List<String> price;
		
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
		
	}
	

	private static String getPriceVeggie(WebElement a) {
		// TODO Auto-generated method stub
		String price = a.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
