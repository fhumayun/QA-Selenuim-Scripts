package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS17_NetworkServices_DHCPDeleteDNSServerList extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesDeleteDHCPDNSServerList() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		//Delete DNS Server List
		clickButton(BTN_DHCP_CONFIGURE_DNS_SERVER_LIST);
		updateMap(RETRIES);
		
		clickCheckbox_All();
		clickButtonDelete();
		//Check deletion
		checkText_NotVisible("10.11.252.190");
		checkText_NotVisible("10.1.254.157");
		checkText_NotVisible("10.1.253.128");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonSave();
	    updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesDHCPDNSServerListDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_DNS_SERVER_LIST);
		updateMap(RETRIES);
		
		//Verify deletion
		checkText_NotVisible("10.11.252.190");
		checkText_NotVisible("10.1.254.157");
		checkText_NotVisible("10.1.253.128");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}

 