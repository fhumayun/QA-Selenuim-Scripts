package com.profiles.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;
import com.profiles.list.Profiles_GeneralMethods;
import com.profiles.list.PropertiesProfilesList;

public class PC_SC_03_ProfilesConfiguration_Security_CreateProfile_ModeSBCProxy extends SuperHelper implements PropertiesProfilesList {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToProfilesList();
	}

	@BeforeMethod(alwaysRun = true)
	public void initializeWindowsMap() throws InterruptedException {
		initMap();
	}
	
	@AfterMethod(alwaysRun = true)
	public void getfocusClearWindowsBeforeMethod() throws InterruptedException {
		clearWindows();
	}

	Profiles_GeneralMethods pr = new Profiles_GeneralMethods();
	
	
	@Test (priority = 0)
	public void profilesListCreateProfileModeSBCProxyForSecurity() throws InterruptedException {
		
		classMethodLogger.log(); 
		pr.createProfile("Pr05SBCProxySecurity", TXT_SBC_PROXY, OpenBranchVersion);
		setMethodState();
	}
	

	
}