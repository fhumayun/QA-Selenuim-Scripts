package com.administration.configuration.logging;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LG02_Logging_Settings extends SuperHelper implements PropertiesLogging {

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
	
	@Test (priority=0)
	public void changeLoggingSettings() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationLogging();
		updateMap(RETRIES);
	
		javaScriptConfirmation("alert");
		//Change Log Level in all Drop-Down Menus
		selectFromDropDown(SLC_SIP_SERVER,readproperties("OpenBranch\\OpenBranchGui", "common.emergency"));
		selectFromDropDown(SLC_MEDIA_SERVER, readproperties("OpenBranch\\OpenBranchGui", "common.alert"));
		selectFromDropDown(SLC_PROCESS_MANAGER, readproperties("OpenBranch\\OpenBranchGui", "common.critical"));
		selectFromDropDown(SLC_ALARM_MANAGER, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		selectFromDropDown(SLC_CONTINUOUS_TRACING, readproperties("OpenBranch\\OpenBranchGui", "common.warning"));
		selectFromDropDown(SLC_B2BUA, readproperties("OpenBranch\\OpenBranchGui", "common.notice"));
		selectFromDropDown(SLC_CDR, readproperties("OpenBranch\\OpenBranchGui", "common.info"));
		selectFromDropDown(SLC_SURVIVABILITY_PROVIDER, readproperties("OpenBranch\\OpenBranchGui", "common.debug"));
		selectFromDropDown(SLC_RTP_PROXY, readproperties("OpenBranch\\OpenBranchGui", "common.emergency"));
		selectFromDropDown(SLC_SSM, readproperties("OpenBranch\\OpenBranchGui", "common.alert"));
		selectFromDropDown(SLC_CAS, readproperties("OpenBranch\\OpenBranchGui", "cas_mf_trace"));
		
		//Type log size & log server
		type_byId(IPF_LOG_SIZE, LOG_SIZE);
		type_byId(IPF_LOG_SERVER, LOG_SERVER);
		
		//Click check box
		if(!getCheckboxStatus(CB_FALLBACK_DEFAULT))
			clickCheckbox_byID(CB_FALLBACK_DEFAULT);
		
		//Type hours & minutes
		type_byId(IPF_FALLBACK_TIME_HOURS_XPATH, HOURS);
		type_byId(IPF_FALLBACK_TIME_MINUTES_XPATH, MINUTES);
	
		
		//Click button save
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();	
		setMethodState();
	
	}
	
	@Test (priority=1)
	public void verifyLoggingSettings() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationLogging();
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
		checkSelectedValue_inDropDownList(SLC_SSM, readproperties("OpenBranch\\OpenBranchGui", "common.alert"));
		checkSelectedValue_inDropDownList(SLC_CAS, readproperties("OpenBranch\\OpenBranchGui", "cas_mf_trace"));
	
		//Check Type log size & log server
		checkValue_byId(IPF_LOG_SIZE, LOG_SIZE);
		checkValue_byId(IPF_LOG_SERVER, LOG_SERVER);
		
		//Check check box 
		checkStatus(CB_FALLBACK_DEFAULT, "enabled", "Checkbox Fallback to Default Log Level");
		checkStatus(CB_FALLBACK_DEFAULT, "checked", "Checkbox Fallback to Default Log Level");
		
		//Check Type hours & minutes
		checkValue_byId(IPF_FALLBACK_TIME_HOURS_XPATH, HOURS);
		checkValue_byId(IPF_FALLBACK_TIME_MINUTES_XPATH, MINUTES);
		
		clickButtonCancel();
		
		updateMap(RETRIES);
		
		setMethodState();
	}

}