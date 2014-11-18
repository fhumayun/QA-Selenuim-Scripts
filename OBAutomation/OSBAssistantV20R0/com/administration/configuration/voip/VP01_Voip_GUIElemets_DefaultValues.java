package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP01_Voip_GUIElemets_DefaultValues extends SuperHelper implements PropertiesVoip {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	
	@Test (priority = 0)
	public void voip_CheckDefaultValues() throws InterruptedException {
		
		classMethodLogger.log(); 
		String[] modeOptions = {TXT_BRANCH_SBC,TXT_SBC_PROXY,TXT_PROXY,TXT_PROXY_ACD};
		String[] backupLinkModeOptions = {TXT_NONE,TXT_CLIENT,TXT_SERVER};
		String[] supervisionTimerOptions = {"500","1000","2000","4000","8000","16000","32000"};
		String[] targetTypeOptions = {TXT_SRV_RECORD,TXT_BINDING};
		String[] commSystemTypeOptions = {TXT_SIMPLEX,TXT_COLLOCATED,TXT_GEO_SEPERATED};
		String[] transportProtocolOptions = {TXT_TCP,TXT_UDP,TXT_TLS};
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
    	checkStatus(SLC_MODE,"enabled","Drop-Down List Mode");
    	checkSelectedValue_inDropDownList(SLC_MODE, TXT_SBC_PROXY);
    	getPossibleValuesOfDropDown(SLC_MODE, modeOptions);
    	
    	checkStatus(BTN_MANIPULATION,"enabled","Button SIP Manipulation");
    	
    	checkStatus(BTN_ROUTING,"enabled","Button SIP Routing");
    	
    	checkStatus(BTN_ERROR_CODES,"enabled","Button SIP Error Codes");
    	
    	checkStatus(BTN_CALL_FORWARD,"enabled","Button SIP Call Forward");
    	
    	checkStatus(IPF_LISTENING_PORT_TCP, "enabled", "Input Field Listening Port TCP");
		checkValue_byId(IPF_LISTENING_PORT_TCP, "5060");
		
		checkStatus(IPF_LISTENING_PORT_UDP, "enabled", "Input Field Listening Port UDP");
		checkValue_byId(IPF_LISTENING_PORT_UDP, "5060");
		
		checkStatus(IPF_LISTENING_PORT_TLS, "enabled", "Input Field Listening Port TLS");
		checkValue_byId(IPF_LISTENING_PORT_TLS, "5061");
		
		checkStatus(IPF_OPTIONS_SOURCE_PORT, "enabled", "Input Field Options Source Port");
		checkValue_byId(IPF_OPTIONS_SOURCE_PORT, "5060");
		
		
		checkStatus(IPF_RTP_PORTS_MIN, "enabled", "Input Field RTP Ports Min Value");
		checkValue_byId(IPF_RTP_PORTS_MIN, "35000");
		
		checkStatus(IPF_RTP_PORTS_MAX, "enabled", "Input Field RTP Ports Max Value");
		checkValue_byId(IPF_RTP_PORTS_MAX, "65000");
		
		checkStatus(IPF_TIME_TO_LIVE, "enabled", "Input Field Time To Live");
		checkValue_byId(IPF_TIME_TO_LIVE, "180");
		
		checkStatus(IPF_SIP_PORTS_MIN, "enabled", "Input Field SIP Ports Min Value");
		checkValue_byId(IPF_SIP_PORTS_MIN, "10000");
		
		checkStatus(IPF_SIP_PORTS_MAX, "enabled", "Input Field SIP Ports Max Value");
		checkValue_byId(IPF_SIP_PORTS_MAX, "15000");
		
		checkStatus(BTN_SHOW_PORT_MAPPING,"enabled","Button Show Port Mapping");
    	
		checkStatus(BTN_CLEAR_PORT_MAPPING,"enabled","Button Clear Port Mapping");
    	
    	checkStatus(SLC_BACKUP_LINK_MODE,"enabled","Drop-Down List Backup Link Mode");
    	checkSelectedValue_inDropDownList(SLC_BACKUP_LINK_MODE, TXT_NONE);
    	getPossibleValuesOfDropDown(SLC_BACKUP_LINK_MODE, backupLinkModeOptions);
    
    	checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"disabled","Button Configure Backup Link Mode");
    	
    	checkStatus(CB_ENABLE_GATEWAYS,"enabled","Checkbox Enable Gateways");
    	checkStatus(CB_ENABLE_GATEWAYS,"unchecked","Checkbox Enable Gateways");
    	
    	checkStatus(BTN_CONFIGURE_GATEWAYS,"disabled","Button Configure Gateways");
    	checkStatus(BTN_SIP_SERVICE_PROVIDER_PROFILES,"enabled","Button SIP Service Provider Profiles");
    	
    	checkStatus(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "enabled", "Input Field DNS Dynamic Refresh Interval");
		checkValue_byId(IPF_DNS_DYNAMIC_REFRESH_INTERVAL, "10");
		
		checkStatus(CB_ROUTING_SUPERVISION_TIMER,"enabled","Checkbox Extend alternate routing supervision timer");
    	checkStatus(CB_ROUTING_SUPERVISION_TIMER,"unchecked","Checkbox Extend alternate routing supervision timer");
    	
    	checkStatus(SLC_ROUTING_SUPERVISION_TIMER,"enabled","Drop-Down List Backup Link Mode");
    	checkSelectedValue_inDropDownList(SLC_ROUTING_SUPERVISION_TIMER, "32000");
    	getPossibleValuesOfDropDown(SLC_ROUTING_SUPERVISION_TIMER, supervisionTimerOptions);
    
    	checkStatus(CB_ENABLE_QOS,"enabled","Checkbox Enable QoS");
    	checkStatus(CB_ENABLE_QOS,"unchecked","Checkbox Enable QoS");
    	
    	checkStatus(BTN_CONFIGURE_QOS,"disabled","Button Configure QoS");
    	
    	//Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
    	checkStatus(SLC_COMM_SYSTEM_TYPE,"enabled","Drop-Down List Comm System Type");
    	checkSelectedValue_inDropDownList(SLC_COMM_SYSTEM_TYPE, TXT_SIMPLEX);
    	getPossibleValuesOfDropDown(SLC_COMM_SYSTEM_TYPE, commSystemTypeOptions);
    
    	checkStatus(BTN_CONFIGURE_TRUSTED_ADDRESS,"enabled","Button Configure Trusted Address");
    	
    	checkStatus(CB_ENABLE_OUTBOUND_PROXY,"disabled","Checkbox Enable outbound proxy");
    	checkStatus(CB_ENABLE_OUTBOUND_PROXY,"unchecked","Checkbox Enable outbound proxy");
    
    	checkStatus(IPF_OUTBOUND_PROXY, "disabled", "Input Field Outbound proxy");
		checkValue_byId(IPF_OUTBOUND_PROXY, "");
		
		checkStatus(IPF_OUTBOUND_PROXY_PORT, "disabled", "Input Field Outbound proxy port");
		checkValue_byId(IPF_OUTBOUND_PROXY_PORT, "5060");
		
		checkStatus(CB_ENABLE_PATH_TAGGING,"enabled","Checkbox Enable path tagging");
    	checkStatus(CB_ENABLE_PATH_TAGGING,"unchecked","Checkbox Enable path tagging");
    
    	checkStatus(CB_BRANCH_BEHIND_SBC,"enabled","Checkbox Branch behind SBC");
    	checkStatus(CB_BRANCH_BEHIND_SBC,"unchecked","Checkbox Branch behind SBC");
    
    	checkStatus(SLC_NODE1_TARGET_TYPE,"enabled","Drop-Down List Node1 Target Type");
    	checkSelectedValue_inDropDownList(SLC_NODE1_TARGET_TYPE, TXT_BINDING);
    	getPossibleValuesOfDropDown(SLC_NODE1_TARGET_TYPE, targetTypeOptions);
    
    	checkStatus(IPF_NODE1_PRIMARY_SERVER, "enabled", "Input Field Node1 Primary Server");
		checkValue_byId(IPF_NODE1_PRIMARY_SERVER, "127.0.0.0");
	
		checkStatus(SLC_NODE1_PRIMARY_SERVER_TRANSPORT,"enabled","Drop-Down List Node1 Primary Server Transport Protocol");
    	checkSelectedValue_inDropDownList(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
    	getPossibleValuesOfDropDown(SLC_NODE1_PRIMARY_SERVER_TRANSPORT, transportProtocolOptions);
    
    	checkStatus(IPF_NODE1_PRIMARY_SERVER_PORT, "enabled", "Input Field Node1 Primary Server Port");
		checkValue_byId(IPF_NODE1_PRIMARY_SERVER_PORT, "5060");
	
		checkStatus(IPF_NODE1_SECONDARY_SERVER, "disabled", "Input Field Node1 Secondary Server");
		checkValue_byId(IPF_NODE1_SECONDARY_SERVER, "");
	
		checkStatus(SLC_NODE1_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node1 Secondary Server Transport Protocol");
    	checkSelectedValue_inDropDownList(SLC_NODE1_SECONDARY_SERVER_TRANSPORT, TXT_TCP);
    	getPossibleValuesOfDropDown(SLC_NODE1_SECONDARY_SERVER_TRANSPORT, transportProtocolOptions);
    
    	checkStatus(IPF_NODE1_SECONDARY_SERVER_PORT, "disabled", "Input Field Node1 Secondary Server Port");
		checkValue_byId(IPF_NODE1_SECONDARY_SERVER_PORT, "0");
	
		checkStatus(IPF_NODE1_SRV_RECORD, "disabled", "Input Field Node1 SRV Record");
		checkValue_byId(IPF_NODE1_SRV_RECORD, "");
	
		checkStatus(SLC_NODE1_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node1  SRV Record Transport Protocol");
    	checkSelectedValue_inDropDownList(SLC_NODE1_SRV_RECORD_TRANSPORT, TXT_TCP);
    	getPossibleValuesOfDropDown(SLC_NODE1_SRV_RECORD_TRANSPORT, transportProtocolOptions);
    
    	checkStatus(SLC_NODE2_TARGET_TYPE,"disabled","Drop-Down List Node2 Target Type");
    	checkSelectedValue_inDropDownList(SLC_NODE2_TARGET_TYPE, TXT_BINDING);
    	getPossibleValuesOfDropDown(SLC_NODE2_TARGET_TYPE, targetTypeOptions);
    
    	checkStatus(IPF_NODE2_PRIMARY_SERVER, "disabled", "Input Field Node2 Primary Server");
		checkValue_byId(IPF_NODE2_PRIMARY_SERVER, "");
	
		checkStatus(SLC_NODE2_PRIMARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Primary Server Transport Protocol");
    	checkSelectedValue_inDropDownList(SLC_NODE2_PRIMARY_SERVER_TRANSPORT, TXT_TCP);
    	getPossibleValuesOfDropDown(SLC_NODE2_PRIMARY_SERVER_TRANSPORT, transportProtocolOptions);
    
    	checkStatus(IPF_NODE2_PRIMARY_SERVER_PORT, "disabled", "Input Field Node2 Primary Server Port");
		checkValue_byId(IPF_NODE2_PRIMARY_SERVER_PORT, "0");
	
		checkStatus(IPF_NODE2_SECONDARY_SERVER, "disabled", "Input Field Node2 Secondary Server");
		checkValue_byId(IPF_NODE2_SECONDARY_SERVER, "");
	
		checkStatus(SLC_NODE2_SECONDARY_SERVER_TRANSPORT,"disabled","Drop-Down List Node2 Secondary Server Transport Protocol");
    	checkSelectedValue_inDropDownList(SLC_NODE2_SECONDARY_SERVER_TRANSPORT, TXT_TCP);
    	getPossibleValuesOfDropDown(SLC_NODE2_SECONDARY_SERVER_TRANSPORT, transportProtocolOptions);
    
    	checkStatus(IPF_NODE2_SECONDARY_SERVER_PORT, "disabled", "Input Field Node2 Secondary Server Port");
		checkValue_byId(IPF_NODE2_SECONDARY_SERVER_PORT, "0");
	
		checkStatus(IPF_NODE2_SRV_RECORD, "disabled", "Input Field Node2 SRV Record");
		checkValue_byId(IPF_NODE2_SRV_RECORD, "");
	
		checkStatus(SLC_NODE2_SRV_RECORD_TRANSPORT,"disabled","Drop-Down List Node2  SRV Record Transport Protocol");
    	checkSelectedValue_inDropDownList(SLC_NODE2_SRV_RECORD_TRANSPORT, TXT_TCP);
    	getPossibleValuesOfDropDown(SLC_NODE2_SRV_RECORD_TRANSPORT, transportProtocolOptions);
    
    	//Timer And Thresholds tab
        clickButton(TB_TIMER_AND_THRESHOLDS);
        
    	checkStatus(IPF_FAILURE_THRESHOLD, "enabled", "Input Field Failure threshold");
		checkValue_byId(IPF_FAILURE_THRESHOLD, "2");
	
		checkStatus(IPF_SUCCESS_THRESHOLD, "enabled", "Input Field Success threshold");
		checkValue_byId(IPF_SUCCESS_THRESHOLD, "1");
	
		checkStatus(IPF_TRASITION_MODE_THRESHOLD, "enabled", "Input Field Transition Mode threshold");
		checkValue_byId(IPF_TRASITION_MODE_THRESHOLD, "1");
	
		checkStatus(IPF_OPTIONS_INTERVAL, "enabled", "Input Field OPTIONS interval");
		checkValue_byId(IPF_OPTIONS_INTERVAL, "60");
	
		checkStatus(IPF_OPTIONS_REQUEST_TIMEOUT, "enabled", "Input Field OPTIONS request timeout");
		checkValue_byId(IPF_OPTIONS_REQUEST_TIMEOUT, "4");
	
		checkStatus(IPF_SUCCESS_NOTIFICATION_RATE, "enabled", "Input Field Notification Rate");
		checkValue_byId(IPF_SUCCESS_NOTIFICATION_RATE, "100");
	
		//Timer And Codecs tab
        clickButton(TB_CODECS);
		
        checkStatus(BTN_ADD_CODEC,"disabled","Button Add Codec");
        
        checkStatus(BTN_DELETE_CODEC,"disabled","Button Delete Codec");
        
        checkStatus(BTN_MOVE_UP_CODEC,"disabled","Button Move Up Codec");
        
        checkStatus(BTN_MOVE_DOWN_CODEC,"disabled","Button Move Down Codec");
        
    	clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}

}