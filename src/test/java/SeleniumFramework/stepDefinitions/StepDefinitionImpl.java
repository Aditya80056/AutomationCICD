package SeleniumFramework.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import SeleniumFrameworkDesign.MyProject.TestComponents.BaseTest;
import SeleniumFrameworkDesign.pageobjects.LandingPage;
import SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import SeleniumFrameworkDesign.tests.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	String countryName = "india";
	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
	landingpage = launchApplication();
}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	
	public void logged_in_username_and_password(String username, String password) {
		
		landingPage.loginApplication(username,password);
	}
	@When("^I add product(.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addProductToCart(productName);
	}
	@When ("^checkout <productname> and submit the order$")
	public void checkout_submit_order() throws InterruptedException {
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		productCatalogue.goToCartPage();
		productCatalogue.buyNowThisProduct();
		checkoutpage.selectCountry(countryName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		checkoutpage.submitOrder();
	}
}




