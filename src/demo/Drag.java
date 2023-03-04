package demo;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class Drag {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://qa.modeler2.decisionsfirst.com/login");
		driver.get("https://dev.modeler2.decisionsfirst.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim13@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		// Thread.sleep(8000);

//			driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//div[@id='addDiagram']")).click();
//			Thread.sleep(3000);

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

		WebElement trget = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));

		WebElement target1 = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div/canvas"));
		WebElement target2 = driver.findElement(By.xpath(
				"//*[@id=\"tab-container\"]/li[2]/div"));
		
		// Decision data
		act.moveToElement(src, -56, 5);
		act.clickAndHold().moveByOffset(-56, 5);
		act.moveToElement(src, 5, -45);
		act.moveToElement(trget, 5, -45);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Decision data
//		act.moveToElement(src, -56, 5);
//		act.clickAndHold().moveByOffset(-56, 5);
//		act.moveToElement(src, 15, -45);
//		act.moveToElement(trget, 15, -45);
//		act.release();
//		act.perform();
//		Thread.sleep(3000);

		// Input data
		act.moveToElement(src, -50, 5);
		act.clickAndHold().moveByOffset(-50, 5);
		act.moveToElement(src, 450, 10);
		act.moveToElement(trget, 450, 10);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Input data
//		act.moveToElement(src, -50, 5);
//		act.clickAndHold().moveByOffset(-50, 5);
//		act.moveToElement(src, 300, 10);
//		act.moveToElement(trget, 300, 10);
//		act.release();
//		act.perform();
//		Thread.sleep(3000);

		// Knowledge Source data
//		act.moveToElement(src, 10, 5);
//		act.clickAndHold().moveByOffset(10, 5);
//		act.moveToElement(src, 250, 70);
//		act.moveToElement(trget, 250, 70);
//		act.release();
//		act.perform();
//		Thread.sleep(4000);

		// act.moveByOffset(5, -45).contextClick().perform();
		
		//LINKS clicK Authority		
//		act.moveToElement(LINKS, 10, 20);
//		act.contextClick().perform();
//		Thread.sleep(2000);
		
//		act.moveToElement(LINKS, 10, 20);
//		act.clickAndHold().moveByOffset(10, 20);
//		act.moveToElement(LINKS, 250, 70);
//		act.moveToElement(trget, 250, 70);
//		act.contextClick();
//		act.release();
//		act.perform();
//		
		
		//LINKS clicK Annotation		
//				act.moveToElement(LINKS, 14, 20);
//				act.contextClick().perform();
//				Thread.sleep(2000);
		
		//dragging on the canvas
		act.moveToElement(trget, 455, 15);
		act.clickAndHold().moveByOffset(455, 15);
		act.moveToElement(trget, 300, 10);
		act.moveToElement(trget, 300, 10);
		act.release();
		act.perform();
		
		//act.clickAndHold(trget).moveByOffset(5, -45).moveToElement(target1, 250, 70).release().build().perform();
		
		//right Click
		//act.moveToElement(trget, 5, -45).contextClick(target1).build().perform();
		//act.moveToElement(target2).contextClick().perform();
	//	act.moveToElement(trget,5, -45).contextClick().perform();
		
		
		//Dragging objects
		//act.dragAndDropBy(trget, 250, 70).clickAndHold().perform();

		System.out.println("done");

	}

}
