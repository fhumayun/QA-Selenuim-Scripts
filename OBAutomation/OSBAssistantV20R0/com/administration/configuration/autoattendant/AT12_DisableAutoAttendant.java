package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT12_DisableAutoAttendant extends SuperHelper implements PropertiesAutoAttendant {

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
	public void disableAutoAttendant() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        clickButton(TB_GENERAL);
        if(getCheckboxStatus(CB_ENABLE_AUTO_ATTENDANT))
			clickCheckbox_byID(CB_ENABLE_AUTO_ATTENDANT);
      
        //Tabs Routing and Menus become disabled
        checkStatus(TB_ROUTING,"disabled","Tab Routing");
		checkStatus(TB_MENUS,"disabled","Tab Menus");
	
        
        //The Input Field Interdigit timer,Wait to go to menu and Record access code become disabled
        checkStatus(IPF_INTERDIGIT_TIMER, "disabled", "Input Field Interdigit timer");
		checkStatus(IPF_WAIT_TO_GO_TO_MENU, "disabled", "Input Field Wait to go to menu");
		checkStatus(IPF_RECORD_ACCESS_CODE, "disabled", "Input Field Record access code");

		//Also Delete 2 Announcements (recover initial configuration)
        clickCheckbox_byText("queue-periodic-announce.wav");
        clickCheckbox_byText("queue-thankyou.wav");
    	javaScriptConfirmation("ok");
        clickButtonDelete();
     
        //Check deletion
	    checkText_NotVisible("queue-periodic-announce.wav");
	    checkText_NotVisible("queue-thankyou.wav");
	    
	    clickButtonSave();     
	    updateMap(RETRIES);
	    applyChangesWithConfirmation();
	    setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantDisabling() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
     
        checkStatus(CB_ENABLE_AUTO_ATTENDANT,"enabled","Checkbox Enable Auto Attendant");
		checkStatus(CB_ENABLE_AUTO_ATTENDANT,"unchecked","Checkbox Enable Auto Attendant");
	   
		//Verify status of tabs Routing and Menus
		checkStatus(TB_ROUTING,"disabled","Tab Routing");
		checkStatus(TB_MENUS,"disabled","Tab Menus");
		
        //Verify values and status in Input Fields Interdigit timer,Wait to go to menu and Record access code
        checkStatus(IPF_INTERDIGIT_TIMER, "disabled", "Input Field Interdigit timer");
		checkStatus(IPF_WAIT_TO_GO_TO_MENU, "disabled", "Input Field Wait to go to menu");
		checkStatus(IPF_RECORD_ACCESS_CODE, "disabled", "Input Field Record access code");
   
		//Verify announcements deletion
	    checkText_NotVisible("queue-periodic-announce.wav");
	    checkText_NotVisible("queue-thankyou.wav");
	   
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}