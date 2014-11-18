package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC25_Security_DeleteRemainingUserCertificates extends SuperHelper implements PropertiesSecurity {

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
	public void securityDeleteCertificates() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Delete TLS certificates
		clickCheckbox_byText("AutomationCA.pem");
		clickCheckbox_byText("Automationkey.pem");
		clickCheckbox_byText("Automationcert.pem");
		javaScriptConfirmation("ok");
		clickButtonDelete();
	
		//Check TLS Certificates Deletion
		checkText_NotVisible("AutomationCA.pem");	
		checkText_NotVisible("Automationkey.pem");
		checkText_NotVisible("Automationcert.pem");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButton(BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Delete Secret Key File Certificate
		clickCheckbox_All();
		javaScriptConfirmation("ok");
		clickButtonDelete();
		//Check Secret Key File Certificates deletion
		checkText_NotVisible("Automation.key");
		checkText_NotVisible("AutomationNew.key");
		
		clickButtonSave();
		updateMap(RETRIES);
		    
		clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 1)
	public void verifySecurityCertificatesDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Verify TLS Certificates Deletion
		checkText_NotVisible("AutomationCA.pem");	
		checkText_NotVisible("Automationkey.pem");
		checkText_NotVisible("Automationcert.pem");
		
		clickButtonSave();
	    updateMap(RETRIES);
	    
	    clickButton(BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Verify Secret Key File Certificates Deletion
		checkText_NotVisible("Automation.key");
		checkText_NotVisible("AutomationNew.key");	
	
		clickButtonSave();
	    updateMap(RETRIES);
	    
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}