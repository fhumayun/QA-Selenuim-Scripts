package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT04_AutoAttendant_DeleteAnnouncement extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantDeleteAnnouncement() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        clickButton(TB_GENERAL);
    
        //Delete Announcement
        clickCheckbox_byText("queue-holdtime.wav");
    	javaScriptConfirmation("ok");
        clickButtonDelete();
        
	    //Check deletion
	    checkText_NotVisible("queue-holdtime.wav");
		
	    clickButtonSave();
		updateMap(RETRIES);
		checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantAnnouncementDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Verify deletion
	    checkText_NotVisible("queue-holdtime.wav");
	    
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}