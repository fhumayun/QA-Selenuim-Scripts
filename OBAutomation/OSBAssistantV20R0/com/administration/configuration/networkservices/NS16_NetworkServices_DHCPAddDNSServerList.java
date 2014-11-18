package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS16_NetworkServices_DHCPAddDNSServerList extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesAddDHCPDNSServerList() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		checkStatus(CB_DHCP_ENABLE_DHCP,"checked","button");
		
		if(!getCheckboxStatus(CB_DHCP_ENABLE_DHCP))
			clickCheckbox_byID(CB_DHCP_ENABLE_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_DNS_SERVER_LIST);
		updateMap(RETRIES);
		
		//Add DNS Server Lists
		type_byId(IPF_DNS_ADD, "10.11.252.190");
		clickButtonAdd();
		
		type_byId(IPF_DNS_ADD, "10.1.254.157");
		clickButtonAdd();
		
		type_byId(IPF_DNS_ADD, "10.1.253.128");
		clickButtonAdd();
		
		//Check successful DNS Server List creation
		checkText("10.11.252.190");
		checkText("10.1.254.157");
		checkText("10.1.253.128");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonSave();
	    updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesDHCPDNSServerListCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab Interfaces
		clickButton(TB_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_DNS_SERVER_LIST);
		updateMap(RETRIES);
		
		//Verify successful DNS Server List creation
		checkText("10.11.252.190");
		checkText("10.1.254.157");
		checkText("10.1.253.128");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}

 