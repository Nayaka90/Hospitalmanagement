package com.hms.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation extends BaseClass implements ITestListener {
	ExtentReports report;
	ExtentTest test ;
	public void onTestStart(ITestResult result) {
		String name=result.getMethod().getMethodName();
        test = report.createTest(name)	;
      
	}

	public void onTestSuccess(ITestResult result) {
		
		String name=result.getMethod().getMethodName();
		test.log(Status.PASS, name+"--->Pass");
	}

	public void onTestFailure(ITestResult result) {
		String name=result.getMethod().getMethodName();
		
		String n=name+new JavaUtility().getSystemDateWithFormatForScreenShot();
		EventFiringWebDriver f=new EventFiringWebDriver(driver);
		File src = f.getScreenshotAs(OutputType.FILE);
		File desc=new File("./Screenshot/"+n+".png");
		String path=desc.getAbsolutePath();
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL, result.getThrowable());
		
	
	}

	public void onTestSkipped(ITestResult result) {
		String name=result.getMethod().getMethodName();
		test.log(Status.SKIP, name+"--->skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report"+new JavaUtility().getSystemDateWithFormatForScreenShot()+".html");
		htmlreport.config().setDocumentTitle("Hosital Mangement");
		
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("CrossBrowserTesting");
    report = new ExtentReports();
	report.attachReporter(htmlreport);
	
	}

	public void onFinish(ITestContext context) {
		  Capabilities capability = ((RemoteWebDriver)BaseClass.driver).getCapabilities();
		    report.setSystemInfo("OS",System.getProperty("os.name"));
		    report.setSystemInfo("JAvA version",System.getProperty("java.version"));
		    report.setSystemInfo("selenium version",System.getProperty("seleniumIDE.version"));
			report.setSystemInfo("Browser",capability.getBrowserName()+capability.getVersion());
			
			//consolidate the report
			report.setSystemInfo("Reporter", "Nithishnayaka");
	report.flush();
	}
	
	

}
