package week5;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.myntra.com/");

		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='Men']/parent::div"))).perform();
		builder.moveToElement(driver.findElement(By.linkText("Jackets"))).click().perform();

		Thread.sleep(3000);
		System.out.println("Count of Jackets items : " + driver.findElement(By.xpath("//span[@class='title-count']")).getText());

		List<WebElement> categories = driver.findElements(By.xpath("//span[@class='categories-num']"));
		int count = 0;
		System.out.println("Categories Count : ");
		for (WebElement webElement : categories) {
			count = count + Integer.parseInt(webElement.getText().replace("(", "").replace(")", ""));
			System.out.println(Integer.parseInt(webElement.getText().replace("(", "").replace(")", "")));
		}

		if (count == Integer.parseInt(driver.findElement(By.xpath("//span[@class='title-count']")).getText().replace(" - ", "").replace(" items", ""))) {
			System.out.println("Count of categories matched total count!!!");
		} else {
			System.out.println("Count mismatch!!!");
		}

		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		Thread.sleep(3000);

		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//input[@value='Duke']/parent::label")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(@class,'prites-remove')]")).click();

		List<WebElement> brands = driver.findElements(By.xpath("//h3[@class='product-brand']"));

		for(WebElement webElement : brands) {
			if (webElement.getText().equals(brands)) {
			} else {
				System.out.println(webElement.getText() + " Hit - All listed products are not of \"Duke\" brand");
				break;
			}
		}

		driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
		driver.findElement(By.xpath("//input[@value='discount']/parent::label")).click();

		Thread.sleep(3000);
		System.out.println("Price of first listed product :"+ driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText());

		driver.findElement(By.xpath("//img[@title='Duke Men Brown Solid Padded Jacket']")).click();

		List<String> windows = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(windows.get(1));
		Thread.sleep(3000);
		File showImg = driver.findElement(By.xpath("//div[contains(@class,'image-grid-container')]")).getScreenshotAs(OutputType.FILE);
		File destName = new File("./screenshots/myntraJacket.jpg");
		FileUtils.copyFile(showImg, destName);
		System.out.println("Screenshot taken!!!");

		driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center ']")).click();
		Thread.sleep(1000);

	}

}
