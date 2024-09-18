package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartHeader;
	
	@FindBy (xpath = "//div[@class='cartSection removeWrap']/button[1]")
    WebElement buyNow;
	
	/*@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']/i")
	WebElement submit;*/

	public void waitForElementToAppear(By findBy) {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	}
	
	public void waitForElementToDisappear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}
	
	/*public void waitForElementToDisclose(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
	wait.until(ExpectedConditions.invisibilityOf
			(driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']"))));
	}*/

	public void goToCartPage() {
		cartHeader.click();
	}
	public void buyNowThisProduct() {
		buyNow.click();
	}
	
	public void submitOrder() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Place Order']")));
	
 }
	
	

}	
	
	
	
	
	
	
	
	
	
	
	
	
	