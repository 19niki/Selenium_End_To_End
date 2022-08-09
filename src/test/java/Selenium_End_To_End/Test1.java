package Selenium_End_To_End;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Test1  {
	 

	public WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void beforeTest()
	{
           System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");  
           driver = new ChromeDriver();
           driver.get("https://courses.letskodeit.com/practice");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
  @Test (priority = 1)
  public void radiobutton() 
  {
	  WebElement radio = driver.findElement(By.id("benzradio"));
	  radio.click();
	  List <WebElement>list_radio = driver.findElements(By.xpath("//fieldset/label/input[@type='radio']"));
	  for(WebElement w: list_radio)
	  {
		  
		  System.out.println(w.getAttribute("value"));
	  }
	  
	  
	  
  }
  
  @Test (priority = 2)
  public void dropDown() {
	
	 WebElement list = driver.findElement(By.id("carselect"));
	  Select drop = new Select(list);
	  drop.selectByValue("honda");
	  List<WebElement> list_drop = driver.findElements(By.xpath("//select[@id = 'carselect']/option"));
	  System.out.println("===============Dropdown=============");
	  for(WebElement w: list_drop)
	  {
		  
		  System.out.println(w.getText());
	  }
	  
  }
  /*
  @Test
 public void switchwindows() {
	 
	 String parent = driver.getWindowHandle();
	 driver.findElement(By.id("openwindow")).click();
	 
	 Set<String> s =driver.getWindowHandles(); 
	 Iterator<String> il = s.iterator();
	 while(il.hasNext())
	 {
		String child = il.next(); 
	 
	 if(!parent.equals(child))
	 {
		driver.switchTo().window(child); 
		driver.findElement(By.linkText("ALL COURSES")).click();
		driver.close();
		driver.switchTo().window(parent);
	 }
	 
 }
	 }
 */
  @Test (priority = 3)
  public void alert() {
	  
	  driver.findElement(By.id("name")).sendKeys("Nikhil");
	  driver.findElement(By.id("alertbtn")).click();
	  String alert_text = driver.switchTo().alert().getText();
	  System.out.println("alert text:"+ alert_text);
	  driver.switchTo().alert().accept();
  }
  
  @Test (priority = 4)
  public void mousehover() {
	  Actions a= new Actions(driver);
	  a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
  }
  
 
  
  @AfterTest
  public void afterTest() 
  { 
	driver.close();
  }

}
