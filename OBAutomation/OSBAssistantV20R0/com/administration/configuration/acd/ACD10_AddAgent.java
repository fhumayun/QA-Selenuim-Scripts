package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD10_AddAgent extends SuperHelper implements PropertiesACD {

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
	public void acdAddAgent() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Agents tab
        clickButton(TB_AGENTS);
        
        //Create 3 Agents
        //1st Agent
        clickButtonAdd();
        updateMap(RETRIES);
        
        //Check if Profiles11,Profile2 and profile3 are available in the Drop-Down list
        checkValue_inDropDownList(SLC_ASSIGNED_PROFILE, "Profile11");
        checkValue_inDropDownList(SLC_ASSIGNED_PROFILE, "Profile2");
        checkValue_inDropDownList(SLC_ASSIGNED_PROFILE, "Profile3");
        
        type_byId(IPF_AGENT_ID, "1");
        type_byId(IPF_AGENT_NAME, "Agent1");
        type_byId(IPF_AGENT_PASSWORD, "123456");
        type_byId(IPF_AGENT_CONFIRM_PASSWORD, "123456");
        selectFromDropDown(SLC_ASSIGNED_PROFILE, "Profile11");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check 1st Agent creation
        checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "1");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "1", TXT_AGENT_NAME, "Agent1");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "1", TXT_ASSIGNED_PROFILE, "Profile11");
       
        //2nd Agent
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_AGENT_ID, "2");
        type_byId(IPF_AGENT_NAME, "Agent2");
        type_byId(IPF_AGENT_PASSWORD, "222222");
        type_byId(IPF_AGENT_CONFIRM_PASSWORD, "222222");
        selectFromDropDown(SLC_ASSIGNED_PROFILE, "Profile2");
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check 2nd Agent creation
    	checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "2");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "2", TXT_AGENT_NAME, "Agent2");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "2", TXT_ASSIGNED_PROFILE, "Profile2");
         
        //3rd Agent
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_AGENT_ID, "3");
        type_byId(IPF_AGENT_NAME, "Agent3");
        type_byId(IPF_AGENT_PASSWORD, "654321");
        type_byId(IPF_AGENT_CONFIRM_PASSWORD, "654321");
        selectFromDropDown(SLC_ASSIGNED_PROFILE, "Profile3");
          
        clickButtonSave();
    	updateMap(RETRIES);
    	
    	//Check 3rd Agent creation
    	checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "3");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "3", TXT_AGENT_NAME, "Agent3");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "3", TXT_ASSIGNED_PROFILE, "Profile3");
     
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdAgentCreation() throws InterruptedException {
		
		methodLogger.log();
        goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Agents tab
        clickButton(TB_AGENTS);
        
        //Verify Agents Creation
        checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "1");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "1", TXT_AGENT_NAME, "Agent1");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "1", TXT_ASSIGNED_PROFILE, "Profile11");
     	checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "2");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "2", TXT_AGENT_NAME, "Agent2");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "2", TXT_ASSIGNED_PROFILE, "Profile2");
    	checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "3");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "3", TXT_AGENT_NAME, "Agent3");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "3", TXT_ASSIGNED_PROFILE, "Profile3");

        //Edit 1st Agent and verify fields
      	clickCheckbox_byText("Agent1");
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
        checkValue_byId(IPF_AGENT_ID, "1");
        checkValue_byId(IPF_AGENT_NAME, "Agent1");
        checkValue_byId(IPF_AGENT_PASSWORD, "123456");
        checkValue_byId(IPF_AGENT_CONFIRM_PASSWORD, "123456");
        checkSelectedValue_inDropDownList(SLC_ASSIGNED_PROFILE, "Profile11");
       
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
		
	}	

}