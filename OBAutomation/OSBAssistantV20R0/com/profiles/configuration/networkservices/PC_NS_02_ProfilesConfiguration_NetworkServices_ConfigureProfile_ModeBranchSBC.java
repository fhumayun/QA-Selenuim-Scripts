package com.profiles.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;
import com.profiles.list.Profiles_GeneralMethods;
import com.profiles.list.PropertiesProfilesList;

public class PC_NS_02_ProfilesConfiguration_NetworkServices_ConfigureProfile_ModeBranchSBC extends SuperHelper implements PropertiesProfilesList,PropertiesAlarms {

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
	ConfigureProfileNetworkServices ns = new ConfigureProfileNetworkServices();
	
	@Test (priority = 0)
	public void profilesConfigureProfileModeBranchSBCForNetworkSevices() throws InterruptedException {
		
		//Configure Network Services for Profile of Mode Branch SBC
		classMethodLogger.log(); 
		selectFromDropDown(SLC_SELECTPROFILE, "Pr04BranchSBCNetworkServices");
	    ns.configureProfileForNetworkServices();
	    setMethodState();
	}
	
	@Test (priority = 1)
	public void profilesAssignProfileModeBranchSBCForNetworkSevices() throws InterruptedException {
		
		//Assign the profile to the OpenBranch
		methodLogger.log(); 
		pr.assignProfile("Pr04BranchSBCNetworkServices");
		setMethodState();   
	}
	
	@Test(priority = 2)
	 public void verifyProfileModeBranchSBCForNetworkSevicesAssignment() throws InterruptedException {
	    	
		//Go to Network Services area of the OpenBranch and check that the Configuration is successful
		methodLogger.log();
		checkOBStatusAfterRestart(OpenBranch);
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
	    ns.verifyProfileNetworkServicesConfiguration();
		setMethodState();
	   }
			
	
}