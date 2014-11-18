package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP40_Voip_CommSystem_GeoSeparated extends SuperHelper implements PropertiesVoip {

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
	public void voipCommSystemGeoSeparatedTargetBinding() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Select Comm System Type Geo-Separated 
        selectFromDropDown(SLC_COMM_SYSTEM_TYPE, TXT_GEO_SEPERATED);
        
        //Select Target Type for Node1 Binding
        selectFromDropDown(SLC_NODE1_TARGET_TYPE, TXT_BINDING);
        
        //The Node 1 Primary and Secondary Server fields become enabled
        checkStatus(IPF_NODE1_PRIMARY_SERVER, "enabled", "Input Field Node1 Primary Server");
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "enabled", "Input Field Node1 Primary Server Port");
    	checkStatus(IPF_NODE1_SECONDARY_SERVER, "enabled", "Input Field Node1 Secondary Server");
   		checkStatus(SLC_NODE1_SECONDARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node1 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE1_SECONDARY_SERVER_PORT, "enabled", "Input Field Node1 Secondary Server Port");
    	
       	//The Node 1 SRV Record fields become disabled
		checkStatus(IPF_NODE1_SRV_RECORD, "disabled", "Input Field Node1 SRV Record");
		checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node1 SRV Record Transport Protocol");
    
		//Configure Node1 Primary Server
		type_byId(IPF_NODE1_PRIMARY_SERVER, "10.1.250.121");
	    selectFromDropDown(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, TXT_TLS);
	    type_byId(IPF_NODE1_PRIMARY_SERVER_PORT, "7001");
	     
	    //Configure Node1 Secondary Server
	    type_byId(IPF_NODE1_SECONDARY_SERVER, "10.1.250.122");
	    selectFromDropDown(SLC_NODE1_SECONDARY_SERVER_TRANSPORT, TXT_TLS);
	    type_byId(IPF_NODE1_SECONDARY_SERVER_PORT, "7001");
	     
	    //Select Target Type for Node2 Binding
	    selectFromDropDown(SLC_NODE2_TARGET_TYPE, TXT_BINDING);
	    
	    //The Node 2 Primary and Secondary Server fields become enabled
        checkStatus(IPF_NODE2_PRIMARY_SERVER, "enabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "enabled", "Input Field Node2 Primary Server Port");
    	checkStatus(IPF_NODE2_SECONDARY_SERVER, "enabled", "Input Field Node2 Secondary Server");
   		checkStatus(SLC_NODE2_SECONDARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node2 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE2_SECONDARY_SERVER_PORT, "enabled", "Input Field Node2 Secondary Server Port");
    	
       	//The Node 2 SRV Record fields become disabled
		checkStatus(IPF_NODE2_SRV_RECORD, "disabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node2 SRV Record Transport Protocol");
    
		//Configure Node2 Primary Server
		type_byId(IPF_NODE2_PRIMARY_SERVER, "10.1.250.131");
	    selectFromDropDown(SLC_NODE2_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
	    type_byId(IPF_NODE2_PRIMARY_SERVER_PORT, "7002");
	     
	    //Configure Node2 Secondary Server
	    type_byId(IPF_NODE2_SECONDARY_SERVER, "10.1.250.132");
	    selectFromDropDown(SLC_NODE2_SECONDARY_SERVER_TRANSPORT, TXT_TCP);
	    type_byId(IPF_NODE2_SECONDARY_SERVER_PORT, "7002");
	 
     
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	
	@Test (priority = 1)
	public void verifyCommSystemGeoSeparatedTargetBinding() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Verify configuration
        checkSelectedValue_inDropDownList(SLC_COMM_SYSTEM_TYPE, TXT_GEO_SEPERATED);
        
        //Verify Node1 Configuration
        checkSelectedValue_inDropDownList(SLC_NODE1_TARGET_TYPE, TXT_BINDING);
        checkStatus(IPF_NODE1_PRIMARY_SERVER, "enabled", "Input Field Node1 Primary Server");
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "enabled", "Input Field Node1 Primary Server Port");
    	checkStatus(IPF_NODE1_SECONDARY_SERVER, "enabled", "Input Field Node1 Secondary Server");
   		checkStatus(SLC_NODE1_SECONDARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node1 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE1_SECONDARY_SERVER_PORT, "enabled", "Input Field Node1 Secondary Server Port");
    	checkStatus(IPF_NODE1_SRV_RECORD, "disabled", "Input Field Node1 SRV Record");
		checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node1 SRV Record Transport Protocol");
		checkValue_byId(IPF_NODE1_PRIMARY_SERVER, "10.1.250.121");
	    checkSelectedValue_inDropDownList(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, TXT_TLS);
	    checkValue_byId(IPF_NODE1_PRIMARY_SERVER_PORT, "7001");
	    checkValue_byId(IPF_NODE1_SECONDARY_SERVER, "10.1.250.122");
	    checkSelectedValue_inDropDownList(SLC_NODE1_SECONDARY_SERVER_TRANSPORT, TXT_TLS);
	    checkValue_byId(IPF_NODE1_SECONDARY_SERVER_PORT, "7001");
	  
	    //Verify Node2 Configuration
	    checkSelectedValue_inDropDownList(SLC_NODE2_TARGET_TYPE, TXT_BINDING);
	    checkStatus(IPF_NODE2_PRIMARY_SERVER, "enabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "enabled", "Input Field Node2 Primary Server Port");
    	checkStatus(IPF_NODE2_SECONDARY_SERVER, "enabled", "Input Field Node2 Secondary Server");
   		checkStatus(SLC_NODE2_SECONDARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node2 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE2_SECONDARY_SERVER_PORT, "enabled", "Input Field Node2 Secondary Server Port");
    	checkStatus(IPF_NODE2_SRV_RECORD, "disabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node2 SRV Record Transport Protocol");
		checkValue_byId(IPF_NODE2_PRIMARY_SERVER, "10.1.250.131");
	    checkSelectedValue_inDropDownList(SLC_NODE2_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
	    checkValue_byId(IPF_NODE2_PRIMARY_SERVER_PORT, "7002");
	    checkValue_byId(IPF_NODE2_SECONDARY_SERVER, "10.1.250.132");
	    checkSelectedValue_inDropDownList(SLC_NODE2_SECONDARY_SERVER_TRANSPORT, TXT_TCP);
	    checkValue_byId(IPF_NODE2_SECONDARY_SERVER_PORT, "7002");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipCommSystemGeoSeparatedTargetSRVRecord() throws InterruptedException {
		
		methodLogger.log(); 
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Select Comm System Type Geo-Separated 
        selectFromDropDown(SLC_COMM_SYSTEM_TYPE, TXT_GEO_SEPERATED);
        
        //Select Target Type for Node1 SRV Record
        selectFromDropDown(SLC_NODE1_TARGET_TYPE, TXT_SRV_RECORD);
        
        //The Node 1 Primary and Secondary Server fields become disabled
        checkStatus(IPF_NODE1_PRIMARY_SERVER, "disabled", "Input Field Node1 Primary Server");
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "disabled", "Input Field Node1 Primary Server Port");
    	checkStatus(IPF_NODE1_SECONDARY_SERVER, "disabled", "Input Field Node1 Secondary Server");
   		checkStatus(SLC_NODE1_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE1_SECONDARY_SERVER_PORT, "disabled", "Input Field Node1 Secondary Server Port");
    	
       	//The Node 1 SRV Record fields become enabled
		checkStatus(IPF_NODE1_SRV_RECORD, "enabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node2 SRV Record Transport Protocol");
    
		//Configure Node1 SRV Record 
		type_byId(IPF_NODE1_SRV_RECORD, "www.testauto1.com");
		selectFromDropDown(SLC_NODE1_SRV_RECORD_TRANSPORT, TXT_TCP);
	   
	    //Select Target Type for Node2 SRV Record
	    selectFromDropDown(SLC_NODE2_TARGET_TYPE, TXT_SRV_RECORD);
	    
	    //The Node 2 Primary and Secondary Server fields become disabled
        checkStatus(IPF_NODE2_PRIMARY_SERVER, "disabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "disabled", "Input Field Node2 Primary Server Port");
    	checkStatus(IPF_NODE2_SECONDARY_SERVER, "disabled", "Input Field Node2 Secondary Server");
   		checkStatus(SLC_NODE2_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE2_SECONDARY_SERVER_PORT, "disabled", "Input Field Node2 Secondary Server Port");
    	
       	//The Node 2 SRV Record fields become disabled
		checkStatus(IPF_NODE2_SRV_RECORD, "enabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node2 SRV Record Transport Protocol");
    
		//Configure Node2 SRV Record 
		type_byId(IPF_NODE2_SRV_RECORD, "www.testauto2.com");
		selectFromDropDown(SLC_NODE2_SRV_RECORD_TRANSPORT, TXT_TCP);
	 
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyCommSystemGeoSeparatedSRVRecord() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        //Verify configuration
        checkSelectedValue_inDropDownList(SLC_COMM_SYSTEM_TYPE, TXT_GEO_SEPERATED);
        
        //Verify Node1 Configuration
        checkSelectedValue_inDropDownList(SLC_NODE1_TARGET_TYPE, TXT_SRV_RECORD);
        checkStatus(IPF_NODE1_PRIMARY_SERVER, "disabled", "Input Field Node1 Primary Server");
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "disabled", "Input Field Node1 Primary Server Port");
    	checkStatus(IPF_NODE1_SECONDARY_SERVER, "disabled", "Input Field Node1 Secondary Server");
   		checkStatus(SLC_NODE1_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE1_SECONDARY_SERVER_PORT, "disabled", "Input Field Node1 Secondary Server Port");
    	checkStatus(IPF_NODE1_SRV_RECORD, "enabled", "Input Field Node1 SRV Record");
		checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node1 SRV Record Transport Protocol");
		checkValue_byId(IPF_NODE1_SRV_RECORD, "www.testauto1.com");
	    checkSelectedValue_inDropDownList(SLC_NODE1_SRV_RECORD_TRANSPORT, TXT_TCP);
	   
	  
	    //Verify Node2 Configuration
	    checkSelectedValue_inDropDownList(SLC_NODE2_TARGET_TYPE, TXT_SRV_RECORD);
	    checkStatus(IPF_NODE2_PRIMARY_SERVER, "disabled", "Input Field Node2 Primary Server");
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "disabled", "Input Field Node2 Primary Server Port");
    	checkStatus(IPF_NODE2_SECONDARY_SERVER, "disabled", "Input Field Node2 Secondary Server");
   		checkStatus(SLC_NODE2_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Secondary Server Transport Protocol");
       	checkStatus(IPF_NODE2_SECONDARY_SERVER_PORT, "disabled", "Input Field Node2 Secondary Server Port");
    	checkStatus(IPF_NODE2_SRV_RECORD, "enabled", "Input Field Node2 SRV Record");
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"enabled","Drop-Down List Node2 SRV Record Transport Protocol");
		checkValue_byId(IPF_NODE2_SRV_RECORD, "www.testauto2.com");
	    checkSelectedValue_inDropDownList(SLC_NODE2_SRV_RECORD_TRANSPORT, TXT_TCP);
	   
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	
}