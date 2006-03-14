package org.jaccept;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestEventManager {
    private static final List aListerners = new LinkedList();
    private static final TestEventManager instance = new TestEventManager();    
    private static boolean aIsBlocking = false;
    private static int aStepCounter = 0;
    private static boolean aFailed = false;

    private static boolean aVerificationEnabled = true;

    
    private TestEventManager(){}

    public static void addTestListener(TestEventListener listener) {
        aListerners.add(listener);
    }

    public static void removeTestListener(TestEventListener listener){
        aListerners.remove(listener);
    }
    
    public void addProject(String name){
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.projectStarted(name);
        }
    }

    public void addSuite(String name) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.suiteStarted(name);
        }
    }

    public void addCase(String name) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.caseStarted(name);
        }
    }

    public void addTest(String name) {
        aStepCounter = 0;
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.testStarted(name);
        }
    }
    
    public void addTestEnded() {
        addStepEnd();
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.testEnded();
        }
    }

    public void addStep(String stimuli, String expectedResult) {
        if (aStepCounter > 0) addStepEnd();
        aStepCounter++;
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.stepStarted(stimuli, expectedResult);
        }
    }
    
    public void addStepEnd() {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.stepEnded();
        }
    }
    
    public void addDescription(String description) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.description(description);
        }
    }
    
    public void addReference(String reference) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.reference(reference);
        }
    }
    
    public void addFailure(String message) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.testFailed(message);
        }
    }

    public void addError(String message) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.testError(message);
        }
    }
    
    public void addStimuli(String stimuli) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.addStimuli(stimuli);
        }
    }
    
    public void addResult(String result) {
        Iterator listenerIterator = aListerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.addResult(result);
        }
    }
    public static TestEventManager getInstance() {
        return instance ;
    }
    
    public static void block() {
        if (isBlocking()) {
            synchronized(TestEventManager.class) {
                try {
                    TestEventManager.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace(); 
                }
            }
        }
    }

    public static void unblock() {
        synchronized(TestEventManager.class) {
            TestEventManager.class.notifyAll();
        }
    }

    public static boolean isBlocking() {
        return aIsBlocking;
    }
    public static void setBlocking(boolean value) {
        aIsBlocking = value;
    }

    public static boolean isVerificationEnabled() {
        return aVerificationEnabled;
    }

    public static void setVerificationEnabled(boolean verificationEnabled) {
        aVerificationEnabled = verificationEnabled;
    }
}
