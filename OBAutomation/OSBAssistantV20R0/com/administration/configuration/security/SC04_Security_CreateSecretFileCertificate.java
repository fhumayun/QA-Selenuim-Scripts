package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC04_Security_CreateSecretFileCertificate extends SuperHelper implements PropertiesSecurity {

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
	public void securityCreateSecretFileCertificate() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON);
		updateMap(RETRIES);
			
		//Create 2 Shared Secret File Certificate
		clickButtonAdd();
		updateMap(RETRIES);
		
		type_byId(IPF_GENERAL_ADD_SHARED_SECRET_FILES_NAME, "Automation");
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check 1st Shared Secret File Certificate creation
		checkText("Automation.key");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "Automation.key", TXT_LIST_CERTIFICATE_TYPE, "Shared Secret File");
	
		clickButtonAdd();
		updateMap(RETRIES);
		
		type_byId(IPF_GENERAL_ADD_SHARED_SECRET_FILES_NAME, "AutomationNew");
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check 1st Shared Secret File Certificates creation
		checkText("AutomationNew.key");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "AutomationNew.key", TXT_LIST_CERTIFICATE_TYPE, "Shared Secret File");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check that the created certificates appear as option in the corresponding drop-down list
		checkValue_inDropDownList(SLC_SHARE_SECRET_FILES, "Automation.key");
		checkValue_inDropDownList(SLC_SHARE_SECRET_FILES, "AutomationNew.key");

		clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		setMethodState();
	}

	@Test (priority = 1)
	public void verifySecuritySecretFileCertificateCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		//Verify that the created certificates appear as option in the corresponding drop-down list
		checkValue_inDropDownList(SLC_SHARE_SECRET_FILES, "Automation.key");
		checkValue_inDropDownList(SLC_SHARE_SECRET_FILES, "AutomationNew.key");
		checkSelectedValue_inDropDownList(SLC_SHARE_SECRET_FILES, "Automation.key");
		
		
		clickButton(BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Verify Shared Secret File Certificates List
		checkText("Automation.key");
		checkText("AutomationNew.key");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "Automation.key", TXT_LIST_CERTIFICATE_TYPE, "Shared Secret File");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "AutomationNew.key", TXT_LIST_CERTIFICATE_TYPE, "Shared Secret File");
		
		clickButtonSave();
	    updateMap(RETRIES);
	    
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}