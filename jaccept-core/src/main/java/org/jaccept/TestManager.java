package org.jaccept;

import org.apache.log4j.Logger;
import org.jaccept.testreport.ReportGenerator;

public class TestManager {
    private final Logger log = Logger.getLogger(TestManager.class);
    private static final ReportGenerator reportGenerator = new ReportGenerator();


    public synchronized Object createTestHMI() {
        String implClass = System.getProperty("componenttest.hmi");
        Object testHMI = null;
        if (implClass != null) {
            try {
                testHMI = Class.forName(implClass).newInstance();
            } catch (InstantiationException e) {
                log.error("Failed instantiate Test HMI" + implClass, e);
            } catch (IllegalAccessException e) {
                log.error("Failed instantiate Test HMI " + implClass, e);
            } catch (ClassNotFoundException e) {
                log.error("Failed instantiate Test HMI " + implClass, e);
            }
        }
        return testHMI;
    }
}
