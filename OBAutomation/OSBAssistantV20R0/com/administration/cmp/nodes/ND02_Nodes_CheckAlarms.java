package com.administration.cmp.nodes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class ND02_Nodes_CheckAlarms extends SuperHelper implements PropertiesNodes{

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
	public void nodesCheckAlarms() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		//Edit a Branch
		clickLink_ByLinkText(OpenBranch);
		updateMap(RETRIES);
		 
		String cricalAlarms = selenium.getTable(TBL_LIST_ALARMS+".0.1");
		String majorAlarms = selenium.getTable(TBL_LIST_ALARMS+".0.2");
		String minorAlarms = selenium.getTable(TBL_LIST_ALARMS+".0.3");
		
		String totalAlarms = String.valueOf(Integer.parseInt(cricalAlarms.split(" ")[1])+Integer.parseInt(majorAlarms.split(" ")[1])+Integer.parseInt(minorAlarms.split(" ")[1]));
		MyLogger.resultInfo("The total number of Alarms is: " + totalAlarms );
		
		clickButton(BTN_SHOW_ACTIVE_ALARMS);
		updateMap(RETRIES);
		checkText_byId(TXT_NUMBER_OF_ITEMS_IN_LIST, totalAlarms);
		
		checkText(TXT_ALARM_ID);
		checkText(TXT_SEVERITY);
		checkText(TXT_MANAGED_RESOURCE);
		checkText(TXT_ALARM_TYPE);
		checkText(TXT_LAST_OCCURED);
		checkText(TXT_ACKNOWLEDGED_STATUS);
		checkText(TXT_USER);
		checkText(TXT_HIT_COUNT);
		
		clickButtonClose();
        updateMap(RETRIES);
		clickButtonClose();
        updateMap(RETRIES);
		setMethodState();
	}
	

	
}