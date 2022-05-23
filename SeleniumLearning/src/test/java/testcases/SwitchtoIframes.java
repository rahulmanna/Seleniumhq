package testcases;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SwitchtoIframes 
{
	public static void main(String[] args) {
		
        ChromeOptions option=new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.switchTo().frame("iframeResult");
	    driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	    
	    driver.switchTo().defaultContent();
	    
	    List<WebElement>frames=driver.findElements(By.tagName("iframe"));
	    System.out.println(frames.size());
	    for(WebElement frame :frames)
	    {
	    	System.out.println(frame.getAttribute("id"));
	    }
	}

}
