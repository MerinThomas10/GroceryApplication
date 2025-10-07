package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	HomePage home;
	@Test(description = "Login by valid credentials",priority = 1, retryAnalyzer = retry.Retry.class,groups = {"smoke"})
	
	public void verifyLoginByValidCredentials() throws IOException {
		
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		System.out.println(driver.getCurrentUrl());
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		//login.enterPassword(passwordValue);
		home = login.signInClick();
		
		
		
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.VALID_LOGIN_ASSERT);
	}
	
@Test(description = "To test login using invalid password",priority = 2)
	
	public void verifyLoginByInvalidPassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue).enterPassword(passwordValue).signInClick();
		//login.enterPassword(passwordValue);
		//login.signInClick();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.INVALID_ASSERT_MSG);
	}

@Test(description = "To test login by invalid username",priority = 3)

public void verifyLoginByInValidUsername() throws IOException {
	String usernameValue=ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
	String passwordValue=ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernameValue).enterPassword(passwordValue).signInClick();
	//login.enterPassword(passwordValue);
	//login.signInClick();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected,Messages.INVALID_ASSERT_MSG);
	
}

@Test(description = "To verify login by Invalid credentials",priority = 4, dataProvider = "loginProvider", groups = {"smoke"})

public void verifyLoginByInValidCredentials(String usernameValue, String passwordValue) throws IOException {
	//String usernameValue=ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);
	//String passwordValue=ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernameValue).enterPassword(passwordValue).signInClick();
	//login.enterPassword(passwordValue);
	//login.signInClick();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected,Messages.INVALID_ASSERT_MSG);
	
}
 @DataProvider(name="loginProvider")	//returns two dimensional object array
public Object[][] getDataFromDataProvider() throws IOException
{
	return new Object[][] { new Object[] {"user","password"},
		new Object[] {"username","pass"},
		new Object[] {"user1","password1"}
	};
}


}
