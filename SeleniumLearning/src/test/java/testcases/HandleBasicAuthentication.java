package testcases;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBasicAuthentication {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
		
		 driver.get("https://the-internet.herokuapp.com/basic_auth");
	}

}
