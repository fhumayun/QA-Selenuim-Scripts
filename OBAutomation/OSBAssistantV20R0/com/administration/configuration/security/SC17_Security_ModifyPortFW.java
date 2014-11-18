package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC17_Security_ModifyPortFW extends SuperHelper implements PropertiesSecurity {

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
	public void securityModifyPortFW() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
        
       
        //Modify Port FW  fields
    	clickCheckbox_byText("10.1.72.10");
    	clickButton(BTN_EDIT_PORT_FW);
    	updateMap(RETRIES);
    	type_byId(IPF_PORT_FW_ADD_IP_ADDRESS,"10.11.72.100");
    	type_byId(IPF_PORT_FW_ADD_IN_PORT, "7200");
    	type_byId(IPF_PORT_FW_ADD_OUT_PORT, "7300");
        selectFromDropDown(SLC_PORT_FW_PROTOCOL, TXT_PORT_FW_UDP);
    	clickButtonSave();
    	updateMap(RETRIES);
    
    	
    	//check Port FW modification
    	checkText("10.11.72.100");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.11.72.100", TXT_LIST_PORT_FW_IN, "7200");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.11.72.100", TXT_LIST_PORT_FW_OUT, "7300");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.11.72.100", TXT_LIST_PORT_FW_PROTOCOL, TXT_PORT_FW_UDP);
        
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();  
	}
	

	@Test (priority = 1)
	public void verifySecurityPortFWModification() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
         
        //Verify Port FW modification
        checkText("10.11.72.100");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.11.72.100", TXT_LIST_PORT_FW_IN, "7200");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.11.72.100", TXT_LIST_PORT_FW_OUT, "7300");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.11.72.100", TXT_LIST_PORT_FW_PROTOCOL, TXT_PORT_FW_UDP);
    	   
        //Edit Port FW and verify fields
    	clickCheckbox_byText("10.11.72.100");
    	clickButton(BTN_EDIT_PORT_FW);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_PORT_FW_ADD_IP_ADDRESS,"10.11.72.100");
    	checkValue_byId(IPF_PORT_FW_ADD_IN_PORT, "7200");
    	checkValue_byId(IPF_PORT_FW_ADD_OUT_PORT, "7300");
        checkSelectedValue_inDropDownList(SLC_PORT_FW_PROTOCOL, TXT_PORT_FW_UDP);
    	clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("10.11.72.100");
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

}