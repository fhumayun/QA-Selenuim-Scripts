package com.profiles.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;
import com.profiles.list.Profiles_GeneralMethods;
import com.profiles.list.PropertiesProfilesList;

public class PC_SC_06_ProfilesConfiguration_Security_ConfigureProfile_ModeProxy extends SuperHelper implements PropertiesProfilesList,PropertiesAlarms {

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
	ConfigureProfileSecurity sc = new ConfigureProfileSecurity();
	
	@Test (priority = 0)
	public void profilesConfigureProfileModeProxyForSecurity() throws InterruptedException {
		
		//Configure Security for Profile of Mode Branch SBC
		classMethodLogger.log(); 
		selectFromDropDown(SLC_SELECTPROFILE, "Pr05ProxySecurity");
		sc.configureProfileForSecurity(TXT_PROXY);
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesAssignProfileModeProxyForSecurity() throws InterruptedException {
		
		//Assign the profile to the OpenBranch
		methodLogger.log(); 
		pr.assignProfile("Pr05ProxySecurity");
		setMethodState();   
	}
	
	@Test(priority = 2)
	 public void verifyProfileModeProxyForSecurityAssignment() throws InterruptedException {
	    	
		//Go to Security area of the OpenBranch and check that the Configuration is successful
		methodLogger.log();
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
	    sc.verifyProfileSecurityConfiguration(TXT_PROXY);
		setMethodState();
	   }
			
	
}