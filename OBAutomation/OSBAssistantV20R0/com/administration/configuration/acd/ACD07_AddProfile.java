package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD07_AddProfile extends SuperHelper implements PropertiesACD {

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
	public void acdAddProfile() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profiles tab
        clickButton(TB_PROFILES);
        
        //Create 3 Profiles
        //1st Profile
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_PROFILE_NAME, "Profile1");
        type_byId(IPF_ASSIGNED_QUEUE_IDs, "1");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check 1st Profile creation
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile1");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile1", TXT_ASSIGNED_QUEUE_ID, "1");
   
        //2nd Profile
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_PROFILE_NAME, "Profile2");
        type_byId(IPF_ASSIGNED_QUEUE_IDs, "1,2");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check 2nd Profile creation
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile2");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile2", TXT_ASSIGNED_QUEUE_ID, "1,2");
   
        //3rd Profile
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_PROFILE_NAME, "Profile3");
        type_byId(IPF_ASSIGNED_QUEUE_IDs, "1,2,3");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check 3rd Profile creation
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile3");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile3", TXT_ASSIGNED_QUEUE_ID, "1,2,3");
   
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdProfileCreation() throws InterruptedException {
		
		methodLogger.log();
        goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profiles tab
        clickButton(TB_PROFILES);
        
        //Verify Profiles Creation
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile1");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile1", TXT_ASSIGNED_QUEUE_ID, "1");
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile2");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile2", TXT_ASSIGNED_QUEUE_ID, "1,2");
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile3");
        checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, "Profile3", TXT_ASSIGNED_QUEUE_ID, "1,2,3");
   
        //Edit 1st profile and verify fields
      	clickCheckbox_byText("Profile1");
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
      	checkValue_byId(IPF_PROFILE_NAME, "Profile1");
      	checkValue_byId(IPF_ASSIGNED_QUEUE_IDs, "1");
         
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
		
	}	

}