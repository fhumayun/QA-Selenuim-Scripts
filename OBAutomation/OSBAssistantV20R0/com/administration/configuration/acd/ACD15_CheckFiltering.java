package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD15_CheckFiltering extends SuperHelper implements PropertiesACD {

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
	public void acdFilterQueue() throws InterruptedException{
		
		classMethodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Queue tab
		clickButton(TB_QUEUE);
		
        //Filter by Queue name
		selectFromDropDown(SLC_FILTER_QUEUE, TXT_QUEUE_NAME);
		type_byId(IPF_FILTER_QUEUE, "Queue11");
		clickButton(BTN_FILTER_QUEUE_GO);
		checkText("Queue11");
		checkText_NotVisible("Queue2");
		checkText_NotVisible("Queue3");
		
		//Filter by Queue DID
		selectFromDropDown(SLC_FILTER_QUEUE, TXT_QUEUE_DID);
		type_byId(IPF_FILTER_QUEUE, "2610995201");
		clickButton(BTN_FILTER_QUEUE_GO);
		checkText("Queue2");
		checkText_NotVisible("Queue11");
		checkText_NotVisible("Queue3");
	
	    //Clear Filter
		clickButton(BTN_FILTER_QUEUE_CLEAR);
		checkText("Queue11");
		checkText("Queue2");
		checkText("Queue3");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void acdFilterProfiles() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Profiles tab
		clickButton(TB_PROFILES);
		
        //Filter by Profile name
		type_byId(IPF_FILTER_PROFILE, "Profile2");
		clickButton(BTN_FILTER_PROFILE_GO);
		checkText("Profile2");
		checkText_NotVisible("Profile11");
		checkText_NotVisible("Profile3");
		
	    //Clear Filter
		clickButton(BTN_FILTER_PROFILE_CLEAR);
		checkText("Profile11");
		checkText("Profile2");
		checkText("Profile3");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
	@Test (priority = 2)
	public void acdFilterAgents() throws InterruptedException{
		
		methodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//Agents tab
		clickButton(TB_AGENTS);
		
        //Filter by Agent name
		selectFromDropDown(SLC_FILTER_AGENT, TXT_AGENT_NAME);
		type_byId(IPF_FILTER_AGENT, "Agent11");
		clickButton(BTN_FILTER_AGENT_GO);
		checkText("Agent11");
		checkText_NotVisible("Agent2");
		checkText_NotVisible("Agent3");
		
		//Filter by Assigned Profile
		selectFromDropDown(SLC_FILTER_AGENT, TXT_PROFILENAME);
		type_byId(IPF_FILTER_AGENT, "Profile2");
		clickButton(BTN_FILTER_AGENT_GO);
		checkText("Agent11");
		checkText("Agent2");
		checkText_NotVisible("Agent3");
	
	    //Clear Filter
		clickButton(BTN_FILTER_AGENT_CLEAR);
		checkText("Agent11");
		checkText("Agent2");
		checkText("Agent3");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
}