package org.jaccept;

public class TestEventLogger implements TestEventListener {

    public void projectStarted(String name) {
        System.out.println("Project: "+name);
    }

    public void suiteStarted(String name) {
        System.out.println("\tSuite: "+name);
    }

    public void caseStarted(String name) {
        System.out.println("\t\tCase: "+name);
    }

    public void testStarted(String name) {
        System.out.println("\t\t\tTest: "+name);
    }
    public void testEnded() {
        System.out.println("\t\t\tTest ended: ");
    }        
    public void testFailed(String message) {
        System.out.println("\t\t\tTest failed: "+message);
    }
    public void testError(String message) {
        System.out.println("\t\t\tTest error: "+message);
    }

    public void stepStarted(String stimuli, String expextedResult) {
        System.out.println("\t\t\t\tStep: "+stimuli);
    }

    public void stepEnded() {
        System.out.println("\t\t\t\tStep ended");
    }

    public void description(String description) {
        System.out.println("Description: "+description);
    }

    public void reference(String reference) {
        System.out.println("Reference: "+reference);
    }

    public void addStimuli(String stimuli) {
        System.out.println("Stimuli: "+stimuli);
    }

    public void addResult(String result) {
        System.out.println("Result: "+result);
    }
}
