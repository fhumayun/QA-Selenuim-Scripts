package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP30_Voip_DeleteSIPServiceProviderProfile extends SuperHelper implements PropertiesVoip {

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
	public void voipDeleteOneSIPServiceProviderProfile() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Delete SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider2");
        clickButtonDelete();
          
	    //Check SIP Service Provider Profile Deletion
        checkText_NotVisible("AutoProvider2");
        
		clickButtonSave();
		updateMap(RETRIES);
		
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	
	@Test (priority = 1)
	public void verifyVoipOneSIPServiceProviderProfileDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
        //Verify SIP Service Provider Profile Deletion
        checkText_NotVisible("AutoProvider2");
       
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}	

	@Test (priority = 2)
	public void voipDeleteMoreSIPServiceProviderProfile() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Delete All SIP Service Provider Profiles
        clickCheckbox_All();
        clickButtonDelete();
         
        //Check SIP Service Provider Profiles Deletion
        checkText_NotVisible("AutoProvider1");
        checkText_NotVisible("AutoProvider3");
        checkText_NotVisible("AutoProvider4");
        
		clickButtonSave();
		updateMap(RETRIES);
		
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 3)
	public void verifyVoipMoreSIPServiceProviderProfilesDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
        //Verify SIP Service Provider Profiles Deletion
        checkText_NotVisible("AutoProvider1");
        checkText_NotVisible("AutoProvider3");
        checkText_NotVisible("AutoProvider4");
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}	
}