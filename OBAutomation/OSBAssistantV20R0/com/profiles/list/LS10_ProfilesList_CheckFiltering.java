package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS10_ProfilesList_CheckFiltering extends SuperHelper implements PropertiesProfilesList {

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


	@Test (priority = 0)
	public void profilesListFilterByName() throws InterruptedException{
		
		classMethodLogger.log(); 
	
        //Filter by Profile Name
		selectFromDropDown(SLC_FILTER_PROFILE, TXT_NAME);
		type_byId(IPF_FILTER_PROFILE, "Profile200");
		clickButton(BTN_FILTER_PROFILE_GO);
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile200");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile100");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile300");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile11");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile22");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile33");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile44");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile55");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile66");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile77");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile88");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile99");
	
	    //Clear Filter
		clickButton(BTN_FILTER_PROFILE_CLEAR);
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile100");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile200");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile300");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile11");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile22");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile33");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile44");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile55");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile66");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile77");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile88");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile99");
		
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void profilesListFilterByMode() throws InterruptedException{
		
		methodLogger.log(); 

	    //Filter by Profile Mode
		selectFromDropDown(SLC_FILTER_PROFILE, TXT_PROFILE_MODE);
		
		String[] modeOptions = {TXT_BRANCH_SBC,TXT_SBC_PROXY,TXT_PROXY,TXT_PROXY_ACD};
		  
		getPossibleValuesOfDropDown(SLC_FILTER_PROFILE_MODE, modeOptions);
	    
		selectFromDropDown(SLC_FILTER_PROFILE_MODE, TXT_PROXY_ACD);
		clickButton(BTN_FILTER_PROFILE_GO);
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile100");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile200");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile300");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile11");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile22");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile33");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile44");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile55");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile66");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile77");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile88");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile99");
	
	    //Clear Filter
		clickButton(BTN_FILTER_PROFILE_CLEAR);
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile100");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile200");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile300");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile11");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile22");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile33");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile44");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile55");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile66");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile77");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile88");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile99");
		
		setMethodState();
	
	}
	
	@Test (priority = 2)
	public void profilesListFilterByVersion() throws InterruptedException{
		
		methodLogger.log(); 

	    //Filter by Profile Version
		selectFromDropDown(SLC_FILTER_PROFILE, TXT_VERSION);
		
		String[] versionOptions ={"V1.R31","V1.R4","V1.R41","V2.R0"};
		  
		getPossibleValuesOfDropDown(SLC_FILTER_PROFILE_VERSION, versionOptions);
	    
		selectFromDropDown(SLC_FILTER_PROFILE_VERSION, "V2.R0");
		clickButton(BTN_FILTER_PROFILE_GO);
	
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile300");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile33");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile66");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile99");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile100");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile200");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile11");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile22");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile44");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile55");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile77");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile88");
		
	
	    //Clear Filter
		clickButton(BTN_FILTER_PROFILE_CLEAR);
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile100");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile200");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile300");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile11");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile22");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile33");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile44");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile55");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile66");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile77");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile88");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile99");
		
		setMethodState();
	
	}
	
}