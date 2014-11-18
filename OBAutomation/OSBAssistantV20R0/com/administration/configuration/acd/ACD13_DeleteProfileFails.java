package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD13_DeleteProfileFails extends SuperHelper implements PropertiesACD {

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
	public void acdDeleteProfileFails() throws InterruptedException{
		
		String[] argsValidation = {"Profile2"};
		classMethodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profile tab
        clickButton(TB_PROFILES);
        
        //Try to Delete Profile2
        clickCheckbox_byText("Profile2");
        clickButtonDelete();
      			
        //Deletion Fails,message appears
        checkMessageFailed("OpenBranch\\OpenBranchGuiError", "acdProfile.profileIsInUse", argsValidation);
        updateMap(RETRIES);
         
        //Check Failed Deletion
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile2");
       
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdProfileFailedDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Profile tab
        clickButton(TB_PROFILES);
        
        //Verify Failed Deletion
        checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, "Profile2");
        
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

}