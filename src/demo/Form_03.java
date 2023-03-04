package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form_03 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='item-text'][normalize-space()='Account Manager']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='plus-icon']//i[@class='eva eva-plus-circle-outline']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='firstName']/quill-editor/div[2]/div[1]")).sendKeys("Nitesh12");
		driver.findElement(By.xpath("//*[@id='lastName']/quill-editor/div[2]/div[1]")).sendKeys("Kumar12");
		driver.findElement(By.xpath("//*[@id='email']/quill-editor/div[2]/div[1]")).sendKeys("Nitesh12345@gmail.com");
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div[2]/div[2]/div/nb-dialog-container/dfm-add-user/nb-card/form/div[4]/select"));
		Select select = new Select(element);
		select.selectByValue("STANDARD");

		driver.findElement(By.xpath("//button[normalize-space()='Add User']")).click();

		String msg = driver.findElement(By.xpath("//div[@class='content-container']")).getText();
		System.out.println("The message after creating User : " + msg);

	}

}
