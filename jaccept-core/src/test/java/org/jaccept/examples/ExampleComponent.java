/**
 *
 */
package org.jaccept.examples;


class ExampleComponent {
    //	 private final Logger log = Logger.getLogger(Component2Test.class.getName());
    private ComponentLister listener;

    /**
     * Called the componentlistener with the supplied value
     *
     * @param param The value to give to the listener
     * @return The string 'returnValue'
     */
    public String firstMethod(String param) {
//		 log.info("firstMethod called with parameters"+param);
        listener.firstMethodCalled(param);
        return "returnValue";
    }

    public void setListener(ComponentLister listener) {
        this.listener = listener;
    }
}

interface ComponentLister {
    public void firstMethodCalled(String param);
}