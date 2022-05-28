package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingShadowDomElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("chrome://downloads/");
		
		
		WebElement root1=driver.findElement(By.cssSelector("downloads-manager"));
		SearchContext context1 = root1.getShadowRoot();
	
		
		
		WebElement root2=context1.findElement(By.cssSelector("downloads-toolbar"));
		SearchContext context2 = root2.getShadowRoot();
		
		
		WebElement root3=context2.findElement(By.cssSelector("cr-toolbar"));
		SearchContext context3 = root3.getShadowRoot();
		
		
		
		WebElement root4=context3.findElement(By.cssSelector("cr-toolbar-search-field"));
		SearchContext context4 = root4.getShadowRoot();
	
		
		context4.findElement(By.cssSelector("#searchInput")).sendKeys("Hello");
		
		
		
	}

}
