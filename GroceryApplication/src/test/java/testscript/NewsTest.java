package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase {
	
	@Test(description = "Add news")
	
	public void verifyAddNews() throws IOException {
		
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		WebElement newsMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class= 'small-box-footer']"));
		newsMoreInfo.click();
		WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newButton.click();
		WebElement addNews = driver.findElement(By.xpath("//textarea[@id='news']"));
		addNews.sendKeys("This a test news");
		WebElement save = driver.findElement(By.xpath("//button[@class= 'btn btn-danger']"));
		save.click();
		
		
		
	}

	@Test(description = "Return to Home page")
	
	public void verifyReturnToHome() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		WebElement newsMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class= 'small-box-footer']"));
		newsMoreInfo.click();
		WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newButton.click();
		WebElement homeLink = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.comadmin/dashboard']"));
		homeLink.click();
		String expected = "https://groceryapp.uniqassosiates.comadmin/dashboard";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"Not redirected to Homepage");
		
	}
	
}
