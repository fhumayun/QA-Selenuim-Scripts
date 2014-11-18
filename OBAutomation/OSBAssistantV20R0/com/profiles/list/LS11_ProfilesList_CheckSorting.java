package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS11_ProfilesList_CheckSorting extends SuperHelper implements PropertiesProfilesList {

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

	@Test (priority = 0)
	public void profilesListCheckSorting() throws InterruptedException {
		
		classMethodLogger.log(); 
		
	    checkSorting(TXT_PROFILE_NAME);
	    checkSorting(TXT_PROFILE_MODE);
	    checkSorting(TXT_PROFILE_VERSION);

	    //Retrieve default sorting
	    clickLink_ByLinkText(TXT_PROFILE_NAME);
	    
	    setMethodState();

	    
	  }
	
}