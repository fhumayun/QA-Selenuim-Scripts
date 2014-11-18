package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD01_GUIElemets_DefaultValues extends SuperHelper implements PropertiesACD {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	@Test (priority = 0)
	public void acdCheckDefaultValues() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		checkStatus(IPF_LOG_ON_SERVICE_ACCESS_CODE,"enabled","Input Field Log On Service Access Code");
		checkValue_byId(IPF_LOG_ON_SERVICE_ACCESS_CODE, "21");
		
		checkStatus(IPF_LOG_OFF_SERVICE_ACCESS_CODE,"enabled","Input Field Log Off Service Access Code");
		checkValue_byId(IPF_LOG_OFF_SERVICE_ACCESS_CODE, "22");
		
		checkStatus(IPF_AGENT_TIMEOUT,"enabled","Input Field Timeout");
		checkValue_byId(IPF_AGENT_TIMEOUT, "30");
		
		checkStatus(CB_SUPPORT_KEYSET_TOGGLE_KEY,"enabled","Checbox Support Keyset Toggle Key");
		checkStatus(CB_SUPPORT_KEYSET_TOGGLE_KEY,"unchecked","Checbox Support Keyset Toggle Key");
		
		checkStatus(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE,"disabled","Input Field Keyset Toggle Service access code");
		checkValue_byId(IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE, "");
		
		checkStatus(BTN_SHOW_STATUS,"enabled","Button Status");
		
		checkStatus(BTN_CONFIGURE_MUSIC_ON_HOLD,"enabled","Button Music on Hold");
		
		checkStatus(BTN_CONFIGURE_ANNOUNCEMENT,"enabled","Button Announcement");
		
		//Queue tab
		clickButton(TB_QUEUE);
		
        checkStatus(BTN_ADD_QUEUE,"enabled","Button Add Queue");
		
		checkStatus(BTN_EDIT_QUEUE,"disabled","Button Edit Queue");
		
		checkStatus(BTN_DELETE_QUEUE,"disabled","Button Delete Queue");
		
        checkStatus(BTN_FILTER_QUEUE_GO,"enabled","Button Filter Queue Go");
		
		checkStatus(BTN_FILTER_QUEUE_CLEAR,"enabled","Button Filter Queue Glear");
		
		checkStatus(IPF_FILTER_QUEUE,"enabled","Input Field Filter Queue");
		checkValue_byId(IPF_FILTER_QUEUE, "");
		
		String[] filterQueue_Options = {TXT_QUEUE_NAME,TXT_QUEUE_DID};
		checkSelectedValue_inDropDownList(SLC_FILTER_QUEUE, TXT_QUEUE_NAME);
		checkStatus(SLC_FILTER_QUEUE, "enabled", "Drop Down list Filter Queue");
		getPossibleValuesOfDropDown(SLC_FILTER_QUEUE, filterQueue_Options);
	
		
		//Profiles tab
		clickButton(TB_PROFILES);
		
        checkStatus(BTN_ADD_PROFILE,"enabled","Button Add Profile");
		
		checkStatus(BTN_EDIT_PROFILE,"disabled","Button Edit Profile");
		
		checkStatus(BTN_DELETE_PROFILE,"disabled","Button Delete Profile");
		
        checkStatus(BTN_FILTER_PROFILE_GO,"enabled","Button Filter Profile Go");
		
		checkStatus(BTN_FILTER_PROFILE_CLEAR,"enabled","Button Filter Profile Glear");
		
		checkStatus(IPF_FILTER_PROFILE,"enabled","Input Field Filter Profile");
		checkValue_byId(IPF_FILTER_PROFILE, "");
	
		
		//Agent tab
		clickButton(TB_AGENTS);
		
        checkStatus(BTN_ADD_AGENT,"enabled","Button Add Agent");
		
		checkStatus(BTN_EDIT_AGENT,"disabled","Button Edit Agent");
		
		checkStatus(BTN_DELETE_AGENT,"disabled","Button Delete Agent");
		
        checkStatus(BTN_FILTER_AGENT_GO,"enabled","Button Filter Agent Go");
		
		checkStatus(BTN_FILTER_AGENT_CLEAR,"enabled","Button Filter Agent Glear");
		
		checkStatus(IPF_FILTER_AGENT,"enabled","Input Field Filter Agent");
		checkValue_byId(IPF_FILTER_AGENT, "");
		
		String[] filterAgent_Options = {TXT_AGENT_NAME,TXT_PROFILENAME};
		checkSelectedValue_inDropDownList(SLC_FILTER_AGENT, TXT_AGENT_NAME);
		checkStatus(SLC_FILTER_AGENT, "enabled", "Drop Down list Filter Agent");
		getPossibleValuesOfDropDown(SLC_FILTER_AGENT, filterAgent_Options);
	
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	
}