package com.administration.configuration.mediaserver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class MS05_MediaServer_ChangeConfiguration extends SuperHelper implements PropertiesMediaServer {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	
	@Test (priority = 0)
	public void mediaServer_changeValues() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        //Modify Values in All Input Fields
        type_byId(IPF_MS_LISTEN_PORT, "2430");
        type_byId(IPF_CONFERENCE_PORT, "30");
        type_byId(IPF_MAX_CONFERENCE_TIME, "19000");
        type_byId(IPF_PAC, "30210805");
        type_byId(IPF_CONFERENCE_ANNOUNCEMENT, "14");
        type_byId(IPF_MAX_ANNOUNCE_TIME, "2000");
       
        
    	clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyMediaServerValues() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        //Modify Values in All Input Fields
        checkValue_byId(IPF_MS_LISTEN_PORT, "2430");
        checkValue_byId(IPF_CONFERENCE_PORT, "30");
        checkValue_byId(IPF_MAX_CONFERENCE_TIME, "19000");
        checkValue_byId(IPF_PAC, "30210805");
        checkValue_byId(IPF_CONFERENCE_ANNOUNCEMENT, "14");
        checkValue_byId(IPF_MAX_ANNOUNCE_TIME, "2000");
       
        clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void mediaServer_enableUnlimitedCheckboxes() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        //Check Unlimited Max Conference and Max Announcements checkBoxes
        //and check that the Input Fields Input Field Maximum conference time 
        //and Maximum announcement time become disabled with value 0
        clickCheckbox_byID(CB_UNLIMITED_MAX_CONFERENE);
        checkValue_byId(IPF_MAX_CONFERENCE_TIME, "unlimited");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "disabled", "Input Field Maximum conference time");
       
        clickCheckbox_byID(CB_UNLIMITED_MAX_ANNOUNCEMENT);
        checkValue_byId(IPF_MAX_ANNOUNCE_TIME, "unlimited");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "disabled", "Input Field Maximum announcement time");
       
        
    	clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 3)
	public void verifyMediaServerUnlimitedCheckboxes() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        //Verify that the Input Fields Input Field Maximum conference time 
        //and Maximum announcement time become disabled with value 0
        checkValue_byId(IPF_MAX_CONFERENCE_TIME, "0");
        checkStatus(IPF_MAX_CONFERENCE_TIME, "disabled", "Input Field Maximum conference time");
        checkValue_byId(IPF_MAX_ANNOUNCE_TIME, "0");
        checkStatus(IPF_MAX_ANNOUNCE_TIME, "disabled", "Input Field Maximum announcement time");
       
        
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}
}