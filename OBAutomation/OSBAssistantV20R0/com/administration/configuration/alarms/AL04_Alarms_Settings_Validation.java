package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL04_Alarms_Settings_Validation extends SuperHelper implements PropertiesAlarms{

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
    public void alarmSettingsEmptyValues() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Edit the first Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
			
    	//Insert empty values in Threshold,Flow Timer and Reporting Class input fields
    	type_byId(IPF_ALARMS_THRESHOLD, "");
    	type_byId(IPF_ALARMS_FLOW_TIMER, "");
    	type_byId(IPF_ALARMS_REPORTING_CLASS, "");
    	
		clickButtonSave();
		
		//Check validation messages
		checkText_byId(DIV_ALARMS_THRESHOLD_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.valueIsRequired"));
		checkText_byId(DIV_ALARMS_FLOW_TIMER_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.valueIsRequired"));
		checkText_byId(DIV_ALARMS_REPORTING_CLASS_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.valueIsRequired"));
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void alarmSettingsInvalidValues() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Edit the first Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
		
		//Insert invalid values in Threshold,Flow Timer and Reporting Class input fields
    	type_byId(IPF_ALARMS_THRESHOLD, "a");
    	type_byId(IPF_ALARMS_FLOW_TIMER, "a");
    	type_byId(IPF_ALARMS_REPORTING_CLASS, "a");
    	
		clickButtonSave();
		
		//Check validation messages
		checkText_byId(DIV_ALARMS_THRESHOLD_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.number"));
		checkText_byId(DIV_ALARMS_FLOW_TIMER_VALIDATION, "Valid range is 0 - 86400.");
		checkText_byId(DIV_ALARMS_REPORTING_CLASS_VALIDATION, "Valid range is 0 - 7.");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
		
    }
		
    @Test(priority = 2)
    public void alarmSettingsValuesOutOfRange() throws InterruptedException {
    	
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Edit the first Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
	
		//Insert values out of range in Flow Timer and Reporting Class input fields
    	type_byId(IPF_ALARMS_FLOW_TIMER, "86401");
    	type_byId(IPF_ALARMS_REPORTING_CLASS, "8");
    	
		clickButtonSave();
		
		//Check validation messages
		checkText_byId(DIV_ALARMS_FLOW_TIMER_VALIDATION, "Valid range is 0 - 86400.");
		checkText_byId(DIV_ALARMS_REPORTING_CLASS_VALIDATION, "Valid range is 0 - 7.");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    	
    }
    
  

}