package org.jaccept.examples;

import org.jaccept.structure.ExtendedTestSuite;
import org.jaccept.structure.IntermediateLevelSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

public class DemoTests extends TestSuite {    
    
    public DemoTests(String name) {
        super(name);
    }

    public static Test suite() {
        ExtendedTestSuite suite= new IntermediateLevelSuite("DemoSuite");
        suite.addDescription("Basic demostration test set");
        suite.addReference("Requirement 1.12, Requirement 1.14");
        suite.addTest(DemoTestCase.suite());
        return suite;
    }     
}
