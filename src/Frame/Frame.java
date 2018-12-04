package Frame;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("file:///E:/eclipse/Institute/Testapp/TestApplication/Main.html");
		
		
		String parent = driver.getWindowHandle();
		System.out.println("parent id: "+parent);
		
		driver.findElement(By.xpath("//*[@class='rLink'][2]")).click();
		
		Set<String> allHandelse = driver.getWindowHandles();
		
		for(String child:allHandelse) {
			
			WebElement str = driver.findElement(By.name("register-reset"));
			
			driver.switchTo().frame(str);
			
			
							
				String browserName= driver.getTitle();
				
				driver.findElement(By.xpath("//*[@class='row1']/p[1]/input[1]")).sendKeys("psathish@gmail.com");
				Thread.sleep(200);
				driver.close();
//				driver.quit();
			}
		
		driver.switchTo().window(parent).findElement(By.id("main frame"));
		Data.Common.driver.findElement(By.xpath("//*[@class='rLink'][1]")).click();
		System.out.println("Parent window: "+driver.getTitle());
	}

}
