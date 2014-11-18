package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL07_Alarms_Modify_Blocked_Trap_Destination extends SuperHelper implements PropertiesAlarms{

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
    public void modifyBlockedTrapDestination() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Edit the Trap Destination
		clickCheckbox_byText("10.11.250.100");
		clickButton(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON);
		
		updateMap(RETRIES);
		
		//Modify IP Address,Port and Reporting Class Set
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.90");
		type_byId(IPF_ALARMS_TRAP_DEST_PORT,"163");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "4");
		
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Trap Destination Creation
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.90");
		
		//Check Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.90", "Port", "163");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.90", "Reporting class set", "4");
						
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void verifyBlockedTrapDestinationModification() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Verify Trap Destination IP Address
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.90");
		
		//Verify Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.90", "Port", "163");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.90", "Reporting class set", "4");
			
	
		//Edit the Trap Destination
		clickCheckbox_byText("10.11.250.90");
		clickButton(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON);
		
		updateMap(RETRIES);
		
		//Verify Trap Destination Input Fields values and Blocked checkBox status
		checkValue_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.90");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_PORT, "163");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "4");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
    }
		
}