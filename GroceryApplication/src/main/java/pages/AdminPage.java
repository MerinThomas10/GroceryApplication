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
	
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminTile;
	public void adminTileClick() {
		page.clickOnElement(adminTile);
	}
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	public void newButtonClick() {
		page.clickOnElement(newButton);
	}
	
	@FindBy(xpath ="//input[@id='username']")WebElement newUsername;
	public void addNewUsername(String randomname) {
		page.sendDataToElement(newUsername,randomname);
	}
	
	@FindBy(xpath ="//input[@id='password']")WebElement newPassword;
	public void addNewPassword(String randompassword) {
		page.sendDataToElement(newPassword,randompassword);
	}
	@FindBy(xpath ="//select[@id='user_type']")WebElement newUserType;
	public void enterNewUserType(String userType) {
		//Select select = new Select(newUserType);
		//select.selectByVisibleText(userType);
		page.selectByVisibleText(newUserType, null);
	}
	
	@FindBy(xpath ="//button[@name='Create']")WebElement saveButton;
	public void saveButtonClick() {
		wait.waitUntilClickable(driver, saveButton);
		page.clickOnElement(saveButton);
	}
	
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement newalert;
	public boolean newAlert() {
		return newalert.isDisplayed();
	}
	
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']")WebElement searchButton;
	public void  searchButtonClick() {
		page.clickOnElement(searchButton);
	}
	@FindBy(xpath ="//input[@id='un']")WebElement userNameSearch;
	public void searchByName(String randomname) {
		
		page.sendDataToElement(userNameSearch,randomname);
	}
	
	
	@FindBy(xpath ="//select[@name='ut']")WebElement userTypeSearch;
	public void searchUserType( String userType) {
		//Select select = new Select(userTypeSearch);
		//select.selectByVisibleText(userType);
		page.selectByVisibleText(newUserType, null);
	}
	
	@FindBy(xpath ="//button[@name='Search']")WebElement searchButton1;
	public void searchUser() {
		page.clickOnElement(searchButton1);
	}
	
	@FindBy(xpath ="//button[@class='btn btn-block-sm btn-danger' and @name = 'Search']")WebElement search;
	public boolean searchTile() {
		return search.isDisplayed();
	}
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-warning']")WebElement resetButton;
	public void resetButtonClick() {
		resetButton.click();
	}
	
	@FindBy(xpath ="//h4[@class='card-title' and text() ='Admin Users']")WebElement resetAssert;
	public boolean resetAlert() {
		
		return resetAssert.isDisplayed();
	}

}
