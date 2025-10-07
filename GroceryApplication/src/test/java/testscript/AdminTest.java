package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
	HomePage home;
	AdminPage admin;
	@Test(description = "To add new user",priority = 1)
	public void verifyAddUser() throws IOException {
	String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
	String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
	LoginPage login = new LoginPage(driver);
	login.enterUserName(usernameValue).enterPassword(passwordValue);
	//login.enterPassword(passwordValue);
	home =login.signInClick();
	
	
	FakerUtility fakerUtility = new FakerUtility();
	String randomName=fakerUtility.createRandomUserName();
	String randomPassword =fakerUtility.createRandomPassword();
	//String userType =ExcelUtility.getStringData(1, 2, "HomePage");
	//AdminPage admin = new AdminPage(driver);
	admin= home.adminTileClick();
	admin.newButtonClick().addNewUsername(randomName).addNewPassword(randomPassword).enterNewUserType(Constants.ADMINUSER).saveButtonClick();
	/*
	 * admin.addNewUsername(randomName) admin.addNewPassword(randomPassword);
	 * admin.enterNewUserType(Constants.ADMINUSER); admin.saveButtonClick();
	 */
	
	boolean isalertdisplayed = admin.newAlert();
	Assert.assertTrue(isalertdisplayed, Messages.NEW_ITEM_ADD_ASSERT_MSG);
	

	}
	
	@Test(description = "Verify search functionality", priority = 2)
	
	public void verifySearch() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		//login.enterPassword(passwordValue);
		home =login.signInClick();
		
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomUsername=fakerUtility.createRandomUserName();
		//String userType =ExcelUtility.getStringData(1, 2, "HomePage");
		//AdminPage admin = new AdminPage(driver);
		admin =home.adminTileClick();	
		admin.searchButtonClick().searchByName(randomUsername).searchUserType(Constants.ADMINUSER).searchUser();
		/*
		 * admin.searchByName(randomUsername);
		 * admin.searchUserType(Constants.ADMINUSER); admin.searchUser();
		 */
		boolean itemSearchdisplayed = admin.searchTile();
		Assert.assertTrue(itemSearchdisplayed, Messages.ITEM_SEARCH);
		
		
	}
	
	@Test (description = "Verify reset functionality",priority = 3)
	
	public void verifyReset() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		//login.enterPassword(passwordValue);
		home =login.signInClick();
		
		//AdminPage admin = new AdminPage(driver);
		admin= home.adminTileClick();		
		admin.resetButtonClick();
		boolean isalertdisplayed = admin.resetAlert();
		Assert.assertTrue(isalertdisplayed, Messages.RESET_ASSERT);
		
		
		
	}

}
