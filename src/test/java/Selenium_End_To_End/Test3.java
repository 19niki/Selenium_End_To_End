package Selenium_End_To_End;

import java.security.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
	
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
	
  @Test
  public void openlinksSeprateTabs() 
  {
	  WebElement footer = driver.findElement(By.xpath("//div[@data-zen='zen_footer_dynamic'][1]"));
	  List<WebElement> links = footer.findElements(By.tagName("a"));
	  System.out.println(links.size());
	  
	  for(WebElement w: links)
	  {
		  String key = Keys.chord(Keys.CONTROL, Keys.ENTER);
		  w.sendKeys(key);
	  }
	  
	  Set<String> tabs=driver.getWindowHandles();
	  Iterator<String> il = tabs.iterator();
	  String parent = driver.getWindowHandle();
	  while(il.hasNext())
	  {
		String child = il.next();
		if(!parent.equals(child))
		{
			driver.switchTo().window(child);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(parent);
		}
	  }
	  
  }

  

@AfterTest
public void close() {
	driver.close();
}
}