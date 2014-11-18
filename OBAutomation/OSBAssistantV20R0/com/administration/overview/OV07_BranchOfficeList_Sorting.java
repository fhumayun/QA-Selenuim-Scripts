package com.administration.overview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class OV07_BranchOfficeList_Sorting extends SuperHelper implements PropertiesOverview {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToBranchOfficeList()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
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
	public void checkSorting() throws InterruptedException {
		
		classMethodLogger.log(); 
		
	    checkSorting(TXT_BRANCH_OFFICE);
	    checkSorting(TXT_IP_ADDRESS);
	    checkSorting(TXT_VERSION);
	    checkSorting(TXT_STATUS);
	    checkSorting(TXT_MODE);
	    checkSorting(TXT_LAST_UPDATE);
	    
	    selectFromDropDown(SLC_ITEMS_PER_PAGE_MAIN_LIST, "10");
	    setMethodState();

	    
	  }
	
}