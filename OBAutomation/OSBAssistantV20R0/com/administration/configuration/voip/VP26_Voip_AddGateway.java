package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP26_Voip_AddGateway extends SuperHelper implements PropertiesVoip {

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

	
	@DataProvider(name = "GatewayData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {TXT_IP_ADDRESS_OR_FQDN,"10.1.252.13","5060",TXT_LAN,TXT_TCP,"10",TXT_RG,TXT_ALL_MODES_EGRESS_INGRESS,TXT_GATEWAY,"","","1"},
				 {TXT_DNS_SRV,"www.autoGW1.com","",TXT_WAN,TXT_UDP,"20",TXT_3K_4K,TXT_ALL_MODES_INGRESS,TXT_GATEWAY,"1","2","2"},
				 {TXT_IP_ADDRESS_OR_FQDN,"172.25.2.93","5080",TXT_LAN,TXT_TLS,"100",TXT_MEDIATRIX,TXT_NORMAL_MODE_EGRESS_INGRESS,TXT_GATEWAY,"10","10","3"},
				 {TXT_DNS_SRV,"www.autoGW2.com","",TXT_LAN,TXT_TCP,"200",TXT_PEER_OSB,TXT_SURVIVABILITY_MODE_EGRESS_INGRESS,TXT_GATEWAY,"","20","4"},
				 {TXT_IP_ADDRESS_OR_FQDN,"10.1.252.14","0",TXT_WAN,TXT_UDP,"1000",TXT_SIP_TRUNK,TXT_ALL_MODES_EGRESS_INGRESS,"AutoProvider1","0","","5"},
				 {TXT_IP_ADDRESS_OR_FQDN,"10.1.252.15","5096",TXT_WAN,TXT_UDP,"2000",TXT_RG,TXT_ALL_MODES_EGRESS_INGRESS,TXT_GATEWAY,"15","","6"},
				 {TXT_IP_ADDRESS_OR_FQDN,"192.168.108.4","5086",TXT_LAN,TXT_UDP,"0",TXT_BACKUP_LINK_SERVER,TXT_ALL_MODES_INGRESS,TXT_GATEWAY,"24","200",""},
				 {TXT_DNS_SRV,"www.autoGW3.com","",TXT_WAN,TXT_UDP,"5",TXT_OTHERS,TXT_NORMAL_MODE_EGRESS_INGRESS,TXT_GATEWAY,"15","15","8"},
				 {TXT_IP_ADDRESS_OR_FQDN,"10.1.252.16","65535",TXT_LAN,TXT_TCP,"23",TXT_VOICE_MAIL,TXT_SURVIVABILITY_MODE_EGRESS_INGRESS,TXT_GATEWAY,"","","9"},
		};	
	}
	
	@Test (priority = 0,dataProvider = "GatewayData")
	public void voipAddGateway(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12) throws InterruptedException {
		
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
        
        //Create Gateway (input From Data Provider)
        clickButtonAdd();
        updateMap(RETRIES);
        
        selectFromDropDown(SLC_SIGNALING_ADDRESS_TYPE, x1);
        type_byId(IPF_GATEWAY_IP_ADDRESS_FQDN, x2);
        if(x1.equals(TXT_IP_ADDRESS_OR_FQDN))
        type_byId(IPF_GATEWAY_PORT, x3);
        selectFromDropDown(SLC_GATEWAY_INTERFACE, x4);
        selectFromDropDown(SLC_GATEWAY_TRANSPORT, x5);
        type_byId(IPF_GATEWAY_ROUTING_PREFIX_FQDN, x6);
        selectFromDropDown(SLC_GATEWAY_TYPE, x7);
        selectFromDropDown(SLC_FUNCTIONAL_TYPE, x8);
        selectFromDropDown(SLC_TRUNK_PROFILE, x9);
        type_byId(IPF_OUTPUT_DIGIT_STRIP, x10);
        type_byId(IPF_OUTPUT_DIGIT_ADD, x11);
        selectFromDropDown(SLC_PRIORITY, x12);
        
        clickButtonSave();
        updateMap(RETRIES);
        
        
        
        //Check Gateway Creation
        checkTextIsContained_byXPathTable(TBL_LIST_GATEWAYS, x2);
    	checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_SIGNALING_ADDRESS_TYPE, x1);
    	if(x1.equals(TXT_DNS_SRV))
 		   checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_PORT, "0");
     	else
     	   checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_PORT, x3);	
 		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_INTERFACE, x4);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_TRANSPORT, x5);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_ROUTING_PREFIX_FQDN, x6);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_TYPE, x7);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_FUNCTIONAL_TYPE, x8);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_TRUNK_PROFILE, x9);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_OUTPUT_DIGIT_STRIP, x10);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_OUTPUT_DIGIT_ADD, x11);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_PRIORITY, x12);
		
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
	
	
	@Test (priority = 2,dataProvider = "GatewayData")
	public void verifyVoipGatewayCreation(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12) throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_GATEWAYS);
        updateMap(RETRIES);
		
		//Verify Gateway Creation
        checkTextIsContained_byXPathTable(TBL_LIST_GATEWAYS, x2);
    	checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_SIGNALING_ADDRESS_TYPE, x1);
    	if(x1.equals(TXT_DNS_SRV))
 		   checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_PORT, "0");
     	else
     	   checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_PORT, x3);	
 		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_INTERFACE, x4);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_TRANSPORT, x5);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_ROUTING_PREFIX_FQDN, x6);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_GATEWAY_TYPE, x7);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_FUNCTIONAL_TYPE, x8);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_TRUNK_PROFILE, x9);
		if(x10.equals(""))
			checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_OUTPUT_DIGIT_STRIP, "0");	
		else
		    checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_OUTPUT_DIGIT_STRIP, x10);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_OUTPUT_DIGIT_ADD, x11);
		checkElementText_inSpecificColumn(TBL_LIST_GATEWAYS, x2, TXT_PRIORITY, x12);
		
		//Edit Gateway and Verify fields
		clickCheckbox_byText(x2);
		clickButtonEdit();
		updateMap(RETRIES);
		checkSelectedValue_inDropDownList(SLC_SIGNALING_ADDRESS_TYPE, x1);
	    checkValue_byId(IPF_GATEWAY_IP_ADDRESS_FQDN, x2);
	    if(x1.equals(TXT_DNS_SRV))
	       checkValue_byId(IPF_GATEWAY_PORT, "0");
	    else
	       checkValue_byId(IPF_GATEWAY_PORT, x3);
	    checkSelectedValue_inDropDownList(SLC_GATEWAY_INTERFACE, x4);
	    checkSelectedValue_inDropDownList(SLC_GATEWAY_TRANSPORT, x5);
	    checkValue_byId(IPF_GATEWAY_ROUTING_PREFIX_FQDN, x6);
	    checkSelectedValue_inDropDownList(SLC_GATEWAY_TYPE, x7);
	    checkSelectedValue_inDropDownList(SLC_FUNCTIONAL_TYPE, x8);
	    checkSelectedValue_inDropDownList(SLC_TRUNK_PROFILE, x9);
	    if(x10.equals(""))
	       checkValue_byId(IPF_OUTPUT_DIGIT_STRIP, "0");
	    else
	       checkValue_byId(IPF_OUTPUT_DIGIT_STRIP, x10);
	    checkValue_byId(IPF_OUTPUT_DIGIT_ADD, x11);
	    checkSelectedValue_inDropDownList(SLC_PRIORITY, x12);
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}