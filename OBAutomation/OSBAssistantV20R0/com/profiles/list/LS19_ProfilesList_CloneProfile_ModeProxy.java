package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.mediaserver.PropertiesMediaServer;
import com.helper.SuperHelper;

public class LS19_ProfilesList_CloneProfile_ModeProxy extends SuperHelper implements PropertiesProfilesList,PropertiesMediaServer {

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

	Profiles_GeneralMethods pr = new Profiles_GeneralMethods();
	
	@Test (priority = 0)
	public void profilesListCloneProfileModeProxy() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		pr.cloneProfile("Pr03ProxyMediaServer", "ClonedProxy");
		
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyProfilesListProfileModeProxyClone() throws InterruptedException {
		
		methodLogger.log(); 
		//Verify Cloned Profile Configuration
		selectFromDropDown(SLC_SELECTPROFILE, "ClonedProxy");
		goToProfilesMediaServer();
		    
	    updateMap(RETRIES);
		
	    //Verify values and status of Input Fields,CheckBoxes,Drop-Down Lists and Buttons
	    //in the clone profile
        checkStatus(IPF_MS_LISTEN_PORT, "enabled", "Input Field Media Server Listen Port");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "enabled", "Input Field Maximum conference time");
        checkStatus(IPF_PAC, "enabled", "Input Field Prefix access code");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "enabled", "Input Field Maximum announcement time");
        checkStatus(CB_USE_FQDN, "enabled", "Checkbox Use FQDN");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "enabled", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "enabled", "Checkbox Announcement Unlimited");
        checkStatus(CB_STOP_ANNOUNCEMENT, "enabled", "Checkbox Stop announcement on DTMF");
        checkStatus(BTN_CONFIGURE, "enabled", "Checkbox Button Configure");
        checkValue_byId(IPF_MS_LISTEN_PORT, "2430");
        checkValue_byId(IPF_MAX_CONFERENCE_TIME, "19000");
        checkValue_byId(IPF_PAC, "30210805");
        checkValue_byId(IPF_MAX_ANNOUNCE_TIME, "2000");
    
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
}
	
}