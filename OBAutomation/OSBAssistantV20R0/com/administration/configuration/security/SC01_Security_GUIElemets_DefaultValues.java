package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC01_Security_GUIElemets_DefaultValues extends SuperHelper implements PropertiesSecurity {

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
	public void security_CheckDefaultValues() throws InterruptedException {
		
		String serverCert= "servercert.pem";
		String serverCA= "serverCA.pem";
		String serverKey= "serverkey.pem";
		
		String[] x509CertificateOptions = {serverCert};
		String[] caCertificateOptions = {serverCA};
		String[] keyFileOptions = {serverKey};
		String[] secretkeyFileOptions = {""};
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Tab General
        clickButton(TB_GENERAL);
        
        checkStatus(SLC_X509_CERTIFICATE, "enabled", "Drop-Down List X.509 Certificate");
        checkSelectedValue_inDropDownList(SLC_X509_CERTIFICATE, serverCert);
        getPossibleValuesOfDropDown(SLC_X509_CERTIFICATE, x509CertificateOptions);
       
        checkStatus(SLC_CA_CERTIFICATES, "enabled", "Drop-Down List CA Certificates");
        checkSelectedValue_inDropDownList(SLC_CA_CERTIFICATES, serverCA);
        getPossibleValuesOfDropDown(SLC_CA_CERTIFICATES, caCertificateOptions);
      
        checkStatus(SLC_KEY_FILE, "enabled", "Drop-Down List Key File");
        checkSelectedValue_inDropDownList(SLC_KEY_FILE, serverKey);
        getPossibleValuesOfDropDown(SLC_KEY_FILE, keyFileOptions);
      
        checkStatus(SLC_SHARE_SECRET_FILES, "enabled", "Drop-Down List Shared Secret Files:");
        checkSelectedValue_inDropDownList(SLC_SHARE_SECRET_FILES, "");
        getPossibleValuesOfDropDown(SLC_SHARE_SECRET_FILES, secretkeyFileOptions);
      
        checkStatus(BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON, "enabled", "Button Configure TLS Certificates");
        checkStatus(BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON, "enabled","Button Configure Shared Secret Files");
       
        
        //Tab SNORT
        clickButton(TB_SNORT);
        
        checkStatus(CB_ENABLE_SNORT,"enabled","Checkbox Enable SNORT"); 
        checkStatus(CB_ENABLE_SNORT,"unchecked","Checkbox Enable SNORT"); 
  
        checkValue_byId(IPF_MESG_RATE_THRESHOLD, "20000");
        checkStatus(IPF_MESG_RATE_THRESHOLD,"disabled","Input Field Message rate threshold"); 
       
        checkValue_byId(IPF_BLOCK_PERIOD, "60");
        checkStatus(IPF_BLOCK_PERIOD,"disabled","Input Field Default Block period"); 
        
        checkValue_byId(IPF_IP_ADDRESS, "");
        checkStatus(IPF_IP_ADDRESS,"disabled","Input Field IP Address"); 
        
        checkStatus(BTN_ADD_IP_ADDRESS, "disabled", "Button Add IP Address");
     
        checkStatus(BTN_DELETE_IP_ADDRESS, "disabled", "Button Delete IP Address");
           
        
        //Tab Firewall
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
 
        checkStatus(BTN_BLACK_CONFIGURE, "enabled", "Button Configure Black List");
        
        checkStatus(BTN_WHITE_CONFIGURE, "enabled", "Button Configure White List");
        
        
        //Tab Port FW
        clickButton(TB_PORT_FW);
        
        checkStatus(CB_ENABLE_PORT_FW,"enabled","Checkbox Enable Port Forwarding"); 
        checkStatus(CB_ENABLE_PORT_FW,"unchecked","Checkbox Enable Port Forwarding"); 
        
        checkStatus(BTN_ADD_PORT_FW, "disabled", "Button Add Port Forwarding");
       
        checkStatus(BTN_EDIT_PORT_FW, "disabled", "Button Edit Port Forwarding");
       
        checkStatus(BTN_DELETE_PORT_FW, "disabled", "Button Delete Port Forwarding");
      
        
        //Tab OpenVPN
        clickButton(TB_OpenVPN);

        checkStatus(BTN_ADD_OpenVPN, "enabled", "Button Add OpenVPN");
        
        checkStatus(BTN_EDIT_OpenVPN, "disabled", "Button Edit OpenVPN");
       
        checkStatus(BTN_DELETE_OpenVPN, "disabled", "Button Delete OpenVPN");
      
        //Tab IPSec
        clickButton(TB_IPsec);

        checkStatus(BTN_ADD_IPsec, "enabled", "Button Add IPsec");
        
        checkStatus(BTN_EDIT_IPsec, "disabled", "Button Edit IPsec");
       
        checkStatus(BTN_DELETE_IPsec, "disabled", "Button Delete IPsec");
   
        clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}

}