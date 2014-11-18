package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV10_Survivability_ConfigureGeneralSFTPBillingFileSettings extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityConfigureGeneralSFTPBillingFileSettings() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		if(!getCheckboxStatus(CB_TICKET_GENERATION))
			clickCheckbox_byID(CB_TICKET_GENERATION);
		
		
		type_byId(IPF_MAX_RECORD_VALUE, "999");
		type_byId(IPF_MAX_TIME_INTERVAL, "6");
		type_byId(IPF_MAX_FILE_SIZE, "200");
		selectFromDropDown(SLC_TRANSFER_METHOD, TXT_TRANSFER_METHOD_PULL);
		type_byId(IPF_PORT, "23");
		clickCheckbox_byID(CB_ALLOW_OVERWRITE);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityGeneralSFTPBillingFileSettings() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		
		checkValue_byId(IPF_MAX_RECORD_VALUE, "999");
		checkValue_byId(IPF_MAX_TIME_INTERVAL, "6");
		checkValue_byId(IPF_MAX_FILE_SIZE, "200");
		checkSelectedValue_inDropDownList(SLC_TRANSFER_METHOD, TXT_TRANSFER_METHOD_PULL);
		checkValue_byId(IPF_PORT, "23");
		checkStatus(CB_ALLOW_OVERWRITE,"checked","Checkbox Allow file overwrite"); 
	       
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}