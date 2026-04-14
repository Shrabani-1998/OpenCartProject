package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class MyListenerReport implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String reportName;

	public void onStart(ITestContext context) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);

		reportName = "Test Report-" + currentDate + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);
		sparkReporter.config().setDocumentTitle("Opencart Automation Report");
		sparkReporter.config().setReportName("Opencart functional testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		extent.setSystemInfo("browser", "Edge");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "Successfully Executed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " test failed");

		try {
			String imgPath = new BaseClass().captureScreenshot(BaseClass.driver, result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	  public void onTestSkipped(ITestResult result) {
		   test= extent.createTest(result.getTestClass().getName());
		   test.assignCategory(result.getMethod().getGroups());
		   
		   test.log(Status.SKIP, result.getName()+"test skipped");
		  }
	  
	  public void onFinish(ITestContext context) {
		    extent.flush();
		  }

}
