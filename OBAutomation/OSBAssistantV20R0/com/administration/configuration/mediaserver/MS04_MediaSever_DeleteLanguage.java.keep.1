package com.administration.configuration.mediaserver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class MS04_MediaSever_DeleteLanguage extends SuperHelper implements PropertiesMediaServer {

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
	public void mediaServerDeleteLanguage() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationMediaServer();
		
		updateMap(RETRIES);
	
		clickButton(BTN_CONFIGURE);
	
		updateMap(RETRIES);
		
		//Delete French Language MS announcements
		clickCheckbox_byText("fr");
	    javaScriptConfirmation("ok");
	    clickButtonDelete();
		
	    selenium.setTimeout("50000");
	    
	    //Check deletion
		checkText_NotVisible("fr");
	
		clickButtonSave();
		
		updateMap(RETRIES);
		
		clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 1)
	public void vefifyMediaServerLanguageDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationMediaServer();
		
		updateMap(RETRIES);
	
		checkValueNotPresent_inDropDownList(SLC_LANGUAGE_SELECTION, "fr");
		checkSelectedValue_inDropDownList(SLC_LANGUAGE_SELECTION, "en_us");
		
		clickButton(BTN_CONFIGURE);
		updateMap(RETRIES);
		
		//Verify Time To Live Input Field
		checkValue_byId(IPF_TIME_TO_LIVE, "22");
		
		//Verify deletion
		checkText_NotVisible("fr");
	
		clickButtonCancel();
		updateMap(RETRIES);
		
        clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}
}