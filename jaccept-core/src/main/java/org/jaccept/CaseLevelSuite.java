
package org.jaccept;

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

    public CaseLevelSuite(String name) {
        super(name);
    }
    
    public CaseLevelSuite(String name, Class _class) {
        super(name, _class);
    }
    
    public CaseLevelSuite(String className, String prosaName) {
        super(className);
    }

    public void run(TestResult testResult) {
        eventReceiver.addCase(getName());
        super.run(testResult);
    }
}
