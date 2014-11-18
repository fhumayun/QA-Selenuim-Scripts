package com.administration.configuration.mediaserver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class MS03_MediaSever_UploadLanguageFile extends SuperHelper implements PropertiesMediaServer {

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
	public void mediaServerUploadLanguageFile() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationMediaServer();
		
		updateMap(RETRIES);
	
		clickButton(BTN_CONFIGURE);
	
		updateMap(RETRIES);
		
		//Change the TTL value
		type_byId(IPF_TIME_TO_LIVE, "22");
		
		//Upload French Language MS announcements
		uploadFile(IPF_FILE, LocalFolder+"\\Announcements\\mediaserver_announcements_fr-3.3_5.5.0-583.i586.rpm");
		
	    clickButton(BTN_ADD);
		
	    selenium.setTimeout("60000");
	    
	    //Check Uploading
		checkText("fr");
	
		//Save data
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check that the added language is an option in Languages Drop-Down list
		checkValue_inDropDownList(SLC_LANGUAGE_SELECTION, "fr");
		
		//Select this language
		selectFromDropDown(SLC_LANGUAGE_SELECTION, "fr");
	
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 1)
	public void vefifyMediaServerUploadingLanguageFile() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationMediaServer();
		
		updateMap(RETRIES);
	
		//Verify that the added language is an option in Languages Drop-Down list and that is selected
		checkValue_inDropDownList(SLC_LANGUAGE_SELECTION, "fr");
		checkSelectedValue_inDropDownList(SLC_LANGUAGE_SELECTION, "fr");
		
		clickButton(BTN_CONFIGURE);
		updateMap(RETRIES);
		
		//Verify Time To Live Input Field
		checkValue_byId(IPF_TIME_TO_LIVE, "22");
		
		//Verify uploading
		checkText("fr");
	
		clickButtonCancel();
		updateMap(RETRIES);
		
        clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}