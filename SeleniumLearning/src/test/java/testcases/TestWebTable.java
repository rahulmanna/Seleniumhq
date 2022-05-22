package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		
		List<WebElement> column=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println(column.size());
		
		for(WebElement ele :column)
		{
			System.out.println(ele.getText());
		}
		//Option 1:Printing all rows value from a table
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println(rows.size());
		for(WebElement ele :rows)
		{
			System.out.println(ele.getText()+"  ");
			System.out.println("\n");
		}
		//Option 2:Printing all rows from a table/ print a particular cell value
		
		for(int i=1;i<=rows.size();i++)
		{
			for(int j=1;j<=column.size();j++)
			{
				WebElement text=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(text.getText()+"  ");
				
				
			}
			System.out.println("\n");
		}
		
		driver.quit();

}
}
