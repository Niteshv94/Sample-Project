package demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumDriverCommandExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;

public class CaptureNetworkResponsesAndStatus {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		WebDriver driver;

//		String randomEmail = RandomStringUtils.randomAlphabetic(8);
//		String Email = randomEmail + "@gmail.com";
		// System.out.println(Email);

		
		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		//ChromiumDriver driver = new ChromiumDriver(null, null, null);
		 driver = new ChromeDriver();
		//EdgeDriver driver = new EdgeDriver();

		driver.get("https://qa.modeler2.decisionsfirst.com/login");
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
		
		//Validate User Email
		Thread.sleep(5000);
		WebElement validateEmail = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-account-manager-container/nb-card/div/div[1]/div/div[2]/dfm-account-manager-user-grid/div/div[2]/div/wj-flex-grid/div[1]/div[1]"));
		String expectedEmailText = "validate1email@gmail.com";
        String actualEmailText  = validateEmail.getText();
        System.out.println(actualEmailText);
        
        if (actualEmailText.contains(expectedEmailText)) {
        	
        	System.out.println("Email available");
			
		} else {
			
			System.out.println("Email not available");

		}
        System.out.println("<<<User created>>>");
        
        //log file
        
        // establish and open connection with URL
        HttpURLConnection cn= (HttpURLConnection)new URL("https://qa.api.decisionsfirst.com//administration/accounts/3118e513-d8f0-4e3d-8681-aed620305345/users").openConnection();
        // set the HEAD request with setRequestMethod
        cn.setRequestMethod("HEAD");
        // connection initiated and obtain status code
        cn.connect();
        int c = cn.getResponseCode();
        System.out.println("Http status code: " + c);


		

/*		// click on logout
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		driver.findElement(By.xpath("//span[normalize-space()='Log Out']")).click();
		// driver.navigate().refresh();

		// Creating diagram
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='addDiagram']")).click();

		driver.findElement(By.xpath("//*[@id=\"diagramName\"]/quill-editor/div[2]/div[1]")).sendKeys("Demo Test");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Select Project']")).click();
		driver.findElement(By.xpath("//nb-option[contains(text(),'A test2')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Select Folder']")).click();
		driver.findElement(By.xpath("//nb-option[contains(text(),'test')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Add Diagram']")).click();
		Thread.sleep(7000);

//		String msg1 = driver.findElement(By.xpath(
//				"//nb-toast[@class='ng-tns-c63-0 ng-trigger ng-trigger-fadeIn status-success destroy-by-click has-icon custom-icon ng-star-inserted']"))
//				.getText();
//		System.out.println("The message after creating diagram is : " + msg1);

		// link objects diagram
		driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
		Thread.sleep(2000);

		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div[1]/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[3]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));

		WebElement LINKS = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div[1]/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[3]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[1]"));

		WebElement target = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div[1]/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[3]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div/canvas"));

		// Knowledge Source data 1
		act.moveToElement(src, 15, 5);
		act.clickAndHold().moveByOffset(15, 5);
		act.moveToElement(src, 250, 70);
		act.moveToElement(target, 250, 70);
		act.release();
		act.perform();
		Thread.sleep(4000);

		// Decision Source data 1
		act.moveToElement(src, -56, 5);
		act.clickAndHold().moveByOffset(-56, 5);
		act.moveToElement(src, 150, 70);
		act.moveToElement(target, 150, 70);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Input Source data 1
		act.moveToElement(src, -30, 5);
		act.clickAndHold().moveByOffset(-30, 5);
		act.moveToElement(src, 300, -50);
		act.moveToElement(target, 300, -50);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// click Authority Links
		act.moveToElement(LINKS, 10, 20);
		act.click().build().perform();
		Thread.sleep(2000);

		// creating the connection with links between Decision data 1 & Knowledge Source
		act.moveToElement(target, 155, 75);
		act.clickAndHold().moveByOffset(155, 75);
		act.moveByOffset(255, 65);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// creating the connection with links between Input Source & Knowledge Source
		// data 1
		act.moveToElement(target, 180, -45);
		act.clickAndHold().moveByOffset(180, -45);
		act.moveByOffset(-100, 70);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// click Information Links
		act.moveToElement(LINKS, -43, 20);
		act.click().build().perform();
		Thread.sleep(2000);

		// creating the connection with links between Input Source & Decision data 1
		act.moveToElement(target, 180, -45);
		act.clickAndHold().moveByOffset(180, -45);
		act.moveByOffset(-250, 70);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// click Knowledge Source data 1
		act.moveToElement(target, 255, 75);
		act.click().build().perform();
		Thread.sleep(3000);

		// update Knowledge Source data 1
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).sendKeys("Knowledge new name Updated");
		Thread.sleep(2000);

		// click Input Source data 1
		act.moveToElement(target, 305, -45);
		act.click().build().perform();
		Thread.sleep(3000);

		// update Input Source data 1
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).sendKeys("Input new name Updated");
		Thread.sleep(2000);

		// click Decision Source data 1
		act.moveToElement(target, 155, 75);
		act.click().build().perform();
		Thread.sleep(3000);

		// update Decision Source data 1
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).sendKeys("Decision new name Updated");
		Thread.sleep(2000);

		act.moveToElement(LINKS, -14, 120);
		act.click().perform();

		System.out.println("<<<Diagram created>>>");*/
//		driver.
		

	}

}
