package captureScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintingScreenShot 
{
	public static WebDriver driver;
	
	public static  void capturescreenshot() throws IOException
	{
		Date d=new Date();
		String filename=(d.toString().replace(":", "_").replace(" ", "_")+".jpg");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+filename));
		
	}
	public static void main(String[] args) throws IOException  
	
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://way2automation.com");
		
        capturescreenshot();
		
		
	}
         
}
