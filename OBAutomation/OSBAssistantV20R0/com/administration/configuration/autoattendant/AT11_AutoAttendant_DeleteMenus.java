package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT11_AutoAttendant_DeleteMenus extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantDeleteOneMenu() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Menus tab and Delete one Menu
        clickButton(TB_MENUS);
      
    	clickCheckbox_byText("Auto1");
    	clickButtonDelete();
        
    	//Check Menu Deletion
    	checkText_NotVisible("Auto1");
    	
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantOneMenuDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Menus tab
        clickButton(TB_MENUS);
        
    	//Verify Menu Deletion
    	checkText_NotVisible("Auto1");
    	
        clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
	
	@Test (priority = 2)
	public void autoAttendantDeleteMoreMenus() throws InterruptedException {
		
	     methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Menus tab and Delete 2 Menus
        clickButton(TB_MENUS);
      
    	clickCheckbox_All();
    	clickButtonDelete();
        
    	//Check Menus Deletion
    	checkText_NotVisible("Auto22");
    	checkText_NotVisible("Auto3");
    	
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 3)
	public void verifyAutoAttendantMoreMenusDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Menus tab
        clickButton(TB_MENUS);
        
    	//Verify Menus Deletion
    	checkText_NotVisible("Auto22");
    	checkText_NotVisible("Auto3");
    	
        clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}