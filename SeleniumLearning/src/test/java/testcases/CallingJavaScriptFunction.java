package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CallingJavaScriptFunction {
   
      public static void main(String[] args) {
		   
  		WebDriverManager.chromedriver().setup();
  		WebDriver driver=new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
  		driver.switchTo().frame("iframeResult");
  		JavascriptExecutor js= (JavascriptExecutor)driver;
  		js.executeScript("arguments[0].style.border='3px solid red'",driver.findElement(By.id("mySubmit")));
  		js.executeScript("myFunction()");
	}
}
