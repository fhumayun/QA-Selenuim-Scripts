package com.profiles.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LS08_ProfilesList_EditProfile_ModeProxy extends SuperHelper implements PropertiesProfilesList {

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
				 {"Profile7","Profile77"},
				 {"Profile8","Profile88"},
				 {"Profile9","Profile99"},
		};	
	}
	
	@Test (priority = 0,dataProvider = "ProfileData")
	public void profilesListModifyProfileModeProxy(String x1,String x2) throws InterruptedException {
		
		classMethodLogger.log(); 
	
		clickCheckbox_byText(x1);
		clickButtonEdit();
		updateMap(RETRIES);
		
		//Modify Profile Name(input from data Provider)
		type_byId(IPF_PROFILE_NAME, x2);
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check Modification
		checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, x2);
		setMethodState();
	}

	@Test (priority = 1,dataProvider = "ProfileData")
	public void verifyProfilesListProfileModeProxyModification(String x1,String x2) throws InterruptedException {
		
		methodLogger.log(); 
	
		//Verify Profiles Name(Edit Profile)
		clickCheckbox_byText(x2);
		clickButtonEdit();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_PROFILE_NAME, x2);
		
		clickButtonCancel();
		updateMap(RETRIES);
		clickCheckbox_byText(x2);
		setMethodState();
}
	
	
}