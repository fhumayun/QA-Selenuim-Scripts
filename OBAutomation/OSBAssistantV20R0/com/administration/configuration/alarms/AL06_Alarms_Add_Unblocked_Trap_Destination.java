package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL06_Alarms_Add_Unblocked_Trap_Destination extends SuperHelper implements PropertiesAlarms{

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
    public void addUnblockedTrapDestination() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Add a Unblocked Trap Destination
		clickButtonAdd();
		
		updateMap(RETRIES);
		
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.200");
		type_byId(IPF_ALARMS_TRAP_DEST_PORT,"17670");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "4;5;6");
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Trap Destination Creation
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.200");
		
		//Check Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.200", "Port", "17670");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.200", "Reporting class set", "4;5;6");
						
		//Check Trusted image absence
		checkElement_NotPresent("editAlarmSettings:snmpTab:snmpGrid:1:enabledImage");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void verifyUnblockedTrapDestinationCreation() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Verify Trap Destination Creation
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.200");
		
		//Verify Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.200", "Port", "17670");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.200", "Reporting class set", "4;5;6");
			
		//Check Trusted image absence
		checkElement_NotPresent("editAlarmSettings:snmpTab:snmpGrid:1:enabledImage");
	
		//Edit the Trap Destination
		clickCheckbox_byText("10.11.250.200");
		clickButton(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON);
		
		updateMap(RETRIES);
		
		//Verify Trap Destination Input Fields values and Blocked checkBox status
		checkValue_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.200");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_PORT, "17670");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "4;5;6");
		checkStatus(CB_ALARMS_TRAP_DEST_BLOCKED, "unchecked", "Checkbox Set as active");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    }
		
}