package org.jaccept;

import org.testng.ITestListener;



public interface TestEventListener extends ITestListener {
    
//    /**
//     * Signals the beginning of a test case. 
//     * @param name The name of the test case
//     */
//    void caseStarted(String name);
//    
//    /**
//     * Signals the beginning of a test.
//     * @param name The name of the test
//     */
//    void testStarted(String name);
//
//    /**
//     * Signals the end of a test.
//     */
//    void testEnded();
//    
//    /**
//     * Signals the failure of a test.
//     * @param message The failure message
//     */
//    void testFailed(String message);
//
//    /**
//     * Signals a uncaught exception was thrown by the test.
//     * @param message The string representation of the exception
//     */
//    void testError(String message);

    /**
     * Signals the start of a test step.
     * @param stimuli The stimuli associated with the test step
     * @param expectedResult The expected result of the stimuli
     */
    void stepStarted(String stimuli, String expectedResult);
    
    /**
     * Signals the ending of a test step .
     */
    void stepEnded();
    
    /**
     * Signals a stimuli has been injected into the component under test. 
     * @param stimuli String representation of the stimuli injected into the component under test
     */
    void addStimuli(String stimuli);
    
    /**
     * Signal a result has been received from the testcomponent. 
     * @param result String representation of the result 
     */
    void addResult(String result);
    
    /**
     * Description of the current test scope.
     */
    void description(String description);
    
    /**
     * References relevant to the current test scope.
     */
    void reference(String reference);
}
