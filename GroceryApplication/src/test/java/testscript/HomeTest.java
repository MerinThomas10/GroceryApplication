package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	
	@Test
	
	public void VerifyLogout() throws IOException {
		
			String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
			WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
			userName.sendKeys(usernameValue);
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			password.sendKeys(passwordValue);
			WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
			signIn.click();
			WebElement admin =driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
			admin.click();
			WebElement logOut =driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
			logOut.click();
			
		
		
		
	}

}
