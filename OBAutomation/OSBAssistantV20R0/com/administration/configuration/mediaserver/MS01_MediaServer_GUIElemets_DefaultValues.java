package com.administration.configuration.mediaserver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class MS01_MediaServer_GUIElemets_DefaultValues extends SuperHelper implements PropertiesMediaServer {

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
	public void mediaServer_CheckDefaultValues() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        checkStatus(CB_ENABLED, "enabled", "Checkbox Enable Media Server");
        checkStatus(CB_ENABLED, "unchecked", "Checkbox Enable Media Server");

        //Check Default status and values of Input Fields,CheckBoxes,Drop-Down Lists and Buttons
        checkValue_byId(IPF_MS_LISTEN_PORT, "2427");
        checkStatus(IPF_MS_LISTEN_PORT, "disabled", "Input Field Media Server Listen Port");
        checkValue_byId(IPF_CONFERENCE_PORT, "28");
        checkStatus(IPF_CONFERENCE_PORT, "disabled", "Input Field Number of conference ports");
        checkValue_byId(IPF_MAX_CONFERENCE_TIME, "18000");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "disabled", "Input Field Maximum conference time");
        checkValue_byId(IPF_PAC, "1234567890");
        checkStatus(IPF_PAC, "disabled", "Input Field Prefix access code");
        checkValue_byId(IPF_CONFERENCE_ANNOUNCEMENT, "12");
        checkStatus(IPF_CONFERENCE_ANNOUNCEMENT, "disabled", "Input Field Number of announcement ports");
        checkValue_byId(IPF_MAX_ANNOUNCE_TIME, "1800");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "disabled", "Input Field Maximum announcement time");
        checkStatus(CB_USE_FQDN, "disabled", "Checkbox Use FQDN");
        checkStatus(CB_USE_FQDN, "unchecked", "Checkbox Use FQDN");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "disabled", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "unchecked", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "disabled", "Checkbox Announcement Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "unchecked", "Checkbox Announcement Unlimited");
        checkStatus(CB_STOP_ANNOUNCEMENT, "disabled", "Checkbox Stop announcement on DTMF");
        checkStatus(CB_STOP_ANNOUNCEMENT, "checked", "Checkbox Stop announcement on DTMF");
        checkStatus(SLC_LANGUAGE_SELECTION, "disabled", "Checkbox MS Language");
        checkSelectedValue_inDropDownList(SLC_LANGUAGE_SELECTION, "en_us");
        checkStatus(BTN_CONFIGURE, "disabled", "Checkbox Button Configure");
      
        clickButtonCancel();
		setMethodState();
	}

}