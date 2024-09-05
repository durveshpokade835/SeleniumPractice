import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Bits New Trainning Automation\\Drivers/chromedriver.exe");

		// SSL check and Chrome Options features
		ChromeOptions options = new ChromeOptions();

		// Accept insecure certificates
		options.setAcceptInsecureCerts(true);

		// FirefoxOptions options1 = new FirefoxOptions();
		// options1.setAcceptInsecureCerts(true);

		// EdgeOptions options2 = new EdgeOptions();
		// options1.setAcceptInsecureCerts(true);

		// Set Up proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);

		// to change the download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

		// Initialize the ChromeDriver with the options
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
