package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	@Test(description = "Login by valid credentials",priority = 1)
	
	public void verifyLoginByValidCredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.signInClick();
		
		
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"Login not successful with valid credentials");
	}
	
@Test(description = "To test login using invalid password",priority = 2)
	
	public void verifyLoginByInvalidPassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.signInClick();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"Login not successful with invalid credentials");
	}

@Test(description = "To test login by invalid username",priority = 3)

public void verifyLoginByInValidUsername() throws IOException {
	String usernameValue=ExcelUtility.getStringData(3, 0, "LoginPage");
	String passwordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernameValue);
	login.enterPassword(passwordValue);
	login.signInClick();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected,"Login not successful with invalid credentials");
	
}

@Test(description = "To verify login by Invalid credentials",priority = 4)

public void verifyLoginByInValidCredentials() throws IOException {
	String usernameValue=ExcelUtility.getStringData(4, 0, "LoginPage");
	String passwordValue=ExcelUtility.getStringData(4, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernameValue);
	login.enterPassword(passwordValue);
	login.signInClick();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected,"Login not successful with invalid credentials");
	
}


}
