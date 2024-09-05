package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	//constructor
	public ProductCatalogue(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory-----------------------------------------
	
	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> products;
	
	@FindBy (tagName="ngx-spinner")
	WebElement spinner;
	
	
	
	//By Selectors------------------------------------------------
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.xpath("button[2]");
	By toastMessage = By.id("toast-container");
	
	
	//Functions ---------------------------------------------
	
	//function to get the product List
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	//Function to get the specific product by name
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod =getProductList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
		
	}
	
	//Funtion to add the product in the cart
	
	public void addProductToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		
	}
	
	
	
	
	
}
