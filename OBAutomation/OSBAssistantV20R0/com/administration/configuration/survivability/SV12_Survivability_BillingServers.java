package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV12_Survivability_BillingServers extends SuperHelper implements PropertiesSurvivability {

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
	public void survivabilitySetBillingServers() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		if(!getCheckboxStatus(CB_TICKET_GENERATION))
			clickCheckbox_byID(CB_TICKET_GENERATION);
		
		selectFromDropDown(SLC_TRANSFER_METHOD, TXT_TRANSFER_METHOD_PUSH);
			
		//Check that the Primary ,Secondary Billing Server fields and the Re-attempt timer field become enabled
	    checkStatus(IPF_PRIMARY_HOSTNAME,"enabled","Input Field Primary Billing Server Hostname"); 
	    checkStatus(IPF_PRIMARY_USERNAME,"enabled","Input Field Primary Billing Server Username"); 
	    checkStatus(IPF_PRIMARY_PASSWORD,"enabled","Input Field Primary Billing Server Password"); 
	    checkStatus(IPF_PRIMARY_CONFIRM_PASSWORD,"enabled","Input Field Primary Billing Confirm Password"); 
	    checkStatus(IPF_SECOND_HOSTNAME,"enabled","Input Field Secondary Billing Server Hostname"); 
	    checkStatus(IPF_SECOND_USERNAME,"enabled","Input Field Secondary Billing Server Username"); 
	    checkStatus(IPF_SECOND_PASSWORD,"enabled","Input Field Secondary Billing Server Password"); 
	    checkStatus(IPF_SECOND_CONFIRM_PASSWORD,"enabled","Input Field Secondary Billing Server Confirm Password"); 
	    checkStatus(IPF_RE_ATTEMPT,"enabled","Input Field Re-attempt timer"); 
	    
	    type_byId(IPF_PRIMARY_HOSTNAME, "10.1.253.100");
	    type_byId(IPF_PRIMARY_USERNAME, "primaryuser");
	    type_byId(IPF_PRIMARY_PASSWORD, "Asd123!.");
	    type_byId(IPF_PRIMARY_CONFIRM_PASSWORD, "Asd123!.");
	    type_byId(IPF_SECOND_HOSTNAME, "10.1.253.200");
	    type_byId(IPF_SECOND_USERNAME, "secondaryuser");
	    type_byId(IPF_SECOND_PASSWORD, "Asd123!.");
	    type_byId(IPF_SECOND_CONFIRM_PASSWORD, "Asd123!.");
	    type_byId(IPF_RE_ATTEMPT, "6");
		clickButtonSave();
		updateMap(RETRIES);
		
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityBillingServersSet() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		checkValue_byId(IPF_PRIMARY_HOSTNAME, "10.1.253.100");
		checkValue_byId(IPF_PRIMARY_USERNAME, "primaryuser");
		checkValue_byId(IPF_PRIMARY_PASSWORD, "Asd123!.");
		checkValue_byId(IPF_PRIMARY_CONFIRM_PASSWORD, "Asd123!.");
		checkValue_byId(IPF_SECOND_HOSTNAME, "10.1.253.200");
		checkValue_byId(IPF_SECOND_USERNAME, "secondaryuser");
		checkValue_byId(IPF_SECOND_PASSWORD, "Asd123!.");
		checkValue_byId(IPF_SECOND_CONFIRM_PASSWORD, "Asd123!.");
		checkValue_byId(IPF_RE_ATTEMPT, "6");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void survivabilityUnsetBillingServers() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		if(!getCheckboxStatus(CB_TICKET_GENERATION))
			clickCheckbox_byID(CB_TICKET_GENERATION);
	 
		selectFromDropDown(SLC_TRANSFER_METHOD, TXT_TRANSFER_METHOD_PULL);
		
		//Check that the Primary ,Secondary Billing Server fields and the Re-attempt timer field become disabled
	    checkStatus(IPF_PRIMARY_HOSTNAME,"disabled","Input Field Primary Billing Server Hostname"); 
	    checkStatus(IPF_PRIMARY_USERNAME,"disabled","Input Field Primary Billing Server Username"); 
	    checkStatus(IPF_PRIMARY_PASSWORD,"disabled","Input Field Primary Billing Server Password"); 
	    checkStatus(IPF_PRIMARY_CONFIRM_PASSWORD,"disabled","Input Field Primary Billing Confirm Password"); 
	    checkStatus(IPF_SECOND_HOSTNAME,"disabled","Input Field Secondary Billing Server Hostname"); 
	    checkStatus(IPF_SECOND_USERNAME,"disabled","Input Field Secondary Billing Server Username"); 
	    checkStatus(IPF_SECOND_PASSWORD,"disabled","Input Field Secondary Billing Server Password"); 
	    checkStatus(IPF_SECOND_CONFIRM_PASSWORD,"disabled","Input Field Secondary Billing Server Confirm Password"); 
	    checkStatus(IPF_RE_ATTEMPT,"disabled","Input Field Re-attempt timer"); 
	    
		clickButtonSave();
		updateMap(RETRIES);
		
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifySurvivabilityBillingServersUnset() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		clickButton(TB_CALL_DETAILED_RECORDS);
		
		checkStatus(IPF_PRIMARY_HOSTNAME,"disabled","Input Field Primary Billing Server Hostname"); 
		checkStatus(IPF_PRIMARY_USERNAME,"disabled","Input Field Primary Billing Server Username"); 
		checkStatus(IPF_PRIMARY_PASSWORD,"disabled","Input Field Primary Billing Server Password"); 
		checkStatus(IPF_PRIMARY_CONFIRM_PASSWORD,"disabled","Input Field Primary Billing Confirm Password"); 
		checkStatus(IPF_SECOND_HOSTNAME,"disabled","Input Field Secondary Billing Server Hostname"); 
		checkStatus(IPF_SECOND_USERNAME,"disabled","Input Field Secondary Billing Server Username"); 
		checkStatus(IPF_SECOND_PASSWORD,"disabled","Input Field Secondary Billing Server Password"); 
		checkStatus(IPF_SECOND_CONFIRM_PASSWORD,"disabled","Input Field Secondary Billing Server Confirm Password"); 
		checkStatus(IPF_RE_ATTEMPT,"disabled","Input Field Re-attempt timer"); 
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}