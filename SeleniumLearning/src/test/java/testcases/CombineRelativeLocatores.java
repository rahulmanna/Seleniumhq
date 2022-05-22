package testcases;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CombineRelativeLocatores 
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(with(By.name("password"))
		.above(By.linkText("Signin"))
		.below(By.xpath("//input[@type='text']"))).sendKeys("text");
		
		List<WebElement>list=driver.findElements(with(By.tagName("label")).
		below(By.xpath("(//*[@id=\"load_form\"]/h3)[2]")));
		for(WebElement element :list)
		{
			System.out.println(element.getText());
		}
		
		driver.quit();
		
		
	}

}
