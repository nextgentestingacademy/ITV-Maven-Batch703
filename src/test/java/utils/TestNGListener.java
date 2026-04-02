package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class TestNGListener extends BaseClass implements ITestListener{
	
	ExtentReports extent;//create a blank HTML report
	
	ExtentTest test;//represent each @Test annotation as a separate Test case
	
	//this will ensure that reports are generated to the specific test case running parallely
	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onStart(ITestContext context) {
		String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("District Automation Execution Report");
		reporter.config().setDocumentTitle("District.in Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("QA Name", "Rahul");
		extent.setSystemInfo("Environment", ConfigReader.get("env"));
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed successfully");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		String path =ScreenshotUtils.capture(driver, result.getName());
		extentTest.get().addScreenCaptureFromPath(path, "Failed Test Screenshot");
		LoggerUtils.fail("Screenshot saved for failed test case: " + result.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}