package org.jaccept;

import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestEventLogger implements TestEventListener {

	public void addResult(String result) {
		System.out.println("Result: "+result);
	}

	public void addStimuli(String stimuli) {
		System.out.println("Stimuli: "+stimuli);
	}

	public void description(String description) {
		System.out.println("Description: "+description);		
	}

	public void reference(String reference) {
		System.out.println("Reference: "+reference);
	}

	public void stepStarted(String stimuli, String expectedResult) {
		System.out.println("\ttStep: "+stimuli);
	}
	
	public void stepEnded() {
		System.out.println("\tStep ended");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Finished");
	}

	public void onStart(ITestContext context) {
		System.out.println("Starting");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test partial fail: "+result);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: "+result);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: "+result);
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test starting: "+result);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test success: "+result);		
	}

//    public void projectStarted(String name) {
//        System.out.println("Project: "+name);
//    }
//
//    public void suiteStarted(String name) {
//        System.out.println("\tSuite: "+name);
//    }
//
//    public void caseStarted(String name) {
//        System.out.println("\t\tCase: "+name);
//    }
//
//    public void testStarted(String name) {
//        System.out.println("\t\t\tTest: "+name);
//    }
//    public void testEnded() {
//        System.out.println("\t\t\tTest ended: ");
//    }        
//    public void testFailed(String message) {
//        System.out.println("\t\t\tTest failed: "+message);
//    }
//    public void testError(String message) {
//        System.out.println("\t\t\tTest error: "+message);
//    }
//
//    public void stepStarted(String stimuli, String expextedResult) {
//        System.out.println("\t\t\t\tStep: "+stimuli);
//    }
//
//    public void stepEnded() {
//        System.out.println("\t\t\t\tStep ended");
//    }
//
//    public void description(String description) {
//        System.out.println("Description: "+description);
//    }
//
//    public void reference(String reference) {
//        System.out.println("Reference: "+reference);
//    }
//
//    public void addStimuli(String stimuli) {
//        System.out.println("Stimuli: "+stimuli);
//    }
//
//    public void addResult(String result) {
//        System.out.println("Result: "+result);
//    }
}
