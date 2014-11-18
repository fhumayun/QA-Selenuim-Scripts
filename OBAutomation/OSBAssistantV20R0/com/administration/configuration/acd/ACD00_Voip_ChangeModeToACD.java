package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.voip.PropertiesVoip;
import com.administration.overview.PropertiesOverview;

import com.helper.SuperHelper;

public class ACD00_Voip_ChangeModeToACD extends SuperHelper implements PropertiesVoip,PropertiesOverview {

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
    
	String obStatus;
	boolean testStatus = false;

	@Test (priority = 0)
	public void voipSetModeToProxyACD() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        selectFromDropDown(SLC_MODE, TXT_PROXY_ACD);
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	@Test (priority = 1)
	public void verifyVoipModeProxyACD() throws InterruptedException {
		
		methodLogger.log();
		checkOBStatusAfterRestart(OpenBranch);
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        checkSelectedValue_inDropDownList(SLC_MODE, TXT_PROXY_ACD);
        
        clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();	
	}
	
}