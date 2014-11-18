package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS18_NetworkServices_DisableDHCP extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesDisableDHCP() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		//Enter default values again
		selectFromDropDown(SLC_DHCP_UPDATE_MODE, TXT_NONE);
		type_byId(IPF_DHCP_START_RANGE, "");
		type_byId(IPF_DHCP_END_RANGE, "");
		type_byId(IPF_DHCP_EXCUSION_FROM, "");
		type_byId(IPF_DHCP_EXCUSION_TO, "");
		type_byId(IPF_DHCP_LEASE_TIME_DEFAULT, "86400");
		type_byId(IPF_DHCP_LEASE_TIME_MAX, "604800");
		type_byId(IPF_DHCP_ROUTER, "");
		type_byId(IPF_DHCP_DOMAIN, "");
		type_byId(IPF_DHCP_WIN_SERVER, "");
		type_byId(IPF_DHCP_PRINT_SERVER, "");
		type_byId(IPF_DHCP_DLS_SERVER, "");
	
		if(getCheckboxStatus(CB_DHCP_ENABLE_DHCP))
			clickCheckbox_byID(CB_DHCP_ENABLE_DHCP);
			
		DCHPfields("disabled");
		
		clickButtonSave();
	    updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesDHCPDisabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		checkStatus(CB_DHCP_ENABLE_DHCP,"unchecked","Checkbox Enable DHCP");
			
		DCHPfields("disabled");
		checkStatus(IPF_DHCP_SUBNET, "disabled","Input Field DHCP Subnet");
		checkStatus(IPF_DHCP_NETMASK, "disabled","Input Field DHCP Netmask");
		checkStatus(IPF_DHCP_BROADCAST_ADDRESS, "disabled","Input Field DHCP Broadcast");
		checkStatus(SLC_DHCP_INTERFACE, "disabled","Drop-Down List Interface");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	public void DCHPfields(String status) throws InterruptedException{
		checkStatus(BTN_DHCP_CONFIGURE_STATIC_IP, status,"button");
		checkStatus(BTN_DHCP_CONFIGURE_DNS_SERVER_LIST, status,"button");
		checkStatus(SLC_DHCP_UPDATE_MODE,status,"selection");
		checkStatus(IPF_DHCP_START_RANGE, status,"selection");
		checkStatus(IPF_DHCP_END_RANGE, status,"selection");
		checkStatus(IPF_DHCP_EXCUSION_FROM, status,"selection");
		checkStatus(IPF_DHCP_EXCUSION_TO, status,"selection");
		checkStatus(IPF_DHCP_LEASE_TIME_DEFAULT, status,"selection");
		checkStatus(IPF_DHCP_LEASE_TIME_MAX, status,"selection");
		checkStatus(IPF_DHCP_ROUTER, status,"selection");
		checkStatus(IPF_DHCP_DOMAIN, status,"selection");
		checkStatus(IPF_DHCP_WIN_SERVER, status,"selection");
		checkStatus(IPF_DHCP_PRINT_SERVER, status,"selection");
		checkStatus(IPF_DHCP_DLS_SERVER, status,"selection");
		checkStatus(IPF_DHCP_DLS_PORT, status,"selection");
		checkStatus(CB_DHCP_ENABLE_NTP, status,"selection");
	}
}

 