package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {
	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;
	
	public NewsPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	public NewsPage newButtonClick() {

		wait.waitUntilClickable(driver, newButton);
		page.clickOnElement(newButton);
		return this;
	}
	
	@FindBy(xpath ="//textarea[@id='news']")WebElement addNews;
	public NewsPage addNewNews() {
		page.sendDataToElement(addNews, Constants.NEW_NEWS);
		return this;
	}
	
	@FindBy(xpath ="//button[@name='create']")WebElement save;
	public NewsPage saveButtonClick() {
		
		page.clickOnElement(save);
		return this;
	}
	
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement newsAlert;
	public boolean newsAlertDisplay() {
		
		return newsAlert.isDisplayed();
	}
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='Home']")WebElement homeLink;
	public HomePage homeLinkClick() {
		page.clickOnElement(homeLink);
		return new HomePage(driver);
	
	}
}
