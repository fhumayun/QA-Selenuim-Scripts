package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC03_Security_AssignTLSCertificates extends SuperHelper implements PropertiesSecurity {

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
	public void securityAssignTLSCertificates() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		//Assign TLS Certificates
		selectFromDropDown(SLC_X509_CERTIFICATE, "Automationcert.pem");
		selectFromDropDown(SLC_CA_CERTIFICATES, "AutomationCA.pem");
		selectFromDropDown(SLC_KEY_FILE, "Automationkey.pem");
	      
		clickButtonSave();
		updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}

	@Test (priority = 1)
	public void verifySecurityTLSCertificatesAssignment() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		//Verify Certification Assignment
		checkSelectedValue_inDropDownList(SLC_X509_CERTIFICATE, "Automationcert.pem");
		checkSelectedValue_inDropDownList(SLC_CA_CERTIFICATES, "AutomationCA.pem");
		checkSelectedValue_inDropDownList(SLC_KEY_FILE, "Automationkey.pem");
	
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}