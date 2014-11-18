package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP06_Voip_EditSIPRouting extends SuperHelper implements PropertiesVoip {

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
	public void voipModifySIPRouting() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
        
       //Edit SIP Routing and Modify fields
		clickCheckbox_byText("50.60.70.80");
		clickButtonEdit();
		updateMap(RETRIES);
        
        type_byId(IPF_SOURCE_IP, "55.65.75.85");
        type_byId(IPF_CONDITION_ERROR_CODES, "500");
        type_byId(IPF_DESTINATION_IP_FQDN, "56.66.76.86");
        type_byId(IPF_DESTINATION_PORT, "2000");
        selectFromDropDown(SLC_DESTINATION_TRANSPORT, TXT_TCP);
        type_byId(IPF_DESTINATION_TAG, "newtag");
        selectFromDropDown(SLC_DESTINATION_TYPE, TXT_VOICE_MAIL);
       
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check SIP Routing Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_ROUTING, "55.65.75.85");
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_CONDITION_ERROR_CODES, "500");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_IP_FQDN, "56.66.76.86");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_PORT, "2000");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_TRANSPORT, TXT_TCP);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_TAG, "newtag");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_TYPE, TXT_VOICE_MAIL);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	
	@Test (priority = 1)
	public void verifyVoipSIPRoutingModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
		
		//Verify SIP Routing Modification
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_ROUTING, "55.65.75.85");
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_CONDITION_ERROR_CODES, "500");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_IP_FQDN, "56.66.76.86");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_PORT, "2000");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_TRANSPORT, TXT_TCP);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_TAG, "newtag");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, "55.65.75.85", TXT_DESTINATION_TYPE, TXT_VOICE_MAIL);
		
		//Edit SIP Routing and Verify fields
		clickCheckbox_byText("55.65.75.85");
		clickButtonEdit();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_SOURCE_IP, "55.65.75.85");
		checkValue_byId(IPF_CONDITION_ERROR_CODES, "500");
		checkValue_byId(IPF_DESTINATION_IP_FQDN, "56.66.76.86");
		checkValue_byId(IPF_DESTINATION_PORT, "2000");
	    checkSelectedValue_inDropDownList(SLC_DESTINATION_TRANSPORT, TXT_TCP);
	    checkValue_byId(IPF_DESTINATION_TAG, "newtag");
	    checkSelectedValue_inDropDownList(SLC_DESTINATION_TYPE, TXT_VOICE_MAIL);
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}