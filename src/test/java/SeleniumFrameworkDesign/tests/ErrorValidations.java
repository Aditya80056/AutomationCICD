package SeleniumFrameworkDesign.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import SeleniumFrameworkDesign.MyProject.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	
		// TODO Auto-generated method stub
		
		@Test
		public void appLoginTest() throws IOException, InterruptedException 
		{
		
		landingPage.goTo();
		loginError loginerror = new loginError(driver);
		loginerror.negativeLogin("userLogin", "userPassword");
		loginerror.errorMessage();
		
	}

}



















