package testcases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizingWindow 
{
	public static void main(String[] args) {
		
       int j;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
	    Dimension d1=new Dimension(399,399);
		driver.manage().window().setSize(d1);
		
		for (int i=400;i<=1000;i++)
		{
			for(j=500;j<=1000;)
			{
				Dimension d=new Dimension(i,j);
				driver.manage().window().setSize(d);
				break;
			}
			j=j+100;
		}
		
      System.out.println("Automation done!");

}
}
