package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC19_Security_AddOpenVPN extends SuperHelper implements PropertiesSecurity {

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
	public void securityAddOpenVPN() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab OpenVPN
        clickButton(TB_OpenVPN);
          
        //Add OpenVPN 
        clickButtonAdd();
        updateMap(RETRIES);
 
        type_byId(IPF_OpenVPN_NAME,"AutoOpenVPN");
        type_byId(IPF_OpenVPN_ROUTING, "10.11.22.20");
        type_byId(IPF_OpenVPN_PARTNER, "10.11.22.10");
        type_byId(IPF_OpenVPN_ROUTING_MASK,"255.255.255.0");
        type_byId(IPF_OpenVPN_LOCAL_IP, "10.11.22.50");
        type_byId(IPF_OpenVPN_REMOTE_IP, "10.11.22.60");
        type_byId(IPF_OpenVPN_PORT, "7000");
        
        selectFromDropDown(SLC_OpenVPN_AUTHENTICATION_TYPE, TXT_OpenVPN_AUTH_TYPE_SECRET);
        selectFromDropDown(SLC_OpenVPN_SECRET_KEY_FILE, "Automation.key");
       
        checkStatus(SLC_OpenVPN_CA_FILE,"disabled","Drop-Down List OpenVPN CA file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_FILE,"disabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_KEY,"disabled","Drop-Down List OpenVPN Certification key"); 
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check OpenVPN creation
    	checkText("AutoOpenVPN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", "Partner", "10.11.22.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_ROUTING, "10.11.22.20");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_ROUTING_MASK, "255.255.255.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_LOCAL_IP, "10.11.22.50");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_REMOTE_IP, "10.11.22.60");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_PORT, "7000");
       
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 1)
	public void verifySecurityOpenVPNCreation() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab OpenVPN
        clickButton(TB_OpenVPN);
      
    	//Verify OpenVPN creation
    	checkText("AutoOpenVPN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", "Partner", "10.11.22.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_ROUTING, "10.11.22.20");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_ROUTING_MASK, "255.255.255.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_LOCAL_IP, "10.11.22.50");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_REMOTE_IP, "10.11.22.60");
    	checkElementText_inSpecificTableColumn(TBL_LIST_OpenVPN, "AutoOpenVPN", TXT_LIST_OpenVPN_PORT, "7000");
         
        //Edit OpenVPN and verify fields
    	clickCheckbox_byText("AutoOpenVPN");
    	clickButton(BTN_EDIT_OpenVPN);
    	updateMap(RETRIES);
    	
    	checkValue_byId(IPF_OpenVPN_NAME,"AutoOpenVPN");
    	checkValue_byId(IPF_OpenVPN_ROUTING, "10.11.22.20");
    	checkValue_byId(IPF_OpenVPN_PARTNER, "10.11.22.10");
    	checkValue_byId(IPF_OpenVPN_ROUTING_MASK,"255.255.255.0");
    	checkValue_byId(IPF_OpenVPN_LOCAL_IP, "10.11.22.50");
    	checkValue_byId(IPF_OpenVPN_REMOTE_IP, "10.11.22.60");
    	checkValue_byId(IPF_OpenVPN_PORT, "7000");
        
        checkSelectedValue_inDropDownList(SLC_OpenVPN_AUTHENTICATION_TYPE, TXT_OpenVPN_AUTH_TYPE_SECRET);
        checkSelectedValue_inDropDownList(SLC_OpenVPN_SECRET_KEY_FILE, "Automation.key");
       
        checkStatus(SLC_OpenVPN_CA_FILE,"disabled","Drop-Down List OpenVPN CA file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_FILE,"disabled","Drop-Down List OpenVPN Certification file"); 
        checkStatus(SLC_OpenVPN_CERTIFICATION_KEY,"disabled","Drop-Down List OpenVPN Certification key"); 
      
        
        clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("AutoOpenVPN");
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

}