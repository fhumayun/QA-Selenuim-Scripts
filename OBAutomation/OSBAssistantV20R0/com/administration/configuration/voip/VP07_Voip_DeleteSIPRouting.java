package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP07_Voip_DeleteSIPRouting extends SuperHelper implements PropertiesVoip {

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
	public void voipDeleteOneSIPRouting() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
        
        //Delete one SIP manipulation
        clickCheckbox_byText("55.65.75.85");
        clickButtonDelete();
        
	    //Check SIP Routing Deletion
        checkText_NotVisible("55.65.75.85");
        
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	@Test (priority = 1)
	public void verifyVoipOneSIPRoutingDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
		
		//Verify SIP Routing Deletion
        checkText_NotVisible("55.65.75.85");
      
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipDeleteMoreSIPRouting() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
        
        //Delete All SIP Routing
        clickCheckbox_All();
        clickButtonDelete();
        
	    //Check SIP Routings Deletion
        checkText_NotVisible("10.20.30.40");
        checkText_NotVisible("90.100.110.120");
		
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyVoipMoreSIPRoutingDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_ROUTING);
        updateMap(RETRIES);
		
		//Verify SIP Routings Deletion
        checkText_NotVisible("10.20.30.40");
        checkText_NotVisible("90.100.110.120");
      
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}	

}