package BrowserOptions;



import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DimensionofanElement 
{
	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		WebElement ele=driver.findElement(By.id("selenium_logo"));
		
		Rectangle rect=ele.getRect();
		
		System.out.println(ele.getText());
		
		System.out.println("Height :"+rect.getHeight());
		System.out.println("Width  :"+rect.getWidth());
		System.out.println("X AXIS :"+rect.getX());
		System.out.println("Y AXIS :"+rect.getY());
		
		
		
	}

}
