package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV06_Survivability_EditEmergencyCalling extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityModifyEmergencyCalling() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Emergency Calling
		clickButton(TB_EMERGENCY_CALLING);
		
		clickCheckbox_byText("10.1.255.105");
		clickButton(BTN_EMERGENCY_EDIT);
		
		//Modify Emergency Calling fields
		updateMap(RETRIES);
		type_byId(IPF_GENERAL_IP, "10.2.152.124");
		type_byId(IPF_GENERAL_SUBNET, "255.255.0.0");
		type_byId(IPF_GENERAL_DEFAULT_DEST, "210779999");
		selectFromDropDown(SLC_GENERIC_ROUTING_PREFIX, "None");
		if(!getCheckboxStatus(CB_GENERAL_LIN))
			clickCheckbox_byID(CB_GENERAL_LIN);
		
		//Modify LIN fields
		clickButton(TAB_LIN);
		clickCheckbox_byText("150180210");
		clickButton(BTN_LIN_EDIT);
		updateMap(RETRIES);
		type_byId(IPF_LIN_FIELD, "210180150");
		type_byId(IPF_LIN_CALLBACK, "210777998");
		type_byId(IPF_LIN_DEFAULT_CALLBACK,"2105551000");
		if(!getCheckboxStatus(CB_LIN_USE_DEFAULT))
			clickCheckbox_byID(CB_LIN_USE_DEFAULT);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check LIN Modification
		checkText("210180150");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "210180150", TXT_LIST_LIN_CALLBACK_NUMBER, "210777998");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "210180150", TXT_LIST_LIN_DEFAULT_CALLBACK_NUMBER, "2105551000");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check Emergency Calling Modification
		checkText("10.2.152.124");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.2.152.124", TXT_LIST_EMERGENCY_CALLING_SUBNET_MASK, "255.255.0.0");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.2.152.124", "Routing Prefix", "None");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.2.152.124", TXT_LIST_EMERGENCY_ROUTING_DEFAULT_DESTINATION, "210779999");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityEmergencyCallingModification() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
		//Select Tab Emergency Calling
		clickButton(TB_EMERGENCY_CALLING);
		
		//Verify Emergency Calling Modification
		checkText("10.2.152.124");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.2.152.124", TXT_LIST_EMERGENCY_CALLING_SUBNET_MASK, "255.255.0.0");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.2.152.124", "Routing Prefix", "None");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.2.152.124", TXT_LIST_EMERGENCY_ROUTING_DEFAULT_DESTINATION, "210779999");
	
		clickCheckbox_byText("10.2.152.124");
		clickButton(BTN_EMERGENCY_EDIT);
		
		//Edit Emergency Calling and verify fields
		updateMap(RETRIES);
		checkValue_byId(IPF_GENERAL_IP, "10.2.152.124");
		checkValue_byId(IPF_GENERAL_SUBNET, "255.255.0.0");
		checkValue_byId(IPF_GENERAL_DEFAULT_DEST, "210779999");
		checkValue_inDropDownList(SLC_GENERIC_ROUTING_PREFIX, "None");
		checkStatus(CB_GENERAL_LIN, "checked", "checkbox");
		
		clickButton(TAB_LIN);
		//Verify LIN Modification
		checkText("210180150");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "210180150", TXT_LIST_LIN_CALLBACK_NUMBER, "210777998");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "210180150", TXT_LIST_LIN_DEFAULT_CALLBACK_NUMBER, "2105551000");
	
		//Edit LIN and verify fields
		clickCheckbox_byText("210180150");
		clickButton(BTN_LIN_EDIT);
		updateMap(RETRIES);
		checkValue_byId(IPF_LIN_FIELD, "210180150");
		checkValue_byId(IPF_LIN_CALLBACK, "210777998");
		checkValue_byId(IPF_LIN_DEFAULT_CALLBACK,"2105551000");
		checkStatus(CB_LIN_USE_DEFAULT, "checked", "checkbox");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}

}