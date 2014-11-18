package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS10_NetworkServices_DNSForwardIPlist extends SuperHelper implements PropertiesNetworkServices {

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
	public void networkServicesDNSAddForwardIPList() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
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
		
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	
	@Test (priority = 1)
	public void verifyNetworkServicesDNSForwardIPListCreation() throws InterruptedException {
			
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
        //Verify Forward IP List creation
		clickButton(BTN_DNS_FORWARD);
		updateMap(RETRIES);	
		checkText("10.2.125.12");
		clickButtonClose();
		
		updateMap(RETRIES);
		
		clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}
	
	@Test (priority = 2)
	public void networkServicesDNSDeleteForwardIPList() throws InterruptedException {
		
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
    	//Delete Forward IP List
		clickButton(BTN_DNS_FORWARD);
		updateMap(RETRIES);	
		clickCheckbox_byText("10.2.125.12");
		clickButtonDelete();
		//Check Deletion
		checkText_NotVisible("10.2.125.12");
		clickButtonClose();
		
		updateMap(RETRIES);
        
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	@Test (priority = 3)
	public void verifyNetworkServicesDNSForwardIPDeletion() throws InterruptedException {
			
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
        //Verify Forward IP List deletion
		clickButton(BTN_DNS_FORWARD);
		updateMap(RETRIES);	
		checkText_NotVisible("10.2.125.12");
		clickButtonClose();
		
		updateMap(RETRIES);
		
		clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}
	

}