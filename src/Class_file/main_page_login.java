package Class_file;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class main_page_login extends abstract_usable{
	WebDriver driver;

	
	public main_page_login(WebDriver driver)
	{super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class='main-nav-links__login-button']")
	public WebElement login_button;
	
	
	public void mainpage_to_login_flow() throws InterruptedException
	{ 
		login_button.click();
		Thread.sleep(4000);
		
		
	}

}
