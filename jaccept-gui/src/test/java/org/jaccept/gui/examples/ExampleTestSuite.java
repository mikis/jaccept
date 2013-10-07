package org.jaccept.gui.examples;

import junit.framework.TestSuite;
import org.jaccept.gui.SwingClient;

import javax.swing.*;

public class ExampleTestSuite extends TestSuite {

    public static void suite() {
        JFrame hmi = new SwingClient();
        hmi.pack();
        hmi.setVisible(true);
    }
}
