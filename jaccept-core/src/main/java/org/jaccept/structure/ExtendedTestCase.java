package org.jaccept.structure;

import org.jaccept.TestEventManager;

import junit.framework.TestCase;
import junit.framework.TestResult;

public abstract class ExtendedTestCase extends TestCase {
    private static final TestEventManager eventReceiver = TestEventManager.getInstance();
    private String prosaName;

    public ExtendedTestCase(String string) {
        super(string);
    }
        
    public ExtendedTestCase(String className, String prosaName) {
        super(className);
        this.prosaName = prosaName;
    }

    public void run(TestResult testResult) {
        if (prosaName != null ) {
            addTest(prosaName);
        } else {
            addTest(getName());
        }
        super.run(testResult);
    }
    
    protected void addTest(String name){
        eventReceiver.addTest(name);
    }  
    
    /**
     * Used this method to add a description to a test
     * @param description A general description of the purpose of this test
     */
    public void addDescription(String description) {
        eventReceiver.addDescription(description);
    }

    /**
     * Used for adding a reference entry to an test
     */
    public void addReference(String reference) {
        eventReceiver.addReference(reference);
    }
    
    /**
     * Used for adding a test step event during a test run. A step typically corresponds to 1 stimuli.
     * @param stimuli The stimuli which is added to the system.
     * @param expectedResult The measureable expected changes to the system as a consequence of the stimuli. May be empty
     * if this is part of preparing the state of the system for the real test.
     */
    protected void addStep(String stimuli, String expectedResult){
        eventReceiver.addStep(stimuli, expectedResult);
    }   
}
