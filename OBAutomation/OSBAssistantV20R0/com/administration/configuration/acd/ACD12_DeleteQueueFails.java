package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD12_DeleteQueueFails extends SuperHelper implements PropertiesACD {

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
	public void acdDeleteQueueFails() throws InterruptedException{
		
		String[] argsValidation = {"1","Profile11,Profile2,Profile3"};
		classMethodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        //Try to Delete Queue11
        clickCheckbox_byText("1");
        clickButtonDelete();
      			
        //Deletion Fails,message appears
        checkMessageFailed("OpenBranch\\OpenBranchGuiError", "acdQueue.queueIsAssignedToProfile", argsValidation);
        updateMap(RETRIES);
         
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdQueueFailedDeletion() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        //Verify Failed Deletion
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE, "Queue11");
        
        
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

}