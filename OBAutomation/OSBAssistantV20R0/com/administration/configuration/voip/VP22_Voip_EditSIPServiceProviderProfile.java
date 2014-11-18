package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP22_Voip_EditSIPServiceProviderProfile extends SuperHelper implements PropertiesVoip {

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
	public void voipModifySIPServiceProviderProfile() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider1");
        clickButtonEdit();
        updateMap(RETRIES);
        
        //Go to Options tab
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_OPTIONS);
        
        //Check default status
        checkStatus(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER,"enabled","Checkbox Allow Sending of Insecure Referred By Header");
        checkStatus(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER,"unchecked","Checkbox Allow Sending of Insecure Referred By Header");
        
        checkStatus(CB_SEND_P_PREFFERED_IDENTITY,"enabled","Checkbox Send P-Preferred Identity rather than P-Asserted Identity");
        checkStatus(CB_SEND_P_PREFFERED_IDENTITY,"unchecked","Checkbox Send P-Preferred Identity rather than P-Asserted Identity");
        
        checkStatus(CB_DO_NOT_SEND_DIVERSION_HEADER,"enabled","Checkbox Do not send Diversion header");
        checkStatus(CB_DO_NOT_SEND_DIVERSION_HEADER,"unchecked","Checkbox Do not send Diversion header");
        
        checkStatus(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT,"enabled","Checkbox Send Uri in Telephone Subscriber Format");
        checkStatus(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT,"unchecked","Checkbox Send Uri in Telephone Subscriber Format");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"enabled","Checkbox Send authentication number in Diversion header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"unchecked","Checkbox Send authentication number in Diversion header");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER,"enabled","Checkbox Send authentication number in P-Asserted Identity header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER,"unchecked","Checkbox Send authentication number in P-Asserted Identity header");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER,"enabled","Checkbox Send authentication number in From header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER,"unchecked","Checkbox Send authentication number in From header");
        
        checkStatus(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER,"enabled","Checkbox Include restricted numbers in From header");
        checkStatus(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER,"unchecked","Checkbox Include restricted numbers in From header");
        
        checkStatus(SLC_CERTIFICATE_FILES,"disabled","Drop-Down List Certificate File");
        checkStatus(SLC_CA_CERTIFICATES,"disabled","Drop-Down List CA Certificates");
        checkStatus(SLC_KEY_FILES,"disabled","Drop-Down List Key File");
        
        //Enable all Checkboxes
        clickCheckbox_byID(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER);
        clickCheckbox_byID(CB_SEND_P_PREFFERED_IDENTITY);
        clickCheckbox_byID(CB_DO_NOT_SEND_DIVERSION_HEADER);
        //The Checkbox Send authentication number in Diversion header becomes disabled
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"disabled","Checkbox Send authentication number in Diversion header");
        clickCheckbox_byID(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT);
        clickCheckbox_byID(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER);
        clickCheckbox_byID(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER);
        clickCheckbox_byID(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER);
        
        //Go to Flags tab
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_FLAGS);
        
        //Check default status
        checkStatus(CB_FQDN_IN_REQUEST_TO_URI,"enabled","Checkbox FQDN in Request to URI");
        checkStatus(CB_FQDN_IN_REQUEST_TO_URI,"unchecked","Checkbox FQDN in Request to URI");
        
        checkStatus(CB_FQDN_TO_HEADER_SSP,"enabled","Checkbox FQDN to header SSP");
        checkStatus(CB_FQDN_TO_HEADER_SSP,"unchecked","Checkbox FQDN to header SSP");
        
        checkStatus(CB_REFER_SUPPORTED_SSP,"enabled","Checkbox Refer supported SSP");
        checkStatus(CB_REFER_SUPPORTED_SSP,"unchecked","Checkbox Refer supported SSP");
        
        checkStatus(CB_SPARE_FLAG1,"enabled","Checkbox Spare Flag 1");
        checkStatus(CB_SPARE_FLAG1,"unchecked","Checkbox Spare Flag 1");
        
        checkStatus(CB_SPARE_FLAG2,"enabled","Checkbox Spare Flag 2");
        checkStatus(CB_SPARE_FLAG2,"unchecked","Checkbox Spare Flag 2");
        
        checkStatus(CB_SPARE_FLAG3,"enabled","Checkbox Spare Flag 3");
        checkStatus(CB_SPARE_FLAG3,"unchecked","Checkbox Spare Flag 3");
        
        checkStatus(CB_SPARE_FLAG4,"enabled","Checkbox Spare Flag 4");
        checkStatus(CB_SPARE_FLAG4,"unchecked","Checkbox Spare Flag 4");
        
        checkStatus(CB_SPARE_FLAG5,"enabled","Checkbox Spare Flag 5");
        checkStatus(CB_SPARE_FLAG5,"unchecked","Checkbox Spare Flag 5");
 
        checkStatus(CB_SPARE_FLAG6,"enabled","Checkbox Spare Flag 6");
        checkStatus(CB_SPARE_FLAG6,"unchecked","Checkbox Spare Flag 6");
        
        checkStatus(CB_SPARE_FLAG7,"enabled","Checkbox Spare Flag 7");
        checkStatus(CB_SPARE_FLAG7,"unchecked","Checkbox Spare Flag 7");
        
        checkStatus(CB_SPARE_FLAG8,"enabled","Checkbox Spare Flag 8");
        checkStatus(CB_SPARE_FLAG8,"unchecked","Checkbox Spare Flag 8");
        
        checkStatus(CB_SPARE_FLAG9,"enabled","Checkbox Spare Flag 9");
        checkStatus(CB_SPARE_FLAG9,"unchecked","Checkbox Spare Flag 9");
        
        checkStatus(CB_SPARE_FLAG10,"enabled","Checkbox Spare Flag 10");
        checkStatus(CB_SPARE_FLAG10,"unchecked","Checkbox Spare Flag 10");
        
        //Enable all Checkboxes
        clickCheckbox_byID(CB_FQDN_IN_REQUEST_TO_URI);
        clickCheckbox_byID(CB_FQDN_TO_HEADER_SSP);
        clickCheckbox_byID(CB_REFER_SUPPORTED_SSP);
        clickCheckbox_byID(CB_SPARE_FLAG1);
        clickCheckbox_byID(CB_SPARE_FLAG2);
        clickCheckbox_byID(CB_SPARE_FLAG3);
        clickCheckbox_byID(CB_SPARE_FLAG4);
        clickCheckbox_byID(CB_SPARE_FLAG5);
        clickCheckbox_byID(CB_SPARE_FLAG6);
        clickCheckbox_byID(CB_SPARE_FLAG7);
        clickCheckbox_byID(CB_SPARE_FLAG8);
        clickCheckbox_byID(CB_SPARE_FLAG9);
        clickCheckbox_byID(CB_SPARE_FLAG10);
        
        //Go to SIP Manipulation tab
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
       
        //Check default status
        checkStatus(CB_INSERT_ANONYMOUS_CALLER_ID,"enabled","Checkbox Insert Anonymous Caller-ID for blocked Caller-ID");
        checkStatus(CB_INSERT_ANONYMOUS_CALLER_ID,"unchecked","Checkbox Insert Anonymous Caller-ID for blocked Caller-ID");
       
        //Enable Checkbox Insert Anonymous Caller-ID for blocked Caller-ID
        clickCheckbox_byID(CB_INSERT_ANONYMOUS_CALLER_ID);
        
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	
	@Test (priority = 1)
	public void verifyVoipSIPServiceProviderModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider1");
        clickButtonEdit();
        updateMap(RETRIES);
        
        //Go to Options tab and verify fields
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_OPTIONS);
        
        checkStatus(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER,"enabled","Checkbox Allow Sending of Insecure Referred By Header");
        checkStatus(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER,"checked","Checkbox Allow Sending of Insecure Referred By Header");
        
        checkStatus(CB_SEND_P_PREFFERED_IDENTITY,"enabled","Checkbox Send P-Preferred Identity rather than P-Asserted Identity");
        checkStatus(CB_SEND_P_PREFFERED_IDENTITY,"checked","Checkbox Send P-Preferred Identity rather than P-Asserted Identity");
        
        checkStatus(CB_DO_NOT_SEND_DIVERSION_HEADER,"enabled","Checkbox Do not send Diversion header");
        checkStatus(CB_DO_NOT_SEND_DIVERSION_HEADER,"checked","Checkbox Do not send Diversion header");
        
        checkStatus(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT,"enabled","Checkbox Send Uri in Telephone Subscriber Format");
        checkStatus(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT,"checked","Checkbox Send Uri in Telephone Subscriber Format");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"disabled","Checkbox Send authentication number in Diversion header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"unchecked","Checkbox Send authentication number in Diversion header");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER,"enabled","Checkbox Send authentication number in P-Asserted Identity header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER,"checked","Checkbox Send authentication number in P-Asserted Identity header");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER,"enabled","Checkbox Send authentication number in From header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER,"checked","Checkbox Send authentication number in From header");
        
        checkStatus(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER,"enabled","Checkbox Include restricted numbers in From header");
        checkStatus(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER,"checked","Checkbox Include restricted numbers in From header");
     
        //Go to Flags tab and verify fields
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_FLAGS);
        
        checkStatus(CB_FQDN_IN_REQUEST_TO_URI,"enabled","Checkbox FQDN in Request to URI");
        checkStatus(CB_FQDN_IN_REQUEST_TO_URI,"checked","Checkbox FQDN in Request to URI");
        
        checkStatus(CB_FQDN_TO_HEADER_SSP,"enabled","Checkbox FQDN to header SSP");
        checkStatus(CB_FQDN_TO_HEADER_SSP,"checked","Checkbox FQDN to header SSP");
        
        checkStatus(CB_REFER_SUPPORTED_SSP,"enabled","Checkbox Refer supported SSP");
        checkStatus(CB_REFER_SUPPORTED_SSP,"checked","Checkbox Refer supported SSP");
        
        checkStatus(CB_SPARE_FLAG1,"enabled","Checkbox Spare Flag 1");
        checkStatus(CB_SPARE_FLAG1,"checked","Checkbox Spare Flag 1");
        
        checkStatus(CB_SPARE_FLAG2,"enabled","Checkbox Spare Flag 2");
        checkStatus(CB_SPARE_FLAG2,"checked","Checkbox Spare Flag 2");
        
        checkStatus(CB_SPARE_FLAG3,"enabled","Checkbox Spare Flag 3");
        checkStatus(CB_SPARE_FLAG3,"checked","Checkbox Spare Flag 3");
        
        checkStatus(CB_SPARE_FLAG4,"enabled","Checkbox Spare Flag 4");
        checkStatus(CB_SPARE_FLAG4,"checked","Checkbox Spare Flag 4");
        
        checkStatus(CB_SPARE_FLAG5,"enabled","Checkbox Spare Flag 5");
        checkStatus(CB_SPARE_FLAG5,"checked","Checkbox Spare Flag 5");
 
        checkStatus(CB_SPARE_FLAG6,"enabled","Checkbox Spare Flag 6");
        checkStatus(CB_SPARE_FLAG6,"checked","Checkbox Spare Flag 6");
        
        checkStatus(CB_SPARE_FLAG7,"enabled","Checkbox Spare Flag 7");
        checkStatus(CB_SPARE_FLAG7,"checked","Checkbox Spare Flag 7");
        
        checkStatus(CB_SPARE_FLAG8,"enabled","Checkbox Spare Flag 8");
        checkStatus(CB_SPARE_FLAG8,"checked","Checkbox Spare Flag 8");
        
        checkStatus(CB_SPARE_FLAG9,"enabled","Checkbox Spare Flag 9");
        checkStatus(CB_SPARE_FLAG9,"checked","Checkbox Spare Flag 9");
        
        checkStatus(CB_SPARE_FLAG10,"enabled","Checkbox Spare Flag 10");
        checkStatus(CB_SPARE_FLAG10,"checked","Checkbox Spare Flag 10");

        //Go to SIP Manipulation tab and verify fields
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
       
        checkStatus(CB_INSERT_ANONYMOUS_CALLER_ID,"enabled","Checkbox Insert Anonymous Caller-ID for blocked Caller-ID");
        checkStatus(CB_INSERT_ANONYMOUS_CALLER_ID,"checked","Checkbox Insert Anonymous Caller-ID for blocked Caller-ID");
      
    	clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	
	}	
	
	@Test (priority = 2)
	public void voipSIPServiceProviderProfileRecoverInitialSettings() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider1");
        clickButtonEdit();
        updateMap(RETRIES);
        
        //Go to Options tab
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_OPTIONS);
        
        //Uncheck all Checkboxes
        clickCheckbox_byID(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER);
        clickCheckbox_byID(CB_SEND_P_PREFFERED_IDENTITY);
        clickCheckbox_byID(CB_DO_NOT_SEND_DIVERSION_HEADER);
        //The Checkbox Send authentication number in Diversion header becomes enabled
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"enabled","Checkbox Send authentication number in Diversion header");
        clickCheckbox_byID(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT);
        clickCheckbox_byID(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER);
        clickCheckbox_byID(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER);
        clickCheckbox_byID(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER);
        
        //Go to Flags tab
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_FLAGS);
        
        //Uncheck all Checkboxes
        clickCheckbox_byID(CB_FQDN_IN_REQUEST_TO_URI);
        clickCheckbox_byID(CB_FQDN_TO_HEADER_SSP);
        clickCheckbox_byID(CB_REFER_SUPPORTED_SSP);
        clickCheckbox_byID(CB_SPARE_FLAG1);
        clickCheckbox_byID(CB_SPARE_FLAG2);
        clickCheckbox_byID(CB_SPARE_FLAG3);
        clickCheckbox_byID(CB_SPARE_FLAG4);
        clickCheckbox_byID(CB_SPARE_FLAG5);
        clickCheckbox_byID(CB_SPARE_FLAG6);
        clickCheckbox_byID(CB_SPARE_FLAG7);
        clickCheckbox_byID(CB_SPARE_FLAG8);
        clickCheckbox_byID(CB_SPARE_FLAG9);
        clickCheckbox_byID(CB_SPARE_FLAG10);
        
        //Go to SIP Manipulation tab
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
     
        //Uncheck Checkbox Insert Anonymous Caller-ID for blocked Caller-ID
        clickCheckbox_byID(CB_INSERT_ANONYMOUS_CALLER_ID);
        
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 3)
	public void verifyVoipSIPServiceProviderRecovering() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider1");
        clickButtonEdit();
        updateMap(RETRIES);
        
        //Go to Options tab and verify fields
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_OPTIONS);
        
        checkStatus(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER,"enabled","Checkbox Allow Sending of Insecure Referred By Header");
        checkStatus(CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER,"unchecked","Checkbox Allow Sending of Insecure Referred By Header");
        
        checkStatus(CB_SEND_P_PREFFERED_IDENTITY,"enabled","Checkbox Send P-Preferred Identity rather than P-Asserted Identity");
        checkStatus(CB_SEND_P_PREFFERED_IDENTITY,"unchecked","Checkbox Send P-Preferred Identity rather than P-Asserted Identity");
        
        checkStatus(CB_DO_NOT_SEND_DIVERSION_HEADER,"enabled","Checkbox Do not send Diversion header");
        checkStatus(CB_DO_NOT_SEND_DIVERSION_HEADER,"unchecked","Checkbox Do not send Diversion header");
        
        checkStatus(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT,"enabled","Checkbox Send Uri in Telephone Subscriber Format");
        checkStatus(CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT,"unchecked","Checkbox Send Uri in Telephone Subscriber Format");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"enabled","Checkbox Send authentication number in Diversion header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER,"unchecked","Checkbox Send authentication number in Diversion header");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER,"enabled","Checkbox Send authentication number in P-Asserted Identity header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER,"unchecked","Checkbox Send authentication number in P-Asserted Identity header");
        
        checkStatus(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER,"enabled","Checkbox Send authentication number in From header");
        checkStatus(CB_SEND_AUTH_NUMBER_IN_FROM_HEADER,"unchecked","Checkbox Send authentication number in From header");
        
        checkStatus(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER,"enabled","Checkbox Include restricted numbers in From header");
        checkStatus(CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER,"unchecked","Checkbox Include restricted numbers in From header");
     
        //Go to Flags tab and verify fields
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_FLAGS);
        
        checkStatus(CB_FQDN_IN_REQUEST_TO_URI,"enabled","Checkbox FQDN in Request to URI");
        checkStatus(CB_FQDN_IN_REQUEST_TO_URI,"unchecked","Checkbox FQDN in Request to URI");
        
        checkStatus(CB_FQDN_TO_HEADER_SSP,"enabled","Checkbox FQDN to header SSP");
        checkStatus(CB_FQDN_TO_HEADER_SSP,"unchecked","Checkbox FQDN to header SSP");
        
        checkStatus(CB_REFER_SUPPORTED_SSP,"enabled","Checkbox Refer supported SSP");
        checkStatus(CB_REFER_SUPPORTED_SSP,"unchecked","Checkbox Refer supported SSP");
        
        checkStatus(CB_SPARE_FLAG1,"enabled","Checkbox Spare Flag 1");
        checkStatus(CB_SPARE_FLAG1,"unchecked","Checkbox Spare Flag 1");
        
        checkStatus(CB_SPARE_FLAG2,"enabled","Checkbox Spare Flag 2");
        checkStatus(CB_SPARE_FLAG2,"unchecked","Checkbox Spare Flag 2");
        
        checkStatus(CB_SPARE_FLAG3,"enabled","Checkbox Spare Flag 3");
        checkStatus(CB_SPARE_FLAG3,"unchecked","Checkbox Spare Flag 3");
        
        checkStatus(CB_SPARE_FLAG4,"enabled","Checkbox Spare Flag 4");
        checkStatus(CB_SPARE_FLAG4,"unchecked","Checkbox Spare Flag 4");
        
        checkStatus(CB_SPARE_FLAG5,"enabled","Checkbox Spare Flag 5");
        checkStatus(CB_SPARE_FLAG5,"unchecked","Checkbox Spare Flag 5");
 
        checkStatus(CB_SPARE_FLAG6,"enabled","Checkbox Spare Flag 6");
        checkStatus(CB_SPARE_FLAG6,"unchecked","Checkbox Spare Flag 6");
        
        checkStatus(CB_SPARE_FLAG7,"enabled","Checkbox Spare Flag 7");
        checkStatus(CB_SPARE_FLAG7,"unchecked","Checkbox Spare Flag 7");
        
        checkStatus(CB_SPARE_FLAG8,"enabled","Checkbox Spare Flag 8");
        checkStatus(CB_SPARE_FLAG8,"unchecked","Checkbox Spare Flag 8");
        
        checkStatus(CB_SPARE_FLAG9,"enabled","Checkbox Spare Flag 9");
        checkStatus(CB_SPARE_FLAG9,"unchecked","Checkbox Spare Flag 9");
        
        checkStatus(CB_SPARE_FLAG10,"enabled","Checkbox Spare Flag 10");
        checkStatus(CB_SPARE_FLAG10,"unchecked","Checkbox Spare Flag 10");

        //Go to SIP Manipulation tab and verify fields
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
       
        checkStatus(CB_INSERT_ANONYMOUS_CALLER_ID,"enabled","Checkbox Insert Anonymous Caller-ID for blocked Caller-ID");
        checkStatus(CB_INSERT_ANONYMOUS_CALLER_ID,"unchecked","Checkbox Insert Anonymous Caller-ID for blocked Caller-ID");
      
    	clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	
	}	
	

}