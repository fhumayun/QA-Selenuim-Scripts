package com.administration.management;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class MG02_Management_GUIElements_ShowSubscribers extends SuperHelper implements PropertiesManagement {

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
	public void branchOfficeManagement_ShowRegisteredSubscribers() throws InterruptedException {
		
		classMethodLogger.log(); 
		
	    clickButton(BTN_SHOW_REGISTERED_SUBSCRIBERS);	
	    
	    updateMap(RETRIES);
	    
	    checkText(TXT_REGISTERED_SUBSCRIBERS);
	    checkText(TXT_CONTACT);
	    checkText(TXT_EXPIRES);
	    //checkText("302109991005");
	    //checkText("302109991006");
	    
	    clickButtonClose();
	   
	    updateMap(RETRIES);
	    
	    setMethodState();
	
	}

}