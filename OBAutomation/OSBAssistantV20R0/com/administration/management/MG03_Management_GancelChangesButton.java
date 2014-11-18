package com.administration.management;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;

public class MG03_Management_GancelChangesButton extends SuperHelper implements PropertiesManagement,PropertiesAlarms {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }

	  @Test(priority = 0)
	    public void branchOfficeManagement_CancelChangesButton() throws InterruptedException {
	    	
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
			//Check temporary DeActivation
			checkElement_NotPresent("editAlarmSettings:alarmGrid:0:enabledImage");
			
	    	clickButtonSave();
	    	
	    	updateMap(RETRIES);
	    	clickButton(BTN_CANCELCHANGES);
			setMethodState();
	    	
	    }
	  
	  @Test(priority = 1)
	    public void verifyACancelChangesFunction() throws InterruptedException {
	    	
	    	methodLogger.log();
	    	goToAdministrationAlarms();
			updateMap(RETRIES);
			
			//Verify that alarm is still activated since Cancel Changes button was pressed
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