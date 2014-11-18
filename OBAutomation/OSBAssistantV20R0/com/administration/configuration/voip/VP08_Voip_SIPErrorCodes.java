package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP08_Voip_SIPErrorCodes extends SuperHelper implements PropertiesVoip {

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
	public void voipEnableAllErrorCodes() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
        
        //Verify that the error codes are by default 33
        checkText_byId(TXT_ERROR_CODES_ALL_ITEMS, "33");
        selectFromDropDown(SLC_ERROR_CODES_ITEMS_PER_PAGE, "50");
     
        //Check that by default the Rerouting is Disabled in Survivable Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
        //Check that by default the Rerouting is Disabled in Normal Mode
	    for (int i=0; i<33; i++)
	     checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
	    
	    //Enable Rerouting in Survivable Mode
	    clickButton(BTN_ENABLE_ALL_SURVIVABLE_MODE);
	    //Check that Rerouting is Enabled in Survivable Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
      
	    //Enable Rerouting in Survivable Mode
	    clickButton(BTN_ENABLE_ALL_NORMAL_MODE);
	    //Check that Rerouting is Enabled in Normal Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
	
	    clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyVoipAllErrorCodesEnabling() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
      
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
      
        //Verify that Rerouting is Enabled in Survivable Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
        //Verify that Rerouting is Enabled in Normal Mode
	    for (int i=0; i<33; i++)
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
	
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}	
	
	@Test (priority = 2)
	public void voipDisableAllErrorCodes() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
        
          
	    //Disable Rerouting in Survivable Mode
	    clickButton(BTN_DISABLE_ALL_SURVIVABLE_MODE);
	    //Check that Rerouting is Disabled in Survivable Mode
	    for (int i=0; i<33; i++)
	    checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
	      
	    //Disable Rerouting in Survivable Mode
	    clickButton(BTN_DISABLE_ALL_NORMAL_MODE);
	    //Check that Rerouting is Disabled in Normal Mode
	    for (int i=0; i<33; i++)
	    checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
	    
	    clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 3)
	public void verifyVoipAllErrorCodesDisabling() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
      
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
      
        //Verify that Rerouting is Disabled in Survivable Mode
	    for (int i=0; i<33; i++)
	    checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image3' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
	
	    //Verify that Rerouting is Disabled in Normal Mode
	    for (int i=0; i<33; i++)
	    checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:"+i+":image4' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
		   
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}
	
	@Test (priority = 4)
	public void voipEnableOneErrorCode() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
        
        //Edit Error Code 300
        clickRadioButton_byText("300");
        clickButtonEdit();
        updateMap(RETRIES);
        
        //Check Default values
        checkStatus(IPF_ERROR_CODE, "disabled", "Input Field Error Code");
		checkValue_byId(IPF_ERROR_CODE, "300");
		checkStatus(CB_ENABLE_REROUTING_SURVIVABLE_MODE,"enabled","Checkbox Enable rerouting in survivable mode");
    	checkStatus(CB_ENABLE_REROUTING_SURVIVABLE_MODE,"unchecked","Checkbox Enable rerouting in survivable mode");
    	checkStatus(CB_ENABLE_REROUTING_NORMAL_MODE,"enabled","Checkbox Enable rerouting in normal mode");
    	checkStatus(CB_ENABLE_REROUTING_NORMAL_MODE,"unchecked","Checkbox Enable rerouting in normal mode");
        
	    //Enable Rerouting in Survivable Mode
	    clickCheckbox_byID(CB_ENABLE_REROUTING_SURVIVABLE_MODE);
	  
	    //Enable Rerouting in Survivable Mode
	    clickCheckbox_byID(CB_ENABLE_REROUTING_NORMAL_MODE);
	   
	    clickButtonSave();
		updateMap(RETRIES);
		
	    //Check that Rerouting is Enabled in Survivable Mode
	    checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image3' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
        //Check that Rerouting is Enabled in Normal Mode
	    checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image4' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
		
	    clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 5)
	public void verifyVoipOneErrorCodesEnabling() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
      
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
      
        //Verify that Rerouting is Enabled in Survivable Mode for Error Code 300
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image3' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
        //Verify that Rerouting is Enabled in Normal Mode for Error Code 300
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image4' and @src='/symphonia-OpenBranchPortlet/images/success_12_a.gif']");
		
        //Edit Error Code 300 and verify fields
        clickRadioButton_byText("300");
        clickButtonEdit();
        updateMap(RETRIES);
        checkStatus(CB_ENABLE_REROUTING_SURVIVABLE_MODE,"checked","Checkbox Enable rerouting in survivable mode");
    	checkStatus(CB_ENABLE_REROUTING_NORMAL_MODE,"checked","Checkbox Enable rerouting in normal mode");
     
        clickButtonCancel();
		updateMap(RETRIES);
		
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	
	
	@Test (priority = 6)
	public void voipDisableOneErrorCode() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
        
        //Edit Error Code 300
        clickRadioButton_byText("300");
        clickButtonEdit();
        updateMap(RETRIES);
            
	    //Disable Rerouting in Survivable Mode
	    clickCheckbox_byID(CB_ENABLE_REROUTING_SURVIVABLE_MODE);
	  
	    //Disable Rerouting in Survivable Mode
	    clickCheckbox_byID(CB_ENABLE_REROUTING_NORMAL_MODE);
	  
	    clickButtonSave();
		updateMap(RETRIES);
		
	    //Check that Rerouting is Disabled in Survivable Mode
		checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image3' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
	    //Check that Rerouting is Disabled in Normal Mode
		checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image4' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
		   
		clickButtonSave();
		updateMap(RETRIES);
	   
	   
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 7)
	public void verifyVoipOneErrorCodeDisabling() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
      
        //Go to Error Codes
        clickButton(BTN_ERROR_CODES);
        updateMap(RETRIES);
      
        //Verify that Rerouting is Disabled in Survivable Mode for Error Code 300
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image3' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
	    //Verify that Rerouting is Disabled in Normal Mode for Error Code 300
        checkElement("//img[@id='errorCodesPopUp:errorCodesGrid:0:image4' and @src='/symphonia-OpenBranchPortlet/images/deactivated_service_32_a.gif']");
		
        //Edit Error Code 300 and verify fields
        clickRadioButton_byText("300");
        clickButtonEdit();
        updateMap(RETRIES);
        checkStatus(CB_ENABLE_REROUTING_SURVIVABLE_MODE,"unchecked","Checkbox Enable rerouting in survivable mode");
    	checkStatus(CB_ENABLE_REROUTING_NORMAL_MODE,"unchecked","Checkbox Enable rerouting in normal mode");
     
        clickButtonCancel();
		updateMap(RETRIES);
			   
        clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
	
		setMethodState();
	}
}