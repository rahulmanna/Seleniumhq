package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        
	    //Option1- Selecting check boxes dynamically
		WebElement parentelement=driver.findElement(By.xpath("//div[@class='display'][1]"));
		List<WebElement>items=parentelement.findElements(By.name("sports"));
		System.out.println(items.size());
		for(WebElement ele:items)
		{
			ele.click();
		}
		 
		//Option2- Selecting check boxes dynamically		
		for(int i=1;i<=4;i++)
		{
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		}
		
	}

}
