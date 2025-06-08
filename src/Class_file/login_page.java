package Class_file;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath="//a[@class='user-session-bar__account-link user-session-bar__account-link_deposit']")
	WebElement Deposit_button;
	
	@FindBy(xpath="//button[text()=\"Skip for now\"]")
	WebElement skip;
	
	@FindBy(xpath="//iframe[@id='login-frame]")
	WebElement frames;
	
	@FindBy(xpath="//a[contains(text(), \"Casino\")]")
	WebElement casino;
	
	
	public void Enter_username_password(String user, String Pass) throws InterruptedException
	{
		username_field.sendKeys(user);
		password_field.sendKeys(Pass);
		login_button.click();
		driver.switchTo().defaultContent(); //taking out from i frame
		
		
		MFA_handle(frames,skip);
		
		
	
	}
	
	public void navigate_deposit()
	{
wait_element_visible(action_button, 5);
		
		
		action_button.click();
		Deposit_button.click();
	}
	
	public void navigate_casino() throws InterruptedException
	{
System.out.println("inside navigate_casino()");
//Thread.sleep(5000);
		wait_element_visible(casino, 10);
		casino.click();
	}

}
