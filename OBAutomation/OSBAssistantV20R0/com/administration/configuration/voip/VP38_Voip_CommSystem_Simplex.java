package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP38_Voip_CommSystem_Simplex extends SuperHelper implements PropertiesVoip {

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
	public void voipCommSystemSimplexTargetBinding() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Select Comm System Type Simplex 
        selectFromDropDown(SLC_COMM_SYSTEM_TYPE, TXT_SIMPLEX);
        //Select Target type for Node1 Binding
        selectFromDropDown(SLC_NODE1_TARGET_TYPE, TXT_BINDING);
        
        type_byId(IPF_NODE1_PRIMARY_SERVER, "10.1.250.120");
        selectFromDropDown(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, TXT_UDP);
        type_byId(IPF_NODE1_PRIMARY_SERVER_PORT, "5065");
     
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 1)
	public void verifyCommSystemSimplexTargetBinding() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Verify configuration
        checkSelectedValue_inDropDownList(SLC_COMM_SYSTEM_TYPE, TXT_SIMPLEX);
        checkSelectedValue_inDropDownList(SLC_NODE1_TARGET_TYPE, TXT_BINDING);
        checkValue_byId(IPF_NODE1_PRIMARY_SERVER, "10.1.250.120");
        checkSelectedValue_inDropDownList(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, TXT_UDP);
        checkValue_byId(IPF_NODE1_PRIMARY_SERVER_PORT, "5065");
       
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipCommSystemSimplexTargetSRVRecord() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
      
        //Select Comm System Type Simplex 
        selectFromDropDown(SLC_COMM_SYSTEM_TYPE, TXT_SIMPLEX);
        //Select Target type for Node1 SRV Record
        selectFromDropDown(SLC_NODE1_TARGET_TYPE, TXT_SRV_RECORD);
        
        //The Node 1 Primary Server fields become disabled
        checkStatus(IPF_NODE1_PRIMARY_SERVER, "disabled", "Input Field Node1 Primary Server");
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "disabled", "Input Field Node1 Primary Server Port");
		
		//The Node 1 SRV Record fields become enabled
		checkStatus(IPF_NODE1_SRV_RECORD, "enabled", "Input Field Node1 SRV Record");
		checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node1 SRV Record Transport Protocol");
    
        type_byId(IPF_NODE1_SRV_RECORD, "www.autoSRV.com");
        selectFromDropDown(SLC_NODE1_SRV_RECORD_TRANSPORT, TXT_TLS);
    
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyCommSystemSimplexSRVRecord() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Verify configuration
        checkStatus(IPF_NODE1_PRIMARY_SERVER, "disabled", "Input Field Node1 Primary Server");
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "disabled", "Input Field Node1 Primary Server Port");
	    checkStatus(IPF_NODE1_SRV_RECORD, "enabled", "Input Field Node1 SRV Record");
		checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node1  SRV Record Transport Protocol");   
        checkValue_byId(IPF_NODE1_SRV_RECORD, "www.autoSRV.com");
        checkSelectedValue_inDropDownList(SLC_NODE1_SRV_RECORD_TRANSPORT, TXT_TLS);
     
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	
}