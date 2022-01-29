package week5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();		

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(3000);
		System.out.println("Price of the first product : "+ driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText());

		System.out.println("Total Customer ratings of the first product : "+ driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText());

		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.moveToElement(driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[1]"))).click().perform();

		System.out.println("5 star ratings : "+ driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[1]")).getAttribute("title"));

		driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();

		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		Thread.sleep(3000);

		File showImg = driver.findElement(By.id("imgTagWrapperId")).getScreenshotAs(OutputType.FILE);
		File destName = new File("./screenshots/amazonPhone.jpg");
		FileUtils.copyFile(showImg, destName);
		System.out.println("Screenshot taken!!!");

		driver.findElement(By.id("add-to-cart-button")).click();

		Thread.sleep(3000);
		//driver.quit();	
	}
	}