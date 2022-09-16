package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like a implentation class to override all methods
 * present in Itestlistener interface
 * @author Pawan
 *
 */
public class ListenerImplementation implements ITestListener {
ExtentReports report;
ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);//test is created which will intilialize the individual test
		//Reporter.log(methodName+"=>test script execution started",true);
		
		}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		//Reporter.log(methodName+"=> is passed",true);
test.log(Status.PASS, methodName+"---> passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		webDriverUtility wlib=new webDriverUtility();
		javaUtility jLib=new javaUtility();
		//String msg=result.getThrowable().toString();
		String methodName=result.getMethod().getMethodName();
		String screenShotName=methodName+"-"+jLib.getSystemDateInFormat();
		//This will log in report and console
		test.log(Status.FAIL, methodName+"--->Failed");
		test.log(Status.FAIL,result.getThrowable());
	//	Reporter.log(methodName+"=> is failed because =>"+msg,true);
		try {
			//wlib.takeScreenShot(BaseClass.sdriver,screenShotName);
			String path=wlib.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);//navigate to screenshot path and attach it to the report
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//String msg=result.getThrowable().toString();

		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		//Reporter.log(methodName+"=> is skipped because=>"+msg,true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method 
//start of suite execuion
		/*Configure extent reports*/
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new javaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-5-Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser","Chrome");
		report.setSystemInfo("Base-platform","Windows");
		report.setSystemInfo("Base-URL","http://localhost:8888");
		report.setSystemInfo("Reporter Name","Chaira");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//End of Suite execution
		report.flush();//consolidate all the test script execution and dump the status into report
		
	}

}
