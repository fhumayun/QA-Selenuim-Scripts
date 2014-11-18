package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC18_Security_DeletePortFW extends SuperHelper implements PropertiesSecurity {

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
	public void securityDeleteOnePortFW() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
        
        //Delete 1 Port FW
    	clickCheckbox_byText("10.11.72.100");
    	clickButtonDelete();
       	
    	//check Port FW deletion
    	checkText_NotVisible("10.11.72.100");
    	    
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	

	@Test (priority = 1)
	public void verifySecurityOnePortFWDeletion() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
         
        //Verify Port FW deletion
    	checkText_NotVisible("10.11.72.100");
        
        clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

	@Test (priority = 2)
	public void securityDeleteMorePortFW() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
        
        //Delete 2 Port FW
    	clickCheckbox_All();
    	clickButtonDelete();
       	
    	//check Port FW deletion
    	checkText_NotVisible("10.1.82.10");
    	checkText_NotVisible("10.1.92.10");
    	
    	//Disable Port FW
        if (getCheckboxStatus(CB_ENABLE_PORT_FW))
            clickCheckbox_byID(CB_ENABLE_PORT_FW);
       
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 3)
	public void verifySecurityMorePortFWDeletion() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
         
    	//Verify Port FW deletion
    	checkText_NotVisible("10.1.82.10");
    	checkText_NotVisible("10.1.92.10");
        
        //Verify Port FW Disabling
        checkStatus(CB_ENABLE_PORT_FW,"unchecked","Checkbox Enable Port Forwarding"); 
     
        clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}
}