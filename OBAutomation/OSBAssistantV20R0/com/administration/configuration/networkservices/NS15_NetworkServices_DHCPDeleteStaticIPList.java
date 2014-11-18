package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS15_NetworkServices_DHCPDeleteStaticIPList extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesDeleteDHCPStaticIPList() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_STATIC_IP);
		updateMap(RETRIES);
		//Delete Static IP List
		clickCheckbox_byText("HostName002");
		clickButtonDelete();
		//Check Deletion
		checkText_NotVisible("HostName002");
		clickButtonSave();
		
		updateMap(RETRIES);
		
		clickButtonSave();
	    updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesDHCPStaticIPListDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		//Select Tab DHCP
		clickButton(TB_DHCP);
		
		clickButton(BTN_DHCP_CONFIGURE_STATIC_IP);
		updateMap(RETRIES);
		//Verify Deletion
		checkText_NotVisible("HostName002");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}

 