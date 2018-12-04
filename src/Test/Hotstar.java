package Test;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hotstar {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		
	  WebDriver driver = new FirefoxDriver();
	  
	  driver.get("https://www.hotstar.com/");
	  
	  driver.findElement(By.xpath("//div[@class='signIn displayElement']")).click();
	  
	}

}
