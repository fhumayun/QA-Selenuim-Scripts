package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP14_Voip_BLCRouting extends SuperHelper implements PropertiesVoip {

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
	public void voipBLCAddRouting() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Add Routing in Backup Link Client Mode
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        
        clickButton_ByXpath(TB_CLIENT_MODE_ROUTING_XPATH);
        clickButtonAdd();
        updateMap(RETRIES);
        type_byId(IPF_ROUTING_IP, "10.1.253.100");
        type_byId(IPF_ROUTING_DESRIPTION, "AutoRouting");
        
        clickButtonSave();
		updateMap(RETRIES);
		
        //Check Routing Creation
		checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "10.1.253.100");
		checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "AutoRouting");

		clickButtonSave();
		updateMap(RETRIES);
			
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyVoipBLCRoutingCreation() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
       
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_CLIENT_MODE_ROUTING_XPATH);
    
        //Verify Routing Creation
		checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "10.1.253.100");
		checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "AutoRouting");
		
	    clickButtonCancel();
		updateMap(RETRIES);
		
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void voipBLCDeleteRouting() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Delete Routing in Backup Link Client Mode
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        
        clickButton_ByXpath(TB_CLIENT_MODE_ROUTING_XPATH);
        clickCheckbox_byText("10.1.253.100");
		clickButtonDelete();
      	
        //Check Routing Deletion
		checkText_NotVisible("10.1.253.100");
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyVoipBLCRoutingDeletion() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
       
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_CLIENT_MODE_ROUTING_XPATH);
    
        //Verify Routing Deletion
    	checkText_NotVisible("10.1.253.100");
    	
    	clickButtonCancel();
  		updateMap(RETRIES);
  		
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}