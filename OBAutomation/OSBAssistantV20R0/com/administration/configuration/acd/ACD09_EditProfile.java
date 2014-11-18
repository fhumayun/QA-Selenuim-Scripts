package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD09_EditProfile extends SuperHelper implements PropertiesACD {

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
	public void acdModifyProfile() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profiles tab
        clickButton(TB_PROFILES);
        
        //Edit 1st profile and modify fields
      	clickCheckbox_byText("Profile1");
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
      	type_byId(IPF_PROFILE_NAME, "Profile11");
      	type_byId(IPF_ASSIGNED_QUEUE_IDs, "1,3");
    	
      	clickButtonSave();
		updateMap(RETRIES);
		
    	//Check Profile modification
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile11");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile11", TXT_ASSIGNED_QUEUE_ID, "1,3");
   
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdProfileModification() throws InterruptedException {
		
		methodLogger.log();
        goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profiles tab
        clickButton(TB_PROFILES);
        
        //Verify Profile Modification
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile11");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile11", TXT_ASSIGNED_QUEUE_ID, "1,3");
   
        //Edit Profile and verify fields
      	clickCheckbox_byText("Profile11");
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
      	checkValue_byId(IPF_PROFILE_NAME, "Profile11");
      	checkValue_byId(IPF_ASSIGNED_QUEUE_IDs, "1,3");
         
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
		
	}	

}