package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS21_ProfilesList_DeleteAllProfiles extends SuperHelper implements PropertiesProfilesList {

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
	public void profilesListDeleteAllProfiles() throws InterruptedException {
		
		classMethodLogger.log(); 
		selectFromDropDown(SLC_ITEMS_PER_PAGE, "50");
		clickCheckbox_All();
		clickButtonDelete();
		
		//Check Number of Items in Main List
		checkText_byId(TXT_NUMBER_OF_ITEMS_IN_LIST,"0");
		
		selectFromDropDown(SLC_ITEMS_PER_PAGE, "10");
		setMethodState();
	}
	

}