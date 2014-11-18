package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP29_Voip_GatewaySettings extends SuperHelper implements PropertiesVoip {

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
	public void voipModifyGatewaySettings() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        type_byId(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "20");
        clickCheckbox_byID(CB_ROUTING_SUPERVISION_TIMER);
        selectFromDropDown(SLC_ROUTING_SUPERVISION_TIMER, "16000");
    
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 1)
	public void verifyVoipGatewaySettingsModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        checkStatus(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "enabled", "Input Field DNS Dynamic Refresh Interval");
		checkValue_byId(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "20");
		
		checkStatus(CB_ROUTING_SUPERVISION_TIMER,"enabled","Checkbox Extend alternate routing supervision timer");
    	checkStatus(CB_ROUTING_SUPERVISION_TIMER,"checked","Checkbox Extend alternate routing supervision timer");
    	
    	checkStatus(SLC_ROUTING_SUPERVISION_TIMER,"enabled","Drop-Down List Backup Link Mode");
    	checkSelectedValue_inDropDownList(SLC_ROUTING_SUPERVISION_TIMER, "16000");
    		
    	clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipRecoverGatewaySettings() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Disable Gateways Configuration
        if(getCheckboxStatus(CB_ENABLE_GATEWAYS))
        clickCheckbox_byID(CB_ENABLE_GATEWAYS);
        
        type_byId(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "10");
        clickCheckbox_byID(CB_ROUTING_SUPERVISION_TIMER);
        selectFromDropDown(SLC_ROUTING_SUPERVISION_TIMER, "32000");
    
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyVoipGatewaySettingsRecovering() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        checkStatus(BTN_CONFIGURE_GATEWAYS,"disabled","Button Configure Gateways");
    	
        checkStatus(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "enabled", "Input Field DNS Dynamic Refresh Interval");
		checkValue_byId(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "10");
		
		checkStatus(CB_ROUTING_SUPERVISION_TIMER,"enabled","Checkbox Extend alternate routing supervision timer");
    	checkStatus(CB_ROUTING_SUPERVISION_TIMER,"unchecked","Checkbox Extend alternate routing supervision timer");
    	
    	checkStatus(SLC_ROUTING_SUPERVISION_TIMER,"enabled","Drop-Down List Backup Link Mode");
    	checkSelectedValue_inDropDownList(SLC_ROUTING_SUPERVISION_TIMER, "32000");
    		
    	clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
}