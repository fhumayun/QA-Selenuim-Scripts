package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV05_Survivability_AddEmergencyCalling extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilityAddEmergencyCalling() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Emergency Calling
		clickButton(TB_EMERGENCY_CALLING);
		
		clickButtonAdd();
		updateMap(RETRIES);
			
		type_byId(IPF_GENERAL_IP, "10.1.255.105");
		type_byId(IPF_GENERAL_SUBNET, "255.255.255.0");
		type_byId(IPF_GENERAL_DEFAULT_DEST, "210778001");
		selectFromDropDown(SLC_GENERIC_ROUTING_PREFIX, "None");
		clickCheckbox_byID(CB_GENERAL_LIN);
		clickButtonSave();
		
		//checkMessageFailed("OpenBranch\\OpenBranchGuiError", "surivivabilityEmergencyCalling.linListEmpty", null);
		
		String valMessage = readproperties("OpenBranch\\OpenBranchGuiError", "surivivabilityEmergencyCalling.linListEmpty");
		String[] messageWords = valMessage.split(" ");
		String checkMessage = messageWords[0]+" "+messageWords[1]+" "+messageWords[2]+" "+messageWords[3]+" "+messageWords[4]+" "+messageWords[5];
		
		sleep(2000);
		selectWindow_ByTitle(readproperties("messagehandlingportlet\\MessageHandling","displayMessages.failedWindowTitle"));
		waitForPageToLoad("3000");
		checkText(checkMessage);
		clickButtonClose();
		
		updateMap(RETRIES);
		clickButton(TAB_LIN);
		
		clickButtonAdd();
		updateMap(RETRIES);
		type_byId(IPF_LIN_FIELD, "150180210");
		type_byId(IPF_LIN_CALLBACK, "2107778002");
		type_byId(IPF_LIN_DEFAULT_CALLBACK,"2105551000");
		clickCheckbox_byID(CB_LIN_USE_DEFAULT);
		
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check LIN creation
		checkText("150180210");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "150180210", TXT_LIST_LIN_CALLBACK_NUMBER, "2107778002");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "150180210", TXT_LIST_LIN_DEFAULT_CALLBACK_NUMBER, "2105551000");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check creation
		checkText("10.1.255.105");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.1.255.105", TXT_LIST_EMERGENCY_CALLING_SUBNET_MASK, "255.255.255.0");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.1.255.105", "Routing Prefix", "None");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.1.255.105", TXT_LIST_EMERGENCY_ROUTING_DEFAULT_DESTINATION, "210778001");
		
		clickButtonSave();
		
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityEmergencyCallingCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Emergency Calling
		clickButton(TB_EMERGENCY_CALLING);
		
		//Verify Emergency Calling creation
		checkText("10.1.255.105");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.1.255.105", TXT_LIST_EMERGENCY_CALLING_SUBNET_MASK, "255.255.255.0");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.1.255.105", "Routing Prefix", "None");
		checkElementText_inSpecificTableColumn(TBL_LIST_EMERGENCY_CALLING, "10.1.255.105", TXT_LIST_EMERGENCY_ROUTING_DEFAULT_DESTINATION, "210778001");
		
		//Edit the Emergency Calling and verify all fields
		clickCheckbox_byText("10.1.255.105");
		clickButton(BTN_EMERGENCY_EDIT);
		updateMap(RETRIES);
		checkValue_byId(IPF_GENERAL_IP, "10.1.255.105");
		checkValue_byId(IPF_GENERAL_SUBNET, "255.255.255.0");
		checkValue_byId(IPF_GENERAL_DEFAULT_DEST, "210778001");
		checkValue_inDropDownList(SLC_GENERIC_ROUTING_PREFIX, "None");
		checkStatus(CB_GENERAL_LIN, "checked", "checkbox");
		
		clickButton(TAB_LIN);
		
		//Verify LIN creation
		checkText("150180210");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "150180210", TXT_LIST_LIN_CALLBACK_NUMBER, "2107778002");
		checkElementText_inSpecificTableColumn(TBL_LIST_LIN, "150180210", TXT_LIST_LIN_DEFAULT_CALLBACK_NUMBER, "2105551000");
		
		//Edit the LIN
		clickCheckbox_byText("150180210");
		clickButton(BTN_LIN_EDIT);
		updateMap(RETRIES);
		checkValue_byId(IPF_LIN_FIELD, "150180210");
		checkValue_byId(IPF_LIN_CALLBACK, "2107778002");
		checkValue_byId(IPF_LIN_DEFAULT_CALLBACK,"2105551000");
		checkStatus(CB_LIN_USE_DEFAULT, "checked", "checkbox");
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}