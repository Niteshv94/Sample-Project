package demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpException;
import org.apache.http.protocol.HttpContext;
import org.asynchttpclient.proxy.ProxyServer;
import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.devtools.v91.network.model.Request;
import org.openqa.selenium.devtools.v91.network.model.Response;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StatusCode {

	static WebDriver driver;
	    int statusCode;

	    public void checkBrokenLinks() {
	    	System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://qa.modeler2.decisionsfirst.com/");

	        //Get all the links on the page
	        List<WebElement> links = driver.findElements(By.cssSelector("a"));

	        String href;

	        for(WebElement link : links) {
	            href = link.getAttribute("href");
	            statusCode = new StatusCode().httpResponseCodeViaGet(href);

	            if(200 != statusCode) {
	                System.out.println(href + " gave a response code of " + statusCode);
	            }
	        }
	    }

	    private int httpResponseCodeViaGet(String href) {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void main(String args[]) throws InterruptedException {
	        new StatusCode().checkBrokenLinks();
		

		//driver.get("https://qa.modeler2.decisionsfirst.com/login");
//		 try {
//			driver.get("https://dev.modeler2.decisionsfirst.com/");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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

		// click on plus-icon
		driver.findElement(By.xpath("//div[@class='plus-icon']//i[@class='eva eva-plus-circle-outline']")).click();
		Thread.sleep(4000);

		// enter first name
		driver.findElement(By.xpath("//*[@id='firstName']/quill-editor/div[2]/div[1]")).sendKeys("Demo");

		// enter first name
		driver.findElement(By.xpath("//*[@id='lastName']/quill-editor/div[2]/div[1]")).sendKeys("Test");

		// enter email
		driver.findElement(By.xpath("//*[@id='email']/quill-editor/div[2]/div[1]")).sendKeys("validateemail@gmail.com");

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

		// Validate User Email
		Thread.sleep(5000);
		WebElement validateEmail = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-account-manager-container/nb-card/div/div[1]/div/div[2]/dfm-account-manager-user-grid/div/div[2]/div/wj-flex-grid/div[1]/div[1]"));
		String expectedEmailText = "validateemail@gmail.com";
		String actualEmailText = validateEmail.getText();
		System.out.println(actualEmailText);

		if (actualEmailText.contains(expectedEmailText)) {

			System.out.println("Email available");

		} else {

			System.out.println("Email not available");

		}
		System.out.println("<<<User created>>>");
}
	}


