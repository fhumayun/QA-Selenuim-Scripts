package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV03_Survivability_EditMLHG extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityModifyMLHG() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab MLHG
		clickButton(TB_MULTI_LINE_HG);
		
		//Edit MLHG
		clickCheckbox_byText("2107778001");
		clickButton(BTN_MULTI_LINE_HG_EDIT);
		updateMap(RETRIES);
		
		clickCheckbox_byID(CB_MULTI_LINE_HG);
		
		type_byId(IPF_MULTI_LINE_HG_PILOT, "2109876543");
		selectFromDropDown(SLC_MULTI_LINE_HG_PILOT_TYPE, TXT_PILOT_TYPE_NON_PILOT);
		selectFromDropDown(SLC_MULTI_LINE_HG_PILOT_HUNT_TYPE, TXT_HUNT_TYPE_LINEAR);
		type_byId(IPF_MULTI_LINE_HG_NO_ANSWER, "1234");
		type_byId(IPF_MULTI_LINE_HG_OVERFLOW, "2103456789");
		type_byId(IPF_MULTI_LINE_HG_MEMBERS, "6");
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Modification
		checkText("2109876543");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_PILOT_TYPE, "Non pilot");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_HUNT_TYPE, "Linear");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_NO_ANSWER_TIMER, "1234");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", "Overflow Destination", "2103456789");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_MEMBERS, "6");
		
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityMLHGModification() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
        updateMap(RETRIES);
		
		//Select Tab MLHG
		clickButton(TB_MULTI_LINE_HG);
		
		//Verify MLHG modification 
		checkText("2109876543");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_PILOT_TYPE, "Non pilot");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_HUNT_TYPE, "Linear");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_NO_ANSWER_TIMER, "1234");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", "Overflow Destination", "2103456789");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2109876543", TXT_LIST_MLHG_MEMBERS, "6");
		
		//Edit MLHG and verify all fields
		clickCheckbox_byText("2109876543");
		clickButton(BTN_MULTI_LINE_HG_EDIT);
		updateMap(RETRIES);
		
		checkStatus(CB_MULTI_LINE_HG, "unchecked", "Checkbox");
		checkValue_byId(IPF_MULTI_LINE_HG_PILOT,"2109876543");
		checkSelectedValue_inDropDownList(SLC_MULTI_LINE_HG_PILOT_TYPE, TXT_PILOT_TYPE_NON_PILOT);
		checkSelectedValue_inDropDownList(SLC_MULTI_LINE_HG_PILOT_HUNT_TYPE, TXT_HUNT_TYPE_LINEAR);
		checkValue_byId(IPF_MULTI_LINE_HG_NO_ANSWER,"1234");
		checkValue_byId(IPF_MULTI_LINE_HG_OVERFLOW,"2103456789");
		checkValue_byId(IPF_MULTI_LINE_HG_MEMBERS,"6");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}