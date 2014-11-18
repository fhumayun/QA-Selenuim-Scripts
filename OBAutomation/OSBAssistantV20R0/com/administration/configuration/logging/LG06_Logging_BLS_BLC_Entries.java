package com.administration.configuration.logging;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.voip.PropertiesVoip;
import com.helper.SuperHelper;

public class LG06_Logging_BLS_BLC_Entries extends SuperHelper implements PropertiesLogging,PropertiesVoip {

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
    public void loggingBackupLinkServerMode() throws InterruptedException {
    	
    	//Go to Voip tab and select Server option in Backup Link Mode Drop-Down List
    	classMethodLogger.log();
    	goToAdministrationVoip();
    	
    	updateMap(RETRIES);
    	selectFromDropDown(SLC_BACKUP_LINK_MODE, readproperties("OpenBranch\\OpenBranchGui", "editVoip.modeBLS"));
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        
        type_byId(IPF_SERVER_MODE_RTP_PORT_MIN, "65001");
        type_byId(IPF_SERVER_MODE_RTP_PORT_MAX, "65535");

    	clickButtonSave();
    	updateMap(RETRIES);
    	
    	clickButtonSave();
    	updateMap(RETRIES);
    	
    	goToAdministrationLogging();
		updateMap(RETRIES);
		
		//Go to Logging tab and verify that the Backup Link Server Drop-Down list has appeared
	    checkElement_isVisible(SLC_BACKUP_LINK_SERVER);
		checkText(readproperties("OpenBranch\\OpenBranchGui", "editVoip.BLS"));
		
    	clickButtonCancel();
    	updateMap(RETRIES);
    	clickButton(BTN_CANCELCHANGES);
		setMethodState();
		
    }	
		
    @Test(priority = 1)
    public void loggingBackupLinkClientMode() throws InterruptedException {
    	
    	//Go to Voip tab and select Client option in Backup Link Mode Drop-Down List
    	methodLogger.log();
    	goToAdministrationVoip();
    	
    	updateMap(RETRIES);
    	selectFromDropDown(SLC_BACKUP_LINK_MODE, readproperties("OpenBranch\\OpenBranchGui", "editVoip.modeBLC"));
    	
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        type_byId(IPF_PRIMARY_DID_NUMBER, "10");
        type_byId(IPF_CLIENT_MODE_RTP_PORT_MIN, "65001");
        type_byId(IPF_CLIENT_MODE_RTP_PORT_MAX, "65535");
        
    	clickButtonSave();
    	updateMap(RETRIES);
    	
    	clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Go to Logging tab and verify that the Backup Link Client Drop-Down list has appeared
    	goToAdministrationLogging();
		updateMap(RETRIES);
		
	    checkElement_isVisible(SLC_BACKUP_LINK_CLIENT);
		checkText(readproperties("OpenBranch\\OpenBranchGui", "editVoip.BLC"));
		
    	clickButtonCancel();
    	updateMap(RETRIES);
    	clickButton(BTN_CANCELCHANGES);
		setMethodState();
		
    }	
    
    @Test(priority = 2)
    public void loggingReturnToDefault() throws InterruptedException {
    	
    	//Go to Logging tab and verify that the Backup Link Client and Server Drop-Down lists have disappeared
    	goToAdministrationLogging();
		updateMap(RETRIES);
		
	    checkElement_NotPresent(SLC_BACKUP_LINK_SERVER);
	    checkElement_NotPresent(SLC_BACKUP_LINK_CLIENT);
		checkText_NotVisible(readproperties("OpenBranch\\OpenBranchGui", "editVoip.BLS"));
		checkText_NotVisible(readproperties("OpenBranch\\OpenBranchGui", "editVoip.BLC"));
		
    	clickButtonCancel();
    	updateMap(RETRIES);;
		setMethodState();
		
    }	
		
  

}