package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumDriverCommandExecutor;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v89.network.model.Request;
import org.openqa.selenium.devtools.v90.network.Network;
import org.openqa.selenium.devtools.v91.browser.Browser;
import org.openqa.selenium.devtools.v91.browser.model.Bounds;
import org.openqa.selenium.devtools.v91.browser.model.WindowID;
import org.openqa.selenium.devtools.v91.browser.model.WindowState;
import org.openqa.selenium.devtools.v91.log.Log;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkLog {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

	     
		DevTools devTools = ((ChromiumDriver) driver).getDevTools();

	      devTools.createSession();

	      devTools.send(Log.enable());
	      devTools.send(Browser.setWindowBounds(new WindowID(1), new Bounds(
	         Optional.of(20),
	         Optional.of(20),
	         Optional.of(20),
	         Optional.of(20),
	         Optional.of(WindowState.NORMAL))));
	      
	      driver.get("https://qa.modeler2.decisionsfirst.com/");
	      driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
			driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
			Thread.sleep(8000);

	      driver.quit();
	   }

}
