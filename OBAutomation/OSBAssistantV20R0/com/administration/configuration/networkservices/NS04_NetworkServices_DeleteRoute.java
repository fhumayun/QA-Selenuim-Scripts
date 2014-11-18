package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS04_NetworkServices_DeleteRoute extends SuperHelper implements PropertiesNetworkServices {

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
	public void networkServicesDeleteRoute() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to Routing tab
        clickButton(TB_ROUTING);
        
        //Delete the Route
        clickCheckbox_byText("10.11.222.20");
        clickButtonDelete();
         
        //Check Route Deletion
        checkText_NotVisible("10.11.222.20");
        
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	
	@Test (priority = 1)
	public void verifyNetworkServicesRouteDeletion() throws InterruptedException {
			
		methodLogger.log(); 
		checkOBStatusAfterRestart(OpenBranch);
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to Routing tab
        clickButton(TB_ROUTING);
        
        //Verify Route Deletion
        checkText_NotVisible("10.11.222.20");

    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}


}