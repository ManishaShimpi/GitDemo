package E2ETestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryonce implements IRetryAnalyzer
{
	int count = 0;
	int maxTry = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry)
		{
			count++;
			result.setStatus(ITestResult.SKIP); 
			return true;
		}
		return false;
	}


}
