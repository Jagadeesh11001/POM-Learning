package utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {

	ExtentReports extent;
	ExtentTest test ;
	String desc ="";
	String author ="";
	String category ="";
	
	@BeforeSuite
	protected void startTest() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@AfterTest
	protected void stopTest() {
		extent.flush();
	}
	
	@BeforeClass
	void createTest() {
		test = extent.createTest("TC001 - search product");
		test.assignAuthor("Jagan");
		test.assignCategory("Smoke");
	}
	
	void stepReport(String status,String description) {
		switch (status) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.fail(description);
			break;
		default:
			break;
		}
	}
}
