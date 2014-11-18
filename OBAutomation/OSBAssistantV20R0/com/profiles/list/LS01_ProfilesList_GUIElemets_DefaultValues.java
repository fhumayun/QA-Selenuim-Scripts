package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS01_ProfilesList_GUIElemets_DefaultValues extends SuperHelper implements PropertiesProfilesList {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToProfilesList();
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
	public void profilesList_CheckDefaultValues() throws InterruptedException {
		
		//Main page
		classMethodLogger.log(); 
		String[] modeOptions = {TXT_BRANCH_SBC,TXT_SBC_PROXY,TXT_PROXY,TXT_PROXY_ACD};
	    String[] versionOptions ={"V1.R31","V1.R4","V1.R41","V2.R0"};
		String[] filterOprions = {TXT_NAME,TXT_PROFILE_MODE,TXT_PROFILE_VERSION};
		String[] itemsPerPageOprions = {"10","20","50","100","200"};
		
	    checkStatus(BTN_ADD_PROFILE,"enabled","Button Add Profile");
    	
    	checkStatus(BTN_EDIT_PROFILE,"disabled","Button Edit Profile");
    	
    	checkStatus(BTN_DELETE_PROFILE,"disabled","Button Delete Profile");
    	
    	checkStatus(BTN_CLONE_PROFILE,"disabled","Button Clone profile");
    
        checkStatus(BTN_FILTER_PROFILE_GO,"enabled","Button Start Filter Profiles");
    	
    	checkStatus(BTN_FILTER_PROFILE_CLEAR,"enabled","Button Clear Filter Profiles");
   
    	checkStatus(IPF_FILTER_PROFILE,"enabled","Input Field Filter Profile");
    	checkValue_byId(IPF_FILTER_PROFILE, "");
    	
    	checkStatus(SLC_FILTER_PROFILE,"enabled","Drop-Down Filter Profiles");
    	checkSelectedValue_inDropDownList(SLC_FILTER_PROFILE, TXT_NAME);
    	getPossibleValuesOfDropDown(SLC_FILTER_PROFILE, filterOprions);
    
    	checkStatus(SLC_ITEMS_PER_PAGE,"enabled","Drop-Down Filter Profiles");
    	checkSelectedValue_inDropDownList(SLC_ITEMS_PER_PAGE, "10");
    	getPossibleValuesOfDropDown(SLC_ITEMS_PER_PAGE, itemsPerPageOprions);
 
    	if(!selenium.getSelectedLabel(SLC_ITEMS_PER_PAGE).equals("10"))
    	{
    		selectFromDropDown(SLC_ITEMS_PER_PAGE, "10");
    	}
    	//Add profile pop-up
    	clickButtonAdd();
    	updateMap(RETRIES);
    	
    	checkStatus(IPF_PROFILE_NAME,"enabled","Input Field Profile Name");
    	checkValue_byId(IPF_PROFILE_NAME, "");
    	
    	checkStatus(SLC_MODE,"enabled","Drop-Down List Mode");
    	checkSelectedValue_inDropDownList(SLC_MODE, TXT_BRANCH_SBC);
    	getPossibleValuesOfDropDown(SLC_MODE, modeOptions);

    	checkStatus(SLC_VERSION,"enabled","Drop-Down List OpenBranch Version");
    	checkSelectedValue_inDropDownList(SLC_VERSION, "V1.R31");
    	getPossibleValuesOfDropDown(SLC_VERSION, versionOptions);
    
    	clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}

}