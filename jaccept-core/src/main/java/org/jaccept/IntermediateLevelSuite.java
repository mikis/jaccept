package org.jaccept;

import junit.framework.TestResult;

/**
 * Defines a TestSuite below a the root suite but not at the TestCase level
 */
public class IntermediateLevelSuite extends ExtendedTestSuite {

    public IntermediateLevelSuite(String name) {
        super(name);
    }    

    public void run(TestResult testResult) {
        eventReceiver.addSuite(getName());
        super.run(testResult);
    }
}
