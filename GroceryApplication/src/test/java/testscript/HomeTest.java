package testscript;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	
	@Test(description = "To check logout functionality from Home page",priority = 1)
	
	public void VerifyLogout() throws IOException {
		
			String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
			LoginPage login = new LoginPage(driver);
			login.enterUserName(usernameValue);
			login.enterPassword(passwordValue);
			login.signInClick();
			HomePage home = new HomePage(driver);
			home.adminClick();
			home.logOut();
			
			
			String expected ="https://groceryapp.uniqassosiates.com/admin/login";
			String actual = driver.getCurrentUrl();
			Assert.assertEquals(actual, expected, "Logout not successful");

			
		
		
		
	}

}
