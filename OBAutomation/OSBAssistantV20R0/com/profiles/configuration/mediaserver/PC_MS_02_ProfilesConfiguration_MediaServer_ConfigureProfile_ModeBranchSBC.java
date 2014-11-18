package com.profiles.configuration.mediaserver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;
import com.profiles.list.Profiles_GeneralMethods;
import com.profiles.list.PropertiesProfilesList;

public class PC_MS_02_ProfilesConfiguration_MediaServer_ConfigureProfile_ModeBranchSBC extends SuperHelper implements PropertiesProfilesList,PropertiesAlarms {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToOpenScapeBranch();
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
	ConfigureProfileMediaServer ms = new ConfigureProfileMediaServer();
	
	@Test (priority = 0)
	public void profilesConfigureProfileModeBranchSBCForMediaServer() throws InterruptedException {
		
		//Configure Media Server for Profile of Mode Branch SBC
		classMethodLogger.log(); 
		selectFromDropDown(SLC_SELECTPROFILE, "Pr03BranchSBCMediaServer");
		ms.configureProfileForMediaServer();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesAssignProfileModeBranchSBCForMediaServer() throws InterruptedException {
		
		//Assign the profile to the OpenBranch
		methodLogger.log(); 
		pr.assignProfile("Pr03BranchSBCMediaServer");
		setMethodState();   
	}
	
	@Test(priority = 2)
	 public void verifyProfileModeBranchSBCForMediaServerAssignment() throws InterruptedException {
	    	
		//Go to Media Server area of the OpenBranch and check that the Configuration is successful
		methodLogger.log();
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
	    ms.verifyProfileMediaServerConfiguration();
		setMethodState();
	   }
			
	
}