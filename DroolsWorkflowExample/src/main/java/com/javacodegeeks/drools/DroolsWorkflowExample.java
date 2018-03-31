package com.javacodegeeks.drools;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

/**
 * This is a sample file to launch a process.
 */
public class DroolsWorkflowExample {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-process");
        	Message message = new Message();
            message.setMessage("Rule is fired");
            message.setStatus(Message.HELLO);
            
            
String consumerId ="CIA";
kSession.setGlobal("consumerId", consumerId);
            
//            kSession.insert(message);
            
            // start a new process instance
//            kSession.startProcess("com.javacodegeeks.drools", null);    
//            kSession.fireAllRules();
            
            
Map<String, Object> inputParams = new HashMap<String, Object>();
inputParams.put("consumerId", consumerId);

 ProcessInstance processInstance= kSession.startProcess("com.javacodegeeks.drools", inputParams);  
// RuleFlowProcessInstance ruleFlowProcessInstance= (RuleFlowProcessInstance) processInstance;
// ruleFlowProcessInstance.setVariable("consumerId",consumerId);

 
 			kSession.insert(message);
    		kSession.fireAllRules();            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
