package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV01_Survivability_GUIElemets_DefaultValues extends SuperHelper implements PropertiesSurvivability {

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
	public void networkServices_CheckDefaultValues() throws InterruptedException {
			
		String[] transferMethodOptions = {TXT_TRANSFER_METHOD_PUSH,TXT_TRANSFER_METHOD_PULL};
		
		classMethodLogger.log(); 
		goToAdministrationSurvivability();
        updateMap(RETRIES);
        
        //Tab Multi Line Hunt Groups
        checkStatus(BTN_MULTI_LINE_HG_ADD, "enabled", "Button Add MLHG");
        checkStatus(BTN_MULTI_LINE_HG_EDIT, "disabled", "Button Edit MLHG");
        checkStatus(BTN_MULTI_LINE_HG_DELETE, "disabled", "Button Delete MLHG");
        

        //Tab Emergency Calling
        clickButton(TB_EMERGENCY_CALLING);
        
        checkStatus(BTN_EMERGENCY_ADD, "enabled", "Button Add Emergency Calling");
        checkStatus(BTN_EMERGENCY_EDIT, "disabled", "Button Edit Emergency Calling");
        checkStatus(BTN_EMERGENCY_DELETE, "disabled", "Button Delete Emergency Calling");
        
        
        //Tab Emergency Number
        clickButton(TB_EMERGENCY_NUMBER);
        
        checkStatus(BTN_EMERGENCY_NUMBER_ADD, "enabled", "Button Add Emergency Number");
        checkStatus(BTN_EMERGENCY_NUMBER_DELETE, "disabled", "Button Delete Emergency Number");
        checkStatus(IPF_EMERGENCY_NUMBER_FIELD, "enabled", "Input Field Emergency Number");
        
        //Tab Call Detail Records
        clickButton(TB_CALL_DETAILED_RECORDS);
        
        checkStatus(CB_TICKET_GENERATION,"enabled","Checkbox Enable Ticket Generation"); 
        checkStatus(CB_TICKET_GENERATION,"checked","Checkbox Enable Ticket Generation"); 
       
        checkStatus(IPF_PRIMARY_HOSTNAME,"disabled","Input Field Primary Billing Server Hostname"); 
        checkValue_byId(IPF_PRIMARY_HOSTNAME, "");
        
        checkStatus(IPF_PRIMARY_USERNAME,"disabled","Input Field Primary Billing Server Username"); 
        checkValue_byId(IPF_PRIMARY_USERNAME, "");
        
        checkStatus(IPF_PRIMARY_PASSWORD,"disabled","Input Field Primary Billing Server Password"); 
        checkValue_byId(IPF_PRIMARY_PASSWORD, "");
        
        checkStatus(IPF_PRIMARY_CONFIRM_PASSWORD,"disabled","Input Field Primary Billing Confirm Password"); 
        checkValue_byId(IPF_PRIMARY_CONFIRM_PASSWORD, "");
      
        checkStatus(IPF_SECOND_HOSTNAME,"disabled","Input Field Secondary Billing Server Hostname"); 
        checkValue_byId(IPF_SECOND_HOSTNAME, "");
        
        checkStatus(IPF_SECOND_USERNAME,"disabled","Input Field Secondary Billing Server Username"); 
        checkValue_byId(IPF_SECOND_USERNAME, "");
        
        checkStatus(IPF_SECOND_PASSWORD,"disabled","Input Field Secondary Billing Server Password"); 
        checkValue_byId(IPF_SECOND_PASSWORD, "");
        
        checkStatus(IPF_SECOND_CONFIRM_PASSWORD,"disabled","Input Field Secondary Billing Server Confirm Password"); 
        checkValue_byId(IPF_SECOND_CONFIRM_PASSWORD, "");
      
        checkStatus(SLC_TRANSFER_METHOD, "enabled", "Drop-Down List Transfer Method");
        checkSelectedValue_inDropDownList(SLC_TRANSFER_METHOD, TXT_TRANSFER_METHOD_PULL);
        getPossibleValuesOfDropDown(SLC_TRANSFER_METHOD, transferMethodOptions);
       
        checkStatus(IPF_MAX_RECORD_VALUE,"enabled","Input Field Max number of records"); 
        checkValue_byId(IPF_MAX_RECORD_VALUE, "1000");
      
        checkStatus(IPF_MAX_TIME_INTERVAL,"enabled","Input Field Max time interval"); 
        checkValue_byId(IPF_MAX_TIME_INTERVAL, "5");
        
        checkStatus(IPF_MAX_FILE_SIZE,"enabled","Input Field Max file size"); 
        checkValue_byId(IPF_MAX_FILE_SIZE, "250");
        
        checkStatus(IPF_PORT,"enabled","Input Field Port"); 
        checkValue_byId(IPF_PORT, "22");
        
        checkStatus(IPF_RE_ATTEMPT,"disabled","Input Field Re-attempt timer"); 
        checkValue_byId(IPF_RE_ATTEMPT, "5");
     
        checkStatus(CB_E164,"enabled","Checkbox E.164 Translation"); 
        checkStatus(CB_E164,"unchecked","Checkbox E.164 Translation"); 
       
        checkStatus(CB_ALLOW_OVERWRITE,"enabled","Checkbox Allow file overwrite"); 
        checkStatus(CB_ALLOW_OVERWRITE,"unchecked","Checkbox Allow file overwrite"); 
       
        checkStatus(BTN_CONFIGURE_TRANSLATION, "disabled", "Button Configure E.164 Translation");
      
        
        //Tab Music On Hold
        clickButton(TB_MUSIC_ON_HOLD);    
        
        checkStatus(CB_ENABLE_MOH,"enabled","Checkbox Enable MOH"); 
        checkStatus(CB_ENABLE_MOH,"unchecked","Checkbox Enable MOH"); 
       
        checkStatus(CB_ENABLE_MOH_SUB,"disabled","Enable MOH for Subscribers"); 
        checkStatus(CB_ENABLE_MOH_SUB,"unchecked","Enable MOH for Subscribers"); 
       
        clickButtonCancel();
        updateMap(RETRIES);
		setMethodState();
	}

}