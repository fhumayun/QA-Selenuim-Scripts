package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD08_AddProfileFails extends SuperHelper implements PropertiesACD {

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
	public void acdAddProfileFails() throws InterruptedException {
		
		classMethodLogger.log(); 
		String[] argsValidation = {"TestProfile","Profile2"};
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profile tab
        clickButton(TB_PROFILES);
        
        clickButtonAdd();
        updateMap(RETRIES);
        
        //Create Profile with reverse Profile Numbers fails and DID Number
        type_byId(IPF_PROFILE_NAME, "TestProfile");
        type_byId(IPF_ASSIGNED_QUEUE_IDs, "2,1");
      
        clickButtonSave();
        checkMessageFailed("OpenBranch\\OpenBranchGuiError", "acdProfile.duplicateQueueIdsInProfile", argsValidation);
    	updateMap(RETRIES);
    	
    	//Check that the Profile is not created
    	checkText_NotVisible("TestProfile");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdProfileFailedCreation() throws InterruptedException {
		
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profile tab
        clickButton(TB_PROFILES);
   
    	//Verify that the Profile is not created
    	checkText_NotVisible("TestProfile");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
}