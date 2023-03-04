package demo;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestResponseCode {
	
	public static void main(String[] args) throws InterruptedException
    {
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
        driver = new ChromeDriver(capabilities);
		//WebDriver driver = new ChromeDriver(capabilities);
		driver.get("https://qa.modeler2.decisionsfirst.com/");
		String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
		System.out.println(netData);
		
		
       // driver.get("https://dev.modeler2.decisionsfirst.com/");
        
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='item-text'][normalize-space()='Account Manager']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Users & Groups')]")));
    }

   

}
