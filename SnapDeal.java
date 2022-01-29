package week5;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.snapdeal.com/");
		//div[text()='Sports Shoes for Men']/following-sibling::div
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText("Men's Fashion"))).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();

		Thread.sleep(3000);
		System.out.println("Count of Sport Shoes : "+ driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText());

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();

		driver.findElement(By.xpath("//ul[@class='sort-value']//li[2]")).click();

		driver.findElement(By.xpath("(//div[@class='price-text-box']//input)[1]")).clear();
		driver.findElement(By.xpath("(//div[@class='price-text-box']//input)[1]")).sendKeys("900");
		driver.findElement(By.xpath("(//div[@class='price-text-box']//input)[2]")).clear();
		driver.findElement(By.xpath("(//div[@class='price-text-box']//input)[2]")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='Color_s-Navy']/parent::div")).click();
		
		builder.moveToElement(driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();

		//driver.switchTo().activeElement();
		System.out.println("Price of the selected shoe : " + driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println("Discount received for the selected shoe : " +driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());

		File showImg = driver.findElement(By.xpath("(//div[@class='bx-viewport'])[2]")).getScreenshotAs(OutputType.FILE);
		File destName = new File("./screenshots/snapdealShoe.jpg");
		FileUtils.copyFile(showImg, destName);
		System.out.println("Screenshot taken!!!");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		Thread.sleep(3000);
		//driver.quit();
	}

}
