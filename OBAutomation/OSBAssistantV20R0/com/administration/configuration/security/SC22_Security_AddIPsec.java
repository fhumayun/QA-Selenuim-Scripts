package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC22_Security_AddIPsec extends SuperHelper implements PropertiesSecurity {

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
	public void securityAddIPsec() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab IPsec
        clickButton(TB_IPsec);
          
        //Add IPsec 
        clickButtonAdd();
        updateMap(RETRIES);
 
        type_byId(IPF_IPsec_NAME,"AutoIPsec");
        type_byId(IPF_IPsec_PARTNER, "10.11.22.10");
        type_byId(IPF_IPsec_PARTNER_NETWORK, "10.11.22.0");
        type_byId(IPF_IPsec_PARTNER_NETMASK,"255.255.255.0");
        type_byId(IPF_IPsec_LOCAL_NETWORK, "10.11.42.0");
        type_byId(IPF_IPsec_LOCAL_NETMASK, "255.255.255.0");
        type_byId(IPF_IPsec_SECRET_KEY_FILE, "AutoSecret");
        
        selectFromDropDown(SLC_IPsec_SIDE, TXT_IPsec_SIDE_LEFT);
        selectFromDropDown(SLC_IPsec_AUTHENTICATION_TYPE, TXT_IPsec_AUTH_TYPE_SECRET);
       
        checkStatus(SLC_IPsec_CERTIFICATION_FILE,"disabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_IPsec_CERTIFICATION_KEY,"disabled","Drop-Down List OpenVPN Certification key"); 
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check OpenVPN creation
    	checkText("AutoIPsec");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_PARTNER, "10.11.22.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_PARTNER_NETWORK, "10.11.22.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_PARTNER_NETMASK, "255.255.255.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_SIDE, TXT_IPsec_SIDE_LEFT);
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_LOCAL_NETWORK, "10.11.42.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_LOCAL_NETMASK, "255.255.255.0");
       
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 1)
	public void verifySecurityIPsecCreation() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab IPsec
        clickButton(TB_IPsec);
      
    	//Verify IPsec creation
    	checkText("AutoIPsec");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_PARTNER, "10.11.22.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_PARTNER_NETWORK, "10.11.22.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_PARTNER_NETMASK, "255.255.255.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_SIDE, TXT_IPsec_SIDE_LEFT);
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_LOCAL_NETWORK, "10.11.42.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_IPsec, "AutoIPsec", TXT_LIST_IPsec_LOCAL_NETMASK, "255.255.255.0");
       
        //Edit IPsec and verify fields
    	clickCheckbox_byText("AutoIPsec");
    	clickButton(BTN_EDIT_IPsec);
    	updateMap(RETRIES);
    	
    	checkValue_byId(IPF_IPsec_NAME,"AutoIPsec");
    	checkValue_byId(IPF_IPsec_PARTNER, "10.11.22.10");
    	checkValue_byId(IPF_IPsec_PARTNER_NETWORK, "10.11.22.0");
    	checkValue_byId(IPF_IPsec_PARTNER_NETMASK,"255.255.255.0");
    	checkValue_byId(IPF_IPsec_LOCAL_NETWORK, "10.11.42.0");
    	checkValue_byId(IPF_IPsec_LOCAL_NETMASK, "255.255.255.0");
    	checkValue_byId(IPF_IPsec_SECRET_KEY_FILE, "AutoSecret");
        
    	checkSelectedValue_inDropDownList(SLC_IPsec_SIDE, TXT_IPsec_SIDE_LEFT);
    	checkSelectedValue_inDropDownList(SLC_IPsec_AUTHENTICATION_TYPE, TXT_IPsec_AUTH_TYPE_SECRET);
        
        checkStatus(SLC_IPsec_CERTIFICATION_FILE,"disabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_IPsec_CERTIFICATION_KEY,"disabled","Drop-Down List OpenVPN Certification key"); 
       
        clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("AutoIPsec");
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

}