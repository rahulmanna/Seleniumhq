package captureScreenshot;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.HasFullPageScreenshot;
import org.openqa.selenium.firefox.HasFullPageScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullpageScreenshot 
{
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		
		TakesScreenshot scr=((TakesScreenshot)driver);
		
		File pagescreenshot=scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pagescreenshot, new File("./screenshot/pagescreenshot.jpg"));
		
//	    //For full page screenshot(which will work on firefox only as of now)
	   HasFullPageScreenshot scr1=(HasFullPageScreenshot)driver;
	   File fullpage=scr1.getFullPageScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(fullpage,new File( "./screenshot/fullpagescreenshot.jpg"));
	   
	}

}
