package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP36_Voip_CommSystem_EditTrustedAddress extends SuperHelper implements PropertiesVoip {

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
	public void voipModifyTrustedAddress() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
        
        //Modify Trusted Address
        clickCheckbox_byText("10.1.252.13");
        clickButtonEdit();
        updateMap(RETRIES);
        
        type_byId(IPF_TRUSTED_IP, "10.1.252.15");
        type_byId(IPF_TRUSTED_PORT, "6057");
        selectFromDropDown(SLC_TRUSTED_TRANSPORT, TXT_UDP);
 
        clickButtonSave();
        updateMap(RETRIES);
 
        //Check Trusted Address Modification
        checkTextIsContained_byXPathTable(TBL_LIST_TRUSTED_ADDRESS, "10.1.252.15");
     	checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, "10.1.252.15", TXT_TRUSTED_ADDRESS_PORT, "6057");	
 		checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, "10.1.252.15", TXT_TRUSTED_ADDRESS_TRANSPORT, TXT_UDP);

		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 1)
	public void verifyVoipTrustedAddressModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
        
		//Verify Trusted Address Modification
        checkTextIsContained_byXPathTable(TBL_LIST_TRUSTED_ADDRESS, "10.1.252.15");
     	checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, "10.1.252.15", TXT_TRUSTED_ADDRESS_PORT, "6057");	
 		checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, "10.1.252.15", TXT_TRUSTED_ADDRESS_TRANSPORT, TXT_UDP);

		//Edit Trusted Address and Verify fields
		clickCheckbox_byText("10.1.252.15");
		clickButtonEdit();
		updateMap(RETRIES);
		   
		checkValue_byId(IPF_TRUSTED_IP, "10.1.252.15");
		checkValue_byId(IPF_TRUSTED_PORT, "6057");
	    checkSelectedValue_inDropDownList(SLC_TRUSTED_TRANSPORT, TXT_UDP);
	 
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}