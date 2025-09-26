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
		public void adminClick() {
        wait.waitUntilClickable(driver, admin);
        page.clickOnElement(admin);
		
		}
		@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logout;
		public void logOut() {
			page.clickOnElement(logout);
		
		}
		
	}
	


