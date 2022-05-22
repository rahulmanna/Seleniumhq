package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PerformRightClick {
   
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		WebElement ele=driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
		
		Actions act=new Actions(driver);
		
		act.contextClick(ele).perform();
		
		
	}
}
