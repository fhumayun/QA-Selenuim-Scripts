package com.administration.cmp.nodes;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Seleniumhelper.superscripts.MyLogger;
import com.administration.overview.PropertiesOverview;
import com.helper.SuperHelper;

public class ND01_Nodes_CheckOpenBranchNodes extends SuperHelper implements PropertiesNodes,PropertiesOverview{

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToNodes();
	}

	@BeforeMethod(alwaysRun = true)
	public void initializeWindowsMap() throws InterruptedException {
		initMap();
	}
	
	@AfterMethod(alwaysRun = true)
	public void getfocusClearWindowsBeforeMethod() throws InterruptedException {
		clearWindows();
	}

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	
	
	
	@Test (priority = 0)
	public void nodesCheckList() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		//First go to Branch Office List and Retrieve all the names of the Branch Offices
		if(navigateToBranchOfficeList()){
		    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
			}
		
		ArrayList<String> branches = getAllItemsInSpecificColumn(TBL_BRANCH_OFFICE_LIST, getColumn(TBL_BRANCH_OFFICE_LIST, TXT_BRANCH_OFFICE));
		
		//Now go to CMP Nodes List and check if the branches are listed there
		MyLogger.resultInfo("Now go to CMP Nodes List and check if the branches are listed there as well");
	
		navigateToNodes();
	
	    selectFromDropDown(SLC_NODES_ITEMS_PER_PAGE, "50");
		
		for(String ob:branches){
			checkText(ob);
		}
		
		setMethodState();
	}
	
	@Test (priority = 1)
	public void nodesCheckOpenBranchDashboardGUIElements() throws InterruptedException {
		
		methodLogger.log(); 
		
		//Edit a Branch
		clickLink_ByLinkText(OpenBranch);
		updateMap(RETRIES);
		
		checkStatus(BTN_EDIT_NODE_COMMENT, "enabled", "Button Edit Note");
		checkStatus(BTN_SHOW_ACTIVE_ALARMS, "enabled", "Button Show Active Alarms");
		checkStatus(BTN_SHOW_RAPID_STAT, "enabled", "Button Show Rapid Stat");
		checkStatus(BTN_SHOW_VERSION, "enabled", "Button Show Version");
		checkStatus(BTN_SHOW_SERVICES_STATUS, "enabled", "Button Show Services Status");
		checkStatus(BTN_SHOW_LOG_FILES, "enabled", "Button Show Log Files");
	
		
		clickButtonClose();
		updateMap(RETRIES);
		setMethodState();
	}
	
}