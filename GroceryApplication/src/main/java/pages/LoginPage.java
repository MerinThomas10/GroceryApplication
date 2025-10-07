package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	@FindBy(xpath="//input[@name='username']")WebElement username;
	public LoginPage enterUserName(String usernameValue) {
		//WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		//userName.sendKeys(usernameValue);
		wait.waitUntilElementIsVisible(driver, username);
		page.sendDataToElement(username, usernameValue);
		return this;
	}
	@FindBy(xpath ="//input[@name='password']")WebElement password;
	public LoginPage enterPassword(String passwordValue) {
		//WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		//password.sendKeys(passwordValue);
		wait.waitUntilElementIsVisible(driver, password);
		page.sendDataToElement(password, passwordValue);
		return this;
   }
	
	public HomePage signInClick() {
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
		signIn.click();
		return new HomePage(driver);
	}
	
	
}
