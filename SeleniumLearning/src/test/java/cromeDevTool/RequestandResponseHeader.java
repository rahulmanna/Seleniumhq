package cromeDevTool;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;
import org.openqa.selenium.devtools.v100.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RequestandResponseHeader 
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		DevTools devtools=((ChromeDriver)driver).getDevTools();
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		//This is for REQUEST
		
		
		devtools.addListener(Network.requestWillBeSent(), request ->{
			
			Headers header=request.getRequest().getHeaders();
			
			if(!header.isEmpty())
			{
				System.out.println("Request Header:");
				header.forEach((key,value)->{
					
					System.out.println(" "+key+" = "+value);
				});
			}
			
			
		});
		
		//This is RESPONSE 
		
           devtools.addListener(Network.responseReceived(), response ->{
			
			Headers header=response.getResponse().getHeaders();
			
			if(!header.isEmpty())
			{
				System.out.println("Response Header:");
				header.forEach((key,value)->{
					
					System.out.println(" "+key+" = "+value);
				});
			}
			
			System.out.println("Response URL is:"+response.getResponse().getUrl()+"Status code is:"+
			response.getResponse().getStatus());
		});
           
           Map<String,Object>map=new HashMap<String,Object>();
           map.put("CustomHeaderName", "CustomHeaderValue");
           map.put("Rahul", "Selenium Learning");
           Headers head=new Headers(map);
           devtools.send(Network.setExtraHTTPHeaders(head));
           
           
           driver.get("https://reqres.in/api/users?page=2");
	}

}
