package com.administration.management;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class MG01_Management_GUIElements_DefaultValues extends SuperHelper implements PropertiesManagement {

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
	public void branchOfficeManagement_CheckDefaultValues() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		//Check Buttons Status
		checkStatus(BTN_APPLYCHANGES, "disabled", "Button Apply Changes");
		checkStatus(BTN_CANCELCHANGES, "disabled", "Button Cancel Changes");
		checkStatus(BTN_SHOW_REGISTERED_SUBSCRIBERS, "enabled", "Button Show Registered subscribers");
		checkStatus(BTN_SHOW_LINK_STATUS, "disabled", "Button Show Backup link status");
		checkStatus(BTN_REFRESH_LISENCES, "enabled", "Button Refresh Licenses");
		checkStatus(BTN_DEVICE_LICENSE_UPDATE, "enabled", "Button Device License Update");
		checkStatus(BTN_CONFIGURE_LICENSES, "enabled", "Button Configure Licenses");
		
		setMethodState();
	}

}