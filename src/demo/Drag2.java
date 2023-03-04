package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Drag2 {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://qa.modeler2.decisionsfirst.com/login");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
			driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
			
			driver.findElement(By.xpath("//nb-list-item[1]//dfm-preview-container[1]//div[1]//dfm-search-list-item[1]//div[1]//div[1]//span[1]//span[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
			Thread.sleep(4000);
			
//			WebElement src  = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));
//			
//			WebElement trget  = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));

			  Actions actions = new Actions(driver);
//			    actions.moveToElement(src, 65, 75);
//			    actions.clickAndHold();
//			    //Dragging selected node a little bit to make it work. 
//			    actions.moveToElement(src, 65, 75+50 );
//			    //Now perform the actual move
//			    actions.moveToElement(trget, 40 , 50);
//			    actions.release();
//			    actions.perform();
			  
			  WebElement theDivElement  = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[1]/dfm-go-js-links-palette/div"));
				
			  WebElement flowCanvas  = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));
			 
			
	}

}
