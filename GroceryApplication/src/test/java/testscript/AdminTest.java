package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
	
	@Test(description = "To add new user",priority = 1)
	public void verifyAddUser() throws IOException {
	String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
	String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
	WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	userName.sendKeys(usernameValue);
	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
	signIn.click();
	
	
	FakerUtility fakerUtility = new FakerUtility();
	String randomName=fakerUtility.createRandomUserName();
	String randomPassword =fakerUtility.createRandomPassword();
	String userType =ExcelUtility.getStringData(1, 2, "HomePage");
	WebElement adminTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'  and @class='small-box-footer']"));
	adminTile.click();
	WebElement newButton = driver.findElement(By.xpath("//a[@class ='btn btn-rounded btn-danger']"));
	newButton.click();
	WebElement newUsername = driver.findElement(By.xpath("//input[@id='username']"));
	newUsername.sendKeys(randomName);
	WebElement newPassword = driver.findElement(By.xpath("//input[@id='password']"));
	newPassword.sendKeys(randomPassword);
	WebElement newUserType = driver.findElement(By.xpath("//select[@id='user_type']"));
	Select select =new Select(newUserType);
	select.selectByVisibleText(userType);
	WebElement saveButton = driver.findElement(By.xpath("//button[@name='Create']"));
	saveButton.click();
	

	}
	
	@Test(description = "Verify search functionality", priority = 2)
	
	public void verifySearch() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomUsername=fakerUtility.createRandomUserName();
		String userType =ExcelUtility.getStringData(1, 2, "HomePage");
		WebElement adminTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'  and @class='small-box-footer']"));
		adminTile.click();	
		WebElement searchButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		searchButton.click();
		WebElement userNameSearch = driver.findElement(By.xpath("//input[@id='un']"));
		userNameSearch.sendKeys(randomUsername);
		WebElement userTypeSearch = driver.findElement(By.xpath("//select[@id='ut']"));
		Select select =new Select(userTypeSearch);
		select.selectByVisibleText(userType);
		WebElement searchButton1 = driver.findElement(By.xpath("//button[@name='Search']"));
		searchButton1.click();
		
		
		
	}
	
	@Test (description = "Verify reset functionality",priority = 3)
	
	public void verifyReset() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		
		
	
		WebElement adminTile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'  and @class='small-box-footer']"));
		adminTile.click();	
		WebElement resetButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
		resetButton.click();
		
	}

}
