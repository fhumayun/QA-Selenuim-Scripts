package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP42_Voip_TimersAndThresholds extends SuperHelper implements PropertiesVoip {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToAdministration()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void initializeWindowsMap() throws InterruptedException {
		initMap();
	}
	
	@AfterMethod(alwaysRun = true)
	public void getfocusClearWindowsBeforeMethod() throws InterruptedException {
		clearWindows();
	}


	@Test (priority = 0)
	public void voipModifyTimersAndThresholdsValues() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Timers And Thresholds tab
        clickButton(TB_TIMER_AND_THRESHOLDS);
        
    	type_byId(IPF_FAILURE_THRESHOLD, "4");
	    type_byId(IPF_SUCCESS_THRESHOLD, "2");
		type_byId(IPF_TRASITION_MODE_THRESHOLD, "2");
		type_byId(IPF_OPTIONS_INTERVAL, "120");
		type_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "8");
		type_byId(IPF_SUCCESS_NOTIFICATION_RATE, "50");
	
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	
	@Test (priority = 1)
	public void verifyVoipTimersAndThresholdsValuesModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Timers And Thresholds tab
        clickButton(TB_TIMER_AND_THRESHOLDS);
        
        checkValue_byId(IPF_FAILURE_THRESHOLD, "4");
		checkValue_byId(IPF_SUCCESS_THRESHOLD, "2");
		checkValue_byId(IPF_TRASITION_MODE_THRESHOLD, "2");
		checkValue_byId(IPF_OPTIONS_INTERVAL, "120");
		checkValue_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "8");
		checkValue_byId(IPF_SUCCESS_NOTIFICATION_RATE, "50");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipTimersAndThresholdsValuesRecoverInitialSettings() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Timers And Thresholds tab
        clickButton(TB_TIMER_AND_THRESHOLDS);
        
    	type_byId(IPF_FAILURE_THRESHOLD, "2");
	    type_byId(IPF_SUCCESS_THRESHOLD, "1");
		type_byId(IPF_TRASITION_MODE_THRESHOLD, "1");
		type_byId(IPF_OPTIONS_INTERVAL, "60");
		type_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "4");
		type_byId(IPF_SUCCESS_NOTIFICATION_RATE, "100");
	
	
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	
}