package com.profiles.configuration.mediaserver;

import com.administration.configuration.mediaserver.PropertiesMediaServer;
import com.helper.SuperHelper;
import com.profiles.list.PropertiesProfilesList;

public class ConfigureProfileMediaServer extends SuperHelper implements PropertiesProfilesList,PropertiesMediaServer {

	public void configureProfileForMediaServer() throws InterruptedException {
		
	    goToProfilesMediaServer();
	    
	    updateMap(RETRIES);
        
        if(!getCheckboxStatus(CB_ENABLED))
			clickCheckbox_byID(CB_ENABLED);
        
        //Check that Input Fields,CheckBoxes,Drop-Down Lists and Buttons turns to Enabled
        checkStatus(IPF_MS_LISTEN_PORT, "enabled", "Input Field Media Server Listen Port");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "enabled", "Input Field Maximum conference time");
        checkStatus(IPF_PAC, "enabled", "Input Field Prefix access code");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "enabled", "Input Field Maximum announcement time");
        checkStatus(CB_USE_FQDN, "enabled", "Checkbox Use FQDN");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "enabled", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "enabled", "Checkbox Announcement Unlimited");
        checkStatus(CB_STOP_ANNOUNCEMENT, "enabled", "Checkbox Stop announcement on DTMF");
        checkStatus(BTN_CONFIGURE, "enabled", "Checkbox Button Configure");
      
        //Modify Values in All Input Fields
        type_byId(IPF_MS_LISTEN_PORT, "2430");
        type_byId(IPF_MAX_CONFERENCE_TIME, "19000");
        type_byId(IPF_PAC, "30210805");
        type_byId(IPF_MAX_ANNOUNCE_TIME, "2000");
        
    	clickButtonSave();
    	updateMap(RETRIES);
		
		applyChangesWithConfirmationProfiles();
	    
	}
	
      public void verifyProfileMediaServerConfiguration() throws InterruptedException {
	    	
	    methodLogger.log();
	    goToAdministrationMediaServer();
	    updateMap(RETRIES);
			
	    //Verify values and status of Input Fields,CheckBoxes,Drop-Down Lists and Buttons
        checkValue_byId(IPF_MS_LISTEN_PORT, "2430");
        checkStatus(IPF_MS_LISTEN_PORT, "enabled", "Input Field Media Server Listen Port");
        checkValue_byId(IPF_CONFERENCE_PORT, "28");
        checkStatus(IPF_CONFERENCE_PORT, "enabled", "Input Field Number of conference ports");
        checkValue_byId(IPF_MAX_CONFERENCE_TIME, "19000");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "enabled", "Input Field Maximum conference time");
        checkValue_byId(IPF_PAC, "30210805");
        checkStatus(IPF_PAC, "enabled", "Input Field Prefix access code");
        checkValue_byId(IPF_CONFERENCE_ANNOUNCEMENT, "12");
        checkStatus(IPF_CONFERENCE_ANNOUNCEMENT, "enabled", "Input Field Number of announcement ports");
        checkValue_byId(IPF_MAX_ANNOUNCE_TIME, "2000");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "enabled", "Input Field Maximum announcement time");
        checkStatus(CB_USE_FQDN, "enabled", "Checkbox Use FQDN");
        checkStatus(CB_USE_FQDN, "unchecked", "Checkbox Use FQDN");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "enabled", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_CONFERENE, "unchecked", "Checkbox Conference Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "enabled", "Checkbox Announcement Unlimited");
        checkStatus(CB_UNLIMITED_MAX_ANNOUNCEMENT, "unchecked", "Checkbox Announcement Unlimited");
        checkStatus(CB_STOP_ANNOUNCEMENT, "enabled", "Checkbox Stop announcement on DTMF");
        checkStatus(CB_STOP_ANNOUNCEMENT, "unchecked", "Checkbox Stop announcement on DTMF");
        checkStatus(SLC_LANGUAGE_SELECTION, "enabled", "Checkbox MS Language");
        checkSelectedValue_inDropDownList(SLC_LANGUAGE_SELECTION, "en_us");
        checkStatus(BTN_CONFIGURE, "enabled", "Checkbox Button Configure");
    
		clickButtonCancel();
		updateMap(RETRIES);
	   }
			
	
}