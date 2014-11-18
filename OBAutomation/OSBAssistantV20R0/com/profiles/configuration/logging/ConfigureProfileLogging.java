package com.profiles.configuration.logging;

import com.administration.configuration.logging.PropertiesLogging;
import com.helper.SuperHelper;
import com.profiles.list.PropertiesProfilesList;

public class ConfigureProfileLogging extends SuperHelper implements PropertiesProfilesList,PropertiesLogging {

	public void configureProfileForLogging() throws InterruptedException {
		
	    goToProfilesLogging();
	    
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
		
		//Type log size & log server
		type_byId(IPF_LOG_SIZE, LOG_SIZE);
		type_byId(IPF_LOG_SERVER, LOG_SERVER);
		
		//Click check box
		if(!getCheckboxStatus(CB_FALLBACK_DEFAULT))
			clickCheckbox_byID(CB_FALLBACK_DEFAULT);
		
		//Type hours & minutes
		type_byId(IPF_FALLBACK_TIME_HOURS_XPATH, HOURS);
		type_byId(IPF_FALLBACK_TIME_MINUTES_XPATH, MINUTES);
	
		//Select TAB Continious Tracing
		clickButton(TB_PROFILES_CONTINIOUS_TRACING);
		
		//Enable
	    if(!getCheckboxStatus(CB_ENABLE))
		clickCheckbox_byID(CB_ENABLE);
		
		//Check that input fields become enabled
		checkStatus(IPF_SERVER, "enabled", "Input Field Server");
		checkStatus(IPF_FILE_SIZE, "enabled", "Input Field File Size Threshold");
		checkStatus(IPF_TIME_INTERVAL, "enabled", "Input Field Time Interval Threshold");
		checkStatus(IPF_SFTP_SYSTEM, "enabled", "Input Field SFTP System Name");
		checkStatus(IPF_SFTP_USERNAME, "enabled", "Input Field SFTP UserName");
		checkStatus(IPF_SFTP_PASSWORD, "enabled", "Input Field SFTP password");
		
		//Check that checkBoxes become enabled
		checkStatus(CB_SIP, "enabled", "Checkbox SIP/Q931 Trace");
		checkStatus(CB_MGCP, "enabled", "Checkbox MGCP Trace");
		
		//Insert Data
		type_byId(IPF_SERVER, "10.11.152.105");
		type_byId(IPF_FILE_SIZE, "510");
		type_byId(IPF_TIME_INTERVAL, "6");
		
		//Enable SIp & MGCP
		clickCheckbox_byID(CB_SIP);
		clickCheckbox_byID(CB_MGCP);
		
		type_byId(IPF_SFTP_SYSTEM, "Adsa115Simplex");
		type_byId(IPF_SFTP_USERNAME, "Assistant");
		type_byId(IPF_SFTP_PASSWORD, "Asd123!.");
	
		
		//Click button save
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmationProfiles();
	    
	}
	
      public void verifyProfileLoggingConfiguration() throws InterruptedException {
	    	
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
		clickButton(TB_CONTINIOUS_TRACING);
		
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
	   }
			
	
}