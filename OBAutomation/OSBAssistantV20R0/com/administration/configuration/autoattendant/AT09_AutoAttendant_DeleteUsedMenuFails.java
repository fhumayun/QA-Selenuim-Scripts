package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT09_AutoAttendant_DeleteUsedMenuFails extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantDeleteUsedMenuFails() throws InterruptedException {
		
		String[] menu = {"Auto1"};
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Menu tab
        clickButton(TB_MENUS);
       
        //Try to Delete a Menu that is used by a Routing
    	clickCheckbox_byText("1");
    	clickButtonDelete();
    
    	//The action fails
    	checkMessageFailed("OpenBranch\\OpenBranchGuiError", "common.menuInUse", menu);
   	
		updateMap(RETRIES);
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}


}