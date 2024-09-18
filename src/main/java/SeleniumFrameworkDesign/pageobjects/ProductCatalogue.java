package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".card-body button:last-of-type")
	WebElement addToCart;
	
	By productsBy = By.cssSelector(".mb-3");
	//By addToCart = By.cssSelector("");
	By toastMessage = By.cssSelector("#toast-conatiner");
	By notAppear = By.cssSelector(".ng-animating");
	
	/*public List<WebElement> getProductsList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}*/
	
	
	public void addProductToCart(String productName)
	{
		addToCart.click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(notAppear);
	}
	
	/*public WebElement getProductByName(String productName) {
		WebElement prod = getProductsList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("productName")).findFirst().orElse(null);
		return prod;
	}*/
	

}
