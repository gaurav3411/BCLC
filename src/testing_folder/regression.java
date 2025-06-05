 package testing_folder;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Class_file.deposit_page;
import Class_file.login_page;
import Class_file.main_page_login;


public class regression extends base_test {
	//String name="Hi, Evelynsdfsf";
	@Test(dataProvider="Load", groups="regression")
	public void test(String username,String password, String welcome, String Deposit) throws InterruptedException, IOException
	{
		//extent_report();
		//extent.createTest("initial demo");
		initialization();
		main_page_login obj1= new main_page_login(driver);
		obj1.mainpage_to_login_flow();
		
		//String profile=obj1.mainpage_to_login_flow();
		
		login_page obj2= new login_page(driver);
		obj2.Enter_username_password(username, password);
		
		deposit_page obj3= new deposit_page(driver);
		Assert.assertEquals(obj3.welcomet_message(), welcome, "welcome message fail");
		Assert.assertEquals(obj3.depositmethod_message(), Deposit, " Deposit method are incorrect for BC");
		
		
		//Assert.assertEquals(name,profile,"TestPass");
		
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
