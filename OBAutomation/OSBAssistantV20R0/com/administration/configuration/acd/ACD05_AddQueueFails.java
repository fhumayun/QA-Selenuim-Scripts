package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD05_AddQueueFails extends SuperHelper implements PropertiesACD {

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
	public void acdAddQueueSameOverflowAndDIDFails() throws InterruptedException {
		
		classMethodLogger.log(); 
	    String[] number = {"123"};
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        clickButtonAdd();
        updateMap(RETRIES);
        
  
        //Create Queue with same Destination and DID Number
        clickButton(TB_QUEUE_GENERAL);
        type_byId(IPF_QUEUE_NAME, "TestQueue");
        type_byId(IPF_QUEUE_DESTINATION, "123");
      
        //Queue DID tab
        clickButton(TB_QUEUE_DID);
        type_byId(IPF_QUEUE_DID, "123");
        
        clickButtonAdd();

        selenium.windowMaximize();
        
        clickButtonSave();
        checkMessageFailed("OpenBranch\\OpenBranchGuiError", "acdQueue.didMustNotEqualToOverflow", number);
    	updateMap(RETRIES);
    	
    	//Check that the Queue is not created
    	checkText_NotVisible("TestQueue");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdQueueFailedCreation() throws InterruptedException {
		
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        clickButtonAdd();
        updateMap(RETRIES);
        
        clickButton(TB_QUEUE_GENERAL);
      
    	//Verify that the Queue is not created
    	checkText_NotVisible("TestQueue");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
}