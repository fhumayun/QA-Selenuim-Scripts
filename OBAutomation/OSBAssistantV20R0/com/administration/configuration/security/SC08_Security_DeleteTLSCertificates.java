package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC08_Security_DeleteTLSCertificates extends SuperHelper implements PropertiesSecurity {

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
	public void securityDeleteTLSCertificates() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Delete TLS certificates
		
		//Delete TLS CA Certificate
		clickCheckbox_byText("UploadCertCA.pem");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		//Check TLS CA Certificate deletion
		checkText_NotVisible("UploadCertCA.pem");
		
		//Delete TLS Key File Certificate
		clickCheckbox_byText("UploadCertkey.pem");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		//Check TLS Key File Certificate deletion
		checkText_NotVisible("UploadCertkey.pem");
		
		//Delete TLS X.509 Certificate
		clickCheckbox_byText("UploadCertcert.pem");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		//Check TLS X.509 Certificate deletion
		checkText_NotVisible("UploadCertcert.pem");
		
		clickButtonSave();
		updateMap(RETRIES);
		    
		clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		setMethodState();
	}

	@Test (priority = 1)
	public void verifySecurityTLSCertificatesDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Verify TLS Certificates Deletion
		checkText_NotVisible("UploadCertCA.pem");	
		checkText_NotVisible("UploadCertkey.pem");
		checkText_NotVisible("UploadCertcert.pem");
		
		clickButtonSave();
	    updateMap(RETRIES);
	    
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}