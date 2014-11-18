package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT05_AutoAttendant_CreateMenus extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantCreateMenusModeManual() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Menus tab
        clickButton(TB_MENUS);
       
        //Create Menu with Activation Mode Manual
        clickButtonAdd();
        updateMap(RETRIES);
        type_byId(IPF_MENU_NAME, "Auto1");
        type_byId(IPF_ACTIVATION_CODE, "10");
        type_byId(IPF_DEACTIVATION_CODE, "20");
        checkStatus(SLC_DAY_START,"disabled","Drop-Down List Day Start");
        checkStatus(SLC_DAY_STOP,"disabled","Drop-Down List Day Stop");
        checkStatus(SLC_TIME1_START_HOUR,"disabled","Drop-Down List Time1 Start Hour");
        checkStatus(SLC_TIME1_START_MINUTE,"disabled","Drop-Down List Time1 Star Minute");
        checkStatus(SLC_TIME1_STOP_HOUR,"disabled","Drop-Down List Time1 Stop Hour");
        checkStatus(SLC_TIME1_STOP_MINUTE,"disabled","Drop-Down List Time1 Stop Minute");
        checkStatus(SLC_TIME2_START_HOUR,"disabled","Drop-Down List Time2 Start Hour");
        checkStatus(SLC_TIME2_START_MINUTE,"disabled","Drop-Down List Time2 Start Minute");
        checkStatus(SLC_TIME2_STOP_HOUR,"disabled","Drop-Down List Time2 Stop Hour");
        checkStatus(SLC_TIME2_STOP_MINUTE,"disabled","Drop-Down List Time2 Stop Minute");
      
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check Menu Creation
        checkTextIsContained_byXPathTable(TBL_LIST_MENU, "1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "1", TXT_MENU_NAME, "Auto1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "1", TXT_ACTIVATION_MODE, TXT_MANUAL);
    	
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	 }
    	
    	
	@Test (priority = 1)
	public void autoAttendantCreateMenusModeAutomatic() throws InterruptedException {
      
		methodLogger.log(); 	
    	goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Menus tab
        clickButton(TB_MENUS);
        
		//Create Menu with Activation Mode Automatic
    	clickButtonAdd();
        updateMap(RETRIES);
    	type_byId(IPF_MENU_NAME, "Auto2");
    	type_byId(IPF_MENU_TIME_OUT, "15");
    	selectFromDropDown(SLC_ACTIVATION_MODE, TXT_AUTOMATIC);
    	//Check that the following drop Down List become enable select values
    	checkStatus(SLC_DAY_START,"enabled","Drop-Down List Day Start");
        checkStatus(SLC_DAY_STOP,"enabled","Drop-Down List Day Stop");
        checkStatus(SLC_TIME1_START_HOUR,"enabled","Drop-Down List Time1 Start Hour");
        checkStatus(SLC_TIME1_START_MINUTE,"enabled","Drop-Down List Time1 Star Minute");
        checkStatus(SLC_TIME1_STOP_HOUR,"enabled","Drop-Down List Time1 Stop Hour");
        checkStatus(SLC_TIME1_STOP_MINUTE,"enabled","Drop-Down List Time1 Stop Minute");
        checkStatus(SLC_TIME2_START_HOUR,"enabled","Drop-Down List Time2 Start Hour");
        checkStatus(SLC_TIME2_START_MINUTE,"enabled","Drop-Down List Time2 Start Minute");
        checkStatus(SLC_TIME2_STOP_HOUR,"enabled","Drop-Down List Time2 Stop Hour");
        checkStatus(SLC_TIME2_STOP_MINUTE,"enabled","Drop-Down List Time2 Stop Minute");
      
        //Check that the Activation code and De-activation Code Input Fields become disabled
        checkStatus(IPF_ACTIVATION_CODE,"disabled","Input Field Activation  Code");
        checkStatus(IPF_DEACTIVATION_CODE,"disabled","Input Field De-Activation  Code");
     
    	//Select values from Drop-Down lists
        selectFromDropDown(SLC_DAY_START, TXT_TUESDAY);
        selectFromDropDown(SLC_DAY_STOP, TXT_THURSDAY);
        selectFromDropDown(SLC_TIME1_START_HOUR, "05");
        selectFromDropDown(SLC_TIME1_START_MINUTE, "10");
        selectFromDropDown(SLC_TIME1_STOP_HOUR, "08");
        selectFromDropDown(SLC_TIME1_STOP_MINUTE, "20");
        selectFromDropDown(SLC_TIME2_START_HOUR, "15");
        selectFromDropDown(SLC_TIME2_START_MINUTE, "30");
        selectFromDropDown(SLC_TIME2_STOP_HOUR, "18");
        selectFromDropDown(SLC_TIME2_STOP_MINUTE, "40");
        selectFromDropDown(SLC_DESTINATION_SELECTION_GREETING_FILE, "connect-to-party.wav");
        selectFromDropDown(SLC_FAILURE_PROMPT_FILE, "enter-num-to-call.wav");
        selectFromDropDown(SLC_DEFAULT_DESTINATION_PROMPT_FILE, "goodbye.wav");
        selectFromDropDown(SLC_FINAL_PROMPT_FILE, "queue-periodic-announce.wav");
        selectFromDropDown(SLC_TRANSFER_PROMPT_FILE, "queue-thankyou.wav");
        selectFromDropDown(SLC_DIAL_METHOD, TXT_EXTENSION_DIALING);
        
        //Enter value for Default Destination
        type_byId(IPF_MENU_DEFAULT_DESTINATION, "25");
        
    	clickButtonSave();     
	    updateMap(RETRIES);
	    
	    //Check Menu Creation
        checkTextIsContained_byXPathTable(TBL_LIST_MENU, "2");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_MENU_NAME, "Auto2");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_ACTIVATION_MODE, TXT_AUTOMATIC);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_START, TXT_TUESDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_STOP, TXT_THURSDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_START, "05:10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_STOP, "08:20");
	    
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	  }
    	
    	@Test (priority = 2)
	   public void autoAttendantCreateMenusModeBoth() throws InterruptedException {
		
    	methodLogger.log(); 	
    	goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Menus tab
        clickButton(TB_MENUS);
        
    	//Create Menu with Activation Mode Both
    	clickButtonAdd();
        updateMap(RETRIES);
    	type_byId(IPF_MENU_NAME, "Auto3");
    	type_byId(IPF_MENU_TIME_OUT, "3");
    	selectFromDropDown(SLC_ACTIVATION_MODE, TXT_BOTH);
    	//Check that the following drop Down List become enable select values
    	checkStatus(SLC_DAY_START,"enabled","Drop-Down List Day Start");
        checkStatus(SLC_DAY_STOP,"enabled","Drop-Down List Day Stop");
        checkStatus(SLC_TIME1_START_HOUR,"enabled","Drop-Down List Time1 Start Hour");
        checkStatus(SLC_TIME1_START_MINUTE,"enabled","Drop-Down List Time1 Star Minute");
        checkStatus(SLC_TIME1_STOP_HOUR,"enabled","Drop-Down List Time1 Stop Hour");
        checkStatus(SLC_TIME1_STOP_MINUTE,"enabled","Drop-Down List Time1 Stop Minute");
        checkStatus(SLC_TIME2_START_HOUR,"enabled","Drop-Down List Time2 Start Hour");
        checkStatus(SLC_TIME2_START_MINUTE,"enabled","Drop-Down List Time2 Start Minute");
        checkStatus(SLC_TIME2_STOP_HOUR,"enabled","Drop-Down List Time2 Stop Hour");
        checkStatus(SLC_TIME2_STOP_MINUTE,"enabled","Drop-Down List Time2 Stop Minute");
      
        //Check that the Activation code and De-activation Code Input Fields become enabled
        checkStatus(IPF_ACTIVATION_CODE,"enabled","Input Field Activation  Code");
        checkStatus(IPF_DEACTIVATION_CODE,"enabled","Input Field De-Activation  Code");
     
    	//Select values from Drop-Down lists
        selectFromDropDown(SLC_TIME1_START_HOUR, "20");
        selectFromDropDown(SLC_TIME1_START_MINUTE, "45");
        selectFromDropDown(SLC_TIME1_STOP_HOUR, "21");
        selectFromDropDown(SLC_TIME1_STOP_MINUTE, "55");
        selectFromDropDown(SLC_DIAL_METHOD, TXT_DIGIT_SELECTION);
        
        //Enter values for Activation and De-activation Code
        type_byId(IPF_ACTIVATION_CODE, "30");
        type_byId(IPF_DEACTIVATION_CODE, "40");
        
        //Enter value for Default Destination
        type_byId(IPF_MENU_DEFAULT_DESTINATION, "35");
        
    	clickButtonSave();     
	    updateMap(RETRIES);
	    
	    //Check Menu Creation
        checkTextIsContained_byXPathTable(TBL_LIST_MENU, "3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_MENU_NAME, "Auto3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_ACTIVATION_MODE, TXT_BOTH);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_DAY_START, TXT_MONDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_DAY_STOP, TXT_FRIDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_TIME1_START, "20:45");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_TIME1_STOP, "21:55");
	    
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 3)
	public void verifyAutoAttendantMenusCreation() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Menus tab
        clickButton(TB_MENUS);
       
        //Verify Menus Creation
        checkTextIsContained_byXPathTable(TBL_LIST_MENU, "1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "1", TXT_MENU_NAME, "Auto1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "1", TXT_ACTIVATION_MODE, TXT_MANUAL);
    	checkTextIsContained_byXPathTable(TBL_LIST_MENU, "2");
      	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_MENU_NAME, "Auto2");
      	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_ACTIVATION_MODE, TXT_AUTOMATIC);
      	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_START, TXT_TUESDAY);
      	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_DAY_STOP, TXT_THURSDAY);
      	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_START, "05:10");
      	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "2", TXT_TIME1_STOP, "08:20");
        checkTextIsContained_byXPathTable(TBL_LIST_MENU, "3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_MENU_NAME, "Auto3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_ACTIVATION_MODE, TXT_BOTH);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_DAY_START, TXT_MONDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_DAY_STOP, TXT_FRIDAY);
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_TIME1_START, "20:45");
    	checkElementText_inSpecificTableColumn(TBL_LIST_MENU, "3", TXT_TIME1_STOP, "21:55");
	  
    	//Edit 1st Menu and Verify fields
    	clickCheckbox_byText("1");
    	clickButtonEdit();
    	updateMap(RETRIES);
    	
        checkValue_byId(IPF_MENU_NAME, "Auto1");
        checkValue_byId(IPF_MENU_TIME_OUT, "10");
        checkSelectedValue_inDropDownList(SLC_ACTIVATION_MODE, TXT_MANUAL);
        checkValue_byId(IPF_ACTIVATION_CODE, "10");
        checkValue_byId(IPF_DEACTIVATION_CODE, "20");
        checkSelectedValue_inDropDownList(SLC_DIAL_METHOD, TXT_BOTH);
    	
	    clickButtonCancel();
	    updateMap(RETRIES);
	    clickCheckbox_byText("1");
	    
		//Edit 2nd Menu and Verify fields
    	clickCheckbox_byText("2");
    	clickButtonEdit();
    	updateMap(RETRIES);
    	
        checkValue_byId(IPF_MENU_NAME, "Auto2");
        checkValue_byId(IPF_MENU_TIME_OUT, "15");
        checkSelectedValue_inDropDownList(SLC_ACTIVATION_MODE, TXT_AUTOMATIC);
        checkSelectedValue_inDropDownList(SLC_DAY_START, TXT_TUESDAY);
        checkSelectedValue_inDropDownList(SLC_DAY_STOP, TXT_THURSDAY);
        checkSelectedValue_inDropDownList(SLC_TIME1_START_HOUR, "05");
        checkSelectedValue_inDropDownList(SLC_TIME1_START_MINUTE, "10");
        checkSelectedValue_inDropDownList(SLC_TIME1_STOP_HOUR, "08");
        checkSelectedValue_inDropDownList(SLC_TIME1_STOP_MINUTE, "20");
        checkSelectedValue_inDropDownList(SLC_TIME2_START_HOUR, "15");
        checkSelectedValue_inDropDownList(SLC_TIME2_START_MINUTE, "30");
        checkSelectedValue_inDropDownList(SLC_TIME2_STOP_HOUR, "18");
        checkSelectedValue_inDropDownList(SLC_TIME2_STOP_MINUTE, "40");
        checkSelectedValue_inDropDownList(SLC_DESTINATION_SELECTION_GREETING_FILE, "connect-to-party.wav");
        checkSelectedValue_inDropDownList(SLC_FAILURE_PROMPT_FILE, "enter-num-to-call.wav");
        checkSelectedValue_inDropDownList(SLC_DEFAULT_DESTINATION_PROMPT_FILE, "goodbye.wav");
        checkSelectedValue_inDropDownList(SLC_FINAL_PROMPT_FILE, "queue-periodic-announce.wav");
        checkSelectedValue_inDropDownList(SLC_TRANSFER_PROMPT_FILE, "queue-thankyou.wav");
        checkSelectedValue_inDropDownList(SLC_DIAL_METHOD, TXT_EXTENSION_DIALING);
        checkValue_byId(IPF_MENU_DEFAULT_DESTINATION, "25");
  
	    clickButtonCancel();
	    updateMap(RETRIES);
	    clickCheckbox_byText("2");

	 	//Edit 3rd Menu and Verify fields
    	clickCheckbox_byText("3");
    	clickButtonEdit();
    	updateMap(RETRIES);
    	
        checkValue_byId(IPF_MENU_NAME, "Auto3");
        checkValue_byId(IPF_MENU_TIME_OUT, "3");
        checkSelectedValue_inDropDownList(SLC_ACTIVATION_MODE, TXT_BOTH);
        
        checkValue_byId(IPF_ACTIVATION_CODE, "30");
        checkValue_byId(IPF_DEACTIVATION_CODE, "40");
        checkSelectedValue_inDropDownList(SLC_DAY_START, TXT_MONDAY);
        checkSelectedValue_inDropDownList(SLC_DAY_STOP, TXT_FRIDAY);
        checkSelectedValue_inDropDownList(SLC_TIME1_START_HOUR, "20");
        checkSelectedValue_inDropDownList(SLC_TIME1_START_MINUTE, "45");
        checkSelectedValue_inDropDownList(SLC_TIME1_STOP_HOUR, "21");
        checkSelectedValue_inDropDownList(SLC_TIME1_STOP_MINUTE, "55");
        checkSelectedValue_inDropDownList(SLC_DIAL_METHOD, TXT_DIGIT_SELECTION);
        checkValue_byId(IPF_MENU_DEFAULT_DESTINATION, "35");

	    clickButtonCancel();
	    updateMap(RETRIES);
	    clickCheckbox_byText("3");
	    
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}