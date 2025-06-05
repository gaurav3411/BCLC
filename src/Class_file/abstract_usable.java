package Class_file;

import java.time.Duration;

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

}
