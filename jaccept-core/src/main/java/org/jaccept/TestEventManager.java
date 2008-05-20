package org.jaccept;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class TestEventManager implements ITestListener {
    private static final List<TestEventListener> listerners = new LinkedList<TestEventListener>();
    private static final TestEventManager instance = new TestEventManager();   

    private final Logger log = Logger.getLogger(TestEventManager.class);

    private final static TestState testState = new TestState();
    
    private TestEventManager(){
    	URL url = Loader.getResource("log4j.xml");
    	PropertyConfigurator.configure(url);
    	
        URL jacceptPropertiesUrl = Loader.getResource("jaccept.properties");
        Properties jacceptProperties = new Properties();
        String clientClasses = null;
        try {
			jacceptProperties.load(jacceptPropertiesUrl.openStream());
	    	clientClasses = jacceptProperties.getProperty("jaccept.clientloader.clients");
		} catch (IOException e) {
			log.error("Unable to load properties from "+jacceptProperties,e);
		}
    	if (clientClasses != null && !clientClasses.equals("")) {
    		log.info("Adding clients: "+clientClasses);
    		ClientLoader.loadClients(clientClasses);
    	} else {
    		log.info("No JAccept clients found");
    	}
    	onProjectStart(jacceptProperties.getProperty("jaccept.project.name"));
    }

    public static void addTestListener(TestEventListener listener) {
        listerners.add(listener);
    }

    public static void removeTestListener(TestEventListener listener){
        listerners.remove(listener);
    }
    

    public void onProjectStart(String name) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.projectStarted(name);
        }
    }
    
    public void onStart(ITestContext context) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.onStart(context);
        }
    }

	public void onFinish(ITestContext context) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.onFinish(context);
        }
    }

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestStart(ITestResult result) {
		Iterator<TestEventListener> listenerIterator = listerners.iterator();
		while (listenerIterator.hasNext()) {
			TestEventListener testListener = (TestEventListener) listenerIterator.next();
			testListener.onTestStart(result);
		}		
	}
	
    public void addDescription(String description) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.description(description);
        }
    }
    
    public void addReference(String reference) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.reference(reference);
        }
    }
	
	public void onTestFailure(ITestResult result) {
		Iterator<TestEventListener> listenerIterator = listerners.iterator();
		while (listenerIterator.hasNext()) {
			TestEventListener testListener = (TestEventListener) listenerIterator.next();
			testListener.onTestFailure(result);
		}
	}

	public void onTestSkipped(ITestResult result) {
		Iterator<TestEventListener> listenerIterator = listerners.iterator();
		while (listenerIterator.hasNext()) {
			TestEventListener testListener = (TestEventListener) listenerIterator.next();
			testListener.onTestSkipped(result);
		}		
	}

	public void onTestSuccess(ITestResult result) {
		Iterator<TestEventListener> listenerIterator = listerners.iterator();
		while (listenerIterator.hasNext()) {
			TestEventListener testListener = (TestEventListener) listenerIterator.next();
			testListener.onTestSuccess(result);
		}		
	}	

	public void onStart(ISuite arg0) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.onStart(arg0);
        }
    }
    
	public void onFinish(ISuite arg0) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.onFinish(arg0);
        }
	}

    public void addStep(String stimuli, String expectedResult) {
        if (getTestState().getStepCounter() > 0) addStepEnd();
        getTestState().setStepCounter(getTestState().getStepCounter()+1);
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.stepStarted(stimuli, expectedResult);
        }
    }
    
    public void addStepEnd() {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.stepEnded();
        }
    }

//    public void addError(String message) {
//        Iterator<TestEventListener> listenerIterator = listerners.iterator();
//        while (listenerIterator.hasNext()) {
//            TestEventListener testListener = (TestEventListener) listenerIterator.next();
//            testListener.testError(message);
//        }
//    }
//    
    public void addStimuli(String stimuli) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.addStimuli(stimuli);
        }
    }
    
    public void addResult(String result) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.addResult(result);
        }
    }
    
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,
			String arg2) {
		Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = (TestEventListener) listenerIterator.next();
            testListener.generateReport(arg0, arg1, arg2);
        }
	}
    
    public static TestEventManager getInstance() {
        return instance ;
    }
    
    public static void block() {
        if (getTestState().getBlocking()) {
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

	public static TestState getTestState() {
		return testState;
	}
}
