package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL03_Alarms_ChangeSettings extends SuperHelper implements PropertiesAlarms{

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToAdministration()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch)	;	
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
	
    @Test(priority = 0)
    public void changeAlarmSettings() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Edit the first Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
			
		//Change Severity to Major
    	selectFromDropDown(SLC_ALARMS_SEVERITY, "Major");
    	
    	//Change values in Threshold,Flow Timer and Reporting Class input fields
    	type_byId(IPF_ALARMS_THRESHOLD, "80");
    	type_byId(IPF_ALARMS_FLOW_TIMER, "1");
    	type_byId(IPF_ALARMS_REPORTING_CLASS, "2");
    	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check values in Alarms list
		checkText_byId(CLS_ALARMS_LIST_1st_ALARM_TRIGGER, "Greater than 80");
		checkText_byId(CLS_ALARMS_LIST_1st_ALARM_SEVERITY, "Major");
		checkText_byId(CLS_ALARMS_LIST_1st_ALARM_REPORTING_CLASS, "2");
		
		clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
    	
    }
    
    @Test(priority = 1)
    public void verifyAlarmSettings() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Verify values in Alarms list
		checkText_byId(CLS_ALARMS_LIST_1st_ALARM_TRIGGER, "Greater than 80");
		checkText_byId(CLS_ALARMS_LIST_1st_ALARM_SEVERITY, "Major");
		checkText_byId(CLS_ALARMS_LIST_1st_ALARM_REPORTING_CLASS, "2");
	
		//Edit the  Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
			
		//Verify values in Threshold,Flow Timer and Reporting Class input fields
    	checkValue_byId(IPF_ALARMS_THRESHOLD, "80");
    	checkValue_byId(IPF_ALARMS_FLOW_TIMER, "1");
    	checkValue_byId(IPF_ALARMS_REPORTING_CLASS, "2");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    	
    }

}