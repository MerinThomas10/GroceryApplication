package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();

	
	public  LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUserName(String usernameValue) {
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(usernameValue);
		return this;
	}
	
	public LoginPage enterPassword(String passwordValue) {
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		return this;
   }
	
	public HomePage signInClick() {
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		return new HomePage(driver);
	}
	
	
}
