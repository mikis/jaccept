package org.jaccept.gui.examples;

import javax.swing.JFrame;

import junit.framework.TestSuite;

import org.jaccept.StdOutLogger;
import org.jaccept.TestEventManager;
import org.jaccept.gui.ComponentTestFrame;

public class ExampleTestSuite extends TestSuite {
        
    public static void suite() {
        JFrame hmi = new ComponentTestFrame();
        hmi.pack();
        hmi.setVisible(true);

        TestEventManager.addTestListener(new StdOutLogger());
    }            
}
