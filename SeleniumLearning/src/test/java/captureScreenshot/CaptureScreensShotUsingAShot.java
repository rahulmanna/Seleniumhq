package captureScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

 public class CaptureScreensShotUsingAShot 
 {
//public static WebDriver driver;
//	public static  void capturescreenshot() throws IOException
//	{
//		Date d=new Date();
//		String filename=(d.toString().replace(":", "_").replace(" ", "_")+".jpg");
//		
//	}
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://way2automation.com/");

		Screenshot screenshot=new AShot().shootingStrategy
		(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
				
		ImageIO.write(screenshot.getImage(), ".jpg", new File(".\\screenshot\\ashotimage.jpg"));
		
		
	}

}
