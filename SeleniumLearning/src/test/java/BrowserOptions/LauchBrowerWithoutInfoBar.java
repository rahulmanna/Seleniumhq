package BrowserOptions;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LauchBrowerWithoutInfoBar 
{
	public static void main(String[] args) {
		
		  
		  ChromeOptions opt=new ChromeOptions();
		  
		  opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		  opt.addArguments("window-size=1400,1000");
		  
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver(opt);
		  
		  driver.get("https://selenium.dev");
		  System.out.println(driver.getTitle());
	}

}
