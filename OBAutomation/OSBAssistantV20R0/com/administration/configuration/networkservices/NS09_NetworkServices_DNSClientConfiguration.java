package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS09_NetworkServices_DNSClientConfiguration extends SuperHelper implements PropertiesNetworkServices {

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
	public void networkServicesDNSAddClientLists() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
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
        
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	
	@Test (priority = 1)
	public void verifyNetworkServicesDNSClientListsCreation() throws InterruptedException {
			
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
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
		
		clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}
	
	@Test (priority = 2)
	public void networkServicesDNSDeleteClientLists() throws InterruptedException {
		
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
    	//Delete DNS Server List
		clickButton(BTN_CONFIGURE_DNS);
		updateMap(RETRIES);	
		clickCheckbox_byText("10.2.255.15");
		clickButtonDelete();
		//Check Deletion
		checkText_NotVisible("10.2.255.15");
		clickButtonClose();
		
		updateMap(RETRIES);
		
		//Delete DNS Alias List
		clickButton(BTN_CONFIGURE_ALIAS);
		updateMap(RETRIES);	
		clickCheckbox_byText("10.1.253.105");
		clickButtonDelete();
		//Check Deletion
		checkText_NotVisible("10.1.253.105");
		clickButtonClose();
		
		updateMap(RETRIES);
        
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	@Test (priority = 3)
	public void verifyNetworkServicesDNSClientListsDeletion() throws InterruptedException {
			
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to DNS tab
        clickButton(TB_DNS);
        
        //Verify DNS Server List deletion
		clickButton(BTN_CONFIGURE_DNS);
		updateMap(RETRIES);	
		checkText_NotVisible("10.2.255.15");
		clickButtonClose();
		
		updateMap(RETRIES);
		
		//Verify DNS Alias List deletion
		clickButton(BTN_CONFIGURE_ALIAS);
		updateMap(RETRIES);	
		checkText_NotVisible("10.1.253.105");
		clickButtonClose();	
		
		updateMap(RETRIES);
		
		clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}
	

}