package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP39_Voip_CommSystem_Collocated extends SuperHelper implements PropertiesVoip {

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
	public void voipCommSystemCollocatedTargetBinding() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Select Comm System Type Collocated 
        selectFromDropDown(SLC_COMM_SYSTEM_TYPE, TXT_COLLOCATED);
        
        //The Node 2 Target Type and Primary Server fields become enabled
        checkStatus(SLC_NODE2_TARGET_TYPE,"enabled","Drop-Down List Node2 Target Type");
        checkStatus(IPF_NODE2_PRIMARY_SERVER, "enabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "enabled", "Input Field Node2 Primary Server Port");
		
    	//Select Target Type for Node2 Binding
        selectFromDropDown(SLC_NODE2_TARGET_TYPE, TXT_BINDING);
        type_byId(IPF_NODE2_PRIMARY_SERVER, "10.1.250.130");
        selectFromDropDown(SLC_NODE2_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
        type_byId(IPF_NODE2_PRIMARY_SERVER_PORT, "65535");
     
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 1)
	public void verifyCommSystemCollocatedTargetBinding() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Verify configuration
        checkSelectedValue_inDropDownList(SLC_COMM_SYSTEM_TYPE, TXT_COLLOCATED);
        
        checkStatus(SLC_NODE2_TARGET_TYPE,"enabled","Drop-Down List Node2 Target Type");
        checkStatus(IPF_NODE2_PRIMARY_SERVER, "enabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "enabled", "Input Field Node2 Primary Server Port");
    	
    	checkSelectedValue_inDropDownList(SLC_NODE2_TARGET_TYPE, TXT_BINDING);
        checkValue_byId(IPF_NODE2_PRIMARY_SERVER, "10.1.250.130");
        checkSelectedValue_inDropDownList(SLC_NODE2_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
        checkValue_byId(IPF_NODE2_PRIMARY_SERVER_PORT, "65535");
       
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipCommSystemCollocatedTargetSRVRecord() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
      
        //Select Comm System Type Collocated 
        selectFromDropDown(SLC_COMM_SYSTEM_TYPE, TXT_COLLOCATED);
        //Select Target Type for Node2 SRV Record
        selectFromDropDown(SLC_NODE2_TARGET_TYPE, TXT_SRV_RECORD);
        
        //The Node 2 Primary Server fields become disabled
        checkStatus(IPF_NODE2_PRIMARY_SERVER, "disabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "disabled", "Input Field Node2 Primary Server Port");
		
		//The Node 2 SRV Record fields become enabled
		checkStatus(IPF_NODE2_SRV_RECORD, "enabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node2 SRV Record Transport Protocol");
    
		selectFromDropDown(SLC_NODE1_SRV_RECORD_TRANSPORT, TXT_UDP);
        type_byId(IPF_NODE2_SRV_RECORD, "www.auto2SRV.com");
        selectFromDropDown(SLC_NODE2_SRV_RECORD_TRANSPORT, TXT_UDP);
    
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyCommSystemCollocatedSRVRecord() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Verify configuration
        checkSelectedValue_inDropDownList(SLC_COMM_SYSTEM_TYPE, TXT_COLLOCATED);
        
        checkStatus(IPF_NODE2_PRIMARY_SERVER, "disabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "disabled", "Input Field Node2 Primary Server Port");
	    checkStatus(IPF_NODE2_SRV_RECORD, "enabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node2 SRV Record Transport Protocol");   
       
		checkSelectedValue_inDropDownList(SLC_NODE1_SRV_RECORD_TRANSPORT, TXT_UDP);
		checkValue_byId(IPF_NODE2_SRV_RECORD, "www.auto2SRV.com");
        checkSelectedValue_inDropDownList(SLC_NODE2_SRV_RECORD_TRANSPORT, TXT_UDP);
     
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	
}