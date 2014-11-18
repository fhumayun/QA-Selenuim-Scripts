package com.administration.overview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class OV01_BranchOfficeList_GUIElemets_DefaultValues extends SuperHelper implements PropertiesOverview {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	@Test (priority = 0)
	public void branchOfficeList_CheckDefaultValues() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		String[] filterOptions = {TXT_BRANCH_OFFICE,TXT_BUSINESS_GROUP,TXT_IP_ADDRESS,TXT_VERSION,TXT_STATUS,TXT_MODE };
	            
		String[] itemsPerPage = {"10","20","50","100","200"};
		
		
		//Check Buttons Status
		checkStatus(BTN_ADD_OSB, "enabled", "Button ADD OSB");
		checkStatus(BTN_EDIT_OSB, "disabled", "Button Edit OSB");
		checkStatus(BTN_DELETE_OSB, "disabled", "Button Delete OSB");
		checkStatus(BTN_MANAGE_OSB, "disabled", "Button Manage OSB");
		checkStatus(BTN_LOCAL_PASSWORD_OSB, "disabled", "Button Local Password");
		checkStatus(BTN_REFRESH_SELECTED_OSB, "disabled", "Button Refresh Selected");
		checkStatus(BTN_REFRESH_ALL_OSB, "enabled", "Button Refresh All");
		checkStatus(BTN_APPLY_FILTER_OSB, "enabled", "Button Apply Filter");
		checkStatus(BTN_CLEAR_FILTER_OSB, "enabled", "Button Clear Filter");
		
		//Check selected option,status and all possible options in drop-down lists
		checkSelectedValue_inDropDownList(SLC_FILTER_OPTIONS, TXT_BRANCH_OFFICE);
		checkStatus(SLC_FILTER_OPTIONS, "enabled", "Drop Down list Filter Options");
		getPossibleValuesOfDropDown(SLC_FILTER_OPTIONS, filterOptions);
		
		checkSelectedValue_inDropDownList(SLC_ITEMS_PER_PAGE_MAIN_LIST,"10");
		checkStatus(SLC_ITEMS_PER_PAGE_MAIN_LIST, "enabled", "Drop Down list Items Per Page");
		getPossibleValuesOfDropDown(SLC_ITEMS_PER_PAGE_MAIN_LIST, itemsPerPage);
		
		//Check value and status in input fields
		checkValue_byId(IPF_FILTER_MAIN_LIST, "");
		
		
		checkStatus(IPF_FILTER_MAIN_LIST, "enabled", "Input Field Filter Main List");
		setMethodState();
	}
	
}