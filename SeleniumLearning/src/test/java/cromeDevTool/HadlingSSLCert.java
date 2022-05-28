package cromeDevTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.security.Security;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HadlingSSLCert 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		DevTools dev=((ChromeDriver)driver).getDevTools();
		dev.createSession();
		
		dev.send(Security.enable());
		dev.send(Security.setIgnoreCertificateErrors(true));
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com");
		
		
	}

}
