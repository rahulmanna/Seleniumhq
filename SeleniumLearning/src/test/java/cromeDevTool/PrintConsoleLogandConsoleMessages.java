package cromeDevTool;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.console.Console;
import org.openqa.selenium.devtools.v100.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintConsoleLogandConsoleMessages 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		DevTools devtools=((ChromeDriver)driver).getDevTools();
		devtools.createSession();
		
	// Print log from console
		
		devtools.send(Log.enable());
		devtools.addListener(Log.entryAdded(), entry ->{
			
			System.out.println("Text is:"+entry.getText());
			System.out.println("Timestamp is:"+entry.getTimestamp());
			System.out.println("Source is:"+entry.getSource());
			System.out.println("Level is:"+entry.getLevel());
		});
	
   // Print message from console
		
		devtools.send(Console.enable());
		devtools.addListener(Console.messageAdded(), message->{
			
			System.out.println("Console text is:"+message.getText());
			
		
		});
		
		// write message in console
		driver.get("http://filpkart.com/");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("console.log('This is a text log')");
		
		
	}

}
