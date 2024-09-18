package SeleniumFrameworkDesign.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class loginError extends AbstractComponent {

	WebDriver driver;
	public loginError(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
		@FindBy (id = "userEmail")
		WebElement userLogin;
		
		@FindBy (id = "userPassword")
		WebElement userPassword;
		
		@FindBy (id = "login")
		WebElement submitting;
		
		@FindBy (xpath = "//div[@role='alertdialog']")
		WebElement errorValidation;
	

		public void negativeLogin(String email, String password) {
			userLogin.sendKeys("aditya84051@gmail.com");
			userPassword.sendKeys("Okay@goog");
			submitting.click();
		}
		public void errorMessage() {
			
			errorValidation.getText();
			
		}
}		
