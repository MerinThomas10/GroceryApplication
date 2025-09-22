package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase {
	public WebDriver driver;
	@BeforeMethod
		public void initalizeBrowser() {
		ChromeOptions options = new ChromeOptions();
		Map<String,Object> prefs=new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		driver=new ChromeDriver(options);
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		}
		@AfterMethod
		public void browserClose() {
			driver.close();
			//driver.quit();
		}


}
