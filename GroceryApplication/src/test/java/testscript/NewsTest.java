package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestNGBase;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase {
	
	@Test(description = "Add news" , priority = 1)
	
	public void verifyAddNews() throws IOException {
		
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.signInClick();
		
		NewsPage news = new NewsPage(driver);
		news.newsMoreInfoClick();
		news.newButtonClick();
		news.addNewNews();
		news.saveButtonClick();
		boolean isAlertDisplayed = news.newsAlertDisplay();
		Assert.assertTrue(isAlertDisplayed,"Alert not displayed");
		
		
		
	}

	@Test(description = "Return to Home page", priority = 2)
	
	public void verifyReturnToHome() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.signInClick();
		
		NewsPage news = new NewsPage(driver);
		news.newsMoreInfoClick();
		news.homeLinkClick();
	
	
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/home";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"The page is not redirecting to the home page.");
		
	}
	
}
