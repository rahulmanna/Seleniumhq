package BrowserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowerOptions 
{
   public static void main(String[] args) {
	
	   
	  ChromeOptions opt=new ChromeOptions();
	  opt.addArguments("headless");
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver(opt);
	  
	  driver.get("https://selenium.dev");
	  System.out.println(driver.getTitle());
}

}
