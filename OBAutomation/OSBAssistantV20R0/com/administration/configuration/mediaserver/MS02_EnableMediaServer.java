package com.administration.configuration.mediaserver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class MS02_EnableMediaServer extends SuperHelper implements PropertiesMediaServer {

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
	public void enableMediaServer() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        if(!getCheckboxStatus(CB_ENABLED))
			clickCheckbox_byID(CB_ENABLED);
        
        //Check that Input Fields,CheckBoxes,Drop-Down Lists and Buttons turns to Enabled
        checkStatus(IPF_MS_LISTEN_PORT, "enabled", "Input Field Media Server Listen Port");
        checkStatus(IPF_CONFERENCE_PORT, "enabled", "Input Field Number of conference ports");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "enabled", "Input Field Maximum conference time");
        checkStatus(IPF_PAC, "enabled", "Input Field Prefix access code");
        checkStatus(IPF_CONFERENCE_ANNOUNCEMENT, "enabled", "Input Field Number of announcement ports");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "enabled", "Input Field Maximum announcement time");
        checkStatus(CB_USE_FQDN, "enabled", "Checkbox Use FQDN");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "enabled", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "enabled", "Checkbox Announcement Unlimited");
        checkStatus(CB_STOP_ANNOUNCEMENT, "enabled", "Checkbox Stop announcement on DTMF");
        checkStatus(SLC_LANGUAGE_SELECTION, "enabled", "Checkbox MS Language");
        checkStatus(BTN_CONFIGURE, "enabled", "Checkbox Button Configure");
      
    	clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyMediaServerEnabling() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        //Verify values and status of Input Fields,CheckBoxes,Drop-Down Lists and Buttons
        checkValue_byId(IPF_MS_LISTEN_PORT, "2427");
        checkStatus(IPF_MS_LISTEN_PORT, "enabled", "Input Field Media Server Listen Port");
        checkValue_byId(IPF_CONFERENCE_PORT, "28");
        checkStatus(IPF_CONFERENCE_PORT, "enabled", "Input Field Number of conference ports");
        checkValue_byId(IPF_MAX_CONFERENCE_TIME, "18000");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "enabled", "Input Field Maximum conference time");
        checkValue_byId(IPF_PAC, "1234567890");
        checkStatus(IPF_PAC, "enabled", "Input Field Prefix access code");
        checkValue_byId(IPF_CONFERENCE_ANNOUNCEMENT, "12");
        checkStatus(IPF_CONFERENCE_ANNOUNCEMENT, "enabled", "Input Field Number of announcement ports");
        checkValue_byId(IPF_MAX_ANNOUNCE_TIME, "1800");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "enabled", "Input Field Maximum announcement time");
        checkStatus(CB_USE_FQDN, "enabled", "Checkbox Use FQDN");
        checkStatus(CB_USE_FQDN, "unchecked", "Checkbox Use FQDN");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "enabled", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "unchecked", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "enabled", "Checkbox Announcement Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "unchecked", "Checkbox Announcement Unlimited");
        checkStatus(CB_STOP_ANNOUNCEMENT, "enabled", "Checkbox Stop announcement on DTMF");
        checkStatus(CB_STOP_ANNOUNCEMENT, "checked", "Checkbox Stop announcement on DTMF");
        checkStatus(SLC_LANGUAGE_SELECTION, "enabled", "Checkbox MS Language");
        checkSelectedValue_inDropDownList(SLC_LANGUAGE_SELECTION, "en_us");
        checkStatus(BTN_CONFIGURE, "enabled", "Checkbox Button Configure");
      
    	clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}
	

}