package testing_folder;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Class_file.deposit_page;
import Class_file.login_page;
import Class_file.main_page_login;

public class casino_test extends base_test {
	
	@Test(dataProvider="casino_Load", groups="regression", retryAnalyzer=retry.class)
	public void casino_flow(String username,String password) throws InterruptedException, IOException
	{
		
		initialization();
		main_page_login obj1= new main_page_login(driver);
		obj1.mainpage_to_login_flow();
		
		login_page obj2= new login_page(driver);
		obj2.Enter_username_password(username, password);
		obj2.navigate_casino();
		
		//driver.close();
	}

}
