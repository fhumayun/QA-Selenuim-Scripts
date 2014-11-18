package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP19_Voip_BLSDeleteClient extends SuperHelper implements PropertiesVoip {

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
	public void voipDeleteOneBLSClient() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
       
        //Delete one BLS Client
		clickCheckbox_byText("AutoTunnel2");
		clickButtonDelete();
        
	    //Check BLS Client Deletion
        checkText_NotVisible("AutoTunnel2");
        
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	@Test (priority = 1)
	public void verifyVoipOneBLSClientDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
          
	    //Verify BLS Client Deletion
        checkText_NotVisible("AutoTunnel2");
      
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipDeleteMoreBLSClients() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
       
        //Delete All BLS Clients
        clickCheckbox_All();
        clickButtonDelete();
        
	    //Check BLS Clients Deletion
        checkText_NotVisible("AutoTunnel1");
        checkText_NotVisible("AutoTunnel33");
		
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyVoipMoreBLSClientsDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
       
        //Verify BLS Clients Deletion
        checkText_NotVisible("AutoTunnel1");
        checkText_NotVisible("AutoTunnel33");
		
      
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}	

}