package week5;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountOfLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		String url="";
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of Links:"+links.size());
        
        
        Iterator<WebElement> iter = links.iterator();
        while (iter.hasNext()) {
      	url = iter.next().getText();
      	System.out.println(url);
      	
        }
	}

}
