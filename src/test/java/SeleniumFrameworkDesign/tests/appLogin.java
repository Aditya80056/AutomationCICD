package SeleniumFrameworkDesign.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SeleniumFrameworkDesign.MyProject.TestComponents.BaseTest;
import SeleniumFrameworkDesign.pageobjects.ProductCatalogue;


public class appLogin extends BaseTest {

		// TODO Auto-generated method stub
		
		@Test(dataProvider="getData", groups = {"Purchase"})
		public void appLoginTest(HashMap <String,String> input) throws IOException, InterruptedException 
		{
		String productName = "ZARA COAT 3";
		String countryName = "india";
		
		landingPage.loginApplication(input.get("email"), input.get("password")); 
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		productCatalogue.addProductToCart(productName);
		productCatalogue.goToCartPage();
		productCatalogue.buyNowThisProduct();
		checkoutpage.selectCountry(countryName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		checkoutpage.submitOrder();
	}

		
		@DataProvider
		public Object[][] getData() throws IOException
		{
			
			List<HashMap<String, String>> data = getJsonDataToMap
					(System.getProperty("user.dir")+"//src//test//java//SeleniumFramework//data//PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
		}
}

/*HashMap<String,String> map = new HashMap<String, String>();
			map.put("email", "userEmail");
			map.put("password", "passWord");
			
			HashMap<String,String> map1 = new HashMap<String, String>();
			map1.put("Email", "userLogin");
			map1.put("Password", "userPassword");  */
			


















