package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Highlight {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://qa.modeler2.decisionsfirst.com/login");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		
		  
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
			driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[1]/dfm-home-container/nb-card/div/div[2]/dfm-infinite-search-list/nb-list/nb-list-item[1]/dfm-preview-container/div/dfm-search-list-item/div/div/span")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
			Thread.sleep(4000);
			
			// Create the  JavascriptExecutor object
			  JavascriptExecutor js=(JavascriptExecutor)driver;
			
			// find element using id attribute
			 // WebElement link = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[1]/dfm-go-js-links-palette/div"));
			  
			// find element using id attribute
				 // WebElement link = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));
				  
				// find element using id attribute
				  WebElement link = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));
			  
			 // call the executeScript method
			  js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", link);


	}

}
