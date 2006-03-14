package org.jaccept.examples;

import org.jaccept.ExtendedTestSuite;
import org.jaccept.RootLevelSuite;
import org.jaccept.testreport.ReportGenerator;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RootTestSuite extends TestSuite {
        
    public static Test suite() {
        ExtendedTestSuite suite= new RootLevelSuite("Root");
        suite.addDescription("This is the root level test (Description)");
        suite.addReference("Requirement 1");
        suite.addTest(DemoTests.suite());
//        suite.addTest(Report2Tests.suite());
        return suite;
    }            
}
