package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC20_Security_ModifyOpenVPN extends SuperHelper implements PropertiesSecurity {

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
	public void securityModifyOpenVPNAllFields() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab OpenVPN
        clickButton(TB_OpenVPN);
          
        //Modify OpenVPN 
        clickCheckbox_byText("AutoOpenVPN");
    	clickButton(BTN_EDIT_OpenVPN);
    	updateMap(RETRIES);
 
        type_byId(IPF_OpenVPN_NAME,"AutoNewOpenVPN");
        type_byId(IPF_OpenVPN_ROUTING, "10.11.22.40");
        type_byId(IPF_OpenVPN_PARTNER, "10.11.22.30");
        type_byId(IPF_OpenVPN_ROUTING_MASK,"255.255.255.128");
        type_byId(IPF_OpenVPN_LOCAL_IP, "10.11.22.70");
        type_byId(IPF_OpenVPN_REMOTE_IP, "10.11.22.80");
        type_byId(IPF_OpenVPN_PORT, "8000");
        
        //Select Authentication type X.509 client
        selectFromDropDown(SLC_OpenVPN_AUTHENTICATION_TYPE, TXT_OpenVPN_AUTH_TYPE_X509_CLIENT);
       
        //Check that the Drop-Down List OpenVPN Secret key file becomes disabled
        //and the other 3 Drop-Down Lists become enabled
        checkStatus(SLC_OpenVPN_SECRET_KEY_FILE,"disabled","Drop-Down List OpenVPN Secret key file"); 
        checkStatus(SLC_OpenVPN_CA_FILE,"enabled","Drop-Down List OpenVPN CA file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_FILE,"enabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_KEY,"enabled","Drop-Down List OpenVPN Certification key"); 
        
        selectFromDropDown(SLC_OpenVPN_CA_FILE, "AutomationCA.pem");
        selectFromDropDown(SLC_OpenVPN_CERTIFICATION_FILE, "Automationcert.pem");
        selectFromDropDown(SLC_OpenVPN_CERTIFICATION_KEY, "Automationkey.pem");
        
        //Enable LZO Compression
        clickCheckbox_byID(CB_OpenVPN_LZO_COMPRESSION);
      
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check OpenVPN modification
    	checkText("AutoNewOpenVPN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", "Partner", "10.11.22.30");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_ROUTING, "10.11.22.40");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_ROUTING_MASK, "255.255.255.128");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_LOCAL_IP, "10.11.22.70");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_REMOTE_IP, "10.11.22.80");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_PORT, "8000");
       
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 1)
	public void verifySecurityOpenVPNAllFieldsModification() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab OpenVPN
        clickButton(TB_OpenVPN);
      
    	//Verify OpenVPN modification
    	checkText("AutoNewOpenVPN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", "Partner", "10.11.22.30");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_ROUTING, "10.11.22.40");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_ROUTING_MASK, "255.255.255.128");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_LOCAL_IP, "10.11.22.70");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_REMOTE_IP, "10.11.22.80");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoNewOpenVPN", TXT_LIST_OpenVPN_PORT, "8000");
        
        //Edit OpenVPN and verify fields
    	clickCheckbox_byText("AutoNewOpenVPN");
    	clickButton(BTN_EDIT_OpenVPN);
    	updateMap(RETRIES);
    	
    	checkValue_byId(IPF_OpenVPN_NAME,"AutoNewOpenVPN");
    	checkValue_byId(IPF_OpenVPN_ROUTING, "10.11.22.40");
    	checkValue_byId(IPF_OpenVPN_PARTNER, "10.11.22.30");
    	checkValue_byId(IPF_OpenVPN_ROUTING_MASK,"255.255.255.128");
    	checkValue_byId(IPF_OpenVPN_LOCAL_IP, "10.11.22.70");
    	checkValue_byId(IPF_OpenVPN_REMOTE_IP, "10.11.22.80");
    	checkValue_byId(IPF_OpenVPN_PORT, "8000");
          
    	checkSelectedValue_inDropDownList(SLC_OpenVPN_AUTHENTICATION_TYPE, TXT_OpenVPN_AUTH_TYPE_X509_CLIENT);
        checkSelectedValue_inDropDownList(SLC_OpenVPN_CA_FILE, "AutomationCA.pem");
        checkSelectedValue_inDropDownList(SLC_OpenVPN_CERTIFICATION_FILE, "Automationcert.pem");
        checkSelectedValue_inDropDownList(SLC_OpenVPN_CERTIFICATION_KEY, "Automationkey.pem");
       
        checkStatus(SLC_OpenVPN_SECRET_KEY_FILE,"disabled","Drop-Down List OpenVPN Secret key file"); 
        checkStatus(SLC_OpenVPN_CA_FILE,"enabled","Drop-Down List OpenVPN CA file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_FILE,"enabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_KEY,"enabled","Drop-Down List OpenVPN Certification key"); 
       
        checkStatus(CB_OpenVPN_LZO_COMPRESSION,"checked","CheckBox Enable LZO Compression"); 
        
        clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("AutoNewOpenVPN");
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

	@Test (priority = 2)
	public void securityModifyOpenVPNAuthType() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab OpenVPN
        clickButton(TB_OpenVPN);
          
        //Edit OpenVPN 
        clickCheckbox_byText("AutoNewOpenVPN");
    	clickButton(BTN_EDIT_OpenVPN);
    	updateMap(RETRIES);
      
        //Change Authentication type X.509 server
        selectFromDropDown(SLC_OpenVPN_AUTHENTICATION_TYPE, TXT_OpenVPN_AUTH_TYPE_X509_SERVER);
         
        selectFromDropDown(SLC_OpenVPN_CA_FILE, "serverCA.pem");
        selectFromDropDown(SLC_OpenVPN_CERTIFICATION_FILE, "servercert.pem");
        selectFromDropDown(SLC_OpenVPN_CERTIFICATION_KEY, "serverkey.pem");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 3)
	public void verifySecurityOpenVPNAuthTypeModification() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab OpenVPN
        clickButton(TB_OpenVPN);
        
        //Edit OpenVPN and verify Authentication Type
    	clickCheckbox_byText("AutoNewOpenVPN");
    	clickButton(BTN_EDIT_OpenVPN);
    	updateMap(RETRIES);
    	    
    	checkSelectedValue_inDropDownList(SLC_OpenVPN_AUTHENTICATION_TYPE, TXT_OpenVPN_AUTH_TYPE_X509_SERVER);
        checkSelectedValue_inDropDownList(SLC_OpenVPN_CA_FILE, "serverCA.pem");
        checkSelectedValue_inDropDownList(SLC_OpenVPN_CERTIFICATION_FILE, "servercert.pem");
        checkSelectedValue_inDropDownList(SLC_OpenVPN_CERTIFICATION_KEY, "serverkey.pem");
          
        clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("AutoNewOpenVPN");
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}
	
}