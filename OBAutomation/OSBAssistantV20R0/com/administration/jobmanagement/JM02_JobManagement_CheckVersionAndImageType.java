package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class JM02_JobManagement_CheckVersionAndImageType extends SuperHelper implements PropertiesJobManagement {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
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
	public void jobManagementCheckVersionAndImageType() throws InterruptedException {
		
		classMethodLogger.log(); 
		//First navigate to CMP and Retrieve the OpenScape Branch image version
		goToMaintenance();
		goToInventory();
		goToRepository();
		String imageVersion = getElementText_inSpecificTableColumn(TBL_CMP_LIST_REPOSITORIES, "OpenScape SBC V2 R0", TXT_PRODUCT_VERSION);
	  
		//Now verify that is the same with the one listed in the Target version pop-up of the Job Management
		goToOpenScapeBranch();
	    goToJobManagement();
	    
	    clickButtonAdd();
	    updateMap(RETRIES);
	    
	    clickButton(BTN_SELECT_ACTION_INPUT);
	    updateMap(RETRIES);
	    checkText(imageVersion);
	    
	    clickButtonCancel();
	    updateMap(RETRIES);
	    
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}

}