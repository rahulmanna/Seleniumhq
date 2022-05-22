package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Printinglinks 
{
	public static void main(String[] args) {
		int Count=0;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		List<WebElement>linkelement=driver.findElements(By.tagName("a"));
		System.out.println(linkelement.size());
		
		for(WebElement ele:linkelement)
		{
			System.out.println((Count=Count+1)+":"+ ele.getText());
		}
	}

}
