package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP23_Voip_EditSIPServiceProviderProfile_AddSIP extends SuperHelper implements PropertiesVoip {

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

	@DataProvider(name = "SIPManipulationData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"1000","23",TXT_R_URI,"23","24","","","",TXT_ALL},
				 {"2000","0",TXT_FROM,"21","22","2","1","2",TXT_PSTN_SIP},
				 {"3000","10",TXT_P_ASSERTED_IDENTITY,"","","234","","",TXT_SIP_PSTN},
				 {"4000","0",TXT_P_PREFERRED_IDENTITY,"","","","432","",TXT_SIP_SIP},
		};	
	}
	
	
	@Test (priority = 0,dataProvider = "SIPManipulationData")
	public void voipEditSIPServiceProviderProfileAddSIP(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9) throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Edit SIP Service Provider Profile and Add SIP Manipulation(input From Data Provider)
        clickCheckbox_byText("AutoProvider4");
        clickButtonEdit();
        updateMap(RETRIES);
        
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
        clickButtonAdd();
        updateMap(RETRIES);
       
        type_byId(IPF_SSPP_MATCH_DIGITS, x1);
        type_byId(IPF_SSPP_MATCH_POSITION, x2);
        selectFromDropDown(SLC_SSPP_HEADER, x3);
        type_byId(IPF_SSPP_DELETE_INSERT_POSITION, x4);
        type_byId(IPF_SSPP_NUMBER_OF_DIGITS_TO_DELETE, x5);
        type_byId(IPF_SSPP_INSERT_DIGITS, x6);
        type_byId(IPF_SSPP_ADD_PREFIX, x7);
        type_byId(IPF_SSPP_REPLACE_ALL_WITH, x8);
        selectFromDropDown(SLC_SSPP_CALL_TYPE, x9);
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check SIP Manipulation Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_SSPP_MANIPULATION, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_MATCH_POSITION, x2);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_HEADER, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_DELETE_INSERT_POSITION, x4);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_NUMBER_OF_DIGITS_TO_DELETE, x5);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_INSERT_DIGITS, x6);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_ADD_PREFIX, x7);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_REPLACE_ALL_WITH, x8);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_CALL_TYPE, x9);
	
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
		
	}
	
	@Test (priority = 1)
	public void applyChanges() throws InterruptedException {
		methodLogger.log();
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 2,dataProvider = "SIPManipulationData")
	public void verifyVoipSIPServiceProviderProfileSIPCreation(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9) throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
        //Edit SIP Service Provider Profile and Verify SIP Manipulation Creation
        clickCheckbox_byText("AutoProvider4");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION);
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_SSPP_MANIPULATION, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_MATCH_POSITION, x2);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_HEADER, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_DELETE_INSERT_POSITION, x4);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_NUMBER_OF_DIGITS_TO_DELETE, x5);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_INSERT_DIGITS, x6);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_ADD_PREFIX, x7);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_REPLACE_ALL_WITH, x8);
		checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SSPP_MANIPULATION, x1, TXT_CALL_TYPE, x9);

		//Edit SIP Manipulation and Verify fields
		clickCheckbox_byText(x1);
		clickButton(BTN_MOVE_EDIT_SSPP_SIP_MANIPULATION);
		updateMap(RETRIES);
		checkValue_byId(IPF_SSPP_MATCH_DIGITS, x1);
		checkValue_byId(IPF_SSPP_MATCH_POSITION, x2);
	    checkSelectedValue_inDropDownList(SLC_SSPP_HEADER, x3);
	    checkValue_byId(IPF_SSPP_DELETE_INSERT_POSITION, x4);
	    checkValue_byId(IPF_SSPP_NUMBER_OF_DIGITS_TO_DELETE, x5);
	    checkValue_byId(IPF_SSPP_INSERT_DIGITS, x6);
	    checkValue_byId(IPF_SSPP_ADD_PREFIX, x7);
	    checkValue_byId(IPF_SSPP_REPLACE_ALL_WITH, x8);
	    checkSelectedValue_inDropDownList(SLC_SSPP_CALL_TYPE, x9);
	   
	    clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	
	}	

}