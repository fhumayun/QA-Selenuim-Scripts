package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC10_Security_EnableSnort extends SuperHelper implements PropertiesSecurity {

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
	public void securityEnableSnort() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to SNORT tab and Enable SNORT
        clickButton(TB_SNORT);
        
        if (!getCheckboxStatus(CB_ENABLE_SNORT))
         clickCheckbox_byID(CB_ENABLE_SNORT);
        	
        //Check that The Input Fields Message rate threshold,Default Block period and the Button Add IP Address become enabled
        checkStatus(IPF_MESG_RATE_THRESHOLD,"enabled","Input Field Message rate threshold"); 
        checkStatus(IPF_BLOCK_PERIOD,"enabled","Input Field Default Block period"); 
        checkStatus(BTN_ADD_IP_ADDRESS, "enabled", "Button Add IP Address");
        
        //Change values in Input Fields Message rate threshold and Default Block period
        type_byId(IPF_MESG_RATE_THRESHOLD, "30000");
        type_byId(IPF_BLOCK_PERIOD, "70");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySecuritySnortEnabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		//Go to SNORT tab 
        clickButton(TB_SNORT);
        
        //Verify Input Fields Message rate threshold,Default Block period and the Button Add IP Address status and values
        checkStatus(IPF_MESG_RATE_THRESHOLD,"enabled","Input Field Message rate threshold"); 
        checkStatus(IPF_BLOCK_PERIOD,"enabled","Input Field Default Block period"); 
        checkStatus(BTN_ADD_IP_ADDRESS, "enabled", "Button Add IP Address");
        checkValue_byId(IPF_MESG_RATE_THRESHOLD, "30000");
        checkValue_byId(IPF_BLOCK_PERIOD, "70");
	    
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}

}