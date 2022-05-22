package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwithtoFrames 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_target");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		WebElement linktext=driver.findElement(By.xpath("//a[@target='iframe_a']"));
		
		System.out.println(linktext.getText());
		
		driver.switchTo().frame(0);
		
		String text1=driver.findElement(By.xpath("/html/body/h1")).getText();
		System.out.println(text1);
		
		driver.switchTo().parentFrame();

		WebElement text2=driver.findElement(By.xpath("/html/body/h2"));
		System.out.println(text2.getText());
	}

}
