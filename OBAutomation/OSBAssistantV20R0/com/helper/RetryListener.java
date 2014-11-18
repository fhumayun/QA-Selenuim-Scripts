package com.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import com.Seleniumhelper.SeleniumWebdriver;
import com.Seleniumhelper.listeners.startLogs;
import com.Seleniumhelper.ssh.ExecCommandGetReply;
import com.Seleniumhelper.ssh.Sftp_get;

public class RetryListener implements IAnnotationTransformer,ITestListener {
	public static String testNameStart = "";
	public static String testNameFailure = "";
	public static String enableLogs = SeleniumWebdriver.getEnvVarValue("ENABLELOGS");
	@SuppressWarnings("unchecked")
	@Override
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2,Method arg3) {
		IRetryAnalyzer retry = arg0.getRetryAnalyzer();    
		if (retry==null){    
			arg0.setRetryAnalyzer(Analyzer.class);    
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		for(int i=0;i<context.getAllTestMethods().length;i++){
			if(context.getAllTestMethods()[i].getCurrentInvocationCount()==2){
				if (context.getFailedTests().getResults(context.getAllTestMethods()[i]).size() == 2 || context.getPassedTests().getResults(context.getAllTestMethods()[i]).size() == 1){
					//The following if ensure that the method is not a test method called from dataProvider
					if(context.getAllTestMethods()[i].getParameterInvocationCount()==1){
						context.getFailedTests().removeResult(context.getAllTestMethods()[i]);
					}
				}
			}
		}
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(enableLogs.equals("true")){
			if(testNameFailure!=result.getName()){
				testNameFailure = result.getName();
				killLogs();
				downloadLogs(testNameFailure);
				deleteLogs(testNameFailure);
			}
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		if(enableLogs.equals("true")){
			if(testNameStart!=result.getName()){
				testNameStart = result.getName();
				killLogs();
				startLogs(testNameStart);
			}
		}
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		if(enableLogs.equals("true")){
			if(testNameStart!=result.getName()){
				killLogs();
				deleteLogs(testNameStart);
			}
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		if(enableLogs.equals("true")){
			if(testNameStart!=result.getName()){
				killLogs();
				deleteLogs(testNameStart);
			}
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(enableLogs.equals("true")){
			if(testNameStart!=result.getName()){
				killLogs();
				deleteLogs(testNameStart);
			}
		}
	}
	
	public void killLogs(){
		if(enableLogs.equals("true")){
			ExecCommandGetReply executeCommand = new ExecCommandGetReply();
			executeCommand.execCmd("kill -9 `ps -C tailf -o pid=`");
		}
	}
	
	public void startLogs(String testName){
		if(enableLogs.equals("true")){
			startLogs startLogsSym = new startLogs(testName,"symphonia");
			startLogsSym.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			startLogs startLogsTomcat = new startLogs(testName,"tomcat");
			startLogsTomcat.start();
		}
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void downloadLogs(String testName){
		if(enableLogs.equals("true")){
			Sftp_get executeCommand = new Sftp_get(org.testng.TestNG.getDefault().getOutputDirectory()
				+ System.getProperty("file.separator")+"Logs","/tmp/");
			executeCommand.sftpDnLoad(testName+"*.log");
		}
	}
	
	public void deleteLogs(String testName){
		if(enableLogs.equals("true")){
			ExecCommandGetReply executeCommand = new ExecCommandGetReply();
			executeCommand.execCmd("rm /tmp/"+testName+"*.log");
		}
	}
}



