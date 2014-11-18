package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV08_Survivability_AddEmergencyNumber extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityAddEmergencyNumber() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Emergency Number
		clickButton(TB_EMERGENCY_NUMBER);
		
		//Add 3 Emergency Numbers and check creation
		type_byId(IPF_EMERGENCY_NUMBER_FIELD, "11223344");
		clickButtonAdd();
		checkText("11223344");
		
		type_byId(IPF_EMERGENCY_NUMBER_FIELD, "7894560");
		clickButtonAdd();
		checkText("7894560");
		
		type_byId(IPF_EMERGENCY_NUMBER_FIELD, "21077789998");
		clickButtonAdd();
		checkText("21077789998");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 1)
	public void verifySurvivabilityEmergencyNumberCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Emergency Number
		clickButton(TB_EMERGENCY_NUMBER);
		
		//Verify Emergency Number creation
		checkText("11223344");
		checkText("7894560");
		checkText("21077789998");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}