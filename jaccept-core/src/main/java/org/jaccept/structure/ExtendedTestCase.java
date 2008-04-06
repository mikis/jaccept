package org.jaccept.structure;

import org.jaccept.TestEventManager;

public abstract class ExtendedTestCase {
//	private static final ReportGenerator reportGenerator = new ReportGenerator();
    private static final TestEventManager eventReceiver = TestEventManager.getInstance();
   
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
     * @param expectedResult The measurable expected changes to the system as a consequence of the stimuli. May be empty
     * if this is part of preparing the state of the system for the real test.
     */
    protected void addStep(String stimuli, String expectedResult){
        eventReceiver.addStep(stimuli, expectedResult);
    }   
}
