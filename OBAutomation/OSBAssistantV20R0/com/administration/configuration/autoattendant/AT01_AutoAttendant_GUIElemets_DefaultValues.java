package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT01_AutoAttendant_GUIElemets_DefaultValues extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendant_CheckDefaultValues() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        clickButton(TB_GENERAL);
    	
        //Tabs status (in default status these tab are disabled)
        checkStatus(TB_ROUTING,"disabled","Tab Routing");
		checkStatus(TB_MENUS,"disabled","Tab Menus");
	
        //Check CheckBoxes status
		checkStatus(CB_ENABLE_AUTO_ATTENDANT,"enabled","Checkbox Enable Auto Attendant");
		checkStatus(CB_ENABLE_AUTO_ATTENDANT,"unchecked","Checkbox Enable Auto Attendant");
	
		//Check value and status in input fields
		checkStatus(IPF_DATE_INFO, "disabled", "Input Field Date");
		checkStatus(IPF_DAY_INFO, "disabled", "Input Field Day");
		checkStatus(IPF_TIME_INFO, "disabled", "Input Field Time");
		checkValue_byId(IPF_INTERDIGIT_TIMER, "5");
		checkStatus(IPF_INTERDIGIT_TIMER, "disabled", "Input Field Interdigit timer");
		checkValue_byId(IPF_WAIT_TO_GO_TO_MENU, "1");
		checkStatus(IPF_WAIT_TO_GO_TO_MENU, "disabled", "Input Field Wait to go to menu");
		checkValue_byId(IPF_RECORD_ACCESS_CODE, "*98");
		checkStatus(IPF_RECORD_ACCESS_CODE, "disabled", "Input Field Record access code");
		
		//Check default announcement list
		checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "connect-to-party.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "enter-num-to-call.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "goodbye.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "num-not-valid.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "transfer.wav");
		
        clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}

}