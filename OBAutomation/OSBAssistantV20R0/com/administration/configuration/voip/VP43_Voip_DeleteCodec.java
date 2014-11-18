package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP43_Voip_DeleteCodec extends SuperHelper implements PropertiesVoip {

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
	public void voipDeleteCodec() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
         
        checkTextIsContained_byXPathTable(TBL_LIST_CODECS, "G711A");
        checkTextIsContained_byXPathTable(TBL_LIST_CODECS, "G711A");
        
        clickCheckbox_byText("G711A");
        clickButtonDelete();
        
        //After deletion the Codec appear as option in the Select codec Drop-Down list
        //and is not available in Codecs list
        checkValue_inDropDownList(SLC_SELECT_CODEC, "G711A");
        checkElement_NotPresent(TBL_LIST_CODECS+":1:codec");
        
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	
	}
	
	
	@Test (priority = 1)
	public void verifyVoipCodecDeletion() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
        
        //Verify Deletion
        checkValue_inDropDownList(SLC_SELECT_CODEC, "G711A");
        checkElement_NotPresent(TBL_LIST_CODECS+":1:codec");
    
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipDeleteCodecFails() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
         
        //Delete also the second codec
        clickCheckbox_byText("G711U");
        clickButtonDelete();
        
        //After deletion the Codec appear as option in the Select codec Drop-Down list
        checkValue_inDropDownList(SLC_SELECT_CODEC, "G711A");
        checkValue_inDropDownList(SLC_SELECT_CODEC, "G711U");
       
        //The Codecs list is temporary empty
        checkElement_NotPresent(TBL_LIST_CODECS+":0:codec");
        checkElement_NotPresent(TBL_LIST_CODECS+":1:codec");
      
		clickButtonSave();
		
		//Validation appears At least one Codec should be added
		checkMessageFailed("OpenBranch\\OpenBranchGuiError", "common.emptyCodecList", null);
		
		updateMap(RETRIES);
	    
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyVoipCodecFailedDeletion() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Codecs tab
        clickButton(TB_CODECS);
         
        //verify failed deletion
        checkElement(TBL_LIST_CODECS+":0:codec");
        checkElement_NotPresent(TBL_LIST_CODECS+":1:codec");
         
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}