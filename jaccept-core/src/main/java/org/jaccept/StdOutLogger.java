package org.jaccept;

import java.util.List;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class StdOutLogger implements TestEventListener {

    public void projectStarted(String name) {
		System.out.println("Starting testproject"+name);
    }
	
	public void addResult(String result) {
		System.out.println("\t\t\t\tResult: "+result);
	}

	public void addStimuli(String stimuli) {
		System.out.println("\t\t\t\tStimuli: "+stimuli);
	}

	public void description(String description) {
		System.out.println("\t\tDescription: "+description);		
	}

	public void reference(String reference) {
		System.out.println("\t\tReference: "+reference);
	}

	public void stepStarted(String stimuli, String expectedResult) {
		System.out.println("\t\t\tStep: "+stimuli);
	}
	
	public void stepEnded() {
		System.out.println("\t\t\tStep ended");
	}

	public void onFinish(ITestContext context) {
		System.out.println("\t\tFinished testcase");
	}

	public void onStart(ITestContext context) {
		System.out.println("\t\tStarting testcase "+context.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("\t\tTest partial fail: "+result);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("\t\tTest failed: "+result);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("\t\tTest skipped: "+result);
	}

	public void onTestStart(ITestResult result) {
		System.out.println("\t\tTest starting: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("\t\tTest success: "+result);		
	}

	public void onStart(ISuite arg0) {
		System.out.println("\tSuite: "+arg0.getName());		
	}
	
	public void onFinish(ISuite arg0) {
		System.out.println("\tFinished suite "+arg0.getName());
	}

	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,
			String arg2) {
		System.out.println("Finished");
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
