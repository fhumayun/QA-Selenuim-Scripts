package com.profiles.configuration.voip;

import com.administration.configuration.voip.PropertiesVoip;
import com.helper.SuperHelper;
import com.profiles.list.PropertiesProfilesList;

public class ConfigureProfileVoip extends SuperHelper implements PropertiesProfilesList,PropertiesVoip{

	
    public void configureProfileForVoip(String mode) throws InterruptedException {
		
	    goToProfilesVoip();
	    
	    updateMap(RETRIES);
	    
	    //General tab
        clickButton(TB_GENERAL);
        
        //Go to SIP Manipulation
        clickButton(BTN_MANIPULATION);
        updateMap(RETRIES);
        
        //Create SIP Manipulation
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_MATCH_DIGITS, "1000");
        type_byId(IPF_MATCH_POSITION, "23");
        selectFromDropDown(SLC_HEADER, TXT_R_URI);
        type_byId(IPF_DELETE_INSERT_POSITION, "23");
        type_byId(IPF_NUMBER_OF_DIGITS_TO_DELETE, "24");
        selectFromDropDown(SLC_CALL_TYPE, TXT_ALL);
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check SIP Manipulation Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_MANIPULATION, "1000");
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_MATCH_POSITION, "23");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_HEADER, TXT_R_URI);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_DELETE_INSERT_POSITION, "23");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_NUMBER_OF_DIGITS_TO_DELETE, "24");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_INSERT_DIGITS, "");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_ADD_PREFIX, "");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_REPLACE_ALL_WITH, "");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_CALL_TYPE, TXT_ALL);
	
		clickButtonSave();
		updateMap(RETRIES);
	
		//Go to SIP Routing
		clickButton(BTN_ROUTING);
	    updateMap(RETRIES);
	        
	    //Create SIP Routing
	    clickButtonAdd();
	    updateMap(RETRIES);
	        
	    type_byId(IPF_SOURCE_IP, "10.20.30.40");
	    type_byId(IPF_CONDITION_ERROR_CODES, "300");
	    type_byId(IPF_DESTINATION_IP_FQDN, "11.21.31.41");
	    type_byId(IPF_DESTINATION_PORT, "0");
	    selectFromDropDown(SLC_DESTINATION_TRANSPORT, TXT_TCP);
	    type_byId(IPF_DESTINATION_TAG, "tag1");
	    selectFromDropDown(SLC_DESTINATION_TYPE, TXT_GATEWAY);
	         
	    clickButtonSave();
	    updateMap(RETRIES);
	        
	    //Check SIP Routing Creation
	    checkTextIsContained_byXPathTable(TBL_LIST_SIP_ROUTING, "10.20.30.40");
	    checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_CONDITION_ERROR_CODES, "300");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_IP_FQDN, "11.21.31.41");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_PORT, "0");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_TRANSPORT, TXT_TCP);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_TAG, "tag1");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_TYPE, TXT_GATEWAY);
			
		clickButtonSave();
		updateMap(RETRIES);
		
		
		//Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
        
        //Verify that the error codes are by default 33
        checkText_byId(TXT_ERROR_CODES_ALL_ITEMS, "33");
        selectFromDropDown(SLC_ERROR_CODES_ITEMS_PER_PAGE, "50");
     
        //Check that by default the Rerouting is Disabled in Survivable Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
        //Check that by default the Rerouting is Disabled in Normal Mode
	    for (int i=0; i<33; i++)
	     checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
	    
	    //Enable Rerouting in Survivable Mode
	    clickButton(BTN_ENABLE_ALL_SURVIVABLE_MODE);
	    //Check that Rerouting is Enabled in Survivable Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
      
	    //Enable Rerouting in Survivable Mode
	    clickButton(BTN_ENABLE_ALL_NORMAL_MODE);
	    //Check that Rerouting is Enabled in Normal Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
	
	    clickButtonSave();
		updateMap(RETRIES);
	
	    //Change Listening Ports
        type_byId(IPF_LISTENING_PORT_TCP, "5065");
        type_byId(IPF_LISTENING_PORT_UDP, "5066");
        type_byId(IPF_LISTENING_PORT_TLS, "5067");
        type_byId(IPF_OPTIONS_SOURCE_PORT, "5068");
		
		//Check port mapping
		if(mode.equals(TXT_PROXY)||mode.equals(TXT_PROXY_ACD))
		{       
		   //Check that the Port Mapping fields are disabled
			checkStatus(IPF_RTP_PORTS_MIN, "disabled", "Input Field RTP Ports Min Value");
			checkStatus(IPF_RTP_PORTS_MAX, "disabled", "Input Field RTP Ports Max Value");
			checkStatus(IPF_TIME_TO_LIVE, "disabled", "Input Field Time To Live");
			checkStatus(IPF_SIP_PORTS_MIN, "disabled", "Input Field SIP Ports Min Value");
			checkStatus(IPF_SIP_PORTS_MAX, "disabled", "Input Field SIP Ports Max Value");
			checkStatus(BTN_SIP_SERVICE_PROVIDER_PROFILES, "disabled", "Button SIP Service Provider Profiles");
		}
		if(mode.equals(TXT_SBC_PROXY)||mode.equals(TXT_BRANCH_SBC))
		{       
		   //Check that the Port Mapping fields are enabled
			checkStatus(IPF_RTP_PORTS_MIN, "enabled", "Input Field RTP Ports Min Value");
			checkStatus(IPF_RTP_PORTS_MAX, "enabled", "Input Field RTP Ports Max Value");
			checkStatus(IPF_TIME_TO_LIVE, "enabled", "Input Field Time To Live");
			checkStatus(IPF_SIP_PORTS_MIN, "enabled", "Input Field SIP Ports Min Value");
			checkStatus(IPF_SIP_PORTS_MAX, "enabled", "Input Field SIP Ports Max Value");

		//Go to SIP Service Provider Profiles
		clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
	    updateMap(RETRIES);
	        
	     //Create SIP Service Provider Profile (input From Data Provider)
	     clickButtonAdd();
	     updateMap(RETRIES);
	        
	     type_byId(IPF_SIP_SERVICE_PROVIDER_PROFILE_NAME, "AutoProvider1");
	     selectFromDropDown(SLC_PRIVACY_SUPPORT, TXT_FULL);
	   
	     clickButtonSave();
	     updateMap(RETRIES);
	        
	    //Check SIP Service Provider Profile Creation
	    checkTextIsContained_byXPathTable(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, "AutoProvider1");
	    checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, "AutoProvider1", TXT_REGISTRATION_INTERVAL, "3600");
				
		clickButtonSave();
		updateMap(RETRIES);
		
        }
		
		
		//Change Gateway Settings
		type_byId(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "20");
	    clickCheckbox_byID(CB_ROUTING_SUPERVISION_TIMER);
	    selectFromDropDown(SLC_ROUTING_SUPERVISION_TIMER, "16000");
	    
	    //Enable QoS Configuration
        if(!getCheckboxStatus(CB_ENABLE_QOS))
        clickCheckbox_byID(CB_ENABLE_QOS);
        
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
        
        //Change values in DSCP for SIP and DSCP for RTP input fields
        type_byId(IPF_DSCP_FOR_SIP, "10");
        type_byId(IPF_DSCP_FOR_RTP, "20");
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Timers And Thresholds tab
        clickButton(TB_PROFILES_TIMER_AND_THRESHOLDS);
        
    	type_byId(IPF_FAILURE_THRESHOLD, "4");
	    type_byId(IPF_SUCCESS_THRESHOLD, "2");
		type_byId(IPF_TRASITION_MODE_THRESHOLD, "2");
		type_byId(IPF_OPTIONS_INTERVAL, "120");
		type_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "8");
	
	    clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmationProfiles();
	    
	}
	
      public void verifyProfileVoipConfiguration(String mode) throws InterruptedException {
	    	
	    methodLogger.log();
	    
		goToAdministrationVoip();
    
		updateMap(RETRIES);
		
	    //General tab
        clickButton(TB_GENERAL);
        
        //Go to SIP Manipulation
        clickButton(BTN_MANIPULATION);
        updateMap(RETRIES);
		
		//Verify SIP Manipulation Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_MANIPULATION, "1000");
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_MATCH_POSITION, "23");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_HEADER, TXT_R_URI);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_DELETE_INSERT_POSITION, "23");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_NUMBER_OF_DIGITS_TO_DELETE, "24");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_INSERT_DIGITS, "");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_ADD_PREFIX, "");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_REPLACE_ALL_WITH, "");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "1000", TXT_CALL_TYPE, TXT_ALL);
	
		//Edit SIP Manipulation and Verify fields
		clickCheckbox_byText("1000");
		clickButtonEdit();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_MATCH_DIGITS, "1000");
		checkValue_byId(IPF_MATCH_POSITION, "23");
	    checkSelectedValue_inDropDownList(SLC_HEADER, TXT_R_URI);
	    checkValue_byId(IPF_DELETE_INSERT_POSITION, "23");
	    checkValue_byId(IPF_NUMBER_OF_DIGITS_TO_DELETE, "24");
	    checkValue_byId(IPF_INSERT_DIGITS, "");
	    checkValue_byId(IPF_ADD_PREFIX, "");
	    checkValue_byId(IPF_REPLACE_ALL_WITH, "");
	    checkSelectedValue_inDropDownList(SLC_CALL_TYPE, TXT_ALL);
		
	    
	    clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		//Go to SIP Routing
	    clickButton(BTN_ROUTING);
        updateMap(RETRIES);
		
		//Verify SIP Routing Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_ROUTING, "10.20.30.40");
	    checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_CONDITION_ERROR_CODES, "300");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_IP_FQDN, "11.21.31.41");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_PORT, "0");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_TRANSPORT, TXT_TCP);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_TAG, "tag1");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "10.20.30.40", TXT_DESTINATION_TYPE, TXT_GATEWAY);
		
		//Edit SIP Routing and Verify fields
		clickCheckbox_byText("10.20.30.40");
		clickButtonEdit();
		updateMap(RETRIES);
	    
		checkValue_byId(IPF_SOURCE_IP, "10.20.30.40");
		checkValue_byId(IPF_CONDITION_ERROR_CODES, "300");
		checkValue_byId(IPF_DESTINATION_IP_FQDN, "11.21.31.41");
		checkValue_byId(IPF_DESTINATION_PORT, "0");
		checkSelectedValue_inDropDownList(SLC_DESTINATION_TRANSPORT, TXT_TCP);
		checkValue_byId(IPF_DESTINATION_TAG, "tag1");
		checkSelectedValue_inDropDownList(SLC_DESTINATION_TYPE, TXT_GATEWAY);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		//Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
      
        //Verify that Rerouting is Enabled in Survivable Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
        //Verify that Rerouting is Enabled in Normal Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
	
        clickButtonCancel();
		updateMap(RETRIES);
	
		//Verify Listening Port values
	    checkValue_byId(IPF_LISTENING_PORT_TCP, "5065");
	    checkValue_byId(IPF_LISTENING_PORT_UDP, "5066");
	    checkValue_byId(IPF_LISTENING_PORT_TLS, "5067");
	    checkValue_byId(IPF_OPTIONS_SOURCE_PORT, "5068");
		
	   //Verify port mapping
		if(mode.equals(TXT_PROXY)||mode.equals(TXT_PROXY_ACD))
		{       
		   //Verify that the Port Mapping fields are disabled
			checkStatus(IPF_RTP_PORTS_MIN, "disabled", "Input Field RTP Ports Min Value");
			checkStatus(IPF_RTP_PORTS_MAX, "disabled", "Input Field RTP Ports Max Value");
			checkStatus(IPF_TIME_TO_LIVE, "disabled", "Input Field Time To Live");
			checkStatus(IPF_SIP_PORTS_MIN, "disabled", "Input Field SIP Ports Min Value");
			checkStatus(IPF_SIP_PORTS_MAX, "disabled", "Input Field SIP Ports Max Value");
			checkStatus(BTN_SIP_SERVICE_PROVIDER_PROFILES, "disabled", "Button SIP Service Provider Profiles");
		}
		if(mode.equals(TXT_SBC_PROXY)||mode.equals(TXT_BRANCH_SBC))
		{       
		   //Verify that the Port Mapping fields are enabled
			checkStatus(IPF_RTP_PORTS_MIN, "enabled", "Input Field RTP Ports Min Value");
			checkStatus(IPF_RTP_PORTS_MAX, "enabled", "Input Field RTP Ports Max Value");
			checkStatus(IPF_TIME_TO_LIVE, "enabled", "Input Field Time To Live");
			checkStatus(IPF_SIP_PORTS_MIN, "enabled", "Input Field SIP Ports Min Value");
			checkStatus(IPF_SIP_PORTS_MAX, "enabled", "Input Field SIP Ports Max Value");
		
		//Go to SIP Service Provider Profiles
		clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
	    updateMap(RETRIES);
			
	    //Verify SIP Service Provider Profile Creation
	    checkTextIsContained_byXPathTable(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, "AutoProvider1");
	    checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, "AutoProvider1", TXT_REGISTRATION_INTERVAL, "3600");
		
		//Edit SIP Service Provider Profile and Verify fields
		clickCheckbox_byText("AutoProvider1");
		clickButtonEdit();
		updateMap(RETRIES);
			
		checkValue_byId(IPF_SIP_SERVICE_PROVIDER_PROFILE_NAME, "AutoProvider1");
		//checkSelectedValue_inDropDownList(SLC_DEFAULT_SSP_PROFILE, x2);
		checkSelectedValue_inDropDownList(SLC_PRIVACY_SUPPORT, TXT_FULL);
		checkStatus(CB_MANDATORY_DEFAULT_HOME_DN,"unchecked","Checkbox");
		checkValue_byId(IPF_DEFAULT_HOME_DN, "");
		checkStatus(CB_USE_SIP_SERVICE_ADDRESS,"unchecked","Checkbox");
		checkValue_byId(IPF_SIP_SERVICE_ADDRESS, "");
		checkStatus(CB_REGISTRATION_REQUIRED,"unchecked","Checkbox");
	    checkValue_byId(IPF_INTERVAL, "3600");
		checkStatus(CB_BUSINESS_IDENTITY_REQUIRED,"unchecked","Checkbox");
		checkValue_byId(IPF_BUSINESS_IDENTITY_DN, "");
		checkStatus(CB_DIGEST_AUTHENTICATION_SUPPORTED,"unchecked","Checkbox");
		checkValue_byId(IPF_REALM, "");
		checkValue_byId(IPF_USER_ID, "");
		checkValue_byId(IPF_USER_PASSWORD, "");
		   
	    clickButtonCancel();
	    updateMap(RETRIES);
			
		clickButtonCancel();
		updateMap(RETRIES);
			
        }
		
		//Verify Gateway Settings
	    checkStatus(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "enabled", "Input Field DNS Dynamic Refresh Interval");
		checkValue_byId(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "20");
			
	    checkStatus(CB_ROUTING_SUPERVISION_TIMER,"enabled","Checkbox Extend alternate routing supervision timer");
	    checkStatus(CB_ROUTING_SUPERVISION_TIMER,"checked","Checkbox Extend alternate routing supervision timer");
	    	
	    checkStatus(SLC_ROUTING_SUPERVISION_TIMER,"enabled","Drop-Down List Backup Link Mode");
	    checkSelectedValue_inDropDownList(SLC_ROUTING_SUPERVISION_TIMER, "16000");
	  
		clickButton(BTN_CONFIGURE_QOS);
	    updateMap(RETRIES);
			
	    //Verify values in DSCP for SIP and DSCP for RTP input fields
	    checkValue_byId(IPF_DSCP_FOR_SIP, "10");
	    checkValue_byId(IPF_DSCP_FOR_RTP, "20");
		
	    clickButtonCancel();
		updateMap(RETRIES);
	    
		//Timers And Thresholds tab
        clickButton(TB_TIMER_AND_THRESHOLDS);
        
        checkValue_byId(IPF_FAILURE_THRESHOLD, "4");
		checkValue_byId(IPF_SUCCESS_THRESHOLD, "2");
		checkValue_byId(IPF_TRASITION_MODE_THRESHOLD, "2");
		checkValue_byId(IPF_OPTIONS_INTERVAL, "120");
		checkValue_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "8");
		
		clickButtonCancel();
		updateMap(RETRIES);
	   }
			
	
}