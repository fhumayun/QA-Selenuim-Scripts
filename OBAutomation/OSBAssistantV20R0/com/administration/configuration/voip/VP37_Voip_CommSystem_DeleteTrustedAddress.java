package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP37_Voip_CommSystem_DeleteTrustedAddress extends SuperHelper implements PropertiesVoip {

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
	public void voipDeleteOneTrustedAddress() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
        
        //Delete Trusted Address
        clickCheckbox_byText("10.1.252.15");
		clickButtonDelete();    
        
        //Check Trusted Address Deletion
        checkText_NotVisible("10.1.252.15");
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	@Test (priority = 1)
	public void verifyVoipOneTrustedAddressDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
		
		//Verify Trusted Address Deletion
        checkText_NotVisible("10.1.252.15");
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
	

	@Test (priority = 2)
	public void voipDeleteMoreTrustedAddresses() throws InterruptedException {
		
	    methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
        
        //Delete All Trusted Addresses
    	clickCheckbox_All();
		clickButtonDelete();    
        
        //Check Trusted Addresses Deletion
        checkText_NotVisible("www.test.com");
        checkText_NotVisible("172.25.2.93");
        
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 3)
	public void verifyVoipMoreTrustedAddressesDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
		
		//Verify Trusted Addresses Deletion
        checkText_NotVisible("www.test.com");
        checkText_NotVisible("172.25.2.93");
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
}