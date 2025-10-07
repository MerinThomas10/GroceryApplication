package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase {
	HomePage home;
	NewsPage news;
	@Test(description = "Add news" , priority = 1)
	
	public void verifyAddNews() throws IOException {
		
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		//login.enterPassword(passwordValue);
		home =login.signInClick();
		
		//NewsPage news = new NewsPage(driver);
		news = home.newsMoreInfoClick();
		news.newButtonClick().addNewNews().saveButtonClick();
		//news.addNewNews();
		//news.saveButtonClick();
		boolean isAlertDisplayed = news.newsAlertDisplay();
		Assert.assertTrue(isAlertDisplayed,Messages.ADD_NEWS_ALERT_MSG);
		
		
		
	}

	@Test(description = "Return to Home page", priority = 2)
	
	public void verifyReturnToHome() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		//login.enterPassword(passwordValue);
		home =login.signInClick();
		
		//NewsPage news = new NewsPage(driver);
		news =home.newsMoreInfoClick();
		home =news.homeLinkClick();
	
	
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/home";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.HOME_PAGE_REDIRECT_ASSERT);
		
	}
	
}
