package com.administration.overview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class OV06_BranchOfficeList_Filtering extends SuperHelper implements PropertiesOverview {

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
	public void filterByBranchOffice() throws InterruptedException {
		
		classMethodLogger.log(); 
		
	    selectFromDropDown(SLC_FILTER_OPTIONS, TXT_BRANCH_OFFICE);
	    
	    type_byId(IPF_FILTER_MAIN_LIST, "OB2LAN");
	    
	    clickButton(BTN_APPLY_FILTER_OSB);
	    
	    waitForPageToLoad("10000");
	    
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB2LAN");
	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST, "OB1LAN");
	    
	    clickButton(BTN_CLEAR_FILTER_OSB);
	    
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB2LAN");
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB1LAN");
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB3WAN");
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB4WANPRI");
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB5WANFXO");
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB6WANBRI");
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB8LANCSBC");
	    
	    setMethodState();

	    
	  }
	
	@Test (priority = 1)
	public void filterByIPAddress() throws InterruptedException {
		
		methodLogger.log(); 
		
	    selectFromDropDown(SLC_FILTER_OPTIONS, TXT_IP_ADDRESS);
	    
	    type_byId(IPF_FILTER_MAIN_LIST, "192.168.108.4");
	    
	    clickButton(BTN_APPLY_FILTER_OSB);
	    
	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB2LAN");
	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB1LAN");
	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB3WAN");
	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB4WANPRI");
	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB5WANFXO");
	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB6WANBRI");
	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB8LANCSBC");
	    
	    clickButton(BTN_CLEAR_FILTER_OSB);
	    
	    setMethodState();
	  }
	
//	@Test (priority = 2)
//	public void filterByMode() throws InterruptedException {
//		
//		methodLogger.log(); 
//		
//	    selectFromDropDown(SLC_FILTER_OPTIONS, TXT_MODE);
//	    
//	    selectFromDropDown(SLC_FILTER_OPTIONS_MODE, "Proxy");
//	    
//	    clickButton(BTN_APPLY_FILTER_OSB);
//	    
//	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB2LAN");
//	    checkTextIsContained_byID(TBL_BRANCH_OFFICE_LIST,"OB1LAN");
//	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB3WAN");
//	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB4WANPRI");
//	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB5WANFXO");
//	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB6WANBRI");
//	    checkTextIsNotContained_byId(TBL_BRANCH_OFFICE_LIST,"OB8LANCSBC");
//	    
//	    clickButton(BTN_CLEAR_FILTER_OSB);
//	    
//	    setMethodState();
//	  }
}