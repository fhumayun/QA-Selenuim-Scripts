package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD19_DeleteAudioFiles extends SuperHelper implements PropertiesACD {

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
	public void acdDeleteMusicOnHoldWavFile() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_MUSIC_ON_HOLD);
		updateMap(RETRIES);
		
		//Delete One Wav File
		clickCheckbox_byText("enter-num-to-call.wav");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		
		//Check deletion
		checkText_NotVisible("enter-num-to-call.wav");
	  
		//Delete More Wav Files
		clickCheckbox_byText("num-not-valid.wav");
		clickCheckbox_byText("queue-holdtime.wav");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		
		//Check deletion
		checkText_NotVisible("num-not-valid.wav");
		checkText_NotVisible("queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyAcdMusicOnHoldWavFileDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_MUSIC_ON_HOLD);
		updateMap(RETRIES);
		
		//Verify deletion
		checkText_NotVisible("enter-num-to-call.wav");
		checkText_NotVisible("num-not-valid.wav");
		checkText_NotVisible("queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void acdDeleteAnnouncementWavFile() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_ANNOUNCEMENT);
		updateMap(RETRIES);
		
		//Delete One Wav File
		clickCheckbox_byText("enter-num-to-call.wav");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		
		//Check deletion
		checkText_NotVisible("enter-num-to-call.wav");
	  
		//Delete More Wav Files
		clickCheckbox_byText("num-not-valid.wav");
		clickCheckbox_byText("queue-holdtime.wav");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		
		//Check deletion
		checkText_NotVisible("num-not-valid.wav");
		checkText_NotVisible("queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
}
	
	@Test (priority = 3)
	public void verifyAcdAnnouncementWavFileDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_ANNOUNCEMENT);
		updateMap(RETRIES);
		
		//Verify deletion
		checkText_NotVisible("enter-num-to-call.wav");
		checkText_NotVisible("num-not-valid.wav");
		checkText_NotVisible("queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}


}