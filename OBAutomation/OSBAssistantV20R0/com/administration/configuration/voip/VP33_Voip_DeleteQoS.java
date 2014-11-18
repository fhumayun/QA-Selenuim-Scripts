package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP33_Voip_DeleteQoS extends SuperHelper implements PropertiesVoip {

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
	public void voipDeleteOneQoS() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Enable QoSs Configuration
        if(!getCheckboxStatus(CB_ENABLE_QOS))
        clickCheckbox_byID(CB_ENABLE_QOS);
        
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
        
        //Delete QoS
    	clickCheckbox_byText(TXT_ICMP);
		clickButtonDelete();    
        
        //Check QoS Deletion
        checkText_NotVisible(TXT_ICMP);
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	@Test (priority = 1)
	public void verifyVoipOneQoSDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
		
		//Verify QoS Deletion
        checkText_NotVisible(TXT_ICMP);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
	

	@Test (priority = 2)
	public void voipDeleteMoreQoS() throws InterruptedException {
		
	    methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
           
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
        
        //Delete All QoS
    	clickCheckbox_All();
		clickButtonDelete();    
        
        //Check QoS Deletion
        checkText_NotVisible(TXT_TCP);
        checkText_NotVisible(TXT_UDP);
        
        clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 3)
	public void verifyVoipMoreQoSDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
		
		//Verify QoS Deletion
        checkText_NotVisible(TXT_TCP);
        checkText_NotVisible(TXT_UDP);
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
}