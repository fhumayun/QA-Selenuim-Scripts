package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT03_AutoAttendant_AddAnnouncement extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantAddAnnouncement() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        clickButton(TB_GENERAL);
        if(!getCheckboxStatus(CB_ENABLE_AUTO_ATTENDANT))
			clickCheckbox_byID(CB_ENABLE_AUTO_ATTENDANT);
      
       //Upload Wav Files
	   uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\queue-holdtime.wav");
	   clickButton(BTN_ADD_ANNOUNCEMENT);
	   uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\queue-periodic-announce.wav");
	   clickButton(BTN_ADD_ANNOUNCEMENT);
	   uploadFile(BTN_UPLOAD_BROWSE_BUTTON, LocalFolder+"\\WavFiles\\queue-thankyou.wav");
	   clickButton(BTN_ADD_ANNOUNCEMENT);
	   
	   //Check uploading
	   checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "queue-holdtime.wav");
	   checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "queue-periodic-announce.wav");
	   checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "queue-thankyou.wav");
	
		clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantAnnouncementAdding() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Verify uploading
 	    checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "queue-holdtime.wav");
 	    checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "queue-periodic-announce.wav");
 	    checkTextIsContained_byXPathTable(TBL_LIST_ANNOUNCEMENT_FILES, "queue-thankyou.wav");
 		
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}