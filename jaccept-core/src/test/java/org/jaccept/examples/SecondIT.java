package org.jaccept.examples;

import org.jaccept.TestEventManager;
import org.jaccept.structure.ExtendedTestCase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SecondIT extends ExtendedTestCase {
    ExampleComponentWrapper c2t = new ExampleComponentWrapper(new ExampleComponent());

    @BeforeTest
    public void defineTestCase() {
        //addDescription("This is a example of a TestCase description");
    }

    @Test
    public void testSecondTestsCases() {
        addDescription("Second test description");

        addStep("Create a component2Test instance", "");
        c2t = new ExampleComponentWrapper(new ExampleComponent());

        addStep("Call the setListener method with a testlistener",
                "Testlistener should be set on component2Test");
        c2t.setListener(new ComponentLister() {
            public void firstMethodCalled(String param) {
                TestEventManager.getInstance().addResult("TestListener called with param " + param);
            }
        });
        addStep("Call the c2t with the string 'alpha'",
                "The testlistener should be notified of the call and the string 'returnValue' should be returned");
        assertEquals("Wrong return value", "returnValue", c2t.firstMethod("alpha"));

        addStep("Call the c2t with the string 'beta'",
                "The testlistener should be notified of the call again and the string 'returnValue' should be still be returned");
        assertEquals("Wrong return value", "returnValue", c2t.firstMethod("beta"));
    }
}
