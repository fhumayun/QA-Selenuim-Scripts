package com.profiles.configuration.logging;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;
import com.profiles.list.Profiles_GeneralMethods;
import com.profiles.list.PropertiesProfilesList;

public class PC_LG_02_ProfilesConfiguration_Logging_ConfigureProfile_ModeBranchSBC extends SuperHelper implements PropertiesProfilesList,PropertiesAlarms {

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
	ConfigureProfileLogging lg = new ConfigureProfileLogging();
	
	@Test (priority = 0)
	public void profilesConfigureProfileModeBranchSBCForLogging() throws InterruptedException {
		
		//Configure Logging for Profile of Mode Branch SBC
		classMethodLogger.log(); 
		selectFromDropDown(SLC_SELECTPROFILE, "Pr02BranchSBCLogging");
		lg.configureProfileForLogging();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesAssignProfileModeBranchSBCForLogging() throws InterruptedException {
		
		//Assign the profile to the OpenBranch
		methodLogger.log(); 
		pr.assignProfile("Pr02BranchSBCLogging");
		setMethodState();   
	}
	
	@Test(priority = 2)
	 public void verifyProfileModeBranchSBCForLoggingAssignment() throws InterruptedException {
	    	
		//Go to Logging area of the OpenBranch and check that the Configuration is successful
		methodLogger.log();
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
	    lg.verifyProfileLoggingConfiguration();
		setMethodState();
	   }
			
	
}