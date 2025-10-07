package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	
	public WebDriver driver;
	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();
	
	public AdminPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	public AdminPage newButtonClick() {
		page.clickOnElement(newButton);
		return this;
	}
	
	@FindBy(xpath ="//input[@id='username']")WebElement newUsername;
	public AdminPage addNewUsername(String randomname) {
		page.sendDataToElement(newUsername,randomname);
		return this;
	}
	
	@FindBy(xpath ="//input[@id='password']")WebElement newPassword;
	public AdminPage addNewPassword(String randompassword) {
		page.sendDataToElement(newPassword,randompassword);
		return this;
	}
	@FindBy(xpath ="//select[@id='user_type']")WebElement newUserType;
	public AdminPage enterNewUserType(String userType) {
		//Select select = new Select(newUserType);
		//select.selectByVisibleText(userType);
		page.selectByVisibleText(newUserType, userType);
		return this;
	}
	
	@FindBy(xpath ="//button[@name='Create']")WebElement saveButton;
	public AdminPage saveButtonClick() {
		wait.waitUntilClickable(driver, saveButton);
		page.clickOnElement(saveButton);
		return this;
	}
	
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement newalert;
	public boolean newAlert() {
		return newalert.isDisplayed();
	}
	
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']")WebElement searchButton;
	public AdminPage  searchButtonClick() {
		page.clickOnElement(searchButton);
		return this;
	}
	@FindBy(xpath ="//input[@id='un']")WebElement userNameSearch;
	public AdminPage searchByName(String randomname) {
		
		page.sendDataToElement(userNameSearch,randomname);
		return this;
	}
	
	
	@FindBy(xpath ="//select[@name='ut']")WebElement userTypeSearch;
	public AdminPage searchUserType( String userType) {
		//Select select = new Select(userTypeSearch);
		//select.selectByVisibleText(userType);
		page.selectByVisibleText(userTypeSearch, userType);
		return this;
	}
	
	@FindBy(xpath ="//button[@name='Search']")WebElement searchButton1;
	public AdminPage searchUser() {
		page.clickOnElement(searchButton1);
		return this;
	}
	
	@FindBy(xpath ="//h4[@class='card-title' and text()='Admin Users']")WebElement searchResult;
	public boolean searchTile() {
		return searchResult.isDisplayed();
	}
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-warning']")WebElement resetButton;
	public AdminPage resetButtonClick() {
		resetButton.click();
		return this;
	}
	
	@FindBy(xpath ="//h4[@class='card-title' and text() ='Admin Users']")WebElement resetAssert;
	public boolean resetAlert() {
		
		return resetAssert.isDisplayed();
	}

}
