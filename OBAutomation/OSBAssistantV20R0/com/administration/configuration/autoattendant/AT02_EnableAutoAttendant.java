package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT02_EnableAutoAttendant extends SuperHelper implements PropertiesAutoAttendant {

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

	
	@Test (priority = 0)
	public void enableAutoAttendant() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        clickButton(TB_GENERAL);
        if(!getCheckboxStatus(CB_ENABLE_AUTO_ATTENDANT))
			clickCheckbox_byID(CB_ENABLE_AUTO_ATTENDANT);
      
        //Tabs Routing and Menus become enabled
        checkStatus(TB_ROUTING,"enabled","Tab Routing");
		checkStatus(TB_MENUS,"enabled","Tab Menus");
	
        
        //The Input Field Interdigit timer,Wait to go to menu and Record access code become enabled
        checkStatus(IPF_INTERDIGIT_TIMER, "enabled", "Input Field Interdigit timer");
		checkStatus(IPF_WAIT_TO_GO_TO_MENU, "enabled", "Input Field Wait to go to menu");
		checkStatus(IPF_RECORD_ACCESS_CODE, "enabled", "Input Field Record access code");

        //Change value in these fields
		type_byId(IPF_INTERDIGIT_TIMER, "6");
		type_byId(IPF_WAIT_TO_GO_TO_MENU, "2");
		type_byId(IPF_RECORD_ACCESS_CODE, "*100");
		
	    clickButtonSave();     
	    updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantEnabling() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
     
        checkStatus(CB_ENABLE_AUTO_ATTENDANT,"enabled","Checkbox Enable Auto Attendant");
		checkStatus(CB_ENABLE_AUTO_ATTENDANT,"checked","Checkbox Enable Auto Attendant");
	   
		//Verify status of tabs Routing and Menus
		checkStatus(TB_ROUTING,"enabled","Tab Routing");
		checkStatus(TB_MENUS,"enabled","Tab Menus");
		
        //Verify values and status in Input Fields Interdigit timer,Wait to go to menu and Record access code
        checkStatus(IPF_INTERDIGIT_TIMER, "enabled", "Input Field Interdigit timer");
		checkStatus(IPF_WAIT_TO_GO_TO_MENU, "enabled", "Input Field Wait to go to menu");
		checkStatus(IPF_RECORD_ACCESS_CODE, "enabled", "Input Field Record access code");
        checkValue_byId(IPF_INTERDIGIT_TIMER, "6");
		checkValue_byId(IPF_WAIT_TO_GO_TO_MENU, "2");
		checkValue_byId(IPF_RECORD_ACCESS_CODE, "*100");
		
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}