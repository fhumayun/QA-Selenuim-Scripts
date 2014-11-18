package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC07_Security_UploadSecretFileCertificates extends SuperHelper implements PropertiesSecurity {

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
	public void securityUploadSecretFileCertificate() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Upload Secret File Certificate
		clickButtonAdd();
		updateMap(RETRIES);
		
		clickButton_byName(RB_UPLOAD_CERTIFICATE);
		selectFromDropDown(SLC_GENERAL_UPLOAD_CERTIFICATES, TXT_SHARED_SECRET_FILE);
		uploadFile(BTN_GENERAL_UPLOAD_BROWSE_BUTTON,LocalFolder+"\\Certificates\\UploadCert.key");	
		clickButtonSave();
		updateMap(RETRIES);

		//Check Secret File Certificate uploading
		checkText("UploadCert.key");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCert.key", TXT_LIST_CERTIFICATE_TYPE, "Shared Secret File");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check that the uploaded certificates appear as option in the corresponding drop-down lists
		checkValue_inDropDownList(SLC_SHARE_SECRET_FILES, "UploadCert.key");
		    
		clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		setMethodState();
	}

	@Test (priority = 1)
	public void verifySecuritySecretFileCertificateUploading() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		//Verify that the uploaded certificate appears as option in the corresponding drop-down list
		checkValue_inDropDownList(SLC_SHARE_SECRET_FILES, "UploadCert.key");
		
		clickButton(BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Verify Shared Secret File Certificate Uploading
		checkText("UploadCert.key");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCert.key", TXT_LIST_CERTIFICATE_TYPE, "Shared Secret File");
	
		clickButtonSave();
	    updateMap(RETRIES);
	    
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}