package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP05_Voip_AddSIPRouting extends SuperHelper implements PropertiesVoip {

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

	
	@DataProvider(name = "SIPRoutingData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"10.20.30.40","300","11.21.31.41","0",TXT_TCP,"tag1",TXT_GATEWAY},
				 {"50.60.70.80","400","51.61.71.81","1000",TXT_UDP,"tag2",TXT_OTHER_SIP_EP},
				 {"90.100.110.120","699","91.101.111.121","65535",TXT_TLS,"tag3",TXT_VOICE_MAIL},
		};	
	}
	
	@Test (priority = 0,dataProvider = "SIPRoutingData")
	public void voipAddSIPRouting(String x1,String x2,String x3,String x4,String x5,String x6,String x7) throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
        
        //Create SIP Routing (input From Data Provider)
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_SOURCE_IP, x1);
        type_byId(IPF_CONDITION_ERROR_CODES, x2);
        type_byId(IPF_DESTINATION_IP_FQDN, x3);
        type_byId(IPF_DESTINATION_PORT, x4);
        selectFromDropDown(SLC_DESTINATION_TRANSPORT, x5);
        type_byId(IPF_DESTINATION_TAG, x6);
        selectFromDropDown(SLC_DESTINATION_TYPE, x7);
       
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check SIP Routing Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_ROUTING, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_CONDITION_ERROR_CODES, x2);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_IP_FQDN, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_PORT, x4);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_TRANSPORT, x5);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_TAG, x6);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_TYPE, x7);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 1)
	public void applyChanges() throws InterruptedException {
		methodLogger.log();
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 2,dataProvider = "SIPRoutingData")
	public void verifyVoipSIPRoutingCreation(String x1,String x2,String x3,String x4,String x5,String x6,String x7) throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
		
		//Verify SIP Routing Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_ROUTING, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_CONDITION_ERROR_CODES, x2);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_IP_FQDN, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_PORT, x4);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_TRANSPORT, x5);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_TAG, x6);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_ROUTING, x1, TXT_DESTINATION_TYPE, x7);
		
		//Edit SIP Routing and Verify fields
		clickCheckbox_byText(x1);
		clickButtonEdit();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_SOURCE_IP, x1);
		checkValue_byId(IPF_CONDITION_ERROR_CODES, x2);
		checkValue_byId(IPF_DESTINATION_IP_FQDN, x3);
		checkValue_byId(IPF_DESTINATION_PORT, x4);
	    checkSelectedValue_inDropDownList(SLC_DESTINATION_TRANSPORT, x5);
	    checkValue_byId(IPF_DESTINATION_TAG, x6);
	    checkSelectedValue_inDropDownList(SLC_DESTINATION_TYPE, x7);
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}