package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS07_NetworkServices_DeleteTrafficShaping extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesDeleteClassNotPossible() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		
		//Try to delete the parent Class without deleting the Child.
		clickCheckbox_byText("SFQ");
		clickButtonDelete();
		
		clickButtonSave();
		
		//The action fails
		checkMessageFailed("OpenBranch\\OpenBranchGuiError", "trafficShapingPopUp.parentClassIsRequired", null);
		
		updateMap(RETRIES);
	    clickButtonCancel();
	    updateMap(RETRIES);
		setMethodState();;
	}
	
	@Test (priority = 1)
	public void networkServicesDeleteClass() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		
		clickCheckbox_byText("SFQ");
		clickCheckbox_byText("None");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("SFQ");
		checkText_NotVisible("None");
		
		//Disable Traffic shaping 
		clickCheckbox_byID(CB_ENABLE_TRAFFIC);

		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 2)
	public void verifyNetworkServicesClassDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		
		//Verify Traffic Shaping Disabling
		checkStatus(CB_ENABLE_TRAFFIC,"enabled","Checkbox Enable Traffic"); 
	    checkStatus(CB_ENABLE_TRAFFIC,"unchecked","Checkbox Enable Traffic"); 
	    
		//Verify Deletion
		checkText_NotVisible("SFQ");
		checkText_NotVisible("None");
		
	    clickButtonCancel();
	    updateMap(RETRIES);
		setMethodState();
	}
}