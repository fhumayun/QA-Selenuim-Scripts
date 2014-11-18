package com.profiles.configuration.networkservices;

import com.administration.configuration.networkservices.PropertiesNetworkServices;
import com.helper.SuperHelper;
import com.profiles.list.PropertiesProfilesList;

   public class ConfigureProfileNetworkServices extends SuperHelper implements PropertiesProfilesList,PropertiesNetworkServices{

   
	public void configureProfileForNetworkServices() throws InterruptedException {	
	   
		goToProfilesNetworkServices();
	    
	    updateMap(RETRIES);
	    
	    //Go to NTP tab
        clickButton(TB_PROFILES_NTP);
        
        //Enable Local NTP
        clickCheckbox_byID(CB_ENABLE_LOCAL_NTP_SERVER);
		
        //Go to DNS tab
        clickButton(TB_PROFILES_DNS);
        
        //Add DNS Server List
        clickButton(BTN_CONFIGURE_DNS);
		updateMap(RETRIES);	
		type_byId(IPF_ADD_DNS_FIELD, "10.2.255.15");
		clickButtonAdd();
		//Check Add
		checkText("10.2.255.15");
		clickButtonClose();
		
		updateMap(RETRIES);
		
		//Add DNS Alias List
		clickButton(BTN_CONFIGURE_ALIAS);
		updateMap(RETRIES);	
		type_byId(IPF_ADD_ZONE_FIELD, "10.1.253.105");
		clickButtonAdd();
		//Check Add
		checkText("10.1.253.105");
		clickButtonClose();
		
		updateMap(RETRIES);
        
	    //Enable DNS
        clickCheckbox_byID(CB_ENABLE_DNS);
        //Check that the Configure Forward IP List button becomes enabled
        checkStatus(BTN_DNS_FORWARD, "enabled", "Button Configure IP List");
        
    	//Add Forward IP List
		clickButton(BTN_DNS_FORWARD);
		updateMap(RETRIES);	
		type_byId(IPF_ADD_Dns_ForwardList, "10.2.125.12");
		clickButtonAdd();
		//Check Add
		checkText("10.2.125.12");
		clickButtonClose();
		
		updateMap(RETRIES);
		
		//Add Slave Zone
        clickButtonAdd();
        updateMap(RETRIES);
		selectFromDropDown(SLC_TYPE, TXT_ZONE_TYPE_SLAVE);
		type_byId(IPF_ZONE_NAME,"Zone01.com");
		type_byId(IPF_ZONE_IP, "10.1.125.78,255.255.255.0");
		type_byId(IPF_ZONE_FILE, "File01");
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Slave Zone Creation
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Slave");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone01.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.78,255.255.255.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File01");

		//Add Forward Zone
		clickButtonAdd();
		updateMap(RETRIES);
		selectFromDropDown(SLC_TYPE, TXT_ZONE_TYPE_FORWARD);
		type_byId(IPF_ZONE_NAME,"Zone02.com");
		type_byId(IPF_ZONE_IP, "10.1.125.79,255.255.224.0");
		type_byId(IPF_ZONE_FILE, "File02");
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Forward Zone Creation
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Forward");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone02.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.79,255.255.224.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File02");
		
	    clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmationProfiles();
	    
	}
	
      public void verifyProfileNetworkServicesConfiguration() throws InterruptedException {
	    	
	    methodLogger.log();
	    
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to NTP tab
        clickButton(TB_NTP);
        
        //Verify NTP Enabling
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "enabled", "Checkbox Enable local NTP server");
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "checked", "Checkbox Enable local NTP server");
	
        //Go to DNS tab
        clickButton(TB_DNS);
        
        //Verify DNS Server List creation
		clickButton(BTN_CONFIGURE_DNS);
		updateMap(RETRIES);	
		checkText("10.2.255.15");
		clickButtonClose();
		
		updateMap(RETRIES);
		
		//Verify DNS Alias List creation
		clickButton(BTN_CONFIGURE_ALIAS);
		updateMap(RETRIES);	
		checkText("10.1.253.105");
		clickButtonClose();	
		
		updateMap(RETRIES);
		
		//Verify Forward IP List creation
		clickButton(BTN_DNS_FORWARD);
		updateMap(RETRIES);	
		checkText("10.2.125.12");
		clickButtonClose();
		
		updateMap(RETRIES);
        
		//Verify Slave Zone Creation
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Slave");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone01.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.78,255.255.255.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File01");
		//Verify Forward Zone Creation
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Forward");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone02.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.79,255.255.224.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File02");
	
		//Edit Slave Zone
		clickCheckbox_byText("Slave");
		clickButton(BTN_DNS_EDIT);
		updateMap(RETRIES);
		//Verify Slave Zone fields
		checkSelectedValue_inDropDownList(SLC_TYPE, TXT_ZONE_TYPE_SLAVE);
		checkValue_byId(IPF_ZONE_NAME,"Zone01.com");
		checkValue_byId(IPF_ZONE_IP, "10.1.125.78,255.255.255.0");
		checkValue_byId(IPF_ZONE_FILE, "File01");
		clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("Slave");
    	
    	//Edit Forward Zone
		clickCheckbox_byText("Forward");
		clickButton(BTN_DNS_EDIT);
		updateMap(RETRIES);
		//Verify Forward Zone fields
		checkSelectedValue_inDropDownList(SLC_TYPE, TXT_ZONE_TYPE_FORWARD);
		checkValue_byId(IPF_ZONE_NAME,"Zone02.com");
		checkValue_byId(IPF_ZONE_IP, "10.1.125.79,255.255.224.0");
		checkValue_byId(IPF_ZONE_FILE, "File02");
		clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("Forward");

		clickButtonCancel();
		updateMap(RETRIES);
	   }
			
	
}