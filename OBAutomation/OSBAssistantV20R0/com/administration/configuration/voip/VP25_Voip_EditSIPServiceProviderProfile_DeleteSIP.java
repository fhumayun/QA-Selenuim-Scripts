package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP25_Voip_EditSIPServiceProviderProfile_DeleteSIP extends SuperHelper implements PropertiesVoip {

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
	public void voipEditSIPServiceProviderProfileDeleteOneSIP() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider4");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
       
        //Delete one SIP manipulation
        clickCheckbox_byText("2001");
        clickButtonDelete();
        
	    //Check SIP Manipulation Deletion
        checkText_NotVisible("2001");
        
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	
	@Test (priority = 1)
	public void verifyVoipSIPServiceProviderProfileOneSIPDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider4");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
        
        //Verify SIP Manipulation Deletion
        checkText_NotVisible("2001");
        
	    clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}	

	@Test (priority = 2)
	public void voipEditSIPServiceProviderProfileDeleteMoreSIP() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider4");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
       
        //Delete All SIP Manipulation
        clickCheckbox_All();
        clickButtonDelete();
        
	    //Check SIP Manipulations Deletion
        checkText_NotVisible("1000");
        checkText_NotVisible("3000");
        checkText_NotVisible("4000");
        
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 3)
	public void verifyVoipSIPServiceProviderProfileMoreSIPDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
        //Edit SIP Service Provider Profile
        clickCheckbox_byText("AutoProvider4");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
        
        //Verify SIP Manipulations Deletion
        checkText_NotVisible("1000");
        checkText_NotVisible("3000");
        checkText_NotVisible("4000");   
	   
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}	
}