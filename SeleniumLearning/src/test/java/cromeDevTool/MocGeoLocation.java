package cromeDevTool;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MocGeoLocation 
{
	public static void main(String[] args) {
		 
		//https://chromedevtools.github.io/devtools-protocol/tot/Emulation/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
        
		Map<String,Object> setlocation=new HashMap<String,Object>();
		setlocation.put("latitude", 52.5043);
		setlocation.put("longitude", 13.4501);
		setlocation.put("accuracy", 1);
		((ChromeDriver)driver).executeCdpCommand("Emulation.setGeolocationOverride",setlocation);
		
		driver.get("https://my-location.org/");
		
 
	}
 
}

