package testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestnewTabandWindow {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://way2automation.com/");
		driver.manage().window().maximize();
		//Switch to a new TAB
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		//Switch to a new Window
		
	     driver.switchTo().newWindow(WindowType.WINDOW);
	     driver.get("https://support.tricentis.com/");
	     System.out.println(driver.getTitle());
	     
	     //Get how many window are open
	     
	    System.out.println(driver.getWindowHandles().size());
	    
	    //Switch between windows
	    
	   Set<String>windows=driver.getWindowHandles();
	   Iterator<String>ite=windows.iterator();
	   List<String>list=new ArrayList<String>();
	   
	   while(ite.hasNext())
	   {
		   list.add(ite.next());
	   }
	   driver.switchTo().window(list.get(2));
	   System.out.println(driver.getTitle());
	   
		//driver.quit();
		
	}

}
