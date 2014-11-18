package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP41_Voip_CommSystem_GeneralSettings extends SuperHelper implements PropertiesVoip {

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
	public void voipCommSystemModifyGeneralSettings() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Check Enable path tagging and Branch behind SBC checkboxes
        clickCheckbox_byID(CB_ENABLE_PATH_TAGGING);
        clickCheckbox_byID(CB_BRANCH_BEHIND_SBC);
        
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	
	@Test (priority = 1)
	public void verifyVoipCommSystemGeneralSettingsModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Verify modifications
    	checkStatus(CB_ENABLE_PATH_TAGGING,"enabled","Checkbox Enable path tagging");
    	checkStatus(CB_ENABLE_PATH_TAGGING,"checked","Checkbox Enable path tagging");
    
    	checkStatus(CB_BRANCH_BEHIND_SBC,"enabled","Checkbox Branch behind SBC");
    	checkStatus(CB_BRANCH_BEHIND_SBC,"checked","Checkbox Branch behind SBC");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipCommSystemRecoverInitialSettings() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //UnCheck Enable path tagging and Branch behind SBC checkboxes
        clickCheckbox_byID(CB_ENABLE_PATH_TAGGING);
        clickCheckbox_byID(CB_BRANCH_BEHIND_SBC);
        
        //Select Comm System Type Simplex
        selectFromDropDown(SLC_COMM_SYSTEM_TYPE, TXT_SIMPLEX);
        
        //Select Target Type for Node1 Binding
        selectFromDropDown(SLC_NODE1_TARGET_TYPE, TXT_BINDING);
     
        type_byId(IPF_NODE1_PRIMARY_SERVER, "127.0.0.0");
        selectFromDropDown(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
        type_byId(IPF_NODE1_PRIMARY_SERVER_PORT, "5060");
     
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	@Test (priority = 3)
	public void verifyVoipCommSystemInitialSettingsRecovering() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
    	checkStatus(CB_ENABLE_PATH_TAGGING,"enabled","Checkbox Enable path tagging");
    	checkStatus(CB_ENABLE_PATH_TAGGING,"checked","Checkbox Enable path tagging");
    
    	checkStatus(CB_BRANCH_BEHIND_SBC,"enabled","Checkbox Branch behind SBC");
    	checkStatus(CB_BRANCH_BEHIND_SBC,"checked","Checkbox Branch behind SBC");
     
    	checkStatus(SLC_NODE1_TARGET_TYPE,"enabled","Drop-Down List Node1 Target Type");
    	checkSelectedValue_inDropDownList(SLC_NODE1_TARGET_TYPE, TXT_BINDING);
    
    	checkStatus(IPF_NODE1_PRIMARY_SERVER, "enabled", "Input Field Node1 Primary Server");
		checkValue_byId(IPF_NODE1_PRIMARY_SERVER, "127.0.0.0");
	
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkSelectedValue_inDropDownList(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
    
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "enabled", "Input Field Node1 Primary Server Port");
		checkValue_byId(IPF_NODE1_PRIMARY_SERVER_PORT, "5060");
	
		checkStatus(IPF_NODE1_SECONDARY_SERVER, "disabled", "Input Field Node1 Secondary Server");
		checkStatus(SLC_NODE1_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Secondary Server Transport Protocol");
    	checkStatus(IPF_NODE1_SECONDARY_SERVER_PORT, "disabled", "Input Field Node1 Secondary Server Port");
    	
    	checkStatus(IPF_NODE1_SRV_RECORD, "disabled", "Input Field Node1 SRV Record");
	    checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node1  SRV Record Transport Protocol");
    	
	    checkStatus(SLC_NODE2_TARGET_TYPE,"disabled","Drop-Down List Node2 Target Type");
    	
	    checkStatus(IPF_NODE2_PRIMARY_SERVER, "disabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "disabled", "Input Field Node2 Primary Server Port");
		
    	checkStatus(IPF_NODE2_SECONDARY_SERVER, "disabled", "Input Field Node2 Secondary Server");
		checkStatus(SLC_NODE2_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Secondary Server Transport Protocol");
    	checkStatus(IPF_NODE2_SECONDARY_SERVER_PORT, "disabled", "Input Field Node2 Secondary Server Port");
		
    	checkStatus(IPF_NODE2_SRV_RECORD, "disabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node2  SRV Record Transport Protocol");
    
    	clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
}