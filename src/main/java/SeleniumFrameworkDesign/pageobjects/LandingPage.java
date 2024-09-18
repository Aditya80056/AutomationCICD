	package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//pagefactory
	
	//Annotation --> (@FindBy)
	@FindBy (id = "userEmail")
	WebElement userEmail;
	
	@FindBy (id = "userPassword")
	WebElement passWord;
	
	@FindBy (id = "login")
	WebElement submit;
	
	public void loginApplication (String email, String password)
	{
		userEmail.sendKeys("aditya84051@gmail.com");
		passWord.sendKeys("Okay@google1");
		submit.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	

}
