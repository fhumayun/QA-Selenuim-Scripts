package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.administration.management.PropertiesManagement;
import com.helper.SuperHelper;

public class VP15_Voip_ConfigureBLS extends SuperHelper implements PropertiesVoip,PropertiesManagement {

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
	public void voipConfigureBLS() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Configure Backup Link Server Mode
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_SERVER);
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        
        type_byId(IPF_MAX_BACKUP_LINKS, "15");
        type_byId(IPF_MAX_NUMBER_B_CHANNELS, "60");
        type_byId(IPF_PPP_SUBNET_IP_NETMASK_BITS, "10.1.0.0/16");
        type_byId(IPF_OSV_LSM_IP_ADDRESS, "10.2.252.13");
        selectFromDropDown(SLC_SERVER_MODE_PACKETIZATION_INTERVAL, "50");
        type_byId(IPF_SERVER_MODE_RTP_PORT_MIN, "65001");
        type_byId(IPF_SERVER_MODE_RTP_PORT_MAX, "65535");
        
        clickButtonSave();
		updateMap(RETRIES);
		
          
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyVoipBLSConfiguration() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Verify that Backup link status button is enabled in Management
		checkStatus(BTN_SHOW_LINK_STATUS, "enabled", "Button Show Backup link status");
		clickButton_ByXpath(BTN_SHOW_LINK_STATUS);
		updateMap(RETRIES);
		checkText(TXT_BACKUP_LINK_SERVER_STATUS);
		clickButtonClose();
		updateMap(RETRIES);
		
		//Now go to Voip tab
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
       
        //Verify Backup Link Server Mode Configuration
        checkSelectedValue_inDropDownList(SLC_BACKUP_LINK_MODE, TXT_SERVER);
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        
        checkValue_byId(IPF_MAX_BACKUP_LINKS, "15");
        checkValue_byId(IPF_MAX_NUMBER_B_CHANNELS, "60");
        checkValue_byId(IPF_PPP_SUBNET_IP_NETMASK_BITS, "10.1.0.0/16");
        checkValue_byId(IPF_OSV_LSM_IP_ADDRESS, "10.2.252.13");
        checkSelectedValue_inDropDownList(SLC_SERVER_MODE_PACKETIZATION_INTERVAL, "50");
        checkValue_byId(IPF_SERVER_MODE_RTP_PORT_MIN, "65001");
        checkValue_byId(IPF_SERVER_MODE_RTP_PORT_MAX, "65535");
       
        
        clickButtonCancel();
		updateMap(RETRIES);
		
	   clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}