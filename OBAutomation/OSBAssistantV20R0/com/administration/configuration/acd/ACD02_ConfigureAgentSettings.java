package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD02_ConfigureAgentSettings extends SuperHelper implements PropertiesACD {

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
	public void acdChangeLogOnLogOffServiceAccessCode() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		//Change values in Log On Service Access Code,Log Off Service Access Code and Timeout Input Fields 
		type_byId(IPF_LOG_ON_SERVICE_ACCESS_CODE, "30");
	    type_byId(IPF_LOG_OFF_SERVICE_ACCESS_CODE, "31");
		type_byId(IPF_AGENT_TIMEOUT, "40");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyAcdLogOnLogOffServiceAccessCode() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		//Verify Changes
		checkValue_byId(IPF_LOG_ON_SERVICE_ACCESS_CODE, "30");
		checkValue_byId(IPF_LOG_OFF_SERVICE_ACCESS_CODE, "31");
		checkValue_byId(IPF_AGENT_TIMEOUT, "40");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void acdActivateSupportKeysetToggleKey() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		//Activate Support Keyset Toggle Key
		clickCheckbox_byID(CB_SUPPORT_KEYSET_TOGGLE_KEY);
		
		//Check that the Log On Service Access Code,Log Off Service Access Code 
		//Input Fields become disabled and that the Keyset Toggle Service access code
		//Input field become enabled
		checkStatus(IPF_LOG_ON_SERVICE_ACCESS_CODE,"disabled","Input Field Log On Service Access Code");
		checkStatus(IPF_LOG_OFF_SERVICE_ACCESS_CODE,"disabled","Input Field Log Off Service Access Code");
        checkStatus(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE,"enabled","Input Field Keyset Toggle Service access code");
		type_byId(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE, "30");

		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority =3)
	public void verifyAcdSupportKeysetToggleKeyActivation() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		//Verify Activation
		checkStatus(CB_SUPPORT_KEYSET_TOGGLE_KEY,"checked","Checbox Support Keyset Toggle Key");
		checkStatus(IPF_LOG_ON_SERVICE_ACCESS_CODE,"disabled","Input Field Log On Service Access Code");
		checkStatus(IPF_LOG_OFF_SERVICE_ACCESS_CODE,"disabled","Input Field Log Off Service Access Code");
        checkStatus(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE,"enabled","Input Field Keyset Toggle Service access code");
		checkValue_byId(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE, "30");

		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}

	@Test (priority = 4)
	public void acdDeactivateSupportKeysetToggleKey() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		//De-Activate Support Keyset Toggle Key
		clickCheckbox_byID(CB_SUPPORT_KEYSET_TOGGLE_KEY);
		
		//Check that the Log On Service Access Code,Log Off Service Access Code 
		//Input Fields become enabled and that the Keyset Toggle Service access code
		//Input field become disabled
		checkStatus(IPF_LOG_ON_SERVICE_ACCESS_CODE,"enabled","Input Field Log On Service Access Code");
		checkStatus(IPF_LOG_OFF_SERVICE_ACCESS_CODE,"enabled","Input Field Log Off Service Access Code");
        checkStatus(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE,"disabled","Input Field Keyset Toggle Service access code");
        type_byId(IPF_LOG_ON_SERVICE_ACCESS_CODE, "21");
	    type_byId(IPF_LOG_OFF_SERVICE_ACCESS_CODE, "22");
		type_byId(IPF_AGENT_TIMEOUT, "30");

		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority =5)
	public void verifyAcdSupportKeysetToggleKeyDeactivation() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		//Verify Deactivation
		checkStatus(CB_SUPPORT_KEYSET_TOGGLE_KEY,"unchecked","Checbox Support Keyset Toggle Key");
		checkStatus(IPF_LOG_ON_SERVICE_ACCESS_CODE,"enabled","Input Field Log On Service Access Code");
		checkStatus(IPF_LOG_OFF_SERVICE_ACCESS_CODE,"enabled","Input Field Log Off Service Access Code");
        checkStatus(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE,"disabled","Input Field Keyset Toggle Service access code");
		
        clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}

	@Test (priority =6)
	public void acdLogOnLogOffServiceAccessCodeValidation() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		//Enter same values for Log On Service Access Code and Log Off Service Access Code
		type_byId(IPF_LOG_ON_SERVICE_ACCESS_CODE, "30");
	    type_byId(IPF_LOG_OFF_SERVICE_ACCESS_CODE, "30");
		
		clickButtonSave();
		
		//validation messages appear
		checkText_byId(DIV_LOG_ON_SERVICE_ACCESS_CODE_VALIDATION, TXT_SAME_VALUES_NOT_POSSIBLE);
		checkText_byId(DIV_LOG_OFF_SERVICE_ACCESS_CODE_VALIDATION, TXT_SAME_VALUES_NOT_POSSIBLE);
		
        clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}