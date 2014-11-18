package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD14_ShowAgentQueueStatus extends SuperHelper implements PropertiesACD {

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
	public void acdShowAgentStatus() throws InterruptedException{
		
		classMethodLogger.log(); 

		goToAdministrationAcd();
        updateMap(RETRIES);
        
    	//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
        clickButton(BTN_SHOW_STATUS);
        updateMap(RETRIES);
        
        checkText_byTablePos(TBL_LIST_AGENT, "11", "1", "0");
        checkText_byTablePos(TBL_LIST_AGENT, "2", "2", "0");
        checkText_byTablePos(TBL_LIST_AGENT, "3", "3", "0");
        checkText_byTablePos(TBL_LIST_AGENT, "Agent11", "1", "1");
        checkText_byTablePos(TBL_LIST_AGENT, "Agent2", "2", "1");
        checkText_byTablePos(TBL_LIST_AGENT, "Agent3", "3", "1");
        checkText_byTablePos(TBL_LIST_AGENT, "logged off", "1", "2");
        checkText_byTablePos(TBL_LIST_AGENT, "logged off", "2", "2");
        checkText_byTablePos(TBL_LIST_AGENT, "logged off", "3", "2");
        checkText_byTablePos(TBL_LIST_AGENT, "Profile2", "1", "4");
        checkText_byTablePos(TBL_LIST_AGENT, "Profile2", "2", "4");
        checkText_byTablePos(TBL_LIST_AGENT, "Profile3", "3", "4");
      
        clickButtonClose();
		updateMap(RETRIES);
        
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	

	@Test (priority = 1)
	public void acdShowQueueStatus() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
         
        selenium.click(TBL_LIST_QUEUE+":0:show");
        updateMap(RETRIES);
        
        checkText("Queue: Queue11");
        checkText("11");
        checkText("2");
        checkText("3");
        
        clickButtonClose();
		updateMap(RETRIES);
        
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

}