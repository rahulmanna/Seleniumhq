package testcases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMouseOverEvent {
	
	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.xpath("//div[3]/center/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
		
		WebElement menu=driver.findElement(By.xpath("//*[@id=\"menu-item-27617\"]/a/span[2]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(menu).perform();
		
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"menu-item-27619\"]/a/span[2]"));
		
		System.out.println(ele.getText());
		ele.click();
		
		
		
	}

}
