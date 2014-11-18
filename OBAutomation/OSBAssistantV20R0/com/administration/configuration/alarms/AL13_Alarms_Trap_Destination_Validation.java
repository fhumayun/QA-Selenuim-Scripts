package com.administration.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AL13_Alarms_Trap_Destination_Validation extends SuperHelper implements PropertiesAlarms{

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
    public void trapDestinationEmptyValues() throws InterruptedException {
    	
    	classMethodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		clickButtonAdd();
		
		updateMap(RETRIES);
		
		type_byId(IPF_ALARMS_TRAP_DEST_PORT,"");
		
		clickButtonSave();
	
		//Check validation messages
		checkText_byId(DIV_ALARMS_TRAP_DEST_IP_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.valueIsRequired"));
		checkText_byId(DIV_ALARMS_TRAP_DEST_PORT_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.valueIsRequired"));
		checkText_byId(DIV_ALARMS_TRAP_DEST_REPORTING_CLASS_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.valueIsRequired"));
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void trapDestinationInvalidValues() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		clickButtonAdd();
		
		updateMap(RETRIES);
		
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "a");
		type_byId(IPF_ALARMS_TRAP_DEST_PORT,"a");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "a");
		
		clickButtonSave();
	
		//Check validation messages
		checkText_byId(DIV_ALARMS_TRAP_DEST_IP_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.ipAddressValidator"));
		checkText_byId(DIV_ALARMS_TRAP_DEST_PORT_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.portValidator"));
		checkText_byId(DIV_ALARMS_TRAP_DEST_REPORTING_CLASS_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.reportingClassSet"));
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);;
		setMethodState();
		
    }
		
    @Test(priority = 2)
    public void trapDestinationValuesOutOfRange() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		clickButtonAdd();
		
		updateMap(RETRIES);
		
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "256.256.256.256");
		type_byId(IPF_ALARMS_TRAP_DEST_PORT,"65536");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "8");
		
		clickButtonSave();
	
		//Check validation messages
		checkText_byId(DIV_ALARMS_TRAP_DEST_IP_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.ipAddressValidator"));
		checkText_byId(DIV_ALARMS_TRAP_DEST_PORT_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.portValidator"));
		checkText_byId(DIV_ALARMS_TRAP_DEST_REPORTING_CLASS_VALIDATION, readproperties("OpenBranch\\OpenBranchGuiError", "common.reportingClassSet"));

		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);;
		setMethodState();
    	
    }
    
    @Test(priority = 3)
    public void trapDestinationUniqueness() throws InterruptedException {
    	
    	methodLogger.log();
    	goToAdministrationAlarms();
		updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_ALARMS_TRAP_DESTINATIONS);
		
		//Add a Trap Destination
		clickButtonAdd();
		
		updateMap(RETRIES);
		
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "1.2.3.4");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "1");
		
		clickButtonSave();
	
		updateMap(RETRIES);
		
		checkText("1.2.3.4");
		
		//Try to Add the same Trap Destination again
		//Add a Trap Destination
		clickButtonAdd();
		
		updateMap(RETRIES);
		
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "1.2.3.4");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "1");
		
		clickButtonSave();
	
		//Check that a validation pop-up appears 
		checkMessageFailed("OpenBranch\\OpenBranchGuiError", "common.duplicatedIp", null);
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);;
		setMethodState();
    	
    }
  

}