package org.jaccept.gui;

import org.jaccept.TestEventListener;
import org.jaccept.TestEventManager;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import javax.swing.*;
import java.util.List;


public class ResultDescriptionListModel extends DefaultListModel implements TestEventListener {
    private int aResultCounter = 0;

    public ResultDescriptionListModel() {
        super();
        TestEventManager.getInstance().addTestListener(this);
    }

    @Override
    public void classStart(String name) {
        aResultCounter = 0;
        this.clear();
    }

    @Override
    public void stepStart(String stimuli, String expectedResult) {
        if (this.getSize() == 3) removeElementAt(0);
        aResultCounter++;
        addElement(aResultCounter + "  " + expectedResult);
    }

    @Override
    public void addFixture(String fixtureDescription) {
        addElement("    " + fixtureDescription);
    }

    @Override
    public void stepEnd() {
    }

    @Override
    public void addDescription(String description) {
    }

    @Override
    public void addReference(String reference) {
    }

    @Override
    public void projectStart(String name) {
    }

    @Override
    public void addStimuli(String stimuli) {
    }

    @Override
    public void addResult(String result) {
    }

    @Override
    public void classFinish() {
    }

    @Override
    public void testFailure(ITestResult arg0) {
    }

    @Override
    public void testStart(String name) {
        aResultCounter = 0;
        this.clear();
    }

    @Override
    public void testSuccess(ITestResult arg0) {
    }

    @Override
    public void suiteFinish() {
    }

    @Override
    public void suiteStart(String name) {
    }

    @Override
    public void projectFinish() {
    }
}
