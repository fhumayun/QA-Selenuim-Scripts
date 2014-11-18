package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS15_ProfilesList_DeleteProfile_ModeProxy extends SuperHelper implements PropertiesProfilesList {

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
	public void profilesListDeleteOneProfileModeProxy() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		//Delete One Profile
		clickCheckbox_byText("Profile77");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile77");
		
		setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesListDeleteMoreProfilesModeProxy() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Delete More Profiles
		clickCheckbox_byText("Profile88");
		clickCheckbox_byText("Profile99");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile88");
		checkText_NotVisible("Profile99");
		
		setMethodState();
	}

	
}