package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItemClick {

	WebDriver driver;
	//public static String cName = "Test Hanging demo";
	public static String cName = "DoNotDelete";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://devproductcatalog.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nitesh.k@trezi.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Niteshvats@94");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M3 18h18v-')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Settings']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Product Clusters')]")).click();
		Thread.sleep(8000);

//		try {
//
//			for (int r = 1; r < 11; r++) {
//				String xpath = "//tbody/tr[" + r + "]/td[2]/div[1]";
//				String a = driver.findElement(By.xpath(xpath)).getText();
//				// System.out.println(a);
//
//				if (a.contains(cName)) {
//					Thread.sleep(5000);
//					String xpath1 = "//tbody/tr[" + r + "]/td[2]/div[1]";
//					driver.findElement(By.xpath(xpath1)).click();
//
//				}
//
//			}
//
//		} catch (Exception e) {
//			System.out.println("__________________________");
//		}
		
		for(int r=2; r<71; r++)
		{
			String xpath = "//*[@id='root']/div[2]/div[3]/div/div[3]/div[2]/div[2]/div[2]/div/div[" + r + "]";
			String a = driver.findElement(By.xpath(xpath)).getText();
			
			if(a.contains(cName))
			{
				Thread.sleep(3000);
				String xpath1 = "//div[@class='sc-fznKkj fQkkzS']//div[2]//div[2]//div[1]//div[" + r + "]//div[1]//div[1]//div[1]//span[1]//*[name()='svg']";
				driver.findElement(By.xpath(xpath1)).click();
			}
		}
		
		driver.findElement(By.xpath("//li[contains(text(),'Edit')]")).click();

	}

}
