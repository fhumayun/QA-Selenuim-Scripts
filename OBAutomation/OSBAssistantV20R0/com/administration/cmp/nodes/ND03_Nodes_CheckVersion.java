package com.administration.cmp.nodes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ND03_Nodes_CheckVersion extends SuperHelper implements PropertiesNodes{

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
	
	@Test (priority = 0)
	public void nodesCheckVersion() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		//Edit a Branch
		clickLink_ByLinkText(OpenBranch);
		updateMap(RETRIES);
		 
	    clickButton(BTN_SHOW_VERSION);
		updateMap(RETRIES);
	    
		//Show current version 
		selectFromDropDown(SLC_OB_VERSION, TXT_OB_CURRENT_VERSION);
		clickButton(BTN_SHOW_OB_VERSION);
		checkText(OpenBranchVersion.replace(".",""));
		
		//Show backup version 
		selectFromDropDown(SLC_OB_VERSION, TXT_OB_BACKUP_VERSION);
		clickButton(BTN_SHOW_OB_VERSION);
		checkText(OpenBranchVersion.replace(".",""));
		
		clickButtonClose();
        updateMap(RETRIES);
		clickButtonClose();
        updateMap(RETRIES);
		setMethodState();
	}
	

	
}