package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsElementisDisplayedisEnabledisSelectd {
	
	static WebDriver  driver;
	public static boolean isElementPresent(By by)
	{
		try
		{
		driver.findElement(by);
		return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
	        return false;
		}
		
	}
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		
		System.out.println(isElementPresent(By.name("emailwerwr")));
	}

}
