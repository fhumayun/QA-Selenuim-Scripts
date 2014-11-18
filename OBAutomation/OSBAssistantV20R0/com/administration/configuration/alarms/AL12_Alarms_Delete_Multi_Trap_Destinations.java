package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL12_Alarms_Delete_Multi_Trap_Destinations extends SuperHelper implements PropertiesAlarms{

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
    public void deleteMultiTrapDestination() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Delete All the Trap Destinations
		clickCheckbox_All();
		clickButtonDelete();
		
		
		//Check Trap Destinations Deletion
		checkText_NotVisible("10.11.250.101");
		checkText_NotVisible("10.11.250.102");
		checkText_NotVisible("10.11.250.103");
		checkText_NotVisible("10.11.250.104");
		checkText_NotVisible("10.11.250.105");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void verifyTrapDestinationsDeletion() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Verify Trap Destination Deletion
		checkText_NotVisible("10.11.250.101");
		checkText_NotVisible("10.11.250.102");
		checkText_NotVisible("10.11.250.103");
		checkText_NotVisible("10.11.250.104");
		checkText_NotVisible("10.11.250.105");
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    }
		
}