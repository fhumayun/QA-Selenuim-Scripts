package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD17_DeleteProfile extends SuperHelper implements PropertiesACD {

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
	public void acdDeleteOneProfile() throws InterruptedException{
		
		classMethodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Profiles tab
		clickButton(TB_PROFILES);
		
        //Delete One Profile
		clickCheckbox_byText("Profile2");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile2");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdOneProfileDeletion() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profiles tab
		clickButton(TB_PROFILES);
	
		//Verify Profile Deletion
		checkText_NotVisible("Profile2");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
	@Test (priority = 2)
	public void acdDeleteMoreProfiles() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Profiles tab
		clickButton(TB_PROFILES);
		
        //Delete More Profiles
		clickCheckbox_All();
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Profile11");
		checkText_NotVisible("Profile3");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	@Test (priority = 3)
	public void verifyAcdMoreProfilesDeletion() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profiles tab
		clickButton(TB_PROFILES);
	
		//Verify Profiles Deletion
		checkText_NotVisible("Profile11");
		checkText_NotVisible("Profile3");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
}