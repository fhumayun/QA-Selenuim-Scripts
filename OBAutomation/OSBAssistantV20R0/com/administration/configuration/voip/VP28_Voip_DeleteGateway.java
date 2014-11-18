package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP28_Voip_DeleteGateway extends SuperHelper implements PropertiesVoip {

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
	public void voipDeleteOneGateway() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Enable Gateways Configuration
        if(!getCheckboxStatus(CB_ENABLE_GATEWAYS))
        clickCheckbox_byID(CB_ENABLE_GATEWAYS);
        
        clickButton(BTN_CONFIGURE_GATEWAYS);
        updateMap(RETRIES);
        
        //Delete Gateway
    	clickCheckbox_byText("www.testGW.com");
		clickButtonDelete();    
        
        //Check Gateway Deletion
        checkText_NotVisible("www.testGW.com");
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	@Test (priority = 1)
	public void verifyVoipOneGatewayDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_GATEWAYS);
        updateMap(RETRIES);
		
		//Verify Gateway Deletion
        checkText_NotVisible("www.testGW.com");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
	

	@Test (priority = 2)
	public void voipDeleteMoreGateways() throws InterruptedException {
		
	    methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
           
        clickButton(BTN_CONFIGURE_GATEWAYS);
        updateMap(RETRIES);
        
        //Delete All Gateways
    	clickCheckbox_All();
		clickButtonDelete();    
        
        //Check Gateways Deletion
        checkText_NotVisible("www.autoGW1.com");
        checkText_NotVisible("www.autoGW2.com");
        checkText_NotVisible("www.autoGW3.com");
        checkText_NotVisible("172.25.2.93");
        checkText_NotVisible("10.1.252.14");
        checkText_NotVisible("10.1.252.15");
        checkText_NotVisible("192.168.108.4");
        checkText_NotVisible("10.1.252.16");
        
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 3)
	public void verifyVoipMoreGatewaysDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_GATEWAYS);
        updateMap(RETRIES);
		
		//Verify Gateways Deletion
        checkText_NotVisible("www.autoGW1.com");
        checkText_NotVisible("www.autoGW2.com");
        checkText_NotVisible("www.autoGW3.com");
        checkText_NotVisible("172.25.2.93");
        checkText_NotVisible("10.1.252.14");
        checkText_NotVisible("10.1.252.15");
        checkText_NotVisible("192.168.108.4");
        checkText_NotVisible("10.1.252.16");
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
}