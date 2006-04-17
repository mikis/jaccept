package org.jaccept.gui.examples;

import javax.swing.JFrame;

import org.jaccept.ExtendedTestSuite;
import org.jaccept.RootLevelSuite;
import org.jaccept.TestEventLogger;
import org.jaccept.TestEventManager;
import org.jaccept.examples.DemoTests;
import org.jaccept.gui.ComponentTestFrame;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ExampleTestSuite extends TestSuite {
        
    public static Test suite() {
        JFrame hmi = new ComponentTestFrame();
        hmi.pack();
        hmi.setVisible(true);

        TestEventManager.addTestListener(new TestEventLogger());
        ExtendedTestSuite suite= new RootLevelSuite("Test GUI example project");
        suite.addDescription("The purpose of this example project is to demonstrate " +
                             "the functionality of the Jaccept framework");
        suite.addTest(DemoTests.suite());
        return suite;
    }            
}
