package org.jaccept;

import org.testng.ITestResult;

public class StdOutLogger implements TestEventListener {
    @Override
    public void projectStart(String name) {
        System.out.println("Starting test project " + name);
    }

    @Override
    public void suiteStart(String name) {
        System.out.println("  Suite: " + name);
    }

    @Override
    public void classStart(String name) {
        System.out.println("    Starting testcase " + name);
    }

    @Override
    public void testStart(String name) {
        System.out.println("      Test starting: " + name);
    }

    @Override
    public void addDescription(String description) {
        System.out.println("        Description: " + description);
    }

    @Override
    public void addReference(String reference) {
        System.out.println("        Reference: " + reference);
    }

    @Override
    public void addFixture(String setupDescription) {
        System.out.println("        Added fixture: " + setupDescription);
    }

    @Override
    public void stepStart(String stimuli, String expectedResult) {
        System.out.println("        Step: " + stimuli);
    }

    @Override
    public void addStimuli(String stimuli) {
        System.out.println("          Stimuli: " + stimuli);
    }

    @Override
    public void addResult(String result) {
        System.out.println("          Result: " + result);
    }

    @Override
    public void stepEnd() {
        //System.out.println("      Step ended");
    }

    @Override
    public void testFailure(ITestResult result) {
        System.out.println("      Test failed: " + result.getThrowable());
    }

    @Override
    public void testSuccess(ITestResult result) {
        System.out.println("      Test success: " + result.getName());
    }

    @Override
    public void classFinish() {
        System.out.println("      Finished testcase");
    }

    @Override
    public void suiteFinish() {
        System.out.println("  Finished suite");
    }

    @Override
    public void projectFinish() {
        System.out.println("Finished project");
    }
}
