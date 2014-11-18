package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS12_NetworkServices_EnableDHCP extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesTestDHCP() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
	    updateMap(RETRIES);
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		if(!getCheckboxStatus(CB_DHCP_ENABLE_DHCP))
			//Check that fields are disabled
			DCHPfields("disabled");
		else
			//Check that fields are enabled
			DCHPfields("enabled");
		
		//Check default data
		checkValue_byId(IPF_DHCP_SUBNET, "192.168.108.0");
		checkValue_byId(IPF_DHCP_NETMASK, "255.255.255.224");
		checkValue_byId(IPF_DHCP_BROADCAST_ADDRESS, "192.168.108.31");
		
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
	
	@Test (priority = 1)
	public void networkServicesEnableDHCP() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		 
		//Select Tab DHCP
		clickButton(TB_DHCP);
		if(!getCheckboxStatus(CB_DHCP_ENABLE_DHCP))
			clickCheckbox_byID(CB_DHCP_ENABLE_DHCP);
		
		selectFromDropDown(SLC_DHCP_UPDATE_MODE, TXT_ADD_HOC);
		type_byId(IPF_DHCP_START_RANGE, "192.168.108.1");
		type_byId(IPF_DHCP_END_RANGE, "192.168.108.15");
		type_byId(IPF_DHCP_EXCUSION_FROM, "192.168.108.6");
		type_byId(IPF_DHCP_EXCUSION_TO, "192.168.108.9");
		type_byId(IPF_DHCP_LEASE_TIME_DEFAULT, "86500");
		type_byId(IPF_DHCP_LEASE_TIME_MAX, "602888");
		type_byId(IPF_DHCP_ROUTER, "10.1.225.148");
		type_byId(IPF_DHCP_DOMAIN, "siemens.co.uk");
		type_byId(IPF_DHCP_WIN_SERVER, "10.1.225.149");
		type_byId(IPF_DHCP_PRINT_SERVER, "10.1.225.150");
		type_byId(IPF_DHCP_DLS_SERVER, "10.1.225.160");
	     clickButtonSave();
	     updateMap(RETRIES);
	     applyChangesWithConfirmation();
	     setMethodState();
	}
	
	@Test (priority = 2)
	public void verifyNetworkServicesDHCPEnabling() throws InterruptedException {
		 
		methodLogger.log(); 
		goToAdministrationNetworkServices();
    	updateMap(RETRIES);
		//Select Tab DHCP
		clickButton(TB_DHCP);
		checkStatus(CB_DHCP_ENABLE_DHCP,"checked","Checkbox Enable DHCP");
		
		DCHPfields("enabled");
		
		checkStatus(IPF_DHCP_SUBNET, "disabled","Input Field DHCP Subnet");
		checkStatus(IPF_DHCP_NETMASK, "disabled","Input Field DHCP Netmask");
		checkStatus(IPF_DHCP_BROADCAST_ADDRESS, "disabled","Input Field DHCP Broadcast");
		checkStatus(SLC_DHCP_INTERFACE, "disabled","Drop-Down List Interface");
		
		//Check default data
		checkValue_byId(IPF_DHCP_SUBNET, "192.168.108.0");
		checkValue_byId(IPF_DHCP_NETMASK, "255.255.255.224");
		checkValue_byId(IPF_DHCP_BROADCAST_ADDRESS, "192.168.108.31");
		
		//Check user input data
		checkSelectedValue_inDropDownList(SLC_DHCP_UPDATE_MODE, TXT_ADD_HOC);
		checkValue_byId(IPF_DHCP_START_RANGE, "192.168.108.1");
		checkValue_byId(IPF_DHCP_END_RANGE, "192.168.108.15");
		checkValue_byId(IPF_DHCP_EXCUSION_FROM, "192.168.108.6");
		checkValue_byId(IPF_DHCP_EXCUSION_TO, "192.168.108.9");
		checkValue_byId(IPF_DHCP_LEASE_TIME_DEFAULT, "86500");
		checkValue_byId(IPF_DHCP_LEASE_TIME_MAX, "602888");
		checkValue_byId(IPF_DHCP_ROUTER, "10.1.225.148");
		checkValue_byId(IPF_DHCP_DOMAIN, "siemens.co.uk");
		checkValue_byId(IPF_DHCP_WIN_SERVER, "10.1.225.149");
		checkValue_byId(IPF_DHCP_PRINT_SERVER, "10.1.225.150");
		checkValue_byId(IPF_DHCP_DLS_SERVER, "10.1.225.160");
		checkValue_byId(IPF_DHCP_DLS_PORT, "18443");
		checkStatus(CB_DHCP_ENABLE_NTP, "checked","Checkbox Enable NTP");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}

 