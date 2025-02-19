package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	// constructor
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// pageFactory

//	@FindBy(xpath = "input[placeholder='Select Country']")
//	WebElement country;
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "(//section[@class='ta-results list-group ng-star-inserted'])/button[2]")
	WebElement selectCountry;
	@FindBy(css = "a[class='btnn action__submit ng-star-inserted']")
	WebElement submit;

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.xpath("//section[@class='ta-results list-group ng-star-inserted']"));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}

}
