package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC02_Security_CreateTLSCertificates extends SuperHelper implements PropertiesSecurity {

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
	public void securityCreateTLSCertificate() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Check default TLS Certificates List
		checkText("serverCA.pem");
		checkText("servercert.pem");
		checkText("serverkey.pem");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "serverCA.pem", TXT_LIST_CERTIFICATE_TYPE, "CA Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "servercert.pem", TXT_LIST_CERTIFICATE_TYPE, "X.509 Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "serverkey.pem", TXT_LIST_CERTIFICATE_TYPE, "Key File");
	
		//Create TLS certificate
		clickButtonAdd();
		updateMap(RETRIES);
		
		type_byId(IPF_GENERAL_ADD_TLS_CERTS_NAME, "Automation");
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check Certificates creation
		checkText("AutomationCA.pem");
		checkText("Automationcert.pem");
		checkText("Automationkey.pem");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "AutomationCA.pem", TXT_LIST_CERTIFICATE_TYPE, "CA Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "Automationcert.pem", TXT_LIST_CERTIFICATE_TYPE, "X.509 Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "Automationkey.pem", TXT_LIST_CERTIFICATE_TYPE, "Key File");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check that the created certificates appear as option in the corresponding drop-down lists
		checkValue_inDropDownList(SLC_X509_CERTIFICATE, "Automationcert.pem");
	    checkValue_inDropDownList(SLC_CA_CERTIFICATES, "AutomationCA.pem");
	    checkValue_inDropDownList(SLC_KEY_FILE, "Automationkey.pem");
	     
		clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		setMethodState();
	}

	@Test (priority = 1)
	public void verifySecurityTLSCertificateCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		clickButton(TB_GENERAL);
		//Verify that the created certificates appear as option in the corresponding drop-down lists
		checkValue_inDropDownList(SLC_X509_CERTIFICATE, "Automationcert.pem");
	    checkValue_inDropDownList(SLC_CA_CERTIFICATES, "AutomationCA.pem");
	    checkValue_inDropDownList(SLC_KEY_FILE, "Automationkey.pem");
	  
		clickButton(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON);
		updateMap(RETRIES);
		
		//Verify TLS Certificates List
		checkText("AutomationCA.pem");
		checkText("Automationcert.pem");
		checkText("Automationkey.pem");
		checkText("serverCA.pem");
		checkText("servercert.pem");
		checkText("serverkey.pem");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "AutomationCA.pem", TXT_LIST_CERTIFICATE_TYPE, "CA Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "Automationcert.pem", TXT_LIST_CERTIFICATE_TYPE, "X.509 Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "Automationkey.pem", TXT_LIST_CERTIFICATE_TYPE, "Key File");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "serverCA.pem", TXT_LIST_CERTIFICATE_TYPE, "CA Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "servercert.pem", TXT_LIST_CERTIFICATE_TYPE, "X.509 Certificate");
		checkElementText_inSpecificTableColumn(TBL_LIST_CERTIFICATES, "serverkey.pem", TXT_LIST_CERTIFICATE_TYPE, "Key File");
		
		clickButtonSave();
	    updateMap(RETRIES);
	    
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}