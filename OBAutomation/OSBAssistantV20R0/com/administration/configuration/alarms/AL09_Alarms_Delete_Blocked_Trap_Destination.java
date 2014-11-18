package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL09_Alarms_Delete_Blocked_Trap_Destination extends SuperHelper implements PropertiesAlarms{

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
    public void deleteUnblockedTrapDestination() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Delete the Trap Destination
		clickCheckbox_byText("10.11.250.90");
		clickButtonDelete();
		
		
		//Check Trap Destination Deletion
		checkText_NotVisible("10.11.250.90");
			
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void verifyUnblockedTrapDestinationDeletion() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Verify Trap Destination Deletion
		checkText_NotVisible("10.11.250.90");
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    }
		
}