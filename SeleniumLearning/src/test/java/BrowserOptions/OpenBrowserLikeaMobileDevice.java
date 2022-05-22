package BrowserOptions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowserLikeaMobileDevice 
{
	public static void main(String[] args) {
		
		
	Map<String,String> mobile=new HashMap<String,String>();
	
	    mobile.put("deviceName", "iPhone SE");
	    ChromeOptions opt=new ChromeOptions();
	    opt.setAcceptInsecureCerts(true);

	  opt.setExperimentalOption("mobileEmulation",mobile);
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver(opt);
	  driver.get("https://selenium.dev");
	  System.out.println(driver.getTitle());

}
}