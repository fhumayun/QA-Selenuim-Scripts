package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.administration.management.PropertiesManagement;
import com.helper.SuperHelper;

public class VP20_Voip_SetBackupLinkModeNone extends SuperHelper implements PropertiesVoip,PropertiesManagement {

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
	public void voipSetBackupLinkModeNone() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Set backup Link Mode to None
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_NONE);
       
        //Check that the Configure Backup Link Mode button becomes disabled
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"disabled","Button Configure Backup Link Mode");
        
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyBackupLinkModeNoneSet() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Verify that Backup link status button is disabled in Management
		checkStatus(BTN_SHOW_LINK_STATUS, "disabled", "Button Show Backup link status");
			
		//Now go to Voip tab
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Verify that the selected option for Backup Link Mode is None
        checkSelectedValue_inDropDownList(SLC_BACKUP_LINK_MODE, TXT_NONE);
        //Verify that the Configure Backup Link Mode button is disabled
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"disabled","Button Configure Backup Link Mode");
       
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}