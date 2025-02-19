package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	// Constructor
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Page Factory

	@FindBy(xpath = "(//div[@class='subtotal cf ng-star-inserted'])/ul/li[3]/button")
	WebElement checkOutEle;

	@FindBy(xpath = "(//div[@class='cartSection'])/h3")
	private List<WebElement> cartProducts;

	public Boolean getProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckoutPage goToCheckOut() {
		checkOutEle.click();

		return new CheckoutPage(driver);
	}

}
