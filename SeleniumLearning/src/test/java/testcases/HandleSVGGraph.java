package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSVGGraph 
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.covid19india.org/");
		Thread.sleep(5000);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.
        elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[4]/div[2]/div/div[8]/div[1]"))).click();
        
		List<WebElement> graph=driver.findElements(By.xpath("(//*[name()='svg' and @preserveAspectRatio='xMidYMid meet'])[6]//*[name()='circle']"));
		Actions action=new Actions(driver);
		for(WebElement ele: graph)
		{
			action.moveToElement(ele).perform();
			System.out.println(driver.findElement(By.xpath("//div[@class='stats is-confirmed']/div/h2")).getText());
			
		}
		
	}

}
