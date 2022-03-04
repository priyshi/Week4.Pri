package week8.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
        
        Thread.sleep(3000);
        WebElement web = driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']"));
        web.click();
        web.sendKeys("Kolkata");
        
        List<WebElement> dynamicList = driver.findElements(By.cssSelector("font14 appendBottom5 blackText"));
        
        for(int i=0; i<dynamicList.size();i++) {
        	
        	String text = dynamicList.get(i).getText();
        	System.out.println("Below are the places:"+text);
        	
        	if(text.contains("Kolkata")) {
        		
        		dynamicList.get(i).click();
        		break;
        	}
        }

	}

}
