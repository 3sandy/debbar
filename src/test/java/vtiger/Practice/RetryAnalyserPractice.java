package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	@Test(retryAnalyzer=vtiger.GenericUtility.RetryAnalyzerImplementation.class)
	public void retryPractice()
	{
		System.out.println("hi");
		Assert.fail();
	}

}
