package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdowns {
	
	public static void main(String[] args) {
		
		int Count=0;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		
		WebElement dropdowns=driver.findElement(By.name("country"));
		
		Select select=new Select(dropdowns);
		select.selectByVisibleText("Hungary");
		select.selectByIndex(3);
		
		List<WebElement> list=select.getOptions();
		
		for(WebElement options:list)
		{
			System.out.println(options.getText());
			Count=Count+1;
			
		}
		System.out.println("Number of options on the dropdown:"+Count);
		//System.out.println(list.size());
	}

}
