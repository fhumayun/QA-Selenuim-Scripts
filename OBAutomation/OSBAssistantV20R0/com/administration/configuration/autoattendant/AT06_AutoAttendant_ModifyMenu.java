package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT06_AutoAttendant_ModifyMenu extends SuperHelper implements PropertiesAutoAttendant {

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

	
	@Test (priority = 0)
	public void autoAttendantModifyMenu() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Menus tab
        clickButton(TB_MENUS);
       
    	//Edit 2nd Menu and Modify fields
    	clickCheckbox_byText("2");
    	clickButtonEdit();
    	updateMap(RETRIES);
    
    	type_byId(IPF_MENU_NAME, "Auto22");
    	type_byId(IPF_MENU_TIME_OUT, "14");
    
    	//Select values from Drop-Down lists
        selectFromDropDown(SLC_DAY_START, TXT_WEDNESDAY);
        selectFromDropDown(SLC_DAY_STOP, TXT_WEDNESDAY);
        selectFromDropDown(SLC_TIME1_START_HOUR, "06");
        selectFromDropDown(SLC_TIME1_START_MINUTE, "11");
        selectFromDropDown(SLC_TIME1_STOP_HOUR, "09");
        selectFromDropDown(SLC_TIME1_STOP_MINUTE, "21");
        selectFromDropDown(SLC_TIME2_START_HOUR, "16");
        selectFromDropDown(SLC_TIME2_START_MINUTE, "31");
        selectFromDropDown(SLC_TIME2_STOP_HOUR, "19");
        selectFromDropDown(SLC_TIME2_STOP_MINUTE, "41");
        selectFromDropDown(SLC_DESTINATION_SELECTION_GREETING_FILE, "transfer.wav");
        selectFromDropDown(SLC_FAILURE_PROMPT_FILE, "transfer.wav");
        selectFromDropDown(SLC_DEFAULT_DESTINATION_PROMPT_FILE, "transfer.wav");
        selectFromDropDown(SLC_FINAL_PROMPT_FILE, "transfer.wav");
        selectFromDropDown(SLC_TRANSFER_PROMPT_FILE, "transfer.wav");
        selectFromDropDown(SLC_DIAL_METHOD, TXT_BOTH);
        
        //Enter value for Default Destination
        type_byId(IPF_MENU_DEFAULT_DESTINATION, "26");
        
    	clickButtonSave();     
	    updateMap(RETRIES);
	    
	    //Check Menu Creation
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_MENU_NAME, "Auto22");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_ACTIVATION_MODE, TXT_AUTOMATIC);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_START, TXT_WEDNESDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_STOP, TXT_WEDNESDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_START, "06:11");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_STOP, "09:21");
	    
    
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantMenuModification() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Menus tab
        clickButton(TB_MENUS);
       
        //Verify Menu Modification
        checkTextIsContained_byXPathTable(TBL_LIST_MENU, "2");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_MENU_NAME, "Auto22");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_ACTIVATION_MODE, TXT_AUTOMATIC);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_START, TXT_WEDNESDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_STOP, TXT_WEDNESDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_START, "06:11");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_STOP, "09:21");
	 
    	//Edit Menu and Verify fields
    	clickCheckbox_byText("2");
    	clickButtonEdit();
    	updateMap(RETRIES);
    	
        checkValue_byId(IPF_MENU_NAME, "Auto22");
        checkValue_byId(IPF_MENU_TIME_OUT, "14");
        checkSelectedValue_inDropDownList(SLC_ACTIVATION_MODE, TXT_AUTOMATIC);
        checkSelectedValue_inDropDownList(SLC_DAY_START, TXT_WEDNESDAY);
        checkSelectedValue_inDropDownList(SLC_DAY_STOP, TXT_WEDNESDAY);
        checkSelectedValue_inDropDownList(SLC_TIME1_START_HOUR, "06");
        checkSelectedValue_inDropDownList(SLC_TIME1_START_MINUTE, "11");
        checkSelectedValue_inDropDownList(SLC_TIME1_STOP_HOUR, "09");
        checkSelectedValue_inDropDownList(SLC_TIME1_STOP_MINUTE, "21");
        checkSelectedValue_inDropDownList(SLC_TIME2_START_HOUR, "16");
        checkSelectedValue_inDropDownList(SLC_TIME2_START_MINUTE, "31");
        checkSelectedValue_inDropDownList(SLC_TIME2_STOP_HOUR, "19");
        checkSelectedValue_inDropDownList(SLC_TIME2_STOP_MINUTE, "41");
        checkSelectedValue_inDropDownList(SLC_DESTINATION_SELECTION_GREETING_FILE, "transfer.wav");
        checkSelectedValue_inDropDownList(SLC_FAILURE_PROMPT_FILE, "transfer.wav");
        checkSelectedValue_inDropDownList(SLC_DEFAULT_DESTINATION_PROMPT_FILE, "transfer.wav");
        checkSelectedValue_inDropDownList(SLC_FINAL_PROMPT_FILE, "transfer.wav");
        checkSelectedValue_inDropDownList(SLC_TRANSFER_PROMPT_FILE, "transfer.wav");
        checkSelectedValue_inDropDownList(SLC_DIAL_METHOD, TXT_BOTH);
        checkValue_byId(IPF_MENU_DEFAULT_DESTINATION, "26");
	
	    clickButtonCancel();
	    updateMap(RETRIES);
	    clickCheckbox_byText("2");
	    
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}