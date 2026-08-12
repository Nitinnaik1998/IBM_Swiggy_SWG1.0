package com.swiggy.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.swiggy.WebDriverUtility.UtilityClassObject;


public class ListenerUtility implements ITestListener,ISuiteListener{
	 public ExtentReports report;
	 public static ExtentTest test;
	
	public void onStart(ISuite suite) {
	System.out.println("Report Configuration");
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport./vtigerreport"+time+".html");
	spark.config().setDocumentTitle("VTiger");
	spark.config().setReportName("VTigrReport");
	spark.config().setTheme(Theme.DARK);
	
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "windows10");
	report.setSystemInfo("browser", "chrome");		
}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");
		report.flush();
	}
	public void onTestStart(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"====START=====");
		//String testName = result.getMethod().getMethodName();
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, "Test Case got started");
}
	public void onTestFailure(ITestResult result) {
		UtilityClassObject.getTest().log(Status.FAIL, "Status got failed");
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot tks=(TakesScreenshot)UtilityClassObject.getDriver();
		String src = tks.getScreenshotAs(OutputType.BASE64);
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(src,testName+" "+time);
}
	public void onTestSuccess(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"====END=====");
        test.log(Status.PASS, "Test Case got Pass");
}

}
