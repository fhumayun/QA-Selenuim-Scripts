package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC13_Security_Firewall_ConfigureConnections extends SuperHelper implements PropertiesSecurity {

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
	public void securityConfigureFirewallConnections() throws InterruptedException {
		
	
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        //Enable Masquerading
        clickCheckbox_byID(CB_ENABLE_MASQUERADING);
        
        //Check Incoming/Outgoing WAN network connections checkBoxes
        clickCheckbox_byID(CB_DNS);
        clickCheckbox_byID(CB_SNMP);
        clickCheckbox_byID(CB_FTP);
        clickCheckbox_byID(CB_PING);
        clickCheckbox_byID(CB_TELNET);
        clickCheckbox_byID(CB_NTP);
        
        //Don't AllowIncoming WAN VoIP connections (uncheck checkBoxes)
        clickCheckbox_byID(CB_SIP);
        clickCheckbox_byID(CB_RTP_sRTP);
        clickCheckbox_byID(CB_TLS);
        clickCheckbox_byID(CB_MGCP);
       
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}

	@Test (priority = 1)
	public void verifySecurityFirewallConnectionsConfiguration() throws InterruptedException {
		
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
       //Verify Configuration 
       checkStatus(CB_ENABLE_MASQUERADING,"checked","Checkbox Enable masquerading"); 
       checkStatus(CB_DNS,"checked","Checkbox DNS"); 
       checkStatus(CB_SNMP,"checked","Checkbox SNMP"); 
       checkStatus(CB_FTP,"checked","Checkbox FTP"); 
       checkStatus(CB_HTTPS,"checked","Checkbox HTTPS"); 
       checkStatus(CB_SSH,"checked","Checkbox SSH"); 
       checkStatus(CB_PING,"checked","Checkbox PING"); 
       checkStatus(CB_TELNET,"checked","Checkbox TELNET"); 
       checkStatus(CB_NTP,"checked","Checkbox NTP"); 
       checkStatus(CB_SIP,"unchecked","Checkbox SIP"); 
       checkStatus(CB_RTP_sRTP,"unchecked","Checkbox RTP/sRTP"); 
       checkStatus(CB_TLS,"unchecked","Checkbox TLS"); 
       checkStatus(CB_MGCP,"unchecked","Checkbox "); 
      
        clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}

	@Test (priority = 2)
	public void securityAllowAllWANFirewallConnections() throws InterruptedException {
		
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        //Uncheck all Incoming/Outgoing WAN network connections checkBoxes
        clickCheckbox_byID(CB_DNS);
        clickCheckbox_byID(CB_SNMP);
        clickCheckbox_byID(CB_FTP);
        clickCheckbox_byID(CB_HTTPS);
        clickCheckbox_byID(CB_SSH);
        clickCheckbox_byID(CB_PING);
        clickCheckbox_byID(CB_TELNET);
        clickCheckbox_byID(CB_NTP);
        checkStatus(CB_DNS,"unchecked","Checkbox DNS"); 
        checkStatus(CB_SNMP,"unchecked","Checkbox SNMP"); 
        checkStatus(CB_FTP,"unchecked","Checkbox FTP"); 
        checkStatus(CB_HTTPS,"unchecked","Checkbox HTTPS"); 
        checkStatus(CB_SSH,"unchecked","Checkbox SSH"); 
        checkStatus(CB_PING,"unchecked","Checkbox PING"); 
        checkStatus(CB_TELNET,"unchecked","Checkbox TELNET"); 
        checkStatus(CB_NTP,"unchecked","Checkbox NTP");  
        
        //Allow All Incoming/Outgoing WAN network connections 
        clickCheckbox_byID(CB_ALLOW_ALL_WAN);
        
        //Check that  All Incoming/Outgoing WAN network connections checkBoxes become Checked and Disabled 
        checkStatus(CB_DNS,"disabled","Checkbox DNS"); 
        checkStatus(CB_DNS,"checked","Checkbox DNS"); 
  
        checkStatus(CB_SNMP,"disabled","Checkbox SNMP"); 
        checkStatus(CB_SNMP,"checked","Checkbox SNMP"); 
  
        checkStatus(CB_FTP,"disabled","Checkbox FTP"); 
        checkStatus(CB_FTP,"checked","Checkbox FTP"); 
  
        checkStatus(CB_HTTPS,"disabled","Checkbox HTTPS"); 
        checkStatus(CB_HTTPS,"checked","Checkbox HTTPS"); 
  
        checkStatus(CB_SSH,"disabled","Checkbox SSH"); 
        checkStatus(CB_SSH,"checked","Checkbox SSH"); 
  
        checkStatus(CB_PING,"disabled","Checkbox PING"); 
        checkStatus(CB_PING,"checked","Checkbox PING"); 
  
        checkStatus(CB_TELNET,"disabled","Checkbox TELNET"); 
        checkStatus(CB_TELNET,"checked","Checkbox TELNET"); 
  
        checkStatus(CB_NTP,"disabled","Checkbox NTP"); 
        checkStatus(CB_NTP,"checked","Checkbox NTP"); 
  
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 3)
	public void verifySecurityAllWANFirewallConnectionsAllowance() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        checkStatus(CB_DNS,"disabled","Checkbox DNS"); 
        checkStatus(CB_DNS,"checked","Checkbox DNS"); 
  
        checkStatus(CB_SNMP,"disabled","Checkbox SNMP"); 
        checkStatus(CB_SNMP,"checked","Checkbox SNMP"); 
  
        checkStatus(CB_FTP,"disabled","Checkbox FTP"); 
        checkStatus(CB_FTP,"checked","Checkbox FTP"); 
  
        checkStatus(CB_HTTPS,"disabled","Checkbox HTTPS"); 
        checkStatus(CB_HTTPS,"checked","Checkbox HTTPS"); 
  
        checkStatus(CB_SSH,"disabled","Checkbox SSH"); 
        checkStatus(CB_SSH,"checked","Checkbox SSH"); 
  
        checkStatus(CB_PING,"disabled","Checkbox PING"); 
        checkStatus(CB_PING,"checked","Checkbox PING"); 
  
        checkStatus(CB_TELNET,"disabled","Checkbox TELNET"); 
        checkStatus(CB_TELNET,"checked","Checkbox TELNET"); 
  
        checkStatus(CB_NTP,"disabled","Checkbox NTP"); 
        checkStatus(CB_NTP,"checked","Checkbox NTP"); 
   
        clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 4)
	public void securitySetDefaultFirewallConnectionConfiguration() throws InterruptedException {
		
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        //Disable Masquerading
        clickCheckbox_byID(CB_ENABLE_MASQUERADING);
       
        clickCheckbox_byID(CB_ALLOW_ALL_WAN);
        
        //Set default configuration
        clickCheckbox_byID(CB_DNS);
        clickCheckbox_byID(CB_SNMP);
        clickCheckbox_byID(CB_FTP);
        clickCheckbox_byID(CB_PING);
        clickCheckbox_byID(CB_TELNET);
        clickCheckbox_byID(CB_NTP);
        clickCheckbox_byID(CB_SIP);
        clickCheckbox_byID(CB_RTP_sRTP);
        clickCheckbox_byID(CB_TLS);
        clickCheckbox_byID(CB_MGCP);
      
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 5)
	public void veriftSecurityDefaultFirewallConnectionConfiguration() throws InterruptedException {
		
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        checkStatus(CB_ENABLE_MASQUERADING,"enabled","Checkbox Enable masquerading"); 
        checkStatus(CB_ENABLE_MASQUERADING,"unchecked","Checkbox Enable masquerading"); 
     
        checkStatus(CB_DNS,"enabled","Checkbox DNS"); 
        checkStatus(CB_DNS,"unchecked","Checkbox DNS"); 
  
        checkStatus(CB_SNMP,"enabled","Checkbox SNMP"); 
        checkStatus(CB_SNMP,"unchecked","Checkbox SNMP"); 
  
        checkStatus(CB_FTP,"enabled","Checkbox FTP"); 
        checkStatus(CB_FTP,"unchecked","Checkbox FTP"); 
  
        checkStatus(CB_HTTPS,"enabled","Checkbox HTTPS"); 
        checkStatus(CB_HTTPS,"checked","Checkbox HTTPS"); 
  
        checkStatus(CB_SSH,"enabled","Checkbox SSH"); 
        checkStatus(CB_SSH,"checked","Checkbox SSH"); 
  
        checkStatus(CB_PING,"enabled","Checkbox PING"); 
        checkStatus(CB_PING,"unchecked","Checkbox PING"); 
  
        checkStatus(CB_TELNET,"enabled","Checkbox TELNET"); 
        checkStatus(CB_TELNET,"unchecked","Checkbox TELNET"); 
  
        checkStatus(CB_NTP,"enabled","Checkbox NTP"); 
        checkStatus(CB_NTP,"unchecked","Checkbox NTP"); 
  
        checkStatus(CB_ALLOW_ALL_WAN,"enabled","Checkbox Allow all WAN network connections"); 
        checkStatus(CB_ALLOW_ALL_WAN,"unchecked","Checkbox Allow all WAN network connections"); 
  
        checkStatus(CB_SIP,"enabled","Checkbox SIP"); 
        checkStatus(CB_SIP,"checked","Checkbox SIP"); 
  
        checkStatus(CB_RTP_sRTP,"enabled","Checkbox RTP/sRTP"); 
        checkStatus(CB_RTP_sRTP,"checked","Checkbox RTP/sRTP"); 
  
        checkStatus(CB_TLS,"enabled","Checkbox TLS"); 
        checkStatus(CB_TLS,"checked","Checkbox TLS"); 
  
        checkStatus(CB_MGCP,"enabled","Checkbox "); 
        checkStatus(CB_MGCP,"checked","Checkbox "); 
 
        clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
  
	}
}