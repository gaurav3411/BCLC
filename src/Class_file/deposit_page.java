package Class_file;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deposit_page extends abstract_usable {
	WebDriver driver;
	
	public deposit_page(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//div[@class='deposit-method-card__details']")
WebElement debit_tile;

@FindBy(xpath="(//small)[2]")
WebElement welcome;
@FindBy(xpath="//h1[@class='deposit__header-title-text']")
WebElement Depsoit_message;

@FindBy(xpath="//a[@class='user-controls__button']")
WebElement action_button;

	public String welcomet_message()
	{
		wait_element_visible(action_button, 5);
		
		action_button.click();
		wait_element_visible(welcome, 5);
		String welcome_m=welcome.getText();
	
		return welcome_m;
				
		
	}
	
	public String depositmethod_message()
	{
		
		String Deposit_m=Depsoit_message.getText();
		return Deposit_m;
				
		
	}
	

}
