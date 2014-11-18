package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD16_DeleteAgent extends SuperHelper implements PropertiesACD {

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
	public void acdDeleteOneAgent() throws InterruptedException{
		
		classMethodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Agents tab
		clickButton(TB_AGENTS);
		
        //Delete One Agent
		clickCheckbox_byText("Agent2");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Agent2");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdOneAgentDeletion() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Agents tab
		clickButton(TB_AGENTS);
	
		//Verify Agent Deletion
		checkText_NotVisible("Agent2");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
	@Test (priority = 2)
	public void acdDeleteMoreAgents() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Agents tab
		clickButton(TB_AGENTS);
		
        //Delete More Agents
		clickCheckbox_All();
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("Agent11");
		checkText_NotVisible("Agent3");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	@Test (priority = 3)
	public void verifyAcdMoreAgentsDeletion() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Agents tab
		clickButton(TB_AGENTS);
	
		//Verify Agents Deletion
		checkText_NotVisible("Agent11");
		checkText_NotVisible("Agent3");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
}