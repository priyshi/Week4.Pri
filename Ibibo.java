package week5;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ibibo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();	
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.goibibo.com/");
		WebElement ib = driver.findElement(By.id("gosuggest_inputSrc"));
		ib.clear();
		ib.sendKeys("BBI");
		Thread.sleep(3000);
		ib.sendKeys(Keys.ARROW_DOWN);
		ib.sendKeys(Keys.ENTER);

		WebElement des = driver.findElement(By.id("gosuggest_inputDest"));
		des.clear();
		des.sendKeys("VNS");
		Thread.sleep(3000);
		des.sendKeys(Keys.ARROW_DOWN);
		des.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("gi_search_btn")).click();
		
	}

}
