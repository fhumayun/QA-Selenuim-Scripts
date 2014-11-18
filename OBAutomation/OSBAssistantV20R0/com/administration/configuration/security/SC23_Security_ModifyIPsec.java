package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC23_Security_ModifyIPsec extends SuperHelper implements PropertiesSecurity {

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
	public void securityModifyIPsec() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab IPsec
        clickButton(TB_IPsec);
          
        //Edit IPsec and modify all fields
    	clickCheckbox_byText("AutoIPsec");
    	clickButton(BTN_EDIT_IPsec);
    	updateMap(RETRIES);
 
        type_byId(IPF_IPsec_NAME,"AutoNewIPsec");
        type_byId(IPF_IPsec_PARTNER, "10.11.32.10");
        type_byId(IPF_IPsec_PARTNER_NETWORK, "10.11.32.0");
        type_byId(IPF_IPsec_PARTNER_NETMASK,"255.255.255.128");
        type_byId(IPF_IPsec_LOCAL_NETWORK, "10.11.52.0");
        type_byId(IPF_IPsec_LOCAL_NETMASK, "255.255.255.128");
        
        selectFromDropDown(SLC_IPsec_SIDE, TXT_IPsec_SIDE_RIGHT);
        selectFromDropDown(SLC_IPsec_AUTHENTICATION_TYPE, TXT_IPsec_AUTH_TYPE_X509);
       
        checkStatus(IPF_IPsec_SECRET_KEY_FILE,"disabled","Input Field OpenVPN Secret key file"); 
        checkStatus(SLC_IPsec_CERTIFICATION_FILE,"enabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_IPsec_CERTIFICATION_KEY,"enabled","Drop-Down List OpenVPN Certification key"); 
        
        selectFromDropDown(SLC_IPsec_CERTIFICATION_FILE, "Automationcert.pem");
        selectFromDropDown(SLC_IPsec_CERTIFICATION_KEY, "Automationkey.pem");
      
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check OpenVPN modification
    	checkText("AutoNewIPsec");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_PARTNER, "10.11.32.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_PARTNER_NETWORK, "10.11.32.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_PARTNER_NETMASK, "255.255.255.128");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_SIDE, TXT_IPsec_SIDE_RIGHT);
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_LOCAL_NETWORK, "10.11.52.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_LOCAL_NETMASK, "255.255.255.128");
       
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 1)
	public void verifySecurityIPsecModification() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab IPsec
        clickButton(TB_IPsec);
      
    	//Verify IPsec creation
    	checkText("AutoNewIPsec");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_PARTNER, "10.11.32.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_PARTNER_NETWORK, "10.11.32.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_PARTNER_NETMASK, "255.255.255.128");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_SIDE, TXT_IPsec_SIDE_RIGHT);
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_LOCAL_NETWORK, "10.11.52.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoNewIPsec", TXT_LIST_IPsec_LOCAL_NETMASK, "255.255.255.128");
       
        //Edit IPsec and verify fields
    	clickCheckbox_byText("AutoNewIPsec");
    	clickButton(BTN_EDIT_IPsec);
    	updateMap(RETRIES);
    	
    	checkValue_byId(IPF_IPsec_NAME,"AutoNewIPsec");
    	checkValue_byId(IPF_IPsec_PARTNER, "10.11.32.10");
    	checkValue_byId(IPF_IPsec_PARTNER_NETWORK, "10.11.32.0");
    	checkValue_byId(IPF_IPsec_PARTNER_NETMASK,"255.255.255.128");
    	checkValue_byId(IPF_IPsec_LOCAL_NETWORK, "10.11.52.0");
    	checkValue_byId(IPF_IPsec_LOCAL_NETMASK, "255.255.255.128");
           
    	checkSelectedValue_inDropDownList(SLC_IPsec_SIDE, TXT_IPsec_SIDE_RIGHT);
    	checkSelectedValue_inDropDownList(SLC_IPsec_AUTHENTICATION_TYPE, TXT_IPsec_AUTH_TYPE_X509);
    	checkSelectedValue_inDropDownList(SLC_IPsec_CERTIFICATION_FILE, "Automationcert.pem");
        checkSelectedValue_inDropDownList(SLC_IPsec_CERTIFICATION_KEY, "Automationkey.pem");
  
        checkStatus(SLC_IPsec_CERTIFICATION_FILE,"enabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_IPsec_CERTIFICATION_KEY,"enabled","Drop-Down List OpenVPN Certification key"); 
 
        clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("AutoNewIPsec");
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

}