package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS14_NetworkServices_DHCPModifyStaticIPList extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesModifyDHCPStaticIPList() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		//Edit Static IP List
		clickButton(BTN_DHCP_CONFIGURE_STATIC_IP);
		updateMap(RETRIES);
		clickCheckbox_byText("HostName001");
		clickButton("editUtilitiesDchpStaticIpForm:staticIpGrid:editButton");
		updateMap(RETRIES);
		//Modify Static IP List fields
		type_byId(IPF_STATIC_IP_LIST_HOSTNAME, "HostName002");
		type_byId(IPF_STATIC_IP_LIST_MAC, "01:AC:1D:2F:FF:14");
		type_byId(IPF_STATIC_IP_LIST_IP, "10.14.1.18");
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check successful modification
		checkText("HostName002");
		checkText("01:AC:1D:2F:FF:14");
		checkText("10.14.1.18");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
	    updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesDHCPStaticIPListModification() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_STATIC_IP);
		updateMap(RETRIES);
		//Verify Static IP List successful modification
		checkText("HostName002");
		checkText("01:AC:1D:2F:FF:14");
		checkText("10.14.1.18");
		clickButtonCancel();

		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}

 