package org.jaccept;

import org.jaccept.testreport.ReportGenerator;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;

/**
 * Top level test suite
 */
public class RootLevelSuite extends ExtendedTestSuite {
    private static final ReportGenerator reportGenerator = new ReportGenerator();

    public RootLevelSuite(String name) {
        super(name);
    }

    public void run(TestResult testResult) {
        testResult.addListener(new JUnitTestListener());
        TestEventManager.addTestListener(reportGenerator);
        addProject(getName());
        super.run(testResult);
        reportGenerator.generateAllProtocols();
    }    

    private class JUnitTestListener implements TestListener {
        public void addError(Test arg0, Throwable arg1) {
            eventReceiver.addError(arg1.toString());
        }

        public void addFailure(Test arg0, AssertionFailedError arg1) {
            eventReceiver.addFailure(arg1.getMessage());
        }

        public void endTest(Test arg0) {
            eventReceiver.addTestEnded();
        }

        public void startTest(Test arg0) {
        }        
    }
}
