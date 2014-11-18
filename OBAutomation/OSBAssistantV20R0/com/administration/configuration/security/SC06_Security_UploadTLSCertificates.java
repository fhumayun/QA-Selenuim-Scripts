package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC06_Security_UploadTLSCertificates extends SuperHelper implements PropertiesSecurity {

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
	public void securityUploadTLSCertificates() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Upload TLS CA Certificate
		clickButtonAdd();
		updateMap(RETRIES);
		
		clickButton_byName(RB_UPLOAD_CERTIFICATE);
		selectFromDropDown(SLC_GENERAL_UPLOAD_CERTIFICATES, TXT_CA_CERTIFICATE);
		uploadFile(BTN_GENERAL_UPLOAD_BROWSE_BUTTON,LocalFolder+"\\Certificates\\UploadCertCA.pem");	
		clickButtonSave();
		updateMap(RETRIES);

		//Upload TLS Key File Certificate
		clickButtonAdd();
		updateMap(RETRIES);
		
		clickButton_byName(RB_UPLOAD_CERTIFICATE);
		selectFromDropDown(SLC_GENERAL_UPLOAD_CERTIFICATES, TXT_KEY_FILE);
		uploadFile(BTN_GENERAL_UPLOAD_BROWSE_BUTTON,LocalFolder+"\\Certificates\\UploadCertkey.pem");	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Upload TLS X.509 Certificate
		clickButtonAdd();
		updateMap(RETRIES);
		
		clickButton_byName(RB_UPLOAD_CERTIFICATE);
		selectFromDropDown(SLC_GENERAL_UPLOAD_CERTIFICATES, TXT_X509_CERTIFICATE);
		uploadFile(BTN_GENERAL_UPLOAD_BROWSE_BUTTON,LocalFolder+"\\Certificates\\UploadCertcert.pem");	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check Certificates uploading
		checkText("UploadCertCA.pem");
		checkText("UploadCertcert.pem");
		checkText("UploadCertkey.pem");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCertCA.pem", TXT_LIST_CERTIFICATE_TYPE, "CA Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCertcert.pem", TXT_LIST_CERTIFICATE_TYPE, "X.509 Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCertkey.pem", TXT_LIST_CERTIFICATE_TYPE, "Key File");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check that the uploaded certificates appear as option in the corresponding drop-down lists
		checkValue_inDropDownList(SLC_X509_CERTIFICATE, "UploadCertcert.pem");
	    checkValue_inDropDownList(SLC_CA_CERTIFICATES, "UploadCertCA.pem");
	    checkValue_inDropDownList(SLC_KEY_FILE, "UploadCertkey.pem");
	     
		clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		setMethodState();
	}

	@Test (priority = 1)
	public void verifySecurityTLSCertificatesUploading() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		//Verify that the created certificates appear as option in the corresponding drop-down lists
		checkValue_inDropDownList(SLC_X509_CERTIFICATE, "UploadCertcert.pem");
	    checkValue_inDropDownList(SLC_CA_CERTIFICATES, "UploadCertCA.pem");
	    checkValue_inDropDownList(SLC_KEY_FILE, "UploadCertkey.pem");
	  
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Verify TLS Certificates List
		checkText("UploadCertCA.pem");
		checkText("UploadCertcert.pem");
		checkText("UploadCertkey.pem");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCertCA.pem", TXT_LIST_CERTIFICATE_TYPE, "CA Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCertcert.pem", TXT_LIST_CERTIFICATE_TYPE, "X.509 Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "UploadCertkey.pem", TXT_LIST_CERTIFICATE_TYPE, "Key File");
		
		clickButtonSave();
	    updateMap(RETRIES);
	    
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}