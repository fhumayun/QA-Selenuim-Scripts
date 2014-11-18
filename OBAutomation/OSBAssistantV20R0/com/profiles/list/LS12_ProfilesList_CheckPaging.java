package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS12_ProfilesList_CheckPaging extends SuperHelper implements PropertiesProfilesList {

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
	public void profilesListCheckPaging() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		//First check number of items in Profiles list
	    checkText_byId(TXT_NUMBER_OF_ITEMS_IN_LIST, "12");
	    
	    //Set items per page to 10
	    selectFromDropDown(SLC_ITEMS_PER_PAGE, "10");
	    
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
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile88");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile99");
	
	    //Switch to 2nd page through drop-down list
		selectFromDropDown(SLC_PAGING, "2");
		
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile100");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile200");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile300");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile11");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile22");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile33");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile44");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile55");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile66");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile77");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile88");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile99");
	
		 //Switch to 1st page through drop-down list
		selectFromDropDown(SLC_PAGING, "1");
		
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
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile88");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile99");
	
		
		//Switch to 2nd page through next page button
		clickButton_ByXpath(BTN_NEXT_PAGE);
		
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile100");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile200");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile300");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile11");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile22");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile33");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile44");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile55");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile66");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile77");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile88");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile99");
	
		//Switch to 1st page through previous page button
		clickButton_ByXpath(BTN_PREVIOUS_PAGE);
		
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
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile88");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile99");
	
		//Switch to 2nd page through last page button
		clickButton_ByXpath(BTN_LAST_PAGE);
		
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile100");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile200");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile300");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile11");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile22");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile33");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile44");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile55");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile66");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile77");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile88");
		checkTextIsContained_byID(TBL_LIST_PROFILES,"Profile99");
	
		//Switch to 1st page through first page button
		clickButton_ByXpath(BTN_FIRST_PAGE);
		
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
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile88");
		checkTextIsNotContained_byId(TBL_LIST_PROFILES,"Profile99");
	
	    setMethodState();

	    
	  }
	
}