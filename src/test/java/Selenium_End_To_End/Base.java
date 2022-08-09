package Selenium_End_To_End;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	public WebDriver driver;
	
	By radio = By.id("benzradio");
	By list_radio = By.xpath("//fieldset/label/input[@type='radio']");
	
	public Base(WebDriver driver) {
		this.driver =driver;
	}
	
	
	public void radiobutton() {
		
		driver.findElement(radio).click();
		List <WebElement> radio= driver.findElements(list_radio);
		for (WebElement w: radio)
		{
			System.out.println(w.getText());
		}
	}
}
