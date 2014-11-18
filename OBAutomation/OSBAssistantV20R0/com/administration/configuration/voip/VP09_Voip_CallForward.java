package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP09_Voip_CallForward extends SuperHelper implements PropertiesVoip {

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
	public void voipEnableCallForward() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CALL_FORWARD);
        updateMap(RETRIES);
        
        //Check default status and value of all fields in Call Forward pop-up
       
        //Call Forward No Reply fields
        checkStatus(CB_ACTIVATE_CALL_FW_NO_REPLY,"enabled","Checkbox Activate Call Forward No Reply");
    	checkStatus(CB_ACTIVATE_CALL_FW_NO_REPLY,"unchecked","Checkbox Activate Call Forward No Reply");
    	checkStatus(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward No Reply");
		checkValue_byId(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "");
		checkStatus(IPF_CALL_FW_NO_REPLY_RING_DURATION, "disabled", "Input Field Ring Duration on Call Forward No Reply");
		checkValue_byId(IPF_CALL_FW_NO_REPLY_RING_DURATION, "24");
		checkStatus(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward No Reply");
		checkValue_byId(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "");
		 
		//Call Forward on Busy fields
		checkStatus(CB_ACTIVATE_CALL_FW_ON_BUSY,"enabled","Checkbox Activate Call Forward on Busy");
	    checkStatus(CB_ACTIVATE_CALL_FW_ON_BUSY,"unchecked","Checkbox Activate Call Forward on Busy");
	    checkStatus(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Busy");
		checkValue_byId(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "");
		checkStatus(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Busy");
		checkValue_byId(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "");
			
		//Call Forward on Do not Disturb fields
		checkStatus(CB_ACTIVATE_CALL_FW_DO_NOT_DISTURB,"enabled","Checkbox Activate Call Forward on Do not Disturb");
	    checkStatus(CB_ACTIVATE_CALL_FW_DO_NOT_DISTURB,"unchecked","Checkbox Activate Call Forward on Do not Disturb");
	    checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Do not Disturb");
		checkValue_byId(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "");
		checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Do not Disturb");
		checkValue_byId(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "");
	
		//Call Forward on Error fields
		checkStatus(CB_ACTIVATE_CALL_FW_ON_ERROR,"enabled","Checkbox Activate Call Forward on Error");
	    checkStatus(CB_ACTIVATE_CALL_FW_ON_ERROR,"unchecked","Checkbox Activate Call Forward on Error");
	    checkStatus(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Error");
		checkValue_byId(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "");
		checkStatus(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Error");
		checkValue_byId(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "");
		checkStatus(BTN_CALL_FW_ON_ERROR_ERROR_CODES, "disabled", "Button Call Forward on Error - Error Codes");
		
		
		//Activate Call Forward No Reply
        clickCheckbox_byID(CB_ACTIVATE_CALL_FW_NO_REPLY);
        //The relative fields become enabled
        checkStatus(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward No Reply");
		checkStatus(IPF_CALL_FW_NO_REPLY_RING_DURATION, "enabled", "Input Field Ring Duration on Call Forward No Reply");
		checkStatus(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward No Reply");
		//Enter values
		type_byId(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "2106923616");
		type_byId(IPF_CALL_FW_NO_REPLY_RING_DURATION, "30");
		type_byId(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "10.1.252.43");
	
		
		//Activate Call Forward on Busy
        clickCheckbox_byID(CB_ACTIVATE_CALL_FW_ON_BUSY);
        //The relative fields become enabled
        checkStatus(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward on Busy");
		checkStatus(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward on Busy");
		//Enter values
		type_byId(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "2106923617");
		type_byId(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "10.1.252.44");
		
		
		//Activate Call Forward on Do not Disturb
		clickCheckbox_byID(CB_ACTIVATE_CALL_FW_DO_NOT_DISTURB);
	    //The relative fields become enabled
	    checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward on Do not Disturb");
	 	checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward on Do not Disturb");
		//Enter values
	 	type_byId(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "2106923618");
	 	type_byId(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "10.1.252.45");
	
	 	//Activate Call Forward on Error
		clickCheckbox_byID(CB_ACTIVATE_CALL_FW_ON_ERROR);
		//The relative fields become enabled
		checkStatus(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward on Error");
		checkStatus(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward on Error");
		checkStatus(BTN_CALL_FW_ON_ERROR_ERROR_CODES, "enabled", "Button Call Forward on Error - Error Codes");
		//Enter values	
		type_byId(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "2106923619");
		type_byId(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "10.1.252.46");
		//Add Error Code
		clickButton(BTN_CALL_FW_ON_ERROR_ERROR_CODES);
		updateMap(RETRIES);
		selectFromDropDown(SLC_ERROR_CODE, "401");
		clickButtonAdd();
		checkText("401");
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	
	@Test (priority = 1)
	public void verifyVoipCallForwardEnabling() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CALL_FORWARD);
        updateMap(RETRIES);
		
        //Verify Call Forward Activation
        //Call Forward No Reply fields
        checkStatus(CB_ACTIVATE_CALL_FW_NO_REPLY,"enabled","Checkbox Activate Call Forward No Reply");
    	checkStatus(CB_ACTIVATE_CALL_FW_NO_REPLY,"checked","Checkbox Activate Call Forward No Reply");
    	checkStatus(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward No Reply");
		checkValue_byId(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "2106923616");
		checkStatus(IPF_CALL_FW_NO_REPLY_RING_DURATION, "enabled", "Input Field Ring Duration on Call Forward No Reply");
		checkValue_byId(IPF_CALL_FW_NO_REPLY_RING_DURATION, "30");
		checkStatus(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward No Reply");
		checkValue_byId(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "10.1.252.43");
		 
		//Call Forward on Busy fields
		checkStatus(CB_ACTIVATE_CALL_FW_ON_BUSY,"enabled","Checkbox Activate Call Forward on Busy");
	    checkStatus(CB_ACTIVATE_CALL_FW_ON_BUSY,"checked","Checkbox Activate Call Forward on Busy");
	    checkStatus(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward on Busy");
		checkValue_byId(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "2106923617");
		checkStatus(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward on Busy");
		checkValue_byId(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "10.1.252.44");
			
		//Call Forward on Do not Disturb fields
		checkStatus(CB_ACTIVATE_CALL_FW_DO_NOT_DISTURB,"enabled","Checkbox Activate Call Forward on Do not Disturb");
	    checkStatus(CB_ACTIVATE_CALL_FW_DO_NOT_DISTURB,"enabled","Checkbox Activate Call Forward on Do not Disturb");
	    checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward on Do not Disturb");
		checkValue_byId(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "2106923618");
		checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward on Do not Disturb");
		checkValue_byId(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "10.1.252.45");
	
		//Call Forward on Error fields
		checkStatus(CB_ACTIVATE_CALL_FW_ON_ERROR,"enabled","Checkbox Activate Call Forward on Error");
	    checkStatus(CB_ACTIVATE_CALL_FW_ON_ERROR,"checked","Checkbox Activate Call Forward on Error");
	    checkStatus(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "enabled", "Input Field Redirect Number on Call Forward on Error");
		checkValue_byId(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "2106923619");
		checkStatus(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "enabled", "Input Field Source IP address on Call Forward on Error");
		checkValue_byId(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "10.1.252.46");
		checkStatus(BTN_CALL_FW_ON_ERROR_ERROR_CODES, "enabled", "Button Call Forward on Error - Error Codes");
		
		//Verify Error Code
		clickButton(BTN_CALL_FW_ON_ERROR_ERROR_CODES);
		updateMap(RETRIES);
		checkText("401");
	
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	

	@Test (priority = 2)
	public void voipDisableCallForward() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CALL_FORWARD);
        updateMap(RETRIES);
         
   
		//Disable Call Forward No Reply
        clickCheckbox_byID(CB_ACTIVATE_CALL_FW_NO_REPLY);
        //The relative fields become disabled
        checkStatus(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward No Reply");
		checkStatus(IPF_CALL_FW_NO_REPLY_RING_DURATION, "disabled", "Input Field Ring Duration on Call Forward No Reply");
		checkStatus(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward No Reply");
	
		
		//Disable Call Forward on Busy
        clickCheckbox_byID(CB_ACTIVATE_CALL_FW_ON_BUSY);
        //The relative fields become disabled
        checkStatus(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Busy");
		checkStatus(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Busy");
		
		//Disable Call Forward on Do not Disturb
		clickCheckbox_byID(CB_ACTIVATE_CALL_FW_DO_NOT_DISTURB);
	    //The relative fields become disabled
	    checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Do not Disturb");
	 	checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Do not Disturb");
	
	 	//Disable Call Forward on Error
		clickCheckbox_byID(CB_ACTIVATE_CALL_FW_ON_ERROR);
		//The relative fields become disabled
		checkStatus(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Error");
		checkStatus(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Error");
		checkStatus(BTN_CALL_FW_ON_ERROR_ERROR_CODES, "disabled", "Button Call Forward on Error - Error Codes");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyVoipCallForwardDisabling() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CALL_FORWARD);
        updateMap(RETRIES);
		
        //Verify Call Forward Disabling
        checkStatus(IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward No Reply");
		checkStatus(IPF_CALL_FW_NO_REPLY_RING_DURATION, "disabled", "Input Field Ring Duration on Call Forward No Reply");
		checkStatus(IPF_CALL_FW_NO_REPLY_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward No Reply");
	
		
	    checkStatus(IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Busy");
		checkStatus(IPF_CALL_FW_ON_BUSY_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Busy");
		
	    checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Do not Disturb");
	 	checkStatus(IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Do not Disturb");
	
	    checkStatus(IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER, "disabled", "Input Field Redirect Number on Call Forward on Error");
		checkStatus(IPF_CALL_FW_ON_ERROR_SOUCE_IP, "disabled", "Input Field Source IP address on Call Forward on Error");
		checkStatus(BTN_CALL_FW_ON_ERROR_ERROR_CODES, "disabled", "Button Call Forward on Error - Error Codes");
	
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	
}