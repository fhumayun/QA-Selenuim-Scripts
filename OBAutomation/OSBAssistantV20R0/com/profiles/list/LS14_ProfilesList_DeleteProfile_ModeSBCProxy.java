package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS14_ProfilesList_DeleteProfile_ModeSBCProxy extends SuperHelper implements PropertiesProfilesList {

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
	public void profilesListDeleteOneProfileModeSBCProxy() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		//Delete One Profile
		clickCheckbox_byText("Profile44");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile44");
		
		setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesListDeleteMoreProfilesModeSBCProxy() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Delete More Profiles
		clickCheckbox_byText("Profile55");
		clickCheckbox_byText("Profile66");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile55");
		checkText_NotVisible("Profile66");
		
		setMethodState();
	}

	
}