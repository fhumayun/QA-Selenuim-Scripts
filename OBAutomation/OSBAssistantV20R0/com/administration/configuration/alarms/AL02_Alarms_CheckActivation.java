package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL02_Alarms_CheckActivation extends SuperHelper implements PropertiesAlarms{

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
    public void deActivateAlarm() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Edit the first Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
			
    	//DeActivate the Alarm
		clickCheckbox_byID(CB_ALARMS_SET_ACTIVE);
		
		clickButtonSave();
		updateMap(RETRIES);
		//Check DeActivation
		checkElement_NotPresent("editAlarmSettings:alarmGrid:0:enabledImage");
		
    	clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
    	
    }
    
    @Test(priority = 1)
    public void verifyAlarmDeActivation() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Verify DeActivation
		checkElement_NotPresent("editAlarmSettings:alarmGrid:0:enabledImage");
	
		//Edit the  Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
			
    	//Check Status of Set as active checkBox
		checkStatus(CB_ALARMS_SET_ACTIVE, "unchecked", "Checkbox Set as active");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);;
		setMethodState();
    	
    }
    
    @Test(priority = 2)
    public void activateAlarm() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Edit the first Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
			
    	//Activate the Alarm
		clickCheckbox_byID(CB_ALARMS_SET_ACTIVE);
		
		clickButtonSave();
		updateMap(RETRIES);
		//Check DeActivation
		checkElement("editAlarmSettings:alarmGrid:0:enabledImage");
		
    	clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
    }
    
    @Test(priority = 3)
    public void verifyAlarmActivation() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Verify Activation
		checkElement("editAlarmSettings:alarmGrid:0:enabledImage");
	
		//Edit the  Alarm
		clickRadioButton_byText("High temperature core 0");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
			
    	//Check Status of Set as active checkBox
		checkStatus(CB_ALARMS_SET_ACTIVE, "checked", "Checkbox Set as active");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    	
    }
}