package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC05_Security_AssignSecretFileCertificate extends SuperHelper implements PropertiesSecurity {

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
	public void securityAssignSecretFileCertificates() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		//Assign Shared Secret File Certificate
		selectFromDropDown(SLC_SHARE_SECRET_FILES, "AutomationNew.key");
		  
		clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
	    setMethodState();
	}

	@Test (priority = 1)
	public void verifySecuritySecretFileCertificatesAssignment() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		//Verify Certification Assignment
		checkSelectedValue_inDropDownList(SLC_SHARE_SECRET_FILES, "AutomationNew.key");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}