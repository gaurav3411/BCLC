 package testing_folder;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Class_file.deposit_page;
import Class_file.login_page;
import Class_file.main_page_login;


public class depositflow_debit extends base_test {

	@Test(dataProvider="Load", groups="regression", retryAnalyzer=retry.class)
	public void debit_flow(String username,String password, String welcome, String Deposit) throws InterruptedException, IOException
	{
		
		initialization();
		main_page_login obj1= new main_page_login(driver);
		obj1.mainpage_to_login_flow();
		
		login_page obj2= new login_page(driver);
		obj2.Enter_username_password(username, password);
		obj2.navigate_deposit();
		
		deposit_page obj3= new deposit_page(driver);
		Assert.assertEquals(obj3.welcomet_message(), welcome, "welcome message fail");
		Assert.assertEquals(obj3.depositmethod_message(), Deposit, " Deposit method are incorrect for BC");
		driver.close();
	}
	
	@Test(groups="smoke")
	public void test2()
	{
	System.out.println("smoke group");
	}
	
	@Parameters({"Test_Paramneter"})
	@Test(groups="regression")
	public void test3(String param)
	{
	System.out.println("regression group");
	System.out.println(param);
	
	}
}
