package org.jaccept;

import org.apache.log4j.Logger;

public class TestManager {
    private final Logger log = Logger.getLogger(TestManager.class);
    
    public synchronized Object createTestHMI() {
        String implClass = System.getProperty("dk.mikis.componenttest.hmi");
        Object testHMI = null;
        if (implClass != null) {
            try {
                testHMI = Class.forName(implClass).newInstance();
            } catch (InstantiationException e) {
                log.error("Failed instantiate Test HMI"+implClass, e);
            } catch (IllegalAccessException e) {
                log.error("Failed instantiate Test HMI "+implClass, e);
            } catch (ClassNotFoundException e) {
                log.error("Failed instantiate Test HMI "+implClass, e);
            }
        }
        return testHMI;
    }
}
