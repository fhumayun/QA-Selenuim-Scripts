package com.administration.overview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class OV04_BranchOfficeList_createCentralSBC extends SuperHelper implements PropertiesOverview {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToBranchOfficeList()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
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
	public void createCentralSBC() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		if (!selenium.isTextPresent("OB8LANCSBC")){	
			
			clickButtonAdd();
			updateMap(RETRIES);
			
			//Check Input Fields status in Add Central SBC window
			checkStatus(IPF_CENTRAL_SBC_NAME, "disabled", "Input Field Central SBC Name");
			checkStatus(IPF_CENTRAL_SBC_IP_ADDRESS, "disabled", "Input Field IP Address");
			checkStatus(IPF_CENTRAL_SBC_COMM_SYSTEM, "enabled", "Input Field Comm System");
			checkStatus(IPF_CENTRAL_SBC_BG, "enabled", "Input Field Business Group");
			checkStatus(IPF_CENTRAL_SBC_ENDPOINT, "enabled", "Input Field Endpoint");
		
		    //Select Comm System
			clickButton(BTN_SELECT_COMM_SYSTEM);
			updateMap(RETRIES);
			clickRadioButton_byText("adsa122s");
			clickButtonOk();
			updateMap(RETRIES);
			
			//Check Input Field Comm System
			checkValue_byId(IPF_CENTRAL_SBC_COMM_SYSTEM, "adsa122s");
			
		    //Select BG
			clickButton(BTN_SELECT_BG);
			updateMap(RETRIES);
			clickRadioButton_byText("OpenBranch");
			clickButtonOk();
			updateMap(RETRIES);
			
			//Check Input Field Business Group
			checkValue_byId(IPF_CENTRAL_SBC_BG, "OpenBranch");
			
			
			//Select Endpoint
			clickButton(BTN_SELECT_ENDPOINT);
			updateMap(RETRIES);
			clickRadioButton_byText("OB8LANCSBC");
			clickButtonOk();
			updateMap(RETRIES);
			
			//Check Input Field Endpoint,Central SBC Name and IP Address
			checkValue_byId(IPF_CENTRAL_SBC_ENDPOINT, "OB8LANCSBC");
			checkValue_byId(IPF_CENTRAL_SBC_NAME, "OB8LANCSBC");
			checkValue_byId(IPF_CENTRAL_SBC_IP_ADDRESS, "10.19.2.2");
	
		    clickButtonSave();
		    updateMap(RETRIES);
		    
		    //Check Central SBC creation
		    checkTextIsContained_byXPathTable(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC");
		    
		    clickCheckbox_byText("OB8LANCSBC");
		    clickButton(BTN_REFRESH_SELECTED_OSB);
		    
		    //Check Column values in Main List
		    checkElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_IP_ADDRESS, "10.19.2.2");
		    checkElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_COMM_SYSTEM, "adsa122s");
		    checkElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_BUSINESS_GROUP, "OpenBranch");
//		    checkElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_VERSION, "V2R0.01.0 Build 2");
//		    checkElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_STATUS, "Normal");
		    checkElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_MODE, "Central SBC");
		} 
		else{
			
			MyLogger.resultInfo("The Central SBC Branch is already created");
		}
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyCentralSBCCreation() throws InterruptedException {
		
		     methodLogger.log(); 
	
	        clickCheckbox_byText("OB8LANCSBC");
			clickButtonEdit();
			updateMap(RETRIES);
			
			//Verify Input Fields values and status in Edit Central SBC window
			checkStatus(IPF_CENTRAL_SBC_NAME, "disabled", "Input Field Central SBC Name");
			checkStatus(IPF_CENTRAL_SBC_IP_ADDRESS, "disabled", "Input Field IP Address");
			checkStatus(IPF_CENTRAL_SBC_COMM_SYSTEM, "enabled", "Input Field Comm System");
			checkStatus(IPF_CENTRAL_SBC_BG, "enabled", "Input Field Business Group");
			checkStatus(IPF_CENTRAL_SBC_ENDPOINT, "enabled", "Input Field Endpoint");
			checkValue_byId(IPF_CENTRAL_SBC_COMM_SYSTEM, "adsa122s");
			checkValue_byId(IPF_CENTRAL_SBC_BG, "OpenBranch");
			checkValue_byId(IPF_CENTRAL_SBC_ENDPOINT, "OB8LANCSBC");
			checkValue_byId(IPF_CENTRAL_SBC_NAME, "OB8LANCSBC");
			checkValue_byId(IPF_CENTRAL_SBC_IP_ADDRESS, "10.19.2.2");
	
			 clickButtonCancel();
			 updateMap(RETRIES);
			 
			 clickCheckbox_byText("OB8LANCSBC");
			 
			 setMethodState();
	}
}