package org.jaccept;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class TestNGListerner implements ITestListener, ISuiteListener, IReporter {
	public static final TestEventManager tm = TestEventManager.getInstance();

	public void onFinish(ITestContext arg0) {
		tm.onFinish(arg0);
	}

	public void onStart(ITestContext arg0) {
		tm.onStart(arg0);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		tm.onTestFailedButWithinSuccessPercentage(arg0);
	}

	public void onTestFailure(ITestResult arg0) {
		tm.onTestFailure(arg0);
	}

	public void onTestSkipped(ITestResult arg0) {
		tm.onTestSkipped(arg0);
	}

	public void onTestStart(ITestResult arg0) {
		tm.onTestStart(arg0);
	}

	public void onTestSuccess(ITestResult arg0) {
		tm.onTestSuccess(arg0);
	}

	public void onFinish(ISuite arg0) {
		tm.onFinish(arg0);
	}

	public void onStart(ISuite arg0) {
		tm.onStart(arg0);
	}

	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,
			String arg2) {
		tm.generateReport(arg0, arg1, arg2);		
	}
}
