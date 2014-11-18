package com.helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.Seleniumhelper.SeleniumWebdriver;
import com.Seleniumhelper.superscripts.Core;


public class Analyzer implements IRetryAnalyzer {

	public static int MAX_RETRY_COUNT = 1; 
	private int count = 0;
	String message = "First failure,the test will be executed once more";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean retry(ITestResult arg0) {
		count++; 
		
		if( count <= MAX_RETRY_COUNT && Core.noSuchWindow ){ 
			
			SeleniumWebdriver.LOGGER.info("\t"+message);
			Reporter.log("<font color=\"#FF00FF\"/>"+message+"</font><br>");
			
			try {
		    	SeleniumWebdriver.LOGGER.info("\tExecute @BeforeTest again");
		    	int parameters = arg0.getMethod().getTestClass().getBeforeTestConfigurationMethods()[0].getMethod().getParameterAnnotations().length;
		    	if (parameters == 0){
		    		arg0.getMethod().getTestClass().getBeforeTestConfigurationMethods()[0].getMethod().invoke(arg0.getInstance());
		    	}
		    	else{
		    		arg0.getMethod().getTestClass().getBeforeTestConfigurationMethods()[0].getMethod().invoke(arg0.getInstance(),arg0.getMethod().getTestClass().getBeforeTestConfigurationMethods()[0].getMethod().getParameterAnnotations()[0][0].toString().split("=")[1].replace(")",""));
		    	}	     
		    } catch (Exception e) {
		    	SeleniumWebdriver.LOGGER.info("\tException thrown, the @BeforeTest was not executed");
		    	SeleniumWebdriver.LOGGER.info("\t"+e.getMessage());
	        }
		    
			Core.noSuchWindow = false;
			return true;
		}
		
		Core.noSuchWindow = false;
		return false;
		
	}   
	
	} 
