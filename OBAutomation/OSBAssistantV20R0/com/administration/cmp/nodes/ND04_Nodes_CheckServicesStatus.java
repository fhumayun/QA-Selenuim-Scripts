package com.administration.cmp.nodes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ND04_Nodes_CheckServicesStatus extends SuperHelper implements PropertiesNodes{

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToNodes();
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
	public void nodesCheckServicesStatus() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		//Edit a Branch
		clickLink_ByLinkText(OpenBranch);
		updateMap(RETRIES);
		 
	    clickButton(BTN_SHOW_SERVICES_STATUS);
		updateMap(RETRIES);
	    
		checkText(TXT_MEDIA_SERVER);
		checkText(TXT_MS_ADAPTER);
		checkText(TXT_MS_CONVERTER);
		checkText(TXT_DHCP);
		checkText(TXT_DNS);
		checkText(TXT_NTP);
		checkText(TXT_SNORT);
		checkText(TXT_VPN);
		checkText(TXT_IPsec);
		checkText(TXT_BLC);
		checkText(TXT_BLS);
		checkText(TXT_SSM);
		checkText(TXT_SSDP);
		checkText(TXT_WEB_SERVER);
		checkText(TXT_B2BUA);
		checkText(TXT_SIP_SERVER);
		checkText(TXT_SNMP);
		checkText(TXT_PROCCESS_MANAGER);
		checkText(TXT_RTP_PROXY);
		checkText(TXT_SURVIVABILITY_PROVIDER);
		checkText(TXT_INTERFACE1);
		checkText(TXT_INTERFACE2);
		checkText(TXT_SSH);
		checkText(TXT_SYSLOG);
		checkText(TXT_ALARM_MANAGER);
		checkText(TXT_DBMS);
		checkText(TXT_CHRON);
		checkText(TXT_AUDIT);
		checkText(TXT_CDR);
		checkText(TXT_REDUDANCY);
		checkText(TXT_CONTINIOUS_TRACING);
		
		clickButtonClose();
        updateMap(RETRIES);
		clickButtonClose();
        updateMap(RETRIES);
		setMethodState();
	}
	

	
}