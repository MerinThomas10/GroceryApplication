package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement admin;
		public HomePage adminClick() {
        wait.waitUntilClickable(driver, admin);
        page.clickOnElement(admin);
        return this;
		
		}
		@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logout;
		public LoginPage logOut() {
			page.clickOnElement(logout);
			return new LoginPage(driver);
		
		}
		@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminTile;
		public AdminPage adminTileClick() {
			page.clickOnElement(adminTile);
			return new AdminPage(driver);
		}
		
		@FindBy(xpath ="//a[@class='small-box-footer'and @href ='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement newsMoreInfo;
		public NewsPage newsMoreInfoClick() {
			page.clickOnElement(newsMoreInfo);
			return new NewsPage(driver);
		}
		
	
		
	}
	


