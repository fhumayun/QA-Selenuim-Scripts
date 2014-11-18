package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP03_Voip_EditSIPManipulation extends SuperHelper implements PropertiesVoip {

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
	public void voipModifySIPManipulation() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_MANIPULATION);
        updateMap(RETRIES);
        
        //Edit SIP manipulation and modify fields
        clickCheckbox_byText("2000");
        clickButtonEdit();
		updateMap(RETRIES);
        
        type_byId(IPF_MATCH_DIGITS, "2001");
        type_byId(IPF_MATCH_POSITION, "1");
        selectFromDropDown(SLC_HEADER, TXT_DIVERSION);
        type_byId(IPF_DELETE_INSERT_POSITION, "20");
        type_byId(IPF_NUMBER_OF_DIGITS_TO_DELETE, "23");
        type_byId(IPF_INSERT_DIGITS, "3");
        type_byId(IPF_ADD_PREFIX, "2");
        type_byId(IPF_REPLACE_ALL_WITH, "4");
        selectFromDropDown(SLC_CALL_TYPE, TXT_SIP_PSTN);
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check SIP Manipulation Modification
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_MANIPULATION, "2001");
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_MATCH_POSITION, "1");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_HEADER, TXT_DIVERSION);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_DELETE_INSERT_POSITION, "20");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_NUMBER_OF_DIGITS_TO_DELETE, "23");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_INSERT_DIGITS, "3");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_ADD_PREFIX, "2");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_REPLACE_ALL_WITH, "4");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_CALL_TYPE, TXT_SIP_PSTN);
	
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	@Test (priority = 1)
	public void verifyVoipSIPManipulationModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_MANIPULATION);
        updateMap(RETRIES);
		
		//Verify SIP Manipulation Modification
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_MANIPULATION, "2001");
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_MATCH_POSITION, "1");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_HEADER, TXT_DIVERSION);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_DELETE_INSERT_POSITION, "20");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_NUMBER_OF_DIGITS_TO_DELETE, "23");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_INSERT_DIGITS, "3");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_ADD_PREFIX, "2");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_REPLACE_ALL_WITH, "4");
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_MANIPULATION, "2001", TXT_CALL_TYPE, TXT_SIP_PSTN);
	
		//Edit SIP manipulation and Verify fields
		clickCheckbox_byText("2001");
		clickButtonEdit();
		updateMap(RETRIES);
		checkValue_byId(IPF_MATCH_DIGITS, "2001");
		checkValue_byId(IPF_MATCH_POSITION, "1");
	    checkSelectedValue_inDropDownList(SLC_HEADER, TXT_DIVERSION);
	    checkValue_byId(IPF_DELETE_INSERT_POSITION, "20");
	    checkValue_byId(IPF_NUMBER_OF_DIGITS_TO_DELETE, "23");
	    checkValue_byId(IPF_INSERT_DIGITS, "3");
	    checkValue_byId(IPF_ADD_PREFIX, "2");
	    checkValue_byId(IPF_REPLACE_ALL_WITH, "4");
	    checkSelectedValue_inDropDownList(SLC_CALL_TYPE, TXT_SIP_PSTN);
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}	

}