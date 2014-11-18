package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV11_Survivability_DigitTranslation extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityAddDigitTranslation() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		if(!getCheckboxStatus(CB_TICKET_GENERATION))
			clickCheckbox_byID(CB_TICKET_GENERATION);
		
		//Enable E.164 Translation
		if(!getCheckboxStatus(CB_E164))
			clickCheckbox_byID(CB_E164);
		
		//Check that the Configure Translation Button becomes enabled
	    checkStatus(BTN_CONFIGURE_TRANSLATION, "enabled", "Button Configure E.164 Translation");
	      
		clickButton(BTN_CONFIGURE_TRANSLATION);
		updateMap(RETRIES);
		
		//Add 2 Digit Translations
		clickButtonAdd();
		updateMap(RETRIES);
	
		type_byId(IPF_MATCHING_DIGITS, "123");
		type_byId(IPF_TRANSLATION, "456");
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonAdd();
		updateMap(RETRIES);
	
		type_byId(IPF_MATCHING_DIGITS, "555");
		type_byId(IPF_TRANSLATION, "777");
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check successful Add
		checkText("123");
		checkText("456");
		checkText("555");
		checkText("777");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityDigitTranslationCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		clickButton(BTN_CONFIGURE_TRANSLATION);
		updateMap(RETRIES);
		
		//Verify successful Add
		checkText("123");
		checkText("456");
		checkText("555");
		checkText("777");
		
		//Edit One Digit Translation and verify fields
		clickCheckbox_byText("123");
		clickButtonEdit();
		updateMap(RETRIES);
		checkValue_byId(IPF_MATCHING_DIGITS, "123");
		checkValue_byId(IPF_TRANSLATION, "456");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void survivabilityModifyDigitTranslation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		clickButton(BTN_CONFIGURE_TRANSLATION);
		updateMap(RETRIES);
		
		//Modify Digit Translation
		clickCheckbox_byText("123");
		clickButtonEdit();
		updateMap(RETRIES);
		type_byId(IPF_MATCHING_DIGITS, "888");
		type_byId(IPF_TRANSLATION, "999");
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check successful Modification
		checkText("888");
		checkText("999");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifySurvivabilityDigitTranslationModification() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		clickButton(BTN_CONFIGURE_TRANSLATION);
		updateMap(RETRIES);
		
		//Verify successful Modification
		checkText("888");
		checkText("999");
		
		//Edit Digit Translation and verify fields
		clickCheckbox_byText("888");
		clickButtonEdit();
		updateMap(RETRIES);
		checkValue_byId(IPF_MATCHING_DIGITS, "888");
		checkValue_byId(IPF_TRANSLATION, "999");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 4)
	public void survivabilityDeleteDigitTranslation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
	     
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		clickButton(BTN_CONFIGURE_TRANSLATION);
		updateMap(RETRIES);
		
		//Delete Digit Translation
		clickCheckbox_byText("888");
		clickButtonDelete();
		
		//Check successful Deletion
		checkText_NotVisible("888");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 5)
	public void verifySurvivabilityDigitTranslationDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		clickButton(BTN_CONFIGURE_TRANSLATION);
		updateMap(RETRIES);
		
		//Verify successful deletion
		checkText_NotVisible("888");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 6)
	public void survivabilityDisableDigitTranslation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
	     
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		clickButton(BTN_CONFIGURE_TRANSLATION);
		updateMap(RETRIES);
		
		//Delete Digit Translation
		clickCheckbox_byText("555");
		clickButtonDelete();
		
		//Check successful Deletion
		checkText_NotVisible("555");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		//Disable E.164 Translation
		if(getCheckboxStatus(CB_E164))
			clickCheckbox_byID(CB_E164);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 7)
	public void verifySurvivabilityDigitTranslationDisabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		checkStatus(BTN_CONFIGURE_TRANSLATION, "disabled", "Button Configure E.164 Translation");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}