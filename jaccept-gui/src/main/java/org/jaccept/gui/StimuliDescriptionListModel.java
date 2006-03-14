package org.jaccept.gui;

import javax.swing.DefaultListModel;

import org.jaccept.TestEventListener;
import org.jaccept.TestEventManager;


public class StimuliDescriptionListModel extends DefaultListModel implements TestEventListener {
    private int aStepCounter = 0;

    public StimuliDescriptionListModel() {
        super();
        TestEventManager.addTestListener(this);
    }

    public void projectStarted(String name) {
        // TODO Auto-generated method stub
        
    }

    public void suiteStarted(String name) {
        // TODO Auto-generated method stub
        
    }

    public void caseStarted(String name) {
        aStepCounter = 0;
        this.clear();
    }

    public void testStarted(String name) {
        aStepCounter = 0;
        this.clear();
    }

    public void testEnded() {
        // TODO Auto-generated method stub
        
    }

    public void testFailed(String message) {
        // TODO Auto-generated method stub
        
    }

    public void testError(String message) {
        // TODO Auto-generated method stub
        
    }

    public void stepStarted(String stimuli, String expectedResult) {
        if (this.getSize() == 4) removeElementAt(0);
        aStepCounter++;
        addElement(aStepCounter+"  "+stimuli);
    }

    public void stepEnded() {
        // TODO Auto-generated method stub
        
    }

    public void description(String description) {
        // TODO Auto-generated method stub
        
    }

    public void reference(String reference) {
        // TODO Auto-generated method stub
        
    }

    public void addStimuli(String stimuli) {
        // TODO Auto-generated method stub
        
    }

    public void addResult(String result) {
        // TODO Auto-generated method stub
        
    }
}
