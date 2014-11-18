package com.administration.overview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class OV03_BranchOfficeList_deleteCentralSBC extends SuperHelper implements PropertiesOverview {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToBranchOfficeList()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
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
	public void deleteCentralSBC() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		if (selenium.isTextPresent("OB8LANCSBC")){	
			
		clickCheckbox_byText("OB8LANCSBC");
		javaScriptConfirmation("ok");
		clickButtonDelete();
		//Check if deletion is successful
		checkText_NotVisible("OB8LANCSBC");
		} 
		else{
			
			MyLogger.resultInfo("The Central SBC Branch is not present in order to delete it");
		}
		 setMethodState();
	}

}