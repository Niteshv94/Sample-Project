package demo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobutton {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test_claim2@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='item all-tags-tab']//span[contains(text(),'Tag Explorer')]")).click();
		
		driver.findElement(By.xpath("//div[@class='tags-tree-title']//i[@class='eva eva-plus-circle-outline']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Add Project')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='name']//p")).sendKeys("test claim");
		
		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='description']//p")).sendKeys("gmailcome");
		
		driver.findElement(By.xpath("//nb-radio[@id='item-disableBranching']//span[@class='text']")).click();
		
		
//		List<WebElement> radio	=	driver.findElements(By.xpath("//input[@type='radio' and @name='branching']"));
//		
//		for (int i=0;i<radio.size();i++) {
//			
//			WebElement lcl_radio = radio.get(i);
//		String value = lcl_radio.getAttribute("value");
//			
//		System.out.println(value);
//		if (value.equalsIgnoreCase("enableSimpleBranching")) {
//			
//			lcl_radio.click();
//			break;
//			
//		}
//		
//		
//			
//		}
		
		

	}

}
