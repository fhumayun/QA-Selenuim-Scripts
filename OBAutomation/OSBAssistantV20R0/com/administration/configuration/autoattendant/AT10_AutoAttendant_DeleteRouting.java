package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT10_AutoAttendant_DeleteRouting extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantDeleteRouting() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Routing tab and Delete Routing
        clickButton(TB_ROUTING);
      
    	clickCheckbox_byText("AutoRoutingNew");
    	clickButtonDelete();
        
    	//Check Routing Deletion
    	checkText_NotVisible("AutoRoutingNew");
    	
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantRoutingDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Routing tab
        clickButton(TB_ROUTING);
        
    	//Verify Routing Deletion
    	checkText_NotVisible("AutoRoutingNew");
    	
        clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}