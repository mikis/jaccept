package org.jaccept;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TestEventManager {
    private final List<TestEventListener> listerners = new LinkedList<TestEventListener>();
    private static final TestEventManager instance = new TestEventManager();
    private final Logger log = Logger.getLogger(TestEventManager.class);
    private final TestState testState = new TestState();
    private final Properties jacceptProperties = new Properties();
    private boolean initialized = false;

    private TestEventManager() {
        URL url = Loader.getResource("log4j.xml");
        PropertyConfigurator.configure(url);

        URL jacceptPropertiesUrl = Loader.getResource("jaccept.properties");
        log.info("Loading properties from " + jacceptPropertiesUrl);
        try {
            jacceptProperties.load(jacceptPropertiesUrl.openStream());
        } catch (IOException e) {
            log.error("Unable to load properties from " + jacceptProperties, e);
        }
    }

    public void addTestListener(TestEventListener listener) {
        listerners.add(listener);
    }

    public void removeTestListener(TestEventListener listener) {
        listerners.remove(listener);
    }

    void projectStart() {
        loadClients();
        String projectName = jacceptProperties.getProperty("jaccept.project.name");
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.projectStart(projectName);
        }
    }

    void suiteStart(String name) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.suiteStart(name);
        }
    }

    public void classStart(String name) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.classStart(name);
        }
    }

    public void testStart(String testName) {
        getTestState().setStepCounter(0);
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.testStart(testName);
        }
    }

    public void addDescription(String description) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.addDescription(description);
        }
    }

    public void addReference(String reference) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.addReference(reference);
        }
    }

    public void stepStart(String stimuli, String expectedResult) {
        if (getTestState().getStepCounter() > 0) stepEnd();
        getTestState().setStepCounter(getTestState().getStepCounter() + 1);
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.stepStart(stimuli, expectedResult);
        }
    }

    public void stepEnd() {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.stepEnd();
        }
    }

    public void addStimuli(String stimuli) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.addStimuli(stimuli);
        }
    }

    public void addResult(String result) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.addResult(result);
        }
    }

    public void addFixture(String setupDescription) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.addFixture(setupDescription);
        }
    }

    public void testFailure(ITestResult result) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.testFailure(result);
        }
    }

    public void testSuccess(ITestResult result) {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            stepEnd();
            testListener.testSuccess(result);
        }
    }

    public void classFinish() {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.classFinish();
        }
    }

     void suiteFinish() {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.suiteFinish();
        }
    }

     void projectFinish() {
        Iterator<TestEventListener> listenerIterator = listerners.iterator();
        while (listenerIterator.hasNext()) {
            TestEventListener testListener = listenerIterator.next();
            testListener.projectFinish();
        }
    }

    public static TestEventManager getInstance() {
        return instance;
    }

    public void block() {
        if (getTestState().getBlocking()) {
            synchronized (TestEventManager.class) {
                try {
                    TestEventManager.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void unblock() {
        synchronized (TestEventManager.class) {
            TestEventManager.class.notifyAll();
        }
    }

    public TestState getTestState() {
        return testState;
    }

    public void loadClients() {
        String clientClasses = null;
        clientClasses = jacceptProperties.getProperty("jaccept.clientloader.clients");
        if (clientClasses != null && !clientClasses.equals("")) {
            log.info("Adding clients: " + clientClasses);
        } else {
            log.warn("No JAccept clients found");
            return;
        }

        StringTokenizer st = new StringTokenizer(clientClasses, ",");
        while (st.hasMoreElements()) {
            String clientClass = (String) st.nextElement();
            try {
                log.info("Adding JAccept client " + clientClass);
                TestEventListener client = (TestEventListener) Class.forName(clientClass.trim()).newInstance();
                addTestListener(client);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
