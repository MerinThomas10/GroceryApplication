package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath ="//a[@class='small-box-footer'and @href ='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement newsMoreInfo;
	public void newsMoreInfoClick() {
		page.clickOnElement(newsMoreInfo);
	}
	
	
	@FindBy(xpath ="//a[text()='Home']")WebElement newButton;
	public void newButtonClick() {

		wait.waitUntilClickable(driver, newButton);
		page.clickOnElement(newButton);
	}
	
	@FindBy(xpath ="//textarea[@id='news']")WebElement addNews;
	public void addNewNews() {
		page.sendDataToElement(addNews, "This is a sample news");
	}
	
	@FindBy(xpath ="//button[@name='create']")WebElement save;
	public void saveButtonClick() {
		
		page.clickOnElement(save);
	}
	
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement newsAlert;
	public boolean newsAlertDisplay() {
		
		return newsAlert.isDisplayed();
	}
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.comadmin/dashboard']")WebElement homeLink;
	public void homeLinkClick() {
		page.clickOnElement(homeLink);
	
	}
}
