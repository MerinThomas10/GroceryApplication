package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	//randu parameters ondu driver and failed
	//cotains faied test case
	public void getScreenshot(WebDriver driver,String failedTestCase) throws IOException
	{
	//	TakesScreenshot interfaceil caste cheythitondu
	TakesScreenshot scrShot = (TakesScreenshot) driver;
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//created and object for file
	
//separate ayotu time tarum fail ayathu 10:30kum 10:31
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	//failed testcase + timestabil eee folderil screen shotina pass akunu
	File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");//create file in  directory
	if (!f1.exists()) {
	f1.mkdirs();
	}
	String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
	+ ".png";
	File finalDestination = new File(destination);
	FileHandler.copy(screenShot, finalDestination);
	}

}
