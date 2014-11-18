package com.profiles.configuration.alarms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;
import com.profiles.list.Profiles_GeneralMethods;
import com.profiles.list.PropertiesProfilesList;

public class PC_AL_01_ProfilesConfiguration_Alarms_CreateProfile_ModeBranchSBC extends SuperHelper implements PropertiesProfilesList {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	Profiles_GeneralMethods pr = new Profiles_GeneralMethods();
	
	
	@Test (priority = 0)
	public void profilesListCreateProfileModeBranchSBCForAlarms() throws InterruptedException {
		
		classMethodLogger.log(); 
		selectFromDropDown(SLC_ITEMS_PER_PAGE, "50");
		pr.createProfile("Pr01BranchSBCAlarms", TXT_BRANCH_SBC, OpenBranchVersion);
		setMethodState();
	}
	

	
}