package SeleniumFrameworkDesign.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	
	WebDriver driver ;
	
	public CheckoutPage (WebDriver driver) {
		
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder= 'Select Country']")
	WebElement country;
	
	
	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button[2]")
	WebElement India;
	
	By dropDown = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	public void selectCountry(String countryName) throws InterruptedException{
		Actions a = new Actions(driver);
		a.sendKeys(country , countryName).build().perform();
		Thread.sleep(2000);
		//waitForElementToDisclose(dropDown);
		India.sendKeys(Keys.ENTER);
	}
	
	
	}












