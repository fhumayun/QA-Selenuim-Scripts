package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL08_Alarms_Modify_Unblocked_Trap_Destination extends SuperHelper implements PropertiesAlarms{

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
    public void modifyUnblockedTrapDestination() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Edit the Trap Destination
		clickCheckbox_byText("10.11.250.200");
		clickButton(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON);
		
		updateMap(RETRIES);
		
		//Modify IP Address,Port and Reporting Class Set
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.190");
		type_byId(IPF_ALARMS_TRAP_DEST_PORT,"17680");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "6");
		
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Trap Destination Creation
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.190");
		
		//Check Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.190", "Port", "17680");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.190", "Reporting class set", "6");
						
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void verifyUnblockedTrapDestinationModification() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Verify Trap Destination IP Address
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.190");
		
		//Verify Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.190", "Port", "17680");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.190", "Reporting class set", "6");
			
	
		//Edit the Trap Destination
		clickCheckbox_byText("10.11.250.190");
		clickButton(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON);
		
		updateMap(RETRIES);
		
		//Verify Trap Destination Input Fields values and Blocked checkBox status
		checkValue_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.190");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_PORT, "17680");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "6");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    }
		
}