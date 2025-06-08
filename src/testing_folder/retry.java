package testing_folder;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry extends base_test implements IRetryAnalyzer {
	int count=0;
	int attempt=2;
	@Override
	public boolean retry(ITestResult result) {
		if(count<attempt)
		{
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
