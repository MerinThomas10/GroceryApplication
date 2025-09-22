package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	@Test
	
	public void verifyLoginByValidCredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"Login not successful with valid credentials");
	}
	
@Test
	
	public void verifyLoginByInvalidPassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"Login not successful with invalid credentials");
	}

@Test

public void verifyLoginByInValidUsername() throws IOException {
	String usernameValue=ExcelUtility.getStringData(3, 0, "LoginPage");
	String passwordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
	WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	userName.sendKeys(usernameValue);
	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
	signIn.click();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected,"Login not successful with invalid credentials");
	
}

@Test

public void verifyLoginByInValidCredentials() throws IOException {
	String usernameValue=ExcelUtility.getStringData(4, 0, "LoginPage");
	String passwordValue=ExcelUtility.getStringData(4, 1, "LoginPage");
	WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	userName.sendKeys(usernameValue);
	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
	signIn.click();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	String actual = driver.getCurrentUrl();
	Assert.assertEquals(actual, expected,"Login not successful with invalid credentials");
	
}



}
