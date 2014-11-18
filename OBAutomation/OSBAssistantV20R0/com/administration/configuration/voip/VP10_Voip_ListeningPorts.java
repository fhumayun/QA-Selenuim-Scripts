package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP10_Voip_ListeningPorts extends SuperHelper implements PropertiesVoip {

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
	public void voipSetListeningPorts() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Change Listening Ports
        type_byId(IPF_LISTENING_PORT_TCP, "5065");
        type_byId(IPF_LISTENING_PORT_UDP, "5066");
        type_byId(IPF_LISTENING_PORT_TLS, "5067");
        type_byId(IPF_OPTIONS_SOURCE_PORT, "5068");

		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	
	@Test (priority = 1)
	public void verifyVoipListeningPortsSet() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        checkValue_byId(IPF_LISTENING_PORT_TCP, "5065");
        checkValue_byId(IPF_LISTENING_PORT_UDP, "5066");
        checkValue_byId(IPF_LISTENING_PORT_TLS, "5067");
        checkValue_byId(IPF_OPTIONS_SOURCE_PORT, "5068");

        //Recover initial values for Listening Ports
        type_byId(IPF_LISTENING_PORT_TCP, "5060");
        type_byId(IPF_LISTENING_PORT_UDP, "5060");
        type_byId(IPF_LISTENING_PORT_TLS, "5061");
        type_byId(IPF_OPTIONS_SOURCE_PORT, "5060");

        clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}	




}