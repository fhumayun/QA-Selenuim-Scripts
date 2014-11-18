package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.administration.management.PropertiesManagement;
import com.helper.SuperHelper;

public class VP13_Voip_ConfigureBLC extends SuperHelper implements PropertiesVoip,PropertiesManagement {

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
	public void voipConfigureBLC() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Configure Backup Link Client Mode
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_CLIENT);
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        
        type_byId(IPF_PRIMARY_DID_NUMBER, "10");
        type_byId(IPF_SECONDARY_DID_NUMBER, "20");
        type_byId(IPF_CONGESTION_DELAY, "15");
        selectFromDropDown(SLC_BLC_PPP_AUTHENTICATION, "PAP");
        type_byId(IPF_BLC_PPP_USER_NAME, "autouser");
        type_byId(IPF_BLC_PPP_PASSWORD, "Asd123!.");
        selectFromDropDown(SLC_CLIENT_MODE_PACKETIZATION_INTERVAL, "30");
        type_byId(IPF_CLIENT_MODE_RTP_PORT_MIN, "65001");
        type_byId(IPF_CLIENT_MODE_RTP_PORT_MAX, "65535");
        type_byId(IPF_MINIMUM_NUMBER_B_CHANNELS, "3");
        type_byId(IPF_MAXIMUM_NUMBER_B_CHANNELS, "7");
        type_byId(IPF_INITIAL_NUMBER_B_CHANNELS, "4");
        type_byId(IPF_HIGH_WATERMARK, "91");
        type_byId(IPF_LOW_WATERMARK, "60");
        type_byId(IPF_HIGH_WATERMARK_DETECTION_WINDOW, "5");
        type_byId(IPF_LOW_WATERMARK_DETECTION_WINDOW, "50");
        
        checkStatus(IPF_MINIMUM_BANDWIDTH, "disabled", "Input Field Minimum bandwidth");
        checkValue_byId(IPF_MINIMUM_BANDWIDTH, "128");
        checkStatus(IPF_MAXIMUM_BANDWIDTH, "disabled", "Input Field Maximum bandwidth");
        checkValue_byId(IPF_MAXIMUM_BANDWIDTH, "384");
        checkStatus(IPF_INITIAL_BANDWIDTH, "disabled", "Input Field Initial bandwidth");
        checkValue_byId(IPF_INITIAL_BANDWIDTH, "128");
        
        clickButtonSave();
		updateMap(RETRIES);
		
        //Set Option Interval in Timer And Thresholds tab to 120 in order to be able to Apply Changes
        clickButton(TB_TIMER_AND_THRESHOLDS);
        type_byId(IPF_OPTIONS_INTERVAL, "120");
        type_byId(IPF_FAILURE_THRESHOLD, "3");
        type_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "10");
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyVoipBLCConfiguration() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Verify that Backup link status button is enabled in Management
		checkStatus(BTN_SHOW_LINK_STATUS, "enabled", "Button Show Backup link status");
		clickButton_ByXpath(BTN_SHOW_LINK_STATUS);
		updateMap(RETRIES);
		checkText(TXT_BACKUP_LINK_CLIENT_STATUS);
		clickButtonClose();
		updateMap(RETRIES);
		
		//Now go to Voip tab
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
       
        //Verify Backup Link Client Mode Configuration
        checkSelectedValue_inDropDownList(SLC_BACKUP_LINK_MODE, TXT_CLIENT);
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        
        checkValue_byId(IPF_PRIMARY_DID_NUMBER, "10");
        checkValue_byId(IPF_SECONDARY_DID_NUMBER, "20");
        checkValue_byId(IPF_CONGESTION_DELAY, "15");
        checkSelectedValue_inDropDownList(SLC_BLC_PPP_AUTHENTICATION, "PAP");
        checkValue_byId(IPF_BLC_PPP_USER_NAME, "autouser");
        checkValue_byId(IPF_BLC_PPP_PASSWORD, "Asd123!.");
        checkSelectedValue_inDropDownList(SLC_CLIENT_MODE_PACKETIZATION_INTERVAL, "30");
        checkValue_byId(IPF_CLIENT_MODE_RTP_PORT_MIN, "65001");
        checkValue_byId(IPF_CLIENT_MODE_RTP_PORT_MAX, "65535");
        checkValue_byId(IPF_MINIMUM_NUMBER_B_CHANNELS, "3");
        checkValue_byId(IPF_MAXIMUM_NUMBER_B_CHANNELS, "7");
        checkValue_byId(IPF_INITIAL_NUMBER_B_CHANNELS, "4");
        checkValue_byId(IPF_HIGH_WATERMARK, "91");
        checkValue_byId(IPF_LOW_WATERMARK, "60");
        checkValue_byId(IPF_HIGH_WATERMARK_DETECTION_WINDOW, "5");
        checkValue_byId(IPF_LOW_WATERMARK_DETECTION_WINDOW, "50");
      	
        checkValue_byId(IPF_MINIMUM_BANDWIDTH, "192");
        checkValue_byId(IPF_MAXIMUM_BANDWIDTH, "448");
        checkValue_byId(IPF_INITIAL_BANDWIDTH, "256");

        clickButtonCancel();
		updateMap(RETRIES);
	
		//Verify Option Interval value
        clickButton(TB_TIMER_AND_THRESHOLDS);
        checkValue_byId(IPF_OPTIONS_INTERVAL, "120");
        checkValue_byId(IPF_FAILURE_THRESHOLD, "3");
        checkValue_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "10");
        
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}