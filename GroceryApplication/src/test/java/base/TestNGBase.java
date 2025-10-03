package base;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;

public class TestNGBase {
	Properties prop;
	FileInputStream f;
	public WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
		public void initalizeBrowser(String browser) throws Exception {
		prop = new Properties();
		f= new FileInputStream(Constants.CONFIG_FILE);
		prop.load(f);
		
		if(browser.equalsIgnoreCase("Chrome")) {
			//driver=new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		else {
			throw new Exception("Invalid browser name");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		@AfterMethod
		public void browserClose() {
			driver.close();
			//driver.quit();
		}


}
