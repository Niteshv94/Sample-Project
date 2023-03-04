package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form_02 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@id='addDecision']")).click();

		driver.findElement(By.xpath("//*[@id='decisionName']/quill-editor/div[2]/div[1]")).sendKeys("Decision");

		driver.findElement(By.xpath("//*[@id='decisionDescription']/quill-editor/div[2]/div[1]"))
				.sendKeys("Description");

		WebElement element = driver.findElement(By.xpath("//*[@id='decisionType']"));
		Select select = new Select(element);
		select.selectByValue("TACTICAL");

		driver.findElement(By.xpath("//*[@id='decisionUrl']")).sendKeys("www.demo.com");

		driver.findElement(By.xpath("//*[@id='decisionQuestion']/quill-editor/div[2]/div[1]")).sendKeys("Yes");

		driver.findElement(By.xpath("//button[normalize-space()='Select Project']")).click();
		driver.findElement(By.xpath("//nb-option[contains(text(),'A test2')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Select Folder']")).click();
		driver.findElement(By.xpath("//nb-option[contains(text(),'test')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Add decision']")).click();

		String msg = driver.findElement(By.xpath(
				"//div[@class='content-container']"))
				.getText();
		System.out.println("The message after creating decision : " + msg);

	}

}
