package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS05_ProfilesList_CreateProfile_ModeProxyACD extends SuperHelper implements PropertiesProfilesList {

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

	@DataProvider(name = "ProfileData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"Profile10",TXT_PROXY_ACD,"V1.R4"},
				 {"Profile20",TXT_PROXY_ACD,"V1.R41"},
				 {"Profile30",TXT_PROXY_ACD,"V2.R0"},
		};	
	}
	
	@Test (priority = 0,dataProvider = "ProfileData")
	public void profilesListCreateProfileModeProxyACD(String x1,String x2,String x3) throws InterruptedException {
		
		classMethodLogger.log(); 
	
		clickButtonAdd();
		updateMap(RETRIES);
		
		//Create Profile Mode Proxy ACD(input from data Provider)
		type_byId(IPF_PROFILE_NAME, x1);
		selectFromDropDown(SLC_MODE, x2);
		selectFromDropDown(SLC_VERSION, x3);
		
		clickButtonSave();
		updateMap(RETRIES);
		
	
		//Check Creation
		checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, x1);
		checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, x1, TXT_PROFILE_MODE, x2);
		checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, x1, TXT_PROFILE_VERSION, x3);
		setMethodState();
	}
	
	@Test (priority = 1,dataProvider = "ProfileData")
	public void verifyProfilesListProfileModeProxyACDFields(String x1,String x2,String x3) throws InterruptedException {
		
		methodLogger.log(); 
	
		//Verify Profiles Fields(Edit Profiles)
		clickCheckbox_byText(x1);
		clickButtonEdit();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_PROFILE_NAME, x1);
		checkSelectedValue_inDropDownList(SLC_MODE, x2);
		checkStatus(SLC_MODE,"disabled","Drop-Down List Mode");
		checkSelectedValue_inDropDownList(SLC_VERSION, x3);
		checkStatus(SLC_VERSION,"disabled","Drop-Down List OpenBranch Version");
    	
		clickButtonCancel();
		updateMap(RETRIES);
		clickCheckbox_byText(x1);
		setMethodState();
	}
	
}