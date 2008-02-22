package org.jaccept.examples;

import junit.framework.Test;

import org.jaccept.TestEventManager;
import org.jaccept.structure.CaseLevelSuite;
import org.jaccept.structure.ExtendedTestCase;
import org.jaccept.structure.ExtendedTestSuite;

public class DemoTestCase extends ExtendedTestCase {
    ExampleComponentWrapper c2t = new ExampleComponentWrapper(new ExampleComponent());
	
    public DemoTestCase(String string, String description) {
        super(string, description);
    }
    
    public DemoTestCase(String string) {
        super(string);
    }
    
    public static Test suite() {
        ExtendedTestSuite suite= new CaseLevelSuite("DemoCase", DemoTestCase.class);
        suite.addDescription("Case level description case ");
        suite.addReference("Requirement 1.12.2");
        suite.addTest(new DemoTestCase("firstMethodTest", "Goodcasetest of the firstMethod"));
        suite.addTest(new DemoTestCase("firstMethodNullTest", "Null parameter test of the firstMethod"));
        return suite;
    }

	public void firstMethodTest() {
        addDescription("Test level description test 1");
        
        addStep("Create a component2Test instance", "");
        c2t = new ExampleComponentWrapper(new ExampleComponent());
    	
    	addStep("Call the setListener method with a testlistener", 
    	"Testlistener should be set on component2Test");
    	c2t.setListener(new ComponentLister() {
    		public void firstMethodCalled(String param) {
    			TestEventManager.getInstance().addResult("TestListener called with param "+param);
    		}
    	});
        addStep("Call the c2t with the string 'alpha'", 
        		"The testlistener should be notified of the call and the string 'returnValue' should be returned");
        assertEquals("Wrong return value", "returnValue", c2t.firstMethod("alpha"));
        
        addStep("Call the c2t with the string 'beta'", 
		"The testlistener should be notified of the call again and the string 'returnValue' should be still be returned");
        assertEquals("Wrong return value", "returnValue", c2t.firstMethod("beta"));
    }    

    public void firstMethodNullTest() { 
        addDescription("Verify that the component2Test handles null parameters correctly");
        addReference("-------------");
        
        addStep("Create a component2Test instance", "");
        c2t = new ExampleComponentWrapper(new ExampleComponent());
    	
    	addStep("Call the setListener method with a testlistener", 
    	"Testlistener should be set on component2Test");
    	c2t.setListener(new ComponentLister() {
    		public void firstMethodCalled(String param) {
    			TestEventManager.getInstance().addResult("TestListener called with param "+param);
    		}
    	});
    	
        addStep("Call the c2t with the null", 
        		"The testlistener should be notified of the call and the string 'returnValue' should be returned");
        assertEquals("Wrong return value", "returnValue", c2t.firstMethod(null));
        
    }
}
