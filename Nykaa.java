package week5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.nykaa.com/");

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//div[@id='headerMenu']//li/a[text()='brands']"))).perform();
		builder.moveToElement(driver.findElement(By.linkText("L'Oreal Paris"))).click().perform();

		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println(driver.getTitle() + " -Page landed successfully!!!");
		}

		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//h2[@title=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"product-list-wrap\"]/div[1]/div/div[1]/a/div[1]/img")).click();

		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);

		driver.switchTo().window(windowsList.get(1));
	   //System.out.println("Size of the selected bottle : " + driver
				//.findElement(By.xpath("//label[contains(@class,'selected')]//span[@class='size-pallets']")).getText());

		//System.out.println("Price of the selected bottle : " + driver
			//	.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText().replace("?", ""));
         
		//step1"
		WebElement dropDown1= driver.findElement(By.xpath("//select[@title='SIZE']"));
		//step2
		Select drop1= new Select(dropDown1);
		drop1.selectByVisibleText("175ml");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();

		String totalCheck = driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div")).getText();
	    System.out.println("Grand Total : " + totalCheck);

		Thread.sleep(8000);

		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		if (totalCheck.equals(driver.findElement(By.xpath("//div[text()='Grand Total']")).getText())) {
			System.out.println("Total Amount verified!!!");
		}

		}
}