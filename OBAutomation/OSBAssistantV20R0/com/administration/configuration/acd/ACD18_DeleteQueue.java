package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD18_DeleteQueue extends SuperHelper implements PropertiesACD {

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
	public void acdDeleteOneQueue() throws InterruptedException{
		
		classMethodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Queues tab
		clickButton(TB_QUEUE);
		
        //Delete One Queue
		clickCheckbox_byText("Queue2");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Queue2");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdOneQueueDeletion() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queues tab
		clickButton(TB_QUEUE);
	
		//Verify Queue Deletion
		checkText_NotVisible("Queue2");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
	@Test (priority = 2)
	public void acdDeleteMoreQueues() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Queues tab
		clickButton(TB_QUEUE);
		
        //Delete More Queues
		clickCheckbox_All();
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Queue11");
		checkText_NotVisible("Queue3");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	@Test (priority = 3)
	public void verifyAcdMoreQueuesDeletion() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queues tab
		clickButton(TB_QUEUE);
	
		//Verify Queues Deletion
		checkText_NotVisible("Queue11");
		checkText_NotVisible("Queue3");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
}