package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {
@Test
	public void createCustomerTest()
	{
		System.out.println("this is tc 1-customer is created");//passed
	}
@Test
public void modifyCustomerTest()
{
	System.out.println("this is tc 2-customer is modified");//passed

}
@Test(enabled=false)
public void deleteCustomerTest()
{
Assert.fail();
System.out.println("this is tc 3-customer is deleted");
}
}
