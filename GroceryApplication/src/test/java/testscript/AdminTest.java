package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestNGBase;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
	
	@Test(description = "To add new user",priority = 1)
	public void verifyAddUser() throws IOException {
	String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
	String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernameValue);
	login.enterPassword(passwordValue);
	login.signInClick();
	
	
	FakerUtility fakerUtility = new FakerUtility();
	String randomName=fakerUtility.createRandomUserName();
	String randomPassword =fakerUtility.createRandomPassword();
	String userType =ExcelUtility.getStringData(1, 2, "HomePage");
	AdminPage admin = new AdminPage(driver);
	admin.adminTileClick();
	admin.newButtonClick();
	admin.addNewUsername(randomName);
	admin.addNewPassword(randomPassword);
	admin.enterNewUserType(userType);
	admin.saveButtonClick();
	
	boolean isalertdisplayed = admin.newAlert();
	Assert.assertTrue(isalertdisplayed, "New item is not added");
	

	}
	
	@Test(description = "Verify search functionality", priority = 2)
	
	public void verifySearch() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.signInClick();
		
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomUsername=fakerUtility.createRandomUserName();
		String userType =ExcelUtility.getStringData(1, 2, "HomePage");
		AdminPage admin = new AdminPage(driver);
		admin.adminTileClick();	
		admin.searchButtonClick();
		admin.searchByName(randomUsername);
		admin.searchUserType(userType);
		admin.searchUser();
		boolean itemSearchdisplayed = admin.searchTile();
		Assert.assertTrue(itemSearchdisplayed, "Item not searched");
		
		
	}
	
	@Test (description = "Verify reset functionality",priority = 3)
	
	public void verifyReset() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.signInClick();
		
		AdminPage admin = new AdminPage(driver);
		admin.adminTileClick();		
		admin.resetButtonClick();
		boolean isalertdisplayed = admin.resetAlert();
		Assert.assertTrue(isalertdisplayed, "Admin User header not displayed");
		
		
		
	}

}
