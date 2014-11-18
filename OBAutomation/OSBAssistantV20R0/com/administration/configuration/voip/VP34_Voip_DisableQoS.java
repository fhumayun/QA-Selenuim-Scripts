package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP34_Voip_DisableQoS extends SuperHelper implements PropertiesVoip {

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
	public void voipDisableQoS() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Disable QoS Configuration
        if(getCheckboxStatus(CB_ENABLE_QOS))
        clickCheckbox_byID(CB_ENABLE_QOS);
        
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	
	@Test (priority = 1)
	public void verifyVoipQoSDisabling() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
		
		//Verify QoS Disabling
        checkStatus(CB_ENABLE_QOS,"enabled","Checkbox Enable QoS");
    	checkStatus(CB_ENABLE_QOS,"unchecked","Checkbox Enable QoS");
    	checkStatus(BTN_CONFIGURE_QOS,"disabled","Button Configure QoS");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}