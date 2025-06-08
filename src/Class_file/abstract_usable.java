package Class_file;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class abstract_usable {
	
	WebDriver driver;
	
	
	public abstract_usable (WebDriver driver)
	{
		this.driver=driver;
	}
	public void wait_element_visible(WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void MFA_handle(WebElement element, WebElement elment2)
	 {
		try
		{
		if(element.isDisplayed())
		
		{driver.switchTo().frame(0);
		elment2.click();
			driver.switchTo().defaultContent();
		}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println("NO MFA");
			
		}
	 }

}
