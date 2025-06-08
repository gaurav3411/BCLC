package Class_file;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class casino_page extends abstract_usable {

	public casino_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void select_game()
	{
		
	}

}
