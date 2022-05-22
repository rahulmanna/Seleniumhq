package testcases;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 
{
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
		act.contextClick(ele).perform();
		
		WebElement productifo=driver.findElement(By.id("dm2m1i1tdT"));
		act.moveToElement(productifo).perform();
		
		WebElement parameterinfo=driver.findElement(By.id("dm2m2i2tdT"));
		act.moveToElement(parameterinfo).perform();
		
		WebElement purchase=driver.findElement(By.id("dm2m1i3tdT"));
		act.moveToElement(purchase).click().perform();
		
		Set<String> tab=driver.getWindowHandles();
		Iterator<String>ite=tab.iterator();
		List<String> list=new ArrayList<String>();
		while(ite.hasNext())
		{
			list.add(ite.next());
			
		}
		driver.switchTo().window(list.get(1));
		Thread.sleep(3000);
		driver.close();
		
		
		
}

}
