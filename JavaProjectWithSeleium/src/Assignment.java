import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("Webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver");
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://rahulshettyacademy.com/angularpractice/");
 driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Durvesh");
 Thread.sleep(2000);
 driver.findElement(By.name("email")).sendKeys("durvesh@gmail.com");
 Thread.sleep(2000);

 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("dnp123");
 Thread.sleep(2000);

 driver.findElement(By.id("exampleCheck1")).click();
 Thread.sleep(2000);


 WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
 
 Select dropdown = new Select(staticDropdown);
 dropdown.selectByIndex(0);

 driver.findElement(By.id("inlineRadio1")).click();
 Thread.sleep(1000);
driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("05082000");
Thread.sleep(1000);

driver.findElement(By.xpath("//input[@value='Submit']")).click();
Thread.sleep(1000);

String cnfmsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
System.out.println(cnfmsg);

driver.quit();




/////////////////////////////////
/*Editors CODE
 * import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Assignment {
public static void main(String[] args) {
// TODO Auto-generated method stub
 * 
System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

WebDriver driver=new ChromeDriver();

driver.get("https://rahulshettyacademy.com/angularpractice/");

driver.findElement(By.name("name")).sendKeys("rahul");

driver.findElement(By.name("email")).sendKeys("hello@abc.com");

driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");

driver.findElement(By.id("exampleCheck1")).click();

WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

Select abc = new Select(dropdown);

abc.selectByVisibleText("Female");

driver.findElement(By.id("inlineRadio1")).click();

driver.findElement(By.name("bday")).sendKeys("02/02/1992");

driver.findElement(By.cssSelector(".btn-success")).click();

System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());



}







}
 * 
 */
	}

}
