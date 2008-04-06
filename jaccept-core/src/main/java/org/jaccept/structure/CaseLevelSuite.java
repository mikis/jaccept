
package org.jaccept.structure;

import org.jaccept.TestEventManager;
import org.jaccept.testreport.ReportGenerator;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;

/**
 * This test suite is used at the test case level to define a suite of tests.
 * Should be used by creating a instance of this suite in a static <code>suite()</code> 
 * method in the TestCase class. Example:
 * public static Test suite() {
        ExtendedTestSuite suite= new CaseLevelSuite("Example Test");
        suite.addDescription("This is a example description");
        suite.addTest(new ExampleTestCase("testExample", "Example Test"));
    return suite;    
    }
 */
public class CaseLevelSuite extends ExtendedTestSuite {
	private static final ReportGenerator reportGenerator = new ReportGenerator();
//	
//    public CaseLevelSuite(String name) {
//        super(name);
//    }
//    
//    public CaseLevelSuite(String name, Class _class) {
//        super(name, _class);
//    }
//    
//    public void run(TestResult testResult) {
//        testResult.addListener(new JUnitTestListener());
//        TestEventManager.addTestListener(reportGenerator);
//        addProject(getName());
//        eventReceiver.addCase(getName());
//        super.run(testResult);
//        reportGenerator.generateAllProtocols();
//    }  
//    
//    public CaseLevelSuite(String className, String prosaName) {
//        super(className);
//    }
//
//    private class JUnitTestListener implements TestListener {
//        public void addError(Test arg0, Throwable arg1) {
//            eventReceiver.addError(arg1.toString());
//        }
//
//        public void addFailure(Test arg0, AssertionFailedError arg1) {
//            eventReceiver.addFailure(arg1.getMessage());
//        }
//
//        public void endTest(Test arg0) {
//            eventReceiver.addTestEnded();
//        }
//
//        public void startTest(Test arg0) {
//        }        
//    }
}
