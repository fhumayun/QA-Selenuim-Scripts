package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV09_Survivability_DeleteEmergencyNumber extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityDeleteOneEmergencyNumber() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Emergency Number
		clickButton(TB_EMERGENCY_NUMBER);
		//Delete one Emergency Number
		clickCheckbox_byText("11223344");
		clickButton(BTN_EMERGENCY_NUMBER_DELETE);
		
		//Check Deletion
		checkText_NotVisible("11223344");

		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityOneEmergencyNumberDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
        //Select Tab Emergency Number
		clickButton(TB_EMERGENCY_NUMBER);
		
		//Verify Deletion
		checkText_NotVisible("11223344");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void survivabilityDeleteMultiEmergencyNumber() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Emergency Number
		clickButton(TB_EMERGENCY_NUMBER);
		//Delete all Emergency Numbers
		clickCheckbox_All();
		clickButton(BTN_EMERGENCY_NUMBER_DELETE);
		
		//Check Deletion
		checkText_NotVisible("7894560");
		checkText_NotVisible("21077789998");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifySurvivabilityMultiEmergencyNumberDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
        //Select Tab Emergency Number
		clickButton(TB_EMERGENCY_NUMBER);
		
		//Verify Deletion
		checkText_NotVisible("7894560");
		checkText_NotVisible("21077789998");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}