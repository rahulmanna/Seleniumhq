package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		//implicit wait only satisfy the present condition.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit wait is use to interact with the element
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
		
		//Fluent wait wait is use to interact with the element, but we can add
		 // a certain frequency of time after which element will be search after 1st
		 // unsuccessfull search
		Wait <WebDriver>wait1= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
		
	    WebElement username=driver.findElement(By.id("identifierId"));
	    username.sendKeys("rahulmanna93@gmail.com");
	    
	    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
	    
	    WebElement password= driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
	    password.sendKeys("rahulmanna");
		
	}

}
