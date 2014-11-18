package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP45_Voip_MoveCodec extends SuperHelper implements PropertiesVoip {

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
	public void voipMoveUpCodec() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
         
        //Check Codecs position before Move Up
        checkText_byId(TBL_LIST_CODECS+":0:codec", "G711U");
        checkText_byId(TBL_LIST_CODECS+":1:codec", "G711A");
        
        clickCheckbox_byText("G711A");
        clickButton(BTN_MOVE_UP_CODEC);
        
        //Check Codecs position after Move Up
        checkText_byId(TBL_LIST_CODECS+":0:codec", "G711A");
        checkText_byId(TBL_LIST_CODECS+":1:codec", "G711U");
        
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	
	@Test (priority = 1)
	public void verifyVoipCodecMoveUp() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
        
        //Verify Codecs position after Move Up
        checkText_byId(TBL_LIST_CODECS+":0:codec", "G711A");
        checkText_byId(TBL_LIST_CODECS+":1:codec", "G711U");
    
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	
	
	@Test (priority = 2)
	public void voipMoveDownCodec() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
         
        clickCheckbox_byText("G711A");
        clickButton(BTN_MOVE_DOWN_CODEC);
        
        //Check Codecs position after Move Down
        checkText_byId(TBL_LIST_CODECS+":0:codec", "G711U");
        checkText_byId(TBL_LIST_CODECS+":1:codec", "G711A");
        
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}

	@Test (priority = 3)
	public void verifyVoipCodecMoveDown() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
        
        //Verify Codecs position after Move Down
        checkText_byId(TBL_LIST_CODECS+":0:codec", "G711U");
        checkText_byId(TBL_LIST_CODECS+":1:codec", "G711A");
        
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	
}