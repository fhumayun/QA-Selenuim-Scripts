package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV07_Survivability_DeleteEmergencyCalling extends SuperHelper implements PropertiesSurvivability {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToAdministration()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
		}
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
	public void survivabilityDeleteEmergencyCalling() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
		//Select Tab Emergency Calling
		clickButton(TB_EMERGENCY_CALLING);
		
		//Delete Emergency Calling
		clickCheckbox_byText("10.2.152.124");
		clickButton(BTN_EMERGENCY_DELETE);
		
		//Check Deletion
		checkText_NotVisible("10.2.152.124");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityEmergencyCallingDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
		//Select Tab Emergency Calling
		clickButton(TB_EMERGENCY_CALLING);
		
		//Verify Emergency Calling Deletion
		checkText_NotVisible("10.2.152.124");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}