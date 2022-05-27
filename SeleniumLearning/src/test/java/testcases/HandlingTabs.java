package testcases;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabs
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//a[@id='register_Layer']/div")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> ite=windows.iterator();
		String window1=ite.next();
		driver.switchTo().window(window1);
		System.out.println(driver.getTitle());
		
		String window2=ite.next();
		driver.switchTo().window(window2);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/span/a")).click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Jobseeker's Login:"))
		{ 
			 System.out.println("Automation done !!");
	    }
	}

}
