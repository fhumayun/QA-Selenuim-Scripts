package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL01_Alarms_GUIElemets_DefaultValues extends SuperHelper implements PropertiesAlarms {

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
	
	@Test (priority = 0)
	public void alarmsSettings_CheckDefaultValues() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Check Buttons Status
		checkStatus(BTN_ALARMS_EDIT,"disabled","Button Edit Alarm");
		
		//Check Alarms Items number
		checkText_AllItemsInList(TBL_ALARMS_ALL_ITEMS, "108");
		
		//Check Items per page List
		String[] alarmsList_itemsPerPage = {"10","20","50","100","200"};
		checkSelectedValue_inDropDownList(SLC_ALARMS_ITEMS_PER_PAGE, "10");
		checkStatus(SLC_ALARMS_ITEMS_PER_PAGE, "enabled", "Drop Down list Alarms Items Per Page");
		getPossibleValuesOfDropDown(SLC_ALARMS_ITEMS_PER_PAGE, alarmsList_itemsPerPage);
	
		//Edit the first Alarm
		clickRadioButton_byText("High temperature core 0");
		checkStatus(BTN_ALARMS_EDIT,"enabled","Button Edit Alarm");
		clickButton(BTN_ALARMS_EDIT);
		updateMap(RETRIES);
		
		//Check status and values in all fields (CheckBoxes, Input Fields,Drop-Down Lists)
		checkStatus(CB_ALARMS_SET_ACTIVE, "checked", "Checkbox Set as active");
		checkStatus(CB_ALARMS_SET_ACTIVE, "enabled", "Checkbox Set as active");
		
		checkValue_byId(IPF_ALARMS_GROUP_ID, "1");
		checkStatus(IPF_ALARMS_GROUP_ID, "disabled", "Input Field Group ID");
		
		checkValue_byId(IPF_ALARMS_GROUP_NAME, "Hardware");
		checkStatus(IPF_ALARMS_GROUP_ID, "disabled", "Input Field Group Name");
		
		checkValue_byId(IPF_ALARMS_EVENT_ID, "1");
		checkStatus(IPF_ALARMS_GROUP_ID, "disabled", "Input Field Event ID");
		
		checkValue_byId(IPF_ALARMS_EVENT_NAME, "High temperature core 0");
		checkStatus(IPF_ALARMS_EVENT_NAME, "disabled", "Input Field Event Name");
		
		checkValue_byId(IPF_ALARMS_FAULTY_OBJECT, "HW-Sensors");
		checkStatus(IPF_ALARMS_FAULTY_OBJECT, "disabled", "Input Field Faulty Object");
		
		checkValue_byId(IPF_ALARMS_EVENT_TYPE, "Equipment");
		checkStatus(IPF_ALARMS_EVENT_TYPE, "disabled", "Input Field Event Type");
		
		checkValue_byId(IPF_ALARMS_THRESHOLD_TRIGGER, "Greater than");
		checkStatus(IPF_ALARMS_THRESHOLD_TRIGGER, "disabled", "Input Field Threshold Trigger");
		
		checkValue_byId(IPF_ALARMS_THRESHOLD, "70");
		checkStatus(IPF_ALARMS_THRESHOLD, "enabled", "Input Field Threshold");
		
		checkValue_byId(IPF_ALARMS_THRESHOLD, "70");
		checkStatus(IPF_ALARMS_THRESHOLD, "enabled", "Input Field Threshold");
	
		checkValue_byId(IPF_ALARMS_FLOW_TIMER, "0");
		checkStatus(IPF_ALARMS_FLOW_TIMER, "enabled", "Input Field Flow Timer");
	
		checkValue_byId(IPF_ALARMS_REPORTING_CLASS, "1");
		checkStatus(IPF_ALARMS_REPORTING_CLASS, "enabled", "Input Field Reporting Class");
	
		String[] severityOptions = {"Critical","Major","Minor","Warning"};
		checkSelectedValue_inDropDownList(SLC_ALARMS_SEVERITY, "Critical");
		checkStatus(SLC_ALARMS_SEVERITY, "enabled", "Drop Down list Alarms Severity");
		getPossibleValuesOfDropDown(SLC_ALARMS_SEVERITY, severityOptions);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
	
	@Test (priority = 1)
	public void trapDestinations_CheckDefaultValues() throws InterruptedException {
		 
		methodLogger.log();
		goToAdministrationAlarms();
		updateMap(RETRIES);
		clickButton(TB_ALARMS_TRAP_DESTINATIONS); //Go to Trap Destinations Tab
	
		//Check Buttons Status
		checkStatus(BTN_ALARMS_TRAP_DEST_ADD_BUTTON, "enabled", "Button Add Trap Destination");
		checkStatus(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON, "disabled", "Button Edit Trap Destination");
		checkStatus(BTN_ALARMS_TRAP_DEST_DELETE_BUTTON, "disabled", "Button Delete Trap Destination");
		
		//Check Items per page List
		String[] trapDestinations_itemsPerPage = {"10","20","50","100","200"};
		checkSelectedValue_inDropDownList(SLC_ALARMS_TRAP_DEST_ITEMS_PER_PAGE, "10");
		checkStatus(SLC_ALARMS_TRAP_DEST_ITEMS_PER_PAGE, "enabled", "Drop Down list Alarms Items Per Page");
		getPossibleValuesOfDropDown(SLC_ALARMS_TRAP_DEST_ITEMS_PER_PAGE, trapDestinations_itemsPerPage);
	
		//Check Trap Destinations Items number
		checkText_AllItemsInList(TBL_ALARMS_TRAP_DEST_ALL_ITEMS, "0");
		
		//Check number of selected items
		checkText_byId(TD_NUMBER_OF_SELECTED_ITEMS_IN_TRAP_DESTINATIONS_LIST, "0");
		
		//Click Add Button
		clickButtonAdd();
		updateMap(RETRIES);
		
		//Check status and values in all fields (CheckBoxes, Input Fields)
		checkStatus(CB_ALARMS_TRAP_DEST_BLOCKED, "unchecked", "Checkbox Set as active");
		checkStatus(CB_ALARMS_TRAP_DEST_BLOCKED, "enabled", "Checkbox Set as active");
		
		checkValue_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "");
		checkStatus(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "enabled", "Input Field Trap Destination IP Address");
		
		checkValue_byId(IPF_ALARMS_TRAP_DEST_PORT, "162");
		checkStatus(IPF_ALARMS_TRAP_DEST_PORT, "enabled", "Input Field Trap Destination Port");
		
		checkValue_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "");
		checkStatus(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "enabled", "Input Field Trap Destination Reporting Class Set");
	
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}