package captureScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureElementScreenshot 
{
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		
		WebElement above=driver.findElement(RelativeLocator.with(By.tagName("input"))
		.above(By.tagName("select")));
		above.sendKeys("rahulmanna93@gmail.com");
		
		File abovescrn=above.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(abovescrn, new File("./screenshot/above.jpg"));
		
		
		
		WebElement below=driver.findElement(RelativeLocator.with(By.name("phone")).below(By.name("name")));
		below.sendKeys("8904824252");
		
		File belowscrn=below.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(belowscrn, new File("./screenshot/below.jpg"));
		
//		WebElement toLeftOf=driver.findElement(RelativeLocator.with(By.linkText("Signin")).
//		toLeftOf(By.xpath("(//*[@id=\"load_form\"]/div[1]/div[2]/input)[2]")));
//		toLeftOf.click();
//		
//		WebElement toRightof=driver.findElement(RelativeLocator.with(By.className("button"))
//		.toRightOf(By.linkText("Signin")));
//		toRightof.click();
//		
//		WebElement near=driver.findElement(RelativeLocator.with(By.partialLinkText("THE"))
//		.near(By.linkText("Signin")));
//		near.click();
		
	}

}
