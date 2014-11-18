package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP35_Voip_CommSystem_AddTrustedAddress extends SuperHelper implements PropertiesVoip {

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

	
	@DataProvider(name = "TrustedAddressData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"10.1.252.13","5067",TXT_TCP},
				 {"www.test.com","0",TXT_UDP},
				 {"172.25.2.93","65535",TXT_TLS},
		};	
	}
	
	@Test (priority = 0,dataProvider = "TrustedAddressData")
	public void voipAddTrustedAddress(String x1,String x2,String x3) throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
        
        //Create Trusted Address (input From Data Provider)
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_TRUSTED_IP, x1);
        type_byId(IPF_TRUSTED_PORT, x2);
        selectFromDropDown(SLC_TRUSTED_TRANSPORT, x3);
 
        clickButtonSave();
        updateMap(RETRIES);
 
        //Check Trusted Address Creation
        checkTextIsContained_byXPathTable(TBL_LIST_TRUSTED_ADDRESS, x1);
     	checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, x1, TXT_TRUSTED_ADDRESS_PORT, x2);	
 		checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, x1, TXT_TRUSTED_ADDRESS_TRANSPORT, x3);

		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 1)
	public void applyChanges() throws InterruptedException {
		methodLogger.log();
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 2,dataProvider = "TrustedAddressData")
	public void verifyVoipTrustedAddressCreation(String x1,String x2,String x3) throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //Comm System tab
        clickButton(TB_COMM_SYSTEM);
        
        clickButton(BTN_CONFIGURE_TRUSTED_ADDRESS);
        updateMap(RETRIES);
        
		//Verify Trusted Address Creation
        checkTextIsContained_byXPathTable(TBL_LIST_TRUSTED_ADDRESS, x1);
     	checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, x1, TXT_TRUSTED_ADDRESS_PORT, x2);	
 		checkElementText_inSpecificTableColumn(TBL_LIST_TRUSTED_ADDRESS, x1, TXT_TRUSTED_ADDRESS_TRANSPORT, x3);
	
		//Edit Trusted Address and Verify fields
		clickCheckbox_byText(x1);
		clickButtonEdit();
		updateMap(RETRIES);
		   
		checkValue_byId(IPF_TRUSTED_IP, x1);
		checkValue_byId(IPF_TRUSTED_PORT, x2);
	    checkSelectedValue_inDropDownList(SLC_TRUSTED_TRANSPORT, x3);
	 
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}