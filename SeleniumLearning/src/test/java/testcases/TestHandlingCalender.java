package testcases;

import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingCalender 
{
	static int targetDay=0;
	static int targetMonth=0;
	static int targetYear=0;
	
	static int currentday=0;
	static int currentMonth=0;
	static int currentYear=0;
	
	static int jumpMonthBy=0;
	public static boolean increment=true;
	
	public static void getCurrentDateMonthAndYear() {
		
		Calendar cal=Calendar.getInstance();
		
		currentday=cal.get(Calendar.DAY_OF_MONTH);
		currentMonth=cal.get(Calendar.MONTH)+1;
		currentYear=cal.get(Calendar.YEAR);
	}
	
	public static void GetTargetDateMonthYear(String datestring)
	{
		int firstIndex=datestring.indexOf("/");
		int lastIndex=datestring.lastIndexOf("/");
		
		String day=datestring.substring(0, firstIndex);
		targetDay=Integer.parseInt(day);
		
		
		String month=datestring.substring(firstIndex+1,lastIndex);
		targetMonth=Integer.parseInt(month);
		
		String year=datestring.substring(lastIndex+1, datestring.length());
		targetYear=Integer.parseInt(year);
		
	}
	
	public static void calculateHowManyMonthstoJump() {
		
		if((targetMonth-currentMonth)>0)
		{
			jumpMonthBy=(targetMonth-currentMonth);
		}
		else
		{
			jumpMonthBy=(currentMonth-targetMonth);
			increment=false;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		String dateToSet="09/06/2022";
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("C:\\eclipse\\Selenium doc\\same.html");
		
		driver.findElement(By.className("hasDatepicker")).click();
		GetTargetDateMonthYear(dateToSet);
		for(int i=0;i<jumpMonthBy;i++)
		{
			if(increment)
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]")).click();
			}
			Thread.sleep(1000);
		}
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();
	}

}
