package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS01_NetworkServices_GUIElemets_DefaultValues extends SuperHelper implements PropertiesNetworkServices {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	
	@Test (priority = 0)
	public void networkServices_CheckDefaultValues() throws InterruptedException {
		
		String[] timeZoneOptions = {TXT_GMT_MINUS_1200,TXT_GMT_MINUS_1100,TXT_GMT_MINUS_1000,TXT_GMT_MINUS_900,TXT_GMT_MINUS_800,TXT_GMT_MINUS_700,TXT_GMT_MINUS_600, TXT_GMT_MINUS_500,TXT_GMT_MINUS_400, 
				 TXT_GMT_MINUS_330, TXT_GMT_MINUS_300, TXT_GMT_MINUS_200,TXT_GMT_MINUS_100,TXT_GMT, TXT_GMT_PLUS_100, TXT_GMT_PLUS_200,TXT_GMT_PLUS_300, TXT_GMT_PLUS_330,
				 TXT_GMT_PLUS_400, TXT_GMT_PLUS_430, TXT_GMT_PLUS_500, TXT_GMT_PLUS_530, TXT_GMT_PLUS_600, TXT_GMT_PLUS_700, TXT_GMT_PLUS_800, TXT_GMT_PLUS_900, TXT_GMT_PLUS_930,
				 TXT_GMT_PLUS_1000, TXT_GMT_PLUS_1100, TXT_GMT_PLUS_1200};
		
		String[] updateModeOptions = {TXT_ADD_HOC,TXT_INTERIM,TXT_NONE};
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Tab Interfaces
        checkStatus(BTN_EDIT_INTERFACE, "disabled", "Button Edit Interface");
        checkText("192.168.108.4");
        checkText("10.19.1.4");

        //Tab Routing
        clickButton(TB_ROUTING);
        
        checkValue_byId(IPF_DEFAULT_GATEWAY_ADDRESS, "192.168.108.1");
        checkStatus(IPF_DEFAULT_GATEWAY_ADDRESS,"enabled","Input Field Default Gateway Address"); 
        
        checkStatus(BTN_ADD_ROUTE, "enabled", "Button Add Route");
        checkStatus(BTN_EDIT_ROUTE, "disabled", "Button Edit Route");
        checkStatus(BTN_DELETE_ROUTE, "disabled", "Button Delete Route");
        
        
        //Tab Redundancy
        clickButton(TB_REDUNDANCY);
        
        checkStatus(CB_ENABLE_REDUNDANCY,"enabled","Checkbox Enable Redundancy"); 
        checkStatus(CB_ENABLE_REDUNDANCY,"unchecked","Checkbox Enable Redundancy"); 
        
        
        //Tab Traffic Shaping 
        clickButton(TB_TRAFFIC);
        
        checkStatus(CB_ENABLE_TRAFFIC,"enabled","Checkbox Enable Traffic"); 
        checkStatus(CB_ENABLE_TRAFFIC,"unchecked","Checkbox Enable Traffic"); 
        
        checkStatus(BTN_ADD_CLASS, "disabled", "Button Add Class");
        checkStatus(BTN_EDIT_CLASS, "disabled", "Button Edit Class");
        checkStatus(BTN_DELETE_CLASS, "disabled", "Button Delete Class");
      
        
        //Tab NTP
        clickButton(TB_NTP);
        
        checkStatus(RB_NTP_AUTO, "enabled", "Radio Button Auto (via NTP Server)");
        checkStatus(RB_NTP_AUTO, "unchecked", "Radio Button Auto (via NTP Server)");
        checkStatus(RB_NTP_MANUALLY, "enabled", "Radio Button Manually");
        checkStatus(RB_NTP_MANUALLY, "checked", "Radio Button Manually");
        
        checkStatus(IPF_NTP_SERVER, "disabled", "Input Field NTP Server");
        checkValue_byId(IPF_NTP_SERVER, "127.0.0.1");
        
        checkStatus(BTN_NTP_SYNCH_MANUALLY, "disabled", "Button Synch Manually");
        checkStatus(BTN_NTP_APPLY, "enabled", "Button Apply");
        
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "enabled", "Checkbox Enable local NTP server");
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "unchecked", "Checkbox Enable local NTP server");
        
        checkStatus(SLC_TIME_ZONE, "enabled", "Drop-Down List Time Zone");
        checkSelectedValue_inDropDownList(SLC_TIME_ZONE, TXT_GMT);
        getPossibleValuesOfDropDown(SLC_TIME_ZONE, timeZoneOptions);
        
        
        //Tab DNS
        clickButton(TB_DNS);
        
        checkStatus(BTN_CONFIGURE_DNS, "enabled", "Button Configure DNS");
        checkStatus(BTN_CONFIGURE_ALIAS, "enabled", "Button Configure Alias");
        checkStatus(BTN_DNS_SYNCH_MANUALLY, "enabled", "Button Sync Manually");
        checkStatus(BTN_DNS_FORWARD, "disabled", "Button Configure IP List");
        checkStatus(BTN_DNS_ADD, "disabled", "Button Add DNS");
        checkStatus(BTN_DNS_EDIT, "disabled", "Button Edit DNS");
        checkStatus(BTN_DNS_DELETE, "disabled", "Button Delete DNS");
      
        checkStatus(CB_ENABLE_DNS, "enabled", "Checkbox Enable DNS");
        checkStatus(CB_ENABLE_DNS, "unchecked", "Checkbox Enable DNS");
     
        checkStatus(IPF_DOMAIN_NAME, "enabled", "Input Field Domain Name");
        checkValue_byId(IPF_DOMAIN_NAME, "siemens.com");
       
        
        //Tab DHCP
        clickButton(TB_DHCP);
        
        checkStatus(BTN_DHCP_CONFIGURE_STATIC_IP, "disabled", "Button Configure Static IP List");
        checkStatus(BTN_DHCP_CONFIGURE_DNS_SERVER_LIST, "disabled", "Button Configure DNS server list");
       
        checkStatus(CB_DHCP_ENABLE_DHCP, "enabled", "Checkbox Enable DHCP");
        checkStatus(CB_DHCP_ENABLE_DHCP, "unchecked", "Checkbox Enable DHCP");
        checkStatus(CB_DHCP_ENABLE_NTP, "disabled", "Checkbox Enable NTP");
        checkStatus(CB_DHCP_ENABLE_NTP, "checked", "Checkbox Enable NTP");
        
        checkStatus(IPF_DHCP_SUBNET, "disabled", "Input Field DHCP Subnet");
        checkValue_byId(IPF_DHCP_SUBNET, "192.168.108.0");
        checkStatus(IPF_DHCP_NETMASK, "disabled", "Input Field DHCP Netmask");
        checkValue_byId(IPF_DHCP_NETMASK, "255.255.255.224");
        checkStatus(IPF_DHCP_START_RANGE, "disabled", "Input Field DHCP Start Range");
        checkValue_byId(IPF_DHCP_START_RANGE, "");
        checkStatus(IPF_DHCP_END_RANGE, "disabled", "Input Field DHCP End Range");
        checkValue_byId(IPF_DHCP_END_RANGE, "");
        checkStatus(IPF_DHCP_EXCUSION_FROM, "disabled", "Input Field DHCP IP Exclusion Range from");
        checkValue_byId(IPF_DHCP_EXCUSION_FROM, "");
        checkStatus(IPF_DHCP_EXCUSION_TO, "disabled", "Input Field DHCP IP Exclusion Range to");
        checkValue_byId(IPF_DHCP_EXCUSION_TO, "");
        checkStatus(IPF_DHCP_LEASE_TIME_DEFAULT, "disabled", "Input Field DHCP Lease time default");
        checkValue_byId(IPF_DHCP_LEASE_TIME_DEFAULT, "86400");
        checkStatus(IPF_DHCP_LEASE_TIME_MAX, "disabled", "Input Field DHCP Lease time max");
        checkValue_byId(IPF_DHCP_LEASE_TIME_MAX, "604800");
        checkStatus(IPF_DHCP_BROADCAST_ADDRESS, "disabled", "Input Field DHCP Broadcast address");
        checkValue_byId(IPF_DHCP_BROADCAST_ADDRESS, "192.168.108.31");
        checkStatus(IPF_DHCP_ROUTER, "disabled", "Input Field DHCP Router");
        checkValue_byId(IPF_DHCP_ROUTER, "");
        checkStatus(IPF_DHCP_DOMAIN, "disabled", "Input Field DHCP Domain name");
        checkValue_byId(IPF_DHCP_DOMAIN, "");
        checkStatus(IPF_DHCP_WIN_SERVER, "disabled", "Input Field DHCP Wins server");
        checkValue_byId(IPF_DHCP_WIN_SERVER, "");
        checkStatus(IPF_DHCP_PRINT_SERVER, "disabled", "Input Field DHCP Print server");
        checkValue_byId(IPF_DHCP_PRINT_SERVER, "");
        checkStatus(IPF_DHCP_DLS_SERVER, "disabled", "Input Field DHCP DLS Server");
        checkValue_byId(IPF_DHCP_DLS_SERVER, "");
        checkStatus(IPF_DHCP_DLS_PORT, "disabled", "Input Field DHCP DLS Port");
        checkValue_byId(IPF_DHCP_DLS_PORT, "18443");
     
        checkStatus(SLC_DHCP_UPDATE_MODE, "disabled", "Drop-Down List Update Mode");
        checkSelectedValue_inDropDownList(SLC_DHCP_UPDATE_MODE, TXT_NONE);
        getPossibleValuesOfDropDown(SLC_DHCP_UPDATE_MODE, updateModeOptions);
       
        checkStatus(SLC_DHCP_INTERFACE, "disabled", "Drop-Down List Update Mode");
        checkSelectedValue_inDropDownList(SLC_DHCP_INTERFACE, "Interface1");
       
        clickButtonCancel();
		setMethodState();
	}

}