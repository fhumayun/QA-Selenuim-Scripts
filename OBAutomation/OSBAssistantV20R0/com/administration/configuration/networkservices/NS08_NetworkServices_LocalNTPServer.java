package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS08_NetworkServices_LocalNTPServer extends SuperHelper implements PropertiesNetworkServices {

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
	public void networkServicesEnableNTP() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to NTP tab
        clickButton(TB_NTP);
        
        //Enable Local NTP
        clickCheckbox_byID(CB_ENABLE_LOCAL_NTP_SERVER);
        
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	
	@Test (priority = 1)
	public void verifyNetworkServicesNTPEnabling() throws InterruptedException {
			
		methodLogger.log(); 
		checkOBStatusAfterRestart(OpenBranch);
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to NTP tab
        clickButton(TB_NTP);
        
        //Verify NTP Enabling
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "enabled", "Checkbox Enable local NTP server");
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "checked", "Checkbox Enable local NTP server");
       
    	clickButtonCancel();
    	updateMap(RETRIES);;
		setMethodState();;
   
	}

	@Test (priority = 2)
	public void networkServicesDisableNTP() throws InterruptedException {
		
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to NTP tab
        clickButton(TB_NTP);
        
        //Disable Local NTP
        clickCheckbox_byID(CB_ENABLE_LOCAL_NTP_SERVER);
        
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	
	@Test (priority = 3)
	public void verifyNetworkServicesNTPDisabling() throws InterruptedException {
			
		methodLogger.log(); 
		checkOBStatusAfterRestart(OpenBranch);
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to NTP tab
        clickButton(TB_NTP);
        
        //Verify NTP Disabling
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "enabled", "Checkbox Enable local NTP server");
        checkStatus(CB_ENABLE_LOCAL_NTP_SERVER, "unchecked", "Checkbox Enable local NTP server");
       
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}

}