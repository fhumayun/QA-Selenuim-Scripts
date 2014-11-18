package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS13_NetworkServices_DHCPAddStaticIPList extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesAddDHCPStaticIPList() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		checkStatus(CB_DHCP_ENABLE_DHCP,"checked","button");
		
		if(!getCheckboxStatus(CB_DHCP_ENABLE_DHCP))
			clickCheckbox_byID(CB_DHCP_ENABLE_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_STATIC_IP);
		updateMap(RETRIES);
		
		//Add a Static IP List
		clickButtonAdd();
		updateMap(RETRIES);
		type_byId(IPF_STATIC_IP_LIST_HOSTNAME, "HostName001");
		type_byId(IPF_STATIC_IP_LIST_MAC, "00:01:AB:FF:1D:2A");
		type_byId(IPF_STATIC_IP_LIST_IP, "10.114.12.128");
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Successful Add
		checkText("HostName001");
		checkText("00:01:AB:FF:1D:2A");
		checkText("10.114.12.128");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		 clickButtonSave();
	     updateMap(RETRIES);
	     applyChangesWithConfirmation();
	     setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesDHCPStaticIPListCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_STATIC_IP);
		updateMap(RETRIES);
		
		//Verify Successful Static IP List creation
		checkText("HostName001");
		checkText("00:01:AB:FF:1D:2A");
		checkText("10.114.12.128");
	
		clickButtonCancel();

		updateMap(RETRIES);
		clickButtonCancel();
		
		updateMap(RETRIES);
		setMethodState();
	}
}

 