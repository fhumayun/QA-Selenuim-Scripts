package com.administration.configuration.logging;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LG04_Logging_ContiniousTracing extends SuperHelper implements PropertiesLogging {

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
	public void enableContiniousTracing() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationLogging();
		
		updateMap(RETRIES);
		
		//Select TAB Continious Tracing
		clickButton(TB_CONTINIOUS_TRACING);
		
		//Enable
	    if(!getCheckboxStatus(CB_ENABLE))
		clickCheckbox_byID(CB_ENABLE);
		
		//Check that input fields become enabled
		checkStatus(IPF_SERVER, "enabled", "Input Field Server");
		checkStatus(IPF_FILE_SIZE, "enabled", "Input Field File Size Threshold");
		checkStatus(IPF_TIME_INTERVAL, "enabled", "Input Field Time Interval Threshold");
		checkStatus(IPF_SFTP_SYSTEM, "enabled", "Input Field SFTP System Name");
		checkStatus(IPF_SFTP_USERNAME, "enabled", "Input Field SFTP UserName");
		checkStatus(IPF_SFTP_PASSWORD, "enabled", "Input Field SFTP password");
		
		//Check that checkBoxes become enabled
		checkStatus(CB_SIP, "enabled", "Checkbox SIP/Q931 Trace");
		checkStatus(CB_MGCP, "enabled", "Checkbox MGCP Trace");
		
		//Insert Data
		type_byId(IPF_SERVER, "10.11.152.105");
		type_byId(IPF_FILE_SIZE, "510");
		type_byId(IPF_TIME_INTERVAL, "6");
		
		//Enable SIp & MGCP
		clickCheckbox_byID(CB_SIP);
		clickCheckbox_byID(CB_MGCP);
		
		type_byId(IPF_SFTP_SYSTEM, "Adsa115Simplex");
		type_byId(IPF_SFTP_USERNAME, "Assistant");
		type_byId(IPF_SFTP_PASSWORD, "Asd123!.");
	
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyContiniousTracingEnabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationLogging();
		updateMap(RETRIES);	
		
		//Select TAB debugging
		clickButton(TB_CONTINIOUS_TRACING);
		
		//Verify all input fields and checkBoxes
		
		checkStatus(CB_ENABLE, "checked", "Checkbox Enable Continuous Tracing");
		checkValue_byId(IPF_SERVER, "10.11.152.105");
		checkValue_byId(IPF_FILE_SIZE, "510");
		checkValue_byId(IPF_TIME_INTERVAL, "6");
		checkStatus(CB_SIP, "checked", "Checkbox SIP/Q931 Trace");
		checkStatus(CB_MGCP, "checked", "Checkbox MGCP Trace");	
		checkValue_byId(IPF_SFTP_SYSTEM, "Adsa115Simplex");
		checkValue_byId(IPF_SFTP_USERNAME, "Assistant");
		 
		clickButtonCancel();
	
		setMethodState();
	}
	
	@Test (priority = 2)
	public void disableContiniousTracing() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationLogging();
		updateMap(RETRIES);
		
		//Select TAB debugging
		clickButton(TB_CONTINIOUS_TRACING);
		
		//Disable check box
		if(getCheckboxStatus(CB_ENABLE))
		clickCheckbox_byID(CB_ENABLE);
		
		//Check that input fields become disabled
		checkStatus(IPF_SERVER, "disabled", "Input Field Server");
		checkStatus(IPF_FILE_SIZE, "disabled", "Input Field File Size Threshold");
		checkStatus(IPF_TIME_INTERVAL, "disabled", "Input Field Time Interval Threshold");
		checkStatus(IPF_SFTP_SYSTEM, "disabled", "Input Field SFTP System Name");
		checkStatus(IPF_SFTP_USERNAME, "disabled", "Input Field SFTP UserName");
		checkStatus(IPF_SFTP_PASSWORD, "disabled", "Input Field SFTP password");
		
		//Check that checkBoxes become disabled
		checkStatus(CB_SIP, "disabled", "Checkbox SIP/Q931 Trace");
		checkStatus(CB_MGCP, "disabled", "Checkbox MGCP Trace");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyContiniousTracingDisabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationLogging();
		updateMap(RETRIES);	
		
		//Select TAB debugging
		clickButton(TB_CONTINIOUS_TRACING);
		
		//Verify that input fields are disabled
		checkStatus(IPF_SERVER, "disabled", "Input Field Server");
		checkStatus(IPF_FILE_SIZE, "disabled", "Input Field File Size Threshold");
		checkStatus(IPF_TIME_INTERVAL, "disabled", "Input Field Time Interval Threshold");
		checkStatus(IPF_SFTP_SYSTEM, "disabled", "Input Field SFTP System Name");
		checkStatus(IPF_SFTP_USERNAME, "disabled", "Input Field SFTP UserName");
		checkStatus(IPF_SFTP_PASSWORD, "disabled", "Input Field SFTP password");
		
		//Verify that checkBoxes are disabled
		checkStatus(CB_SIP, "disabled", "Checkbox SIP/Q931 Trace");
		checkStatus(CB_MGCP, "disabled", "Checkbox MGCP Trace");
		 
		clickButtonCancel();
	
		setMethodState();
	}
}