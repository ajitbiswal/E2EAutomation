package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

//Inheriting the base class
public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	
	//to make it thread safe for parallel execution
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentReports extent=ExtentReporterNG.getReportObject();
	
	

	@Override
	public void onTestStart(ITestResult result) {
		
		//on start of the test the method will be logged to extent reports
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		//create a dummy driver
		WebDriver driver = null;
	 String testmethodname = result.getMethod().getMethodName();
	 try {
		//passing the real driver from that test cases or methods 
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
	 {
		
	 }
	 try {
		 extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testmethodname,driver),result.getMethod().getMethodName());
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
