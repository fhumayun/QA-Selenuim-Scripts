package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC12_Security_DisableSnort extends SuperHelper implements PropertiesSecurity {

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
	public void securityDisableSnort() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to SNORT tab and Disable SNORT
        clickButton(TB_SNORT);
        
        if (getCheckboxStatus(CB_ENABLE_SNORT))
         clickCheckbox_byID(CB_ENABLE_SNORT);
        	
        //Check that The Input Fields Message rate threshold,Default Block period and the Button Add IP Address become disabled
        checkStatus(IPF_MESG_RATE_THRESHOLD,"disabled","Input Field Message rate threshold"); 
        checkStatus(IPF_BLOCK_PERIOD,"disabled","Input Field Default Block period"); 
        checkStatus(BTN_ADD_IP_ADDRESS, "disabled", "Button Add IP Address");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySecuritySnortDisabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		//Go to SNORT tab
        clickButton(TB_SNORT);
        
        //Verify Input Fields Message rate threshold,Default Block period and the Button Add IP Address status
        checkStatus(IPF_MESG_RATE_THRESHOLD,"disabled","Input Field Message rate threshold"); 
        checkStatus(IPF_BLOCK_PERIOD,"disabled","Input Field Default Block period"); 
        checkStatus(BTN_ADD_IP_ADDRESS, "disabled", "Button Add IP Address");
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}

}