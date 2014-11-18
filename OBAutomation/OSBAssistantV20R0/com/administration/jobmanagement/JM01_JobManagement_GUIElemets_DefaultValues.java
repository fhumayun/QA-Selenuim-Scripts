package com.administration.jobmanagement;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;
import java.util.Calendar;

public class JM01_JobManagement_GUIElemets_DefaultValues extends SuperHelper implements PropertiesJobManagement {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToJobManagement();
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
	public void jobManagement_CheckDefaultValues() throws InterruptedException {
		
		//Main page
		classMethodLogger.log(); 
		
		Calendar cal = Calendar.getInstance();
    	int month = cal.get(Calendar.MONTH) + 1;
    	int day = cal.get(Calendar.DATE);
    	int year = cal.get(Calendar.YEAR);
    	String date = String.valueOf(month)+ "/" + String.valueOf(day)+ "/" +String.valueOf(year).substring(2);
    
		
		String[] filterOptions = {TXT_START_DATE,TXT_JOB_ID,TXT_STATUS,TXT_ACTION,TXT_NOTE};
		String[] itemsPerPageOptions = {"10","20","50","100","200"};
		String[] jobActionOptions = {TXT_TRANSFER,TXT_ACTIVATION,TXT_TRANSFER_WAV_FILES,TXT_ASSIGN_PROFILE};
		
	    checkStatus(BTN_ADD_JOB,"enabled","Button Add Job");
    	
    	checkStatus(BTN_EDIT_JOB,"disabled","Button Edit Job");
    	
    	checkStatus(BTN_DELETE_JOB,"disabled","Button Delete Job");
    	
    	checkStatus(BTN_CLONE_JOB,"disabled","Button Clone profile");
    
        checkStatus(BTN_CANCEL_JOB,"disabled","Button Cancel Job");
    	
    	checkStatus(BTN_VIEW_DETAILED_STATUS_JOB,"disabled","Button View");
    	
        checkStatus(BTN_APPLY_FILTER_JOB,"enabled","Button Start Filter Jobs");
    	
    	checkStatus(BTN_CLEAR_FILTER_JOB,"enabled","Button Clear Filter Jobs");
   
    	checkStatus(IPF_FILTER_JOB_START_DATE,"disabled","Input Field Filter Job");
    	checkValue_byId(IPF_FILTER_JOB_START_DATE, "");
    	
    	checkStatus(SLC_JOB_FILTER_OPTIONS,"enabled","Drop-Down Filter Jobs");
    	checkSelectedValue_inDropDownList(SLC_JOB_FILTER_OPTIONS, TXT_START_DATE);
    	getPossibleValuesOfDropDown(SLC_JOB_FILTER_OPTIONS, filterOptions);
    
    	checkStatus(SLC_ITEMS_PER_PAGE_MAIN_LIST,"enabled","Drop-Down Filter Jobs");
    	checkSelectedValue_inDropDownList(SLC_ITEMS_PER_PAGE_MAIN_LIST, "10");
    	getPossibleValuesOfDropDown(SLC_ITEMS_PER_PAGE_MAIN_LIST, itemsPerPageOptions);
 
    
    	//Add Schedule pop-up
    	clickButtonAdd();
    	updateMap(RETRIES);
    	
    	checkStatus(SLC_JOB_ACTION,"enabled","Drop-Down List Job Action");
    	checkSelectedValue_inDropDownList(SLC_JOB_ACTION, TXT_TRANSFER);
    	getPossibleValuesOfDropDown(SLC_JOB_ACTION, jobActionOptions);
    	
    	checkStatus(IPF_ACTION_INPUT,"enabled","Input Field Target Version");
    	checkValue_byId(IPF_ACTION_INPUT, "");
    	
    	checkStatus(BTN_SELECT_ACTION_INPUT,"enabled","Button Target Version");
    	
    	checkStatus(IPF_NOTE,"enabled","Input Field Note");
    	checkValue_byId(IPF_NOTE, "");
    	
    	checkStatus(By.xpath(RB_IMMEDIATE), "enabled", "Radio Button Immediate");
    	checkStatus(By.xpath(RB_IMMEDIATE), "checked", "Radio Button Immediate");
    	checkStatus(By.xpath(RB_DATE), "enabled", "Radio Button Date");
    	checkStatus(By.xpath(RB_DATE), "unchecked", "Radio Button Date");
    	
    	checkStatus(IPF_JOB_DATE,"disabled","Input Field Date");
    	checkValue_byId(IPF_JOB_DATE, date);
    	
    	checkStatus(IPF_JOB_TIME_HOUR,"enabled","Input Field Time Hour");
    	checkStatus(IPF_JOB_TIME_MINUTE,"enabled","Input Field Time Minute");
    	
    	checkStatus(SLC_ITEMS_PER_PAGE_NODES_LIST,"enabled","Drop-Down Filter Jobs");
    	checkSelectedValue_inDropDownList(SLC_ITEMS_PER_PAGE_NODES_LIST, "10");
    	getPossibleValuesOfDropDown(SLC_ITEMS_PER_PAGE_NODES_LIST, itemsPerPageOptions);

    	checkStatus(BTN_ADD_NODE,"enabled","Button Add Node");
    	checkStatus(BTN_DELETE_NODE,"disabled","Button Add Node");
    	
    	clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}

}