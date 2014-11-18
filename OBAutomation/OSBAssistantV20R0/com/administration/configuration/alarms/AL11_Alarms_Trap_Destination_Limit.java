package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL11_Alarms_Trap_Destination_Limit extends SuperHelper implements PropertiesAlarms{

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
    public void deleteBlockedTrapDestination() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Add Five Trap Destinations
		for (int i=1;i<=5;i++)
		{
			clickButtonAdd();
			
			updateMap(RETRIES);
			
			type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.10" + i);
			type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "1");
			
			clickButtonSave();
			
			updateMap(RETRIES);
		
			checkText("10.11.250.10" + i);
		}
		
		//Verify that after 5 adds the Add button becomes disabled
		checkStatus(BTN_ALARMS_TRAP_DEST_ADD_BUTTON, "disabled", "Button Add Trap Destination");
		
		//Save the 5 Trap Destinations
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
    }	
		
   
		
}