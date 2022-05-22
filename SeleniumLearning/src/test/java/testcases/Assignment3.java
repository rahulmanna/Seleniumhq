package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Assignment3 {
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String value=driver.findElement(By.id("mathq2")).getText();
		System.out.println(value);
		
		char ch=value.charAt(0);
		char ch1=value.charAt(4);
		
		int firstnum=Character.getNumericValue(ch);
		int secondnum=Character.getNumericValue(ch1);
		int sum=firstnum+secondnum;
		System.out.println(sum);
		driver.findElement(By.xpath("//*[@id=\"mathuserans2\"]")).sendKeys(""+sum+"");
		//driver.quit();
		
	}

}
