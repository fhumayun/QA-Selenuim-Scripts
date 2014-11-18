package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC11_Security_ConfigureWhiteList extends SuperHelper implements PropertiesSecurity {

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
	public void securityAddIPAddress() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to SNORT
        clickButton(TB_SNORT);
        
        if (!getCheckboxStatus(CB_ENABLE_SNORT))
         clickCheckbox_byID(CB_ENABLE_SNORT);
        	
        //Add White List IP Address
        type_byId(IPF_IP_ADDRESS, "10.1.253.100");
        clickButtonAdd();
        
        //Check successful Add
        checkText("10.1.253.100");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySecurityIPAddressCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		//Go to SNORT tab
        clickButton(TB_SNORT);
        
        //Verify successful Add
        checkText("10.1.253.100");  
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}

	@Test (priority = 2)
	public void securityDeleteIPAddress() throws InterruptedException {
		
		
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to SNORT
        clickButton(TB_SNORT);
           	
        //Delete White List IP Address
        clickCheckbox_byText("10.1.253.100");
        clickButtonDelete();
        
        //Check successful Deletion
        checkText_NotVisible("10.1.253.100");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifySecurityIPAddressDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSecurity();
		updateMap(RETRIES);
		
		//Go to SNORT tab
        clickButton(TB_SNORT);
        
        //Verify successful Deletion
        checkText_NotVisible("10.1.253.100");  
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}