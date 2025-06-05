package testing_folder;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listners extends base_test implements ITestListener {
	ExtentTest test;
	ExtentReports extent=extent_report();
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("on test start");
		test=extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("on test fail");
		test.fail(result.getMethod().getMethodName());
		String path= null;
		try {
			path=Screesnhot(result.getMethod().getMethodName());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new SkipException("Billing API is down. Skipping UI test.");
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("on test Success");
		
	}
	
	@Override
	public void onFinish(ITestContext result)
	{
		System.out.println("on test finish");
		extent.flush();
	}

}
