package org.jaccept.gui;

import org.jaccept.TestEventListener;
import org.jaccept.TestEventManager;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import javax.swing.*;
import java.util.List;


public class StimuliDescriptionListModel extends DefaultListModel implements TestEventListener {
    private int aStepCounter = 0;

    public StimuliDescriptionListModel() {
        super();
        TestEventManager.getInstance().addTestListener(this);
    }

    @Override
    public void projectStart(String name) {}
    @Override
    public void suiteStart(String name) {}
    @Override
    public void classStart(String name) {
        aStepCounter = 0;
        this.clear();
    }
    @Override
    public void testStart(String name) {}

    public void stepStart(String stimuli, String expectedResult) {
        if (this.getSize() == 4) removeElementAt(0);
        aStepCounter++;
        addElement(aStepCounter + "  " + stimuli);
    }

    @Override
    public void stepEnd() {}
    @Override
    public void addDescription(String description) {}
    @Override
    public void addReference(String reference) {}
    @Override
    public void addStimuli(String stimuli) {}
    @Override
    public void addResult(String result) {}
    @Override
    public void addFixture(String setupDescription) {}
    @Override
    public void testFailure(ITestResult result) {}
    @Override
    public void testSuccess(ITestResult result) {
        aStepCounter = 0;
        this.clear();
    }
    @Override
    public void classFinish() {}
    @Override
    public void suiteFinish() {}
    @Override
    public void projectFinish() {}
}
