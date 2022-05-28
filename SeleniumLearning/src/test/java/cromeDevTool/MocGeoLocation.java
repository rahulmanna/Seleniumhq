package cromeDevTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.emulation.Emulation;

import com.google.common.base.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MocGeoLocation 
{
	public static void main(String[] args) {
		 
		//https://chromedevtools.github.io/devtools-protocol/tot/Emulation/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
//		devTools.createSession();
//		devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
//                Optional.of(13.4501),
//                Optional.of(1)));
		//devTools.send(Emulation.setGeolocationOverride(Optional.of((Number)51.509865), Optional.of((Number)(double)-0.118092), Optional.of((Number)100)));
		
		driver.get("https://mycurrentlocation.net/");
		
 
	}
 
}

