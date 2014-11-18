package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.administration.configuration.logging.PropertiesLogging;
import com.helper.SuperHelper;

public class LS18_ProfilesList_CloneProfile_ModeSBCProxy extends SuperHelper implements PropertiesProfilesList,PropertiesLogging {

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
	public void profilesListCloneProfileModeSBCProxy() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		pr.cloneProfile("Pr02SBCProxyLogging", "ClonedSBCBroxy");
		
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyProfilesListProfileModeSBCProxyClone() throws InterruptedException {
		
		methodLogger.log(); 
		//Verify Cloned Profile Configuration
		selectFromDropDown(SLC_SELECTPROFILE, "ClonedSBCBroxy");
	
		goToProfilesLogging();
		    
		updateMap(RETRIES);

		//Verify debug levels
		checkSelectedValue_inDropDownList(SLC_SIP_SERVER,readproperties("OpenBranch\\OpenBranchGui", "common.emergency"));
		checkSelectedValue_inDropDownList(SLC_MEDIA_SERVER, readproperties("OpenBranch\\OpenBranchGui", "common.alert"));
		checkSelectedValue_inDropDownList(SLC_PROCESS_MANAGER, readproperties("OpenBranch\\OpenBranchGui", "common.critical"));
		checkSelectedValue_inDropDownList(SLC_ALARM_MANAGER, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkSelectedValue_inDropDownList(SLC_CONTINUOUS_TRACING, readproperties("OpenBranch\\OpenBranchGui", "common.warning"));
		checkSelectedValue_inDropDownList(SLC_B2BUA, readproperties("OpenBranch\\OpenBranchGui", "common.notice"));
		checkSelectedValue_inDropDownList(SLC_CDR, readproperties("OpenBranch\\OpenBranchGui", "common.info"));
		checkSelectedValue_inDropDownList(SLC_SURVIVABILITY_PROVIDER, readproperties("OpenBranch\\OpenBranchGui", "common.debug"));
		checkSelectedValue_inDropDownList(SLC_RTP_PROXY, readproperties("OpenBranch\\OpenBranchGui", "common.emergency"));
	
		//Check Type log size & log server
		checkValue_byId(IPF_LOG_SIZE, LOG_SIZE);
		checkValue_byId(IPF_LOG_SERVER, LOG_SERVER);
		
		//Check check box 
		checkStatus(CB_FALLBACK_DEFAULT, "enabled", "Checkbox Fallback to Default Log Level");
		checkStatus(CB_FALLBACK_DEFAULT, "checked", "Checkbox Fallback to Default Log Level");
		
		//Check Type hours & minutes
		checkValue_byId(IPF_FALLBACK_TIME_HOURS_XPATH, HOURS);
		checkValue_byId(IPF_FALLBACK_TIME_MINUTES_XPATH, MINUTES);
		
		//Select TAB debugging
		clickButton(TB_PROFILES_CONTINIOUS_TRACING);
		
		//Verify all input fields and checkBoxes
		
		checkStatus(CB_ENABLE, "checked", "Checkbox Enable Continuous Tracing");
		checkValue_byId(IPF_SERVER, "10.11.152.105");
		checkValue_byId(IPF_FILE_SIZE, "510");
		checkValue_byId(IPF_TIME_INTERVAL, "6");
		checkStatus(CB_SIP, "checked", "Checkbox SIP/Q931 Trace");
		checkStatus(CB_MGCP, "checked", "Checkbox MGCP Trace");	
		checkValue_byId(IPF_SFTP_SYSTEM, "Adsa115Simplex");
		checkValue_byId(IPF_SFTP_USERNAME, "Assistant");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
}
	
	
}