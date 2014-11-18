package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP27_Voip_EditGateway extends SuperHelper implements PropertiesVoip {

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
	public void voipModifyGateway() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Enable Gateways Configuration
        if(!getCheckboxStatus(CB_ENABLE_GATEWAYS))
        clickCheckbox_byID(CB_ENABLE_GATEWAYS);
        
        clickButton(BTN_CONFIGURE_GATEWAYS);
        updateMap(RETRIES);
        
        //Modify Gateway
    	clickCheckbox_byText("10.1.252.13");
		clickButtonEdit();
		updateMap(RETRIES);
        
        selectFromDropDown(SLC_SIGNALING_ADDRESS_TYPE, TXT_DNS_SRV);
        checkStatus(IPF_GATEWAY_PORT,"disabled","Input Field Gateway Port");
        type_byId(IPF_GATEWAY_IP_ADDRESS_FQDN, "www.testGW.com");
        selectFromDropDown(SLC_GATEWAY_INTERFACE, TXT_WAN);
        selectFromDropDown(SLC_GATEWAY_TRANSPORT, TXT_UDP);
        selectFromDropDown(SLC_GATEWAY_TYPE, TXT_3K_4K);
        type_byId(IPF_OUTPUT_DIGIT_STRIP, "5");
        type_byId(IPF_OUTPUT_DIGIT_ADD, "6");
        selectFromDropDown(SLC_PRIORITY, "0");
        checkStatus(IPF_GATEWAY_ROUTING_PREFIX_FQDN,"disabled","Input Field Gateway Routing Prefix/ FQDN");
        checkStatus(SLC_FUNCTIONAL_TYPE,"disabled","Drop-down list Gateway Functional type");
        clickButtonSave();
        updateMap(RETRIES);
        
        
        //Check Gateway Modification
        checkTextIsContained_byXPathTable(TBL_LIST_GATEWAYS, "www.testGW.com");
    	checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_SIGNALING_ADDRESS_TYPE, TXT_DNS_SRV);
     	checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_PORT, "0");	
 		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_INTERFACE, TXT_WAN);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_TRANSPORT, TXT_UDP);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_ROUTING_PREFIX_FQDN, "");
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_TYPE, TXT_3K_4K);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_FUNCTIONAL_TYPE, TXT_ALL_MODES_EGRESS_INGRESS);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_TRUNK_PROFILE, TXT_GATEWAY);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_OUTPUT_DIGIT_STRIP, "5");
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_OUTPUT_DIGIT_ADD, "6");
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_PRIORITY, "0");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	
	@Test (priority = 1)
	public void verifyVoipGatewayModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_GATEWAYS);
        updateMap(RETRIES);
		
		//Verify Gateway Modification
        checkTextIsContained_byXPathTable(TBL_LIST_GATEWAYS, "www.testGW.com");
    	checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_SIGNALING_ADDRESS_TYPE, TXT_DNS_SRV);
     	checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_PORT, "0");	
 		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_INTERFACE, TXT_WAN);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_TRANSPORT, TXT_UDP);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_ROUTING_PREFIX_FQDN, "");
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_GATEWAY_TYPE, TXT_3K_4K);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_FUNCTIONAL_TYPE, TXT_ALL_MODES_EGRESS_INGRESS);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_TRUNK_PROFILE, TXT_GATEWAY);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_OUTPUT_DIGIT_STRIP, "5");
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_OUTPUT_DIGIT_ADD, "6");
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, "www.testGW.com", TXT_PRIORITY, "0");
		
		//Edit Gateway and Verify fields
		clickCheckbox_byText("www.testGW.com");
		clickButtonEdit();
		updateMap(RETRIES);
		checkSelectedValue_inDropDownList(SLC_SIGNALING_ADDRESS_TYPE, TXT_DNS_SRV);
	    checkValue_byId(IPF_GATEWAY_IP_ADDRESS_FQDN, "www.testGW.com");
	    checkValue_byId(IPF_GATEWAY_PORT, "0");
	    checkSelectedValue_inDropDownList(SLC_GATEWAY_INTERFACE, TXT_WAN);
	    checkSelectedValue_inDropDownList(SLC_GATEWAY_TRANSPORT, TXT_UDP);
	    checkValue_byId(IPF_GATEWAY_ROUTING_PREFIX_FQDN, "");
	    checkSelectedValue_inDropDownList(SLC_GATEWAY_TYPE, TXT_3K_4K);
	    checkSelectedValue_inDropDownList(SLC_FUNCTIONAL_TYPE, TXT_ALL_MODES_EGRESS_INGRESS);
	    checkSelectedValue_inDropDownList(SLC_TRUNK_PROFILE, TXT_GATEWAY);
	    checkValue_byId(IPF_OUTPUT_DIGIT_STRIP, "5");
	    checkValue_byId(IPF_OUTPUT_DIGIT_ADD, "6");
	    checkSelectedValue_inDropDownList(SLC_PRIORITY, "0");
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}