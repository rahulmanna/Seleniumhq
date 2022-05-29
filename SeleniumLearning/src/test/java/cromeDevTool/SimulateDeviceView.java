package cromeDevTool;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimulateDeviceView 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools=((ChromeDriver)driver).getDevTools();
		devtools.createSession();
		
		Map<String,Object> devicemetrices=new HashMap<String,Object>();
		devicemetrices.put("width", 375);
		devicemetrices.put("height", 812);
		devicemetrices.put("mobile", true);
		devicemetrices.put("deviceScaleFactor", 50);
		
		((ChromeDriver)driver).executeCdpCommand("Emulation.setDeviceMetricsOverride",devicemetrices);
		
		driver.get("https://selenium.dev/");
	}

}
