package Class_file;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class login_page extends abstract_usable {
	WebDriver driver;
	String profile;
	
	public login_page(WebDriver driver)
	{super(driver);
		this.driver=driver;
		this.driver.switchTo().frame(0); //login page is create using i frame
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='IDToken1']")
	 WebElement username_field;
	
	@FindBy(xpath="//input[@id='IDToken2']")
	WebElement password_field;
	
	@FindBy(xpath="//button[@class='frl-active-btn frl-submit-btn']")
	WebElement login_button;
	
	@FindBy(xpath="//a[@class='user-controls__button']")
	WebElement action_button;
	//@FindBy(xpath="//span[@class='user-session-bar__player-name-text']")
	//WebElement profilename;
	
	@FindBy(xpath="//a[@class='user-session-bar__account-link user-session-bar__account-link_deposit']")
	WebElement Deposit_button;
	
	public void Enter_username_password(String user, String Pass) throws InterruptedException
	{
		username_field.sendKeys(user);
		password_field.sendKeys(Pass);
		login_button.click();
		driver.switchTo().defaultContent(); //taking out from i frame
		wait_element_visible(action_button, 0);
		//Thread.sleep(3000);
		action_button.click();
		Deposit_button.click();
		//profile=profilename.getText();
		//return profile;
		
		
		
        

	}

}
