package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP44_Voip_AddCodec extends SuperHelper implements PropertiesVoip {

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
	public void voipAddCodec() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
         
        //Add the Codec
        selectFromDropDown(SLC_SELECT_CODEC, "G711A");
        clickButtonAdd();
      
        //The Codec appears in Codecs list
        checkElement(TBL_LIST_CODECS+":1:codec");
        
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	
	@Test (priority = 1)
	public void verifyVoipCodecAddition() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
        
        //Verify Addition
        checkElement(TBL_LIST_CODECS+":1:codec");
    
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	


}