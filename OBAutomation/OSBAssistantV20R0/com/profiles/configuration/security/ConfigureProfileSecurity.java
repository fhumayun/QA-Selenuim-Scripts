package com.profiles.configuration.security;

import com.administration.configuration.security.PropertiesSecurity;
import com.helper.SuperHelper;
import com.profiles.list.PropertiesProfilesList;

public class ConfigureProfileSecurity extends SuperHelper implements PropertiesProfilesList,PropertiesSecurity{

	
   public void configureProfileForSecurity(String mode) throws InterruptedException {
		
	    goToProfilesSecurity();
	    
	    updateMap(RETRIES);
	    
	    //Go to SNORT tab and Enable SNORT
        clickButton(TB_PROFILES_SNORT);
        
        if (!getCheckboxStatus(CB_ENABLE_SNORT))
         clickCheckbox_byID(CB_ENABLE_SNORT);
        	
        //Check that The Input Fields Message rate threshold,Default Block period and the Button Add IP Address become enabled
        checkStatus(IPF_MESG_RATE_THRESHOLD,"enabled","Input Field Message rate threshold"); 
        checkStatus(IPF_BLOCK_PERIOD,"enabled","Input Field Default Block period"); 
        checkStatus(BTN_ADD_IP_ADDRESS, "enabled", "Button Add IP Address");
        
        //Change values in Input Fields Message rate threshold and Default Block period
        type_byId(IPF_MESG_RATE_THRESHOLD, "30000");
        type_byId(IPF_BLOCK_PERIOD, "70");
 
        //Add White List IP Address
        type_byId(IPF_IP_ADDRESS, "10.1.253.100");
        clickButtonAdd();
        
        //Check successful Add
        checkText("10.1.253.100");
        
        //Go to Tab Firewall
        clickButton(TB_PROFILES_FIREWALL);
        
        if(mode.equals(TXT_SBC_PROXY)||mode.equals(TXT_BRANCH_SBC))
        {
        //Enable Masquerading
        clickCheckbox_byID(CB_ENABLE_MASQUERADING);
        }
        
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
        
        clickButton(BTN_BLACK_CONFIGURE);
        updateMap(RETRIES);
    	
    	//Add a IP in Black List
    	clickButtonAdd();
    	updateMap(RETRIES);
    	type_byId(IPF_BLACK_IP_ADDRESS_SUBNET, "10.1.12.10");
    	type_byId(IPF_BLACK_PORT, "6070");
    	clickButtonSave();
      	updateMap(RETRIES);
      	
      	//Check IP in Black List
      	checkText("10.1.12.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_BLACK_IPS_SUBNETS, "10.1.12.10", TXT_PORT, "6070");
    	
    	//Add a Subnet in Black List
    	clickButtonAdd();
    	updateMap(RETRIES);
    	type_byId(IPF_BLACK_IP_ADDRESS_SUBNET, "10.1.72.0");
    	clickButtonSave();
      	updateMap(RETRIES);
    	
    	//Check Subnet in Black List
      	checkText("10.1.72.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_BLACK_IPS_SUBNETS, "10.1.72.0", TXT_PORT, "0");
    	clickButtonSave();
    	updateMap(RETRIES);
   
       	//Add a IP in White List
    	clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
           
       	clickButtonAdd();
       	updateMap(RETRIES);
       	type_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.22.10");
       	type_byId(IPF_WHITE_PORT, "6070");
       	clickButtonSave();
        updateMap(RETRIES);
         	
        //Check IP in White List
        checkText("10.1.22.10");
       	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.22.10", TXT_PORT, "6070");
       	
       	//Add a Subnet in White List
       	clickButtonAdd();
       	updateMap(RETRIES);
       	type_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.82.0");
       	clickButtonSave();
        updateMap(RETRIES);
       	
       	//Check Subnet in White List
        checkText("10.1.82.0");
       	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.82.0", TXT_PORT, "0");
       	clickButtonSave();
       	updateMap(RETRIES);
       	
       
	    clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmationProfiles();
	    
	}
	
      public void verifyProfileSecurityConfiguration(String mode) throws InterruptedException {
	    	
	    methodLogger.log();
	    
		goToAdministrationSecurity();
    
		updateMap(RETRIES);
		
		clickButton(TB_SNORT);
		//Verify Input Fields Message rate threshold,Default Block period and the Button Add IP Address status and values
        checkStatus(IPF_MESG_RATE_THRESHOLD,"enabled","Input Field Message rate threshold"); 
        checkStatus(IPF_BLOCK_PERIOD,"enabled","Input Field Default Block period"); 
        checkStatus(BTN_ADD_IP_ADDRESS, "enabled", "Button Add IP Address");
        checkValue_byId(IPF_MESG_RATE_THRESHOLD, "30000");
        checkValue_byId(IPF_BLOCK_PERIOD, "70");
	
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
       //Verify Configuration 
    
       if(mode.equals(TXT_SBC_PROXY)||mode.equals(TXT_BRANCH_SBC))
       {
         checkStatus(CB_ENABLE_MASQUERADING,"checked","Checkbox Enable masquerading"); 
       }
       if(mode.equals(TXT_PROXY)||mode.equals(TXT_PROXY_ACD))
       {
         checkStatus(CB_ENABLE_MASQUERADING,"disabled","Checkbox Enable masquerading"); 
         checkStatus(CB_ENABLE_MASQUERADING,"unchecked","Checkbox Enable masquerading"); 
       }
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
       
       clickButton(BTN_BLACK_CONFIGURE);
       updateMap(RETRIES);
       
     	//Verify IP and Subnet in Black List
     	checkTextIsContained_byXPathTable(TBL_LIST_BLACK_IPS_SUBNETS, "10.1.12.10");
   	    checkElementText_inSpecificTableColumn(TBL_LIST_BLACK_IPS_SUBNETS, "10.1.12.10", TXT_PORT, "6070");
   	    checkTextIsContained_byXPathTable(TBL_LIST_BLACK_IPS_SUBNETS, "10.1.72.0");
   	    checkElementText_inSpecificTableColumn(TBL_LIST_BLACK_IPS_SUBNETS, "10.1.72.0", TXT_PORT, "0");
     
     	//Edit IP and verify fields
     	clickCheckbox_byText("10.1.12.10");
    	clickButton(BTN_BLACK_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_BLACK_IP_ADDRESS_SUBNET, "10.1.12.10");
    	checkValue_byId(IPF_BLACK_PORT, "6070");
    	clickButtonCancel();
     	updateMap(RETRIES);
     	clickCheckbox_byText("10.1.12.10");
     	
   	   //Edit Subnet and verify fields
    	clickCheckbox_byText("10.1.72.0");
    	clickButton(BTN_BLACK_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_BLACK_IP_ADDRESS_SUBNET, "10.1.72.0");
    	checkValue_byId(IPF_BLACK_PORT, "0");
        clickButtonCancel();
     	updateMap(RETRIES);
     	clickCheckbox_byText("10.1.72.0");
     	
   	    clickButtonCancel();
    	updateMap(RETRIES);
    	
        clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
        
      	//Verify IP and Subnet in White List
      	checkTextIsContained_byXPathTable(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.22.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.22.10", TXT_PORT, "6070");
    	checkTextIsContained_byXPathTable(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.82.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.82.0", TXT_PORT, "0");
      
    	//Edit IP and verify fields
    	clickCheckbox_byText("10.1.22.10");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.22.10");
    	checkValue_byId(IPF_WHITE_PORT, "6070");
    	clickButtonCancel();
      	updateMap(RETRIES);
      	clickCheckbox_byText("10.1.22.10");
      	
    	//Edit Subnet and verify fields
    	clickCheckbox_byText("10.1.82.0");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.82.0");
    	checkValue_byId(IPF_WHITE_PORT, "0");
    	clickButtonCancel();
      	updateMap(RETRIES);
      	clickCheckbox_byText("10.1.82.0");
      	
    	clickButtonCancel();
    	updateMap(RETRIES);
    	
		clickButtonCancel();
		updateMap(RETRIES);
	   }
			
	
}