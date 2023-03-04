package demo;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateUserNegativeScenario {
	
	
	WebDriver driver;
	SoftAssert assert1 = new SoftAssert();

//		String randomEmail = RandomStringUtils.randomAlphabetic(8);
//		String Email = randomEmail + "@gmail.com";
		// System.out.println(Email);

		@BeforeClass
		public void launch_app() {
		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		// driver.get("https://dev.modeler2.decisionsfirst.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		@Test (priority = 1)
		public void launch_app1() throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		Thread.sleep(2000);
		}
		
		@Test (priority = 2)
		public void launch_app2() throws InterruptedException {

		driver.findElement(By.xpath("//span[@class='item-text'][normalize-space()='Account Manager']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Users & Groups')]")));

		// click on plus-icon
		driver.findElement(By.xpath("//div[@class='plus-icon']//i[@class='eva eva-plus-circle-outline']")).click();
		Thread.sleep(4000);

		// enter first name
		driver.findElement(By.xpath("//*[@id='firstName']/quill-editor/div[2]/div[1]")).sendKeys("Demo");

		// enter first name
		driver.findElement(By.xpath("//*[@id='lastName']/quill-editor/div[2]/div[1]")).sendKeys("Test");

		// enter email
		driver.findElement(By.xpath("//*[@id='email']/quill-editor/div[2]/div[1]")).sendKeys("test_claim2@gmail.com");

		// select type
		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div[2]/div[2]/div/nb-dialog-container/dfm-add-user/nb-card/form/div[4]/select"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div[2]/div[2]/div/nb-dialog-container/dfm-add-user/nb-card/form/div[4]/select/option[1]"))
				.click();
		Thread.sleep(1000);

		// click on add user
		driver.findElement(By.xpath("//button[normalize-space()='Add User']")).click();

		// Success message
		String msg = driver.findElement(By.xpath("//div[@class='content-container']")).getText();
		System.out.println("The message after creating diagram is : " + msg);

		System.out.println("<<<User created>>>");

		// click on logout
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
			//	.click();
		//driver.findElement(By.xpath("//span[normalize-space()='Log Out']")).click();

//		System.out.println("<<<Diagram created>>>");
		
//		SoftAssert assert1 = new SoftAssert();
//		assert1.
		
		

	}

}
