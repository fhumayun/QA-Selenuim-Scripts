package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD03_UploadAudioFiles extends SuperHelper implements PropertiesACD {

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
	public void acdUploadMusicOnHoldWavFile() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_MUSIC_ON_HOLD);
		updateMap(RETRIES);
		
		//Upload Music On Hold Wav Files
		uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\enter-num-to-call.wav");
		clickButtonAdd();
		uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\num-not-valid.wav");
		clickButtonAdd();
		uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\queue-holdtime.wav");
		clickButtonAdd();
		
		//Check uploading
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "enter-num-to-call.wav");
	    checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "num-not-valid.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyAcdMusicOnHoldWavFileUploading() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_MUSIC_ON_HOLD);
		updateMap(RETRIES);
		
		//Verify uploading
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "enter-num-to-call.wav");
	    checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "num-not-valid.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void acdUploadAnnouncementWavFile() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_ANNOUNCEMENT);
		updateMap(RETRIES);
		
		//Upload Announcement Wav Files
		uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\enter-num-to-call.wav");
		clickButtonAdd();
		uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\num-not-valid.wav");
		clickButtonAdd();
		uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\queue-holdtime.wav");
		clickButtonAdd();
		
		//Check uploading
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "enter-num-to-call.wav");
	    checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "num-not-valid.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
}
	
	@Test (priority = 3)
	public void verifyAcdAnnouncementWavFileUploading() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAcd();
		updateMap(RETRIES);
		
		//General tab
		clickButton(TB_ACD_GENERAL_TAB);
		
		clickButton(BTN_CONFIGURE_ANNOUNCEMENT);
		updateMap(RETRIES);
		
		//Verify uploading
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "enter-num-to-call.wav");
	    checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "num-not-valid.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_WAV_FILES, "queue-holdtime.wav");
		
		clickButtonClose();
		updateMap(RETRIES);
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}


}