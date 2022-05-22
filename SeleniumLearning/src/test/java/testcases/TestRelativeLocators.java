package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRelativeLocators 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		
		WebElement above=driver.findElement(RelativeLocator.with(By.tagName("input"))
		.above(By.tagName("select")));
		above.sendKeys("rahulmanna93@gmail.com");
		
		WebElement below=driver.findElement(RelativeLocator.with(By.name("phone")).below(By.name("name")));
		below.sendKeys("8904824252");
		
		WebElement toLeftOf=driver.findElement(RelativeLocator.with(By.linkText("Signin")).
		toLeftOf(By.xpath("(//*[@id=\"load_form\"]/div[1]/div[2]/input)[2]")));
		toLeftOf.click();
		
		WebElement toRightof=driver.findElement(RelativeLocator.with(By.className("button"))
		.toRightOf(By.linkText("Signin")));
		toRightof.click();
		
		WebElement near=driver.findElement(RelativeLocator.with(By.partialLinkText("THE"))
		.near(By.linkText("Signin")));
		near.click();
		
		
		System.out.println("Testcase passed !");
		driver.quit();
		
	}

}
