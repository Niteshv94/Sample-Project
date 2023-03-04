package demo;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinkingObjects2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		// driver.get("https://dev.modeler2.decisionsfirst.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		// Thread.sleep(8000);

		driver.findElement(By.xpath(
				"//nb-list-item[1]//dfm-preview-container[1]//div[1]//dfm-search-list-item[1]//div[1]//div[1]//span[1]//span[1]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
		Thread.sleep(4000);

		Actions act = new Actions(driver);

		WebElement src = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));

		WebElement LINKS = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[1]"));

		WebElement target = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));

		// Knowledge Source data 1
		act.moveToElement(src, 10, 5);
		act.clickAndHold().moveByOffset(10, 5);
		act.moveToElement(src, 250, 70);
		act.moveToElement(target, 250, 70);
		act.release();
		act.perform();
		Thread.sleep(4000);

		// Knowledge Source data 2
		act.moveToElement(src, 10, 5);
		act.clickAndHold().moveByOffset(10, 5);
		act.moveToElement(src, 150, 70);
		act.moveToElement(target, 150, 70);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// Decision data 1
		act.moveToElement(src, -56, 5);
		act.clickAndHold().moveByOffset(-56, 5);
		act.moveToElement(src, 100, -50);
		act.moveToElement(target, 100, -50);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// click Authority Links
		act.moveToElement(LINKS, 10, 20);
		act.click().build().perform();
		Thread.sleep(2000);

		// creating the connection with links between Knowledge Source
		act.moveToElement(target, 155, 75);
		act.clickAndHold().moveByOffset(155, 75);
		act.moveByOffset(105, -45);
		act.release();
		act.perform();
		Thread.sleep(2000);

		System.out.println("<<<Diagram created>>>");

	}

}
