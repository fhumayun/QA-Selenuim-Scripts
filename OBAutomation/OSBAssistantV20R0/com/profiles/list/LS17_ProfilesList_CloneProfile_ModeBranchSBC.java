package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;

public class LS17_ProfilesList_CloneProfile_ModeBranchSBC extends SuperHelper implements PropertiesProfilesList,PropertiesAlarms {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToProfilesList();
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
	
	Profiles_GeneralMethods pr = new Profiles_GeneralMethods();
	
	@Test (priority = 0)
	public void profilesListCloneProfileModeBranchSBC() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		pr.cloneProfile("Pr01BranchSBCAlarms", "ClonedBranchSBC");
		
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyProfilesListProfileModeBranchSBCClone() throws InterruptedException {
		
		methodLogger.log(); 
		//Verify Cloned Profile Configuration
		selectFromDropDown(SLC_SELECTPROFILE, "ClonedBranchSBC");
	
		goToProfilesAlarms();
		    
		updateMap(RETRIES);
			
		//Go to Trap Destinations tab
		clickButton(TB_PROFILES_ALARMS_TRAP_DESTINATIONS);
		//Verify Trap Destination Creation
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100");
			
		//Verify Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100", "Port", "162");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100", "Reporting class set", "1;2;3");
				
		//Verify Trusted image presence
		checkElement(IMG_ALARMS_TRAP_DEST_BLOCKED);
		
		//Edit the Trap Destination
		clickCheckbox_byText("10.11.250.100");
		clickButton(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON);
			
		updateMap(RETRIES);
			
		//Verify Trap Destination Input Fields values and Blocked checkBox status
		checkValue_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.100");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_PORT, "162");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "1;2;3");
		checkStatus(CB_ALARMS_TRAP_DEST_BLOCKED, "checked", "Checkbox Set as active");
			
		clickButtonCancel();
		updateMap(RETRIES);
			
	    clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
}
	
	
}