package org.jaccept.gui;

import javax.swing.DefaultListModel;

import org.jaccept.TestEventListener;
import org.jaccept.TestEventManager;


public class ResultDescriptionListModel extends DefaultListModel implements TestEventListener {
    private int aResultCounter = 0;

    public ResultDescriptionListModel() {
        super();
        TestEventManager.addTestListener(this);
    }

    public void suiteStarted(String name) {}

    public void caseStarted(String name) {
        aResultCounter = 0;
        this.clear();
    }

    public void testStarted(String name) {
        aResultCounter = 0;
        this.clear();
    }

    public void testEnded() {}

    public void testFailed(String message) {}

    public void testError(String message) {}

    public void stepStarted(String stimuli, String expectedResult) {  
        if (this.getSize() == 3) removeElementAt(0);
        aResultCounter++;
        addElement(aResultCounter+"  "+expectedResult);
    }

    public void stepEnded() {}

    public void description(String description) {}

    public void reference(String reference) {}

    public void projectStarted(String name) {}

    public void addStimuli(String stimuli) {}

    public void addResult(String result) {}
}
