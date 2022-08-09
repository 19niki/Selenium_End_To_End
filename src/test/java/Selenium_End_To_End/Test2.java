package Selenium_End_To_End;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void beforeTest()
	{
		   ChromeOptions op = new ChromeOptions();
		   op.addArguments("Headless");
           System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");  
           driver = new ChromeDriver(op);
           driver.get("https://courses.letskodeit.com/practice");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           
	}
	 @Test (priority = 1)
	  public void iframe() {
		  driver.switchTo().frame("courses-iframe");
		  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search"))));
		//  driver.findElement(By.id("search")).sendKeys("java");
		  driver.switchTo().defaultContent();
	  }
	 
	 @Test (priority = 2)
	 public void webTable() 
	 {
         List<WebElement> table =driver.findElements(By.xpath("//tbody/tr/td[3]"));	
         int sum=0;
         for(WebElement w:table)
         {
        	 
              int row=Integer.parseInt(w.getText());
              System.out.println(row);
              sum = sum+row;
              
         }
         System.out.println(sum);
	 }
	 @AfterTest
	 public void close() {
		 driver.close();
	 }
}
