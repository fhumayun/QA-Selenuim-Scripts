package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV04_Survivability_DeleteMLHG extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityDeleteOneMLHG() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab MLHG
		clickButton(TB_MULTI_LINE_HG);
		//Delete one MLHG
		clickCheckbox_byText("2109876543");
		clickButton(BTN_MULTI_LINE_HG_DELETE);
		
		//Check Deletion
		checkText_NotVisible("2109876543");

		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityOneMLHGDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
		//Select Tab MLHG
		clickButton(TB_MULTI_LINE_HG);
		
		//Verify Deletion
		checkText_NotVisible("2109876543");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void survivabilityDeleteMultiMLHG() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab MLHG
		clickButton(TB_MULTI_LINE_HG);
		//Delete all MLHG
		clickCheckbox_All();
		clickButton(BTN_MULTI_LINE_HG_DELETE);
		
		//Check Deletion
		checkText_NotVisible("2107772001");
		checkText_NotVisible("2107775001");
		checkText_NotVisible("2107775201");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifySurvivabilityMultiMLHGDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
		//Select Tab MLHG
		clickButton(TB_MULTI_LINE_HG);
		
		//Verify Deletion
		checkText_NotVisible("2107772001");
		checkText_NotVisible("2107775001");
		checkText_NotVisible("2107775201");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}