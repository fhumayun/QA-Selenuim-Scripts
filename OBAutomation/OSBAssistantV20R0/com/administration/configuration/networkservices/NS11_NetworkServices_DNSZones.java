package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS11_NetworkServices_DNSZones extends SuperHelper implements PropertiesNetworkServices {

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
	public void networkServicesDNSAddZones() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
         
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
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	
	@Test (priority = 1)
	public void verifyNetworkServicesDNSZonesCreation() throws InterruptedException {
			
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
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
	
	@Test (priority = 2)
	public void networkServicesDNSModifyZones() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
         
        //Edit Slave Zone and modify the fields
		clickCheckbox_byText("Slave");
		clickButton(BTN_DNS_EDIT);
		updateMap(RETRIES);
		type_byId(IPF_ZONE_NAME,"Zone11.com");
		type_byId(IPF_ZONE_IP, "10.1.125.80,255.255.255.0");
		type_byId(IPF_ZONE_FILE, "File11");
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Slave Zone Modification
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Slave");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone11.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.80,255.255.255.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File11");

		//Edit Forward Zone and modify the fields
		clickCheckbox_byText("Forward");
		clickButton(BTN_DNS_EDIT);
		updateMap(RETRIES);
		type_byId(IPF_ZONE_NAME,"Zone22.com");
		type_byId(IPF_ZONE_IP, "10.1.125.81,255.255.224.0");
		type_byId(IPF_ZONE_FILE, "File22");
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Forward Zone Creation
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Forward");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone22.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.81,255.255.224.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File22");
		
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	@Test (priority = 3)
	public void verifyNetworkServicesDNSZonesModification() throws InterruptedException {
			
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
    	//Verify Slave Zone Modification
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Slave");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone11.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.80,255.255.255.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File11");
		//Verify Forward Zone Modification
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Forward");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"Zone22.com");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"10.1.125.81,255.255.224.0");
		checkTextIsContained_byXPathTable(TBL_LIST_ZONES,"File22");
	
		//Edit Slave Zone
		clickCheckbox_byText("Slave");
		clickButton(BTN_DNS_EDIT);
		updateMap(RETRIES);
		//Verify Slave Zone fields
		checkSelectedValue_inDropDownList(SLC_TYPE, TXT_ZONE_TYPE_SLAVE);
		checkValue_byId(IPF_ZONE_NAME,"Zone11.com");
		checkValue_byId(IPF_ZONE_IP, "10.1.125.80,255.255.255.0");
		checkValue_byId(IPF_ZONE_FILE, "File11");
		clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("Slave");
    	
    	//Edit Forward Zone
		clickCheckbox_byText("Forward");
		clickButton(BTN_DNS_EDIT);
		updateMap(RETRIES);
		//Verify Forward Zone fields
		checkSelectedValue_inDropDownList(SLC_TYPE, TXT_ZONE_TYPE_FORWARD);
		checkValue_byId(IPF_ZONE_NAME,"Zone22.com");
		checkValue_byId(IPF_ZONE_IP, "10.1.125.81,255.255.224.0");
		checkValue_byId(IPF_ZONE_FILE, "File22");
		clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("Forward");
		
		clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}
	
	@Test (priority = 4)
	public void networkServicesDNSDeleteZones() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
         
        //Delete Slave Zone
		clickCheckbox_byText("Slave");
		clickButtonDelete();
	    //Check Slave Zone Deletion
		checkText_NotVisible("Zone11.com");
		
		//Delete Forward Zone
		clickCheckbox_byText("Forward");
		clickButtonDelete();
	    //Check Forward Zone Deletion
		checkText_NotVisible("Zone22.com");
       
		//Disable DNS
        clickCheckbox_byID(CB_ENABLE_DNS);
        //Check that the Configure Forward IP List button becomes disabled
         checkStatus(BTN_DNS_FORWARD, "disabled", "Button Configure IP List");
		
		clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	@Test (priority = 5)
	public void verifyNetworkServicesDNSZonesDeletion() throws InterruptedException {
			
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
        //Verify DNS Disabling
        checkStatus(CB_ENABLE_DNS, "enabled", "Checkbox Enable DNS");
        checkStatus(CB_ENABLE_DNS, "unchecked", "Checkbox Enable DNS");
        checkStatus(BTN_DNS_FORWARD, "disabled", "Button Configure IP List");
		
        //Verify Slave Zone Deletion
		checkText_NotVisible("Zone11.com");
	    //Verify Forward Zone Deletion
		checkText_NotVisible("Zone22.com");
		
		clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}
}