package com.profiles.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;
import com.profiles.list.Profiles_GeneralMethods;
import com.profiles.list.PropertiesProfilesList;

public class PC_VP_06_ProfilesConfiguration_Voip_ConfigureProfile_ModeProxy extends SuperHelper implements PropertiesProfilesList,PropertiesAlarms {

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
	ConfigureProfileVoip vp = new ConfigureProfileVoip();
	
	@Test (priority = 0)
	public void profilesConfigureProfileModeProxyForVoip() throws InterruptedException {
		
		//Configure Voip for Profile of Mode Branch SBC
		classMethodLogger.log(); 
		selectFromDropDown(SLC_SELECTPROFILE, "Pr07ProxyVoip");
		vp.configureProfileForVoip(TXT_PROXY);
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesAssignProfileModeProxyForVoip() throws InterruptedException {
		
		//Assign the profile to the OpenBranch
		methodLogger.log(); 
		pr.assignProfile("Pr07ProxyVoip");
		setMethodState();   
	}
	
	@Test(priority = 2)
	 public void verifyProfileModeProxyForVoipAssignment() throws InterruptedException {
	    	
		//Go to Voip area of the OpenBranch and check that the Configuration is successful
		methodLogger.log();
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
	    vp.verifyProfileVoipConfiguration(TXT_PROXY);
	    setMethodState();
	   }
			
	
}