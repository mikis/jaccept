package org.jaccept.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.jaccept.TestEventManager;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Superclass for the concrete Jaccept suite classes. 
 * Main functionality is to store the events produce during construction of the test hierachy and then dispatch the events when the test are actually run.
 */

public abstract class ExtendedTestSuite extends TestSuite {
    protected static final TestEventManager eventReceiver = TestEventManager.getInstance();
    
    List aProjects = new LinkedList();
    List aSuite = new LinkedList();
    List aCases = new LinkedList();
    List aDescriptions = new LinkedList();
    List aReferences = new LinkedList();
    List aSetUps = new LinkedList();
    List aTearDowns = new LinkedList();

    public ExtendedTestSuite(String name) {
        super(name);
    }
    
    public ExtendedTestSuite(String name, Class _class) {
        super(_class);
        setName(name);
    }
    
    public void run(TestResult testResult) {
        generateStoredEvents();
        super.run(testResult);
    }

    private void generateStoredEvents() {
        Iterator iterator = aProjects.iterator();
        while (iterator.hasNext()) {
            eventReceiver.addProject( (String)iterator.next() );
        }
        
        iterator = aSuite.iterator();
        while (iterator.hasNext()) {
            eventReceiver.addSuite( (String)iterator.next() );
        }
        
        iterator = aCases.iterator();
        while (iterator.hasNext()) {
            eventReceiver.addCase( (String)iterator.next() );
        }
        
        iterator = aDescriptions.iterator();
        while (iterator.hasNext()) {
            eventReceiver.addDescription( (String)iterator.next() );
        }
        
        iterator = aReferences.iterator();
        while (iterator.hasNext()) {
            eventReceiver.addReference( (String)iterator.next() );
        }
        
        iterator = aCases.iterator();
        while (iterator.hasNext()) {
            eventReceiver.addCase( (String)iterator.next() );
        }
        
        iterator = aSetUps.iterator();
        while (iterator.hasNext()) {
//            eventReceiver.addSetUp( (String)iterator.next() );
        }
        
        iterator = aTearDowns.iterator();
        while (iterator.hasNext()) {
//            eventReceiver.addTearDown( (String)iterator.next() );
        }
    }

    void addProject(String descriptor){
        aProjects.add(descriptor);
    }

    void addSuite(String descriptor){
        aSuite.add(descriptor);
    }

    void addCase(String descriptor){
        aCases.add(descriptor);
    }

    /**
     * Adds a description to the current suite
     * @param description
     */
    public void addDescription(String description) {
        aDescriptions.add(description);
    }
    
    /**
     * Adds a reference to the current suite.
     * @param reference
     */
    public void addReference(String reference) {
        aReferences.add(reference);
    }

    void addSetUp(String name) {
        aSetUps.add(name);
    }

    void addTearDown(String name) {
        aTearDowns.add(name);
    }
}