package org.jaccept;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class TestNGListerner implements ITestListener, ISuiteListener, IExecutionListener {
    public static TestEventManager tm;

    @Override
    public void onStart(ISuite arg0) {
        tm.suiteStart(arg0.getName());
    }

    @Override
    public void onStart(ITestContext arg0) {
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        tm.testStart(arg0.getName());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        tm.testSuccess(arg0);
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        tm.testFailure(arg0);
    }

    @Override
    public void onFinish(ITestContext arg0) {
        tm.classFinish();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
    }

    @Override
    public void onFinish(ISuite arg0) {
        tm.suiteFinish();
    }

    @Override
    public void onExecutionStart() {
        tm = TestEventManager.getInstance();
        tm.projectStart();
    }

    @Override
    public void onExecutionFinish() {
        tm.projectFinish();
    }
}
