package testcases;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class PrinttoPDF {
public static void main(String[] args) throws IOException {
	
	
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("headless");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		driver.manage().window().maximize();
		
	    Pdf pdf=((PrintsPage) driver).print(new PrintOptions());
	    Files.write(Paths.get("./selenium.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
	    
	}
}
