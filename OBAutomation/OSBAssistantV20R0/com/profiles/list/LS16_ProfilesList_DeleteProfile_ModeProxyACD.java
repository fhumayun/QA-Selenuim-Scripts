package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS16_ProfilesList_DeleteProfile_ModeProxyACD extends SuperHelper implements PropertiesProfilesList {

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
	public void profilesListDeleteOneProfileModeProxyACD() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		//Delete One Profile
		clickCheckbox_byText("Profile100");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile100");
		
		setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesListDeleteMoreProfilesModeProxyACD() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Delete More Profiles
		clickCheckbox_byText("Profile200");
		clickCheckbox_byText("Profile300");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile200");
		checkText_NotVisible("Profile300");
		
		//Check Number of Items in Main List
		checkText_byId(TXT_NUMBER_OF_ITEMS_IN_LIST,"0");
		
		setMethodState();
	}

	
}