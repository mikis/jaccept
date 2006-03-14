package org.jaccept.examples;

import org.jaccept.CaseLevelSuite;
import org.jaccept.ExtendedTestCase;
import org.jaccept.ExtendedTestSuite;
import org.jaccept.TestEventManager;

import junit.framework.Test;

public class DemoTestCase extends ExtendedTestCase {
    public DemoTestCase(String string) {
        super(string);
    }
    
    public static Test suite() {
        ExtendedTestSuite suite= new CaseLevelSuite("DemoCase", DemoTestCase.class);
        suite.addDescription("Case level description case ");
        suite.addReference("Requirement 1.12.2");
        return suite;
    }
    
    public void test1() {
        addDescription("Test level description test 1");
        addStep("Stimuli 1", "Result 1");
        TestEventManager.getInstance().addStimuli("This is an example of a test stimuli entry");
        TestEventManager.getInstance().addResult("This is an example of a test result entry");
        TestEventManager.getInstance().addResult("This is an example of an another result entry");
        addStep("Stimuli 2", "Result 2");
        addStep("Stimuli 3", "Result 3");
        addStep("Stimuli 4", "Result 4");
        addStep("Stimuli 5", "Result 5");
    }    

    public void test2() { 
        addDescription("Example description for test 2");
        addReference("-------------");
        addStep("Second test, first step", "The expected result of test 2.1");
    }       
}
