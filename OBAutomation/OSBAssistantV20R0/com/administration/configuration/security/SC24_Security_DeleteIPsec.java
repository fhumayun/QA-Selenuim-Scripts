package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC24_Security_DeleteIPsec extends SuperHelper implements PropertiesSecurity {

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
	public void securityDeleteIPsec() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab IPsec
        clickButton(TB_IPsec);
          
        //Delete IPsec
    	clickCheckbox_byText("AutoNewIPsec");
    	clickButtonDelete();
       	
    	//Check IPsec deletion
    	checkText_NotVisible("AutoNewIPsec");
    	    
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	

	@Test (priority = 1)
	public void verifySecurityIPsecDeletion() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab IPsec
        clickButton(TB_IPsec);
         
        //Verify IPsec deletion
        checkText_NotVisible("AutoNewIPsec");
        
        clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

}