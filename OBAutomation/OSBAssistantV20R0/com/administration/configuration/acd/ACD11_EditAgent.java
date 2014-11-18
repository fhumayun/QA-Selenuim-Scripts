package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD11_EditAgent extends SuperHelper implements PropertiesACD {

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
	public void acdModifyAgent() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Agents tab
        clickButton(TB_AGENTS);
        
        //Edit 1st Agent and modify fields
      	clickCheckbox_byText("Agent1");
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
        type_byId(IPF_AGENT_ID, "11");
        type_byId(IPF_AGENT_NAME, "Agent11");
        type_byId(IPF_AGENT_PASSWORD, "4444");
        type_byId(IPF_AGENT_CONFIRM_PASSWORD, "4444");
        selectFromDropDown(SLC_ASSIGNED_PROFILE, "Profile2");
    	
      	clickButtonSave();
		updateMap(RETRIES);
		
    	//Check Agent modification
		checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "11");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "11", TXT_AGENT_NAME, "Agent11");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "11", TXT_ASSIGNED_PROFILE, "Profile2");
   
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void verifyAcdAgentModification() throws InterruptedException {
		
		methodLogger.log();
        goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Agents tab
        clickButton(TB_AGENTS);
        
        //Verify Agent Modification
        checkTextIsContained_byXPathTable(TBL_LIST_AGENTS, "11");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "11", TXT_AGENT_NAME, "Agent11");
        checkElementText_inSpecificTableColumn(TBL_LIST_AGENTS, "11", TXT_ASSIGNED_PROFILE, "Profile2");
   
        //Edit Agent and verify fields
      	clickCheckbox_byText("Agent11");
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
        checkValue_byId(IPF_AGENT_ID, "11");
        checkValue_byId(IPF_AGENT_NAME, "Agent11");
        checkValue_byId(IPF_AGENT_PASSWORD, "4444");
        checkValue_byId(IPF_AGENT_CONFIRM_PASSWORD, "4444");
        checkSelectedValue_inDropDownList(SLC_ASSIGNED_PROFILE, "Profile2");
      
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
		
	}	

}