package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP11_Voip_PortMapping extends SuperHelper implements PropertiesVoip {

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
	public void voipPortMappingChangeMode() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Change Mode to Proxy
        selectFromDropDown(SLC_MODE, TXT_PROXY);
        
        //Check that the Port Mapping fields become disabled
		checkStatus(IPF_RTP_PORTS_MIN, "disabled", "Input Field RTP Ports Min Value");
		checkStatus(IPF_RTP_PORTS_MAX, "disabled", "Input Field RTP Ports Max Value");
		checkStatus(IPF_TIME_TO_LIVE, "disabled", "Input Field Time To Live");
		checkStatus(IPF_SIP_PORTS_MIN, "disabled", "Input Field SIP Ports Min Value");
		checkStatus(IPF_SIP_PORTS_MAX, "disabled", "Input Field SIP Ports Max Value");
		checkStatus(BTN_SHOW_PORT_MAPPING,"disabled","Button Show Port Mapping");
		checkStatus(BTN_CLEAR_PORT_MAPPING,"disabled","Button Clear Port Mapping");
	    
		//Change Mode to Branch SBC
        selectFromDropDown(SLC_MODE, TXT_BRANCH_SBC);
        
        //Check that the Port Mapping fields become enabled
		checkStatus(IPF_RTP_PORTS_MIN, "enabled", "Input Field RTP Ports Min Value");
		checkStatus(IPF_RTP_PORTS_MAX, "enabled", "Input Field RTP Ports Max Value");
		checkStatus(IPF_TIME_TO_LIVE, "enabled", "Input Field Time To Live");
		checkStatus(IPF_SIP_PORTS_MIN, "enabled", "Input Field SIP Ports Min Value");
		checkStatus(IPF_SIP_PORTS_MAX, "enabled", "Input Field SIP Ports Max Value");
	    checkStatus(BTN_SHOW_PORT_MAPPING,"enabled","Button Show Port Mapping");
		checkStatus(BTN_CLEAR_PORT_MAPPING,"enabled","Button Clear Port Mapping");
    	
		
		//Change Mode to Proxy ACD
        selectFromDropDown(SLC_MODE, TXT_PROXY_ACD);
        
        //Check that the Port Mapping fields become disabled
		checkStatus(IPF_RTP_PORTS_MIN, "disabled", "Input Field RTP Ports Min Value");
		checkStatus(IPF_RTP_PORTS_MAX, "disabled", "Input Field RTP Ports Max Value");
		checkStatus(IPF_TIME_TO_LIVE, "disabled", "Input Field Time To Live");
		checkStatus(IPF_SIP_PORTS_MIN, "disabled", "Input Field SIP Ports Min Value");
		checkStatus(IPF_SIP_PORTS_MAX, "disabled", "Input Field SIP Ports Max Value");
		checkStatus(BTN_SHOW_PORT_MAPPING,"disabled","Button Show Port Mapping");
		checkStatus(BTN_CLEAR_PORT_MAPPING,"disabled","Button Clear Port Mapping");
	
	
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	

	@Test (priority = 1)
	public void voipSetPortMapping() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Check Show Port Mapping pop-up
        clickButton(BTN_SHOW_PORT_MAPPING);
        updateMap(RETRIES);
        checkText(TXT_CONTACT);
        checkText(TXT_INTERNAL_IP);
        checkText(TXT_INTERNAL_PORT);
        checkText(TXT_EXTERNAL_IP);
        checkText(TXT_EXTERNAL_PORT);
        checkText(TXT_EXPIRE_TIME_FROM_SERVER);
        checkText(TXT_MAP_TIME);
        clickButtonClose();
        updateMap(RETRIES);
        
        //Change Port Mapping
        type_byId(IPF_RTP_PORTS_MIN, "35010");
        type_byId(IPF_RTP_PORTS_MAX, "65010");
        type_byId(IPF_TIME_TO_LIVE, "1200");
        type_byId(IPF_SIP_PORTS_MIN, "11000");
        type_byId(IPF_SIP_PORTS_MAX, "16000");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 2)
	public void verifyVoipPortMappingSet() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        checkValue_byId(IPF_RTP_PORTS_MIN, "35010");
        checkValue_byId(IPF_RTP_PORTS_MAX, "65010");
        checkValue_byId(IPF_TIME_TO_LIVE, "1200");
        checkValue_byId(IPF_SIP_PORTS_MIN, "11000");
        checkValue_byId(IPF_SIP_PORTS_MAX, "16000");

        //Recover initial values for Listening Ports
        type_byId(IPF_RTP_PORTS_MIN, "35000");
        type_byId(IPF_RTP_PORTS_MAX, "65000");
        type_byId(IPF_TIME_TO_LIVE, "180");
        type_byId(IPF_SIP_PORTS_MIN, "10000");
        type_byId(IPF_SIP_PORTS_MAX, "15000");

        clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}	




}