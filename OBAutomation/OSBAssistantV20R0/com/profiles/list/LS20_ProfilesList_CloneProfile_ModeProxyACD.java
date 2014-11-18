package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.networkservices.PropertiesNetworkServices;
import com.helper.SuperHelper;

public class LS20_ProfilesList_CloneProfile_ModeProxyACD extends SuperHelper implements PropertiesProfilesList,PropertiesNetworkServices {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToProfilesList();
	}

	@BeforeMethod(alwaysRun = true)
	public void initializeWindowsMap() throws InterruptedException {
		initMap();
	}
	
	@AfterMethod(alwaysRun = true)
	public void getfocusClearWindowsBeforeMethod() throws InterruptedException {
		clearWindows();
	}

   Profiles_GeneralMethods pr = new Profiles_GeneralMethods();
	
	@Test (priority = 0)
	public void profilesListCloneProfileModeProxyACD() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		pr.cloneProfile("Pr04ProxyACDNetworkServices", "ClonedProxyACD");
		
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyProfilesListProfileModeProxyACDClone() throws InterruptedException {
		
		methodLogger.log(); 
		//Verify Cloned Profile Configuration
		selectFromDropDown(SLC_SELECTPROFILE, "ClonedProxyACD");
		goToProfilesNetworkServices();
		    
	    updateMap(RETRIES);
        
        //Go to NTP tab
        clickButton(TB_PROFILES_NTP);
        
        //Verify NTP Enabling
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "enabled", "Checkbox Enable local NTP server");
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "checked", "Checkbox Enable local NTP server");
	
        //Go to DNS tab
        clickButton(TB_PROFILES_DNS);
        
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
		setMethodState();
}
	
}