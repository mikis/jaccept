/**
 * 
 */
package org.jaccept.examples;

import org.jaccept.TestEventManager;

class ExampleComponentWrapper {
	private ExampleComponent c2t;
	
	public ExampleComponentWrapper(ExampleComponent c2t) {
		this.c2t = c2t;
	}
	
	 public String firstMethod(String param) {
	     TestEventManager.getInstance().addStimuli("Calling firstMethod("+param+")");
	     String returnResult = c2t.firstMethod(param);
	     TestEventManager.getInstance().addResult("Returning:" + returnResult);
		 return returnResult;
	 }
	 
	 public void setListener(ComponentLister listener) {
	     TestEventManager.getInstance().addStimuli("Setting listener "+listener+")");
		 c2t.setListener(listener);
	 }

}
