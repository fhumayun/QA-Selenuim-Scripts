package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP18_Voip_BLSEditClient extends SuperHelper implements PropertiesVoip {

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
	public void voipBLSModifyClient() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
       
        //Edit BLS client and modify all fields
		clickCheckbox_byText("AutoTunnel3");
		clickButtonEdit();
		updateMap(RETRIES);
	     
        type_byId(IPF_BLS_CLIENT_TUNNEL_NAME, "AutoTunnel33");
        type_byId(IPF_BLC_HOST_NAME, "AutoHost33");
        type_byId(IPF_BLS_CLIENT_PRIORITY, "40");
        selectFromDropDown(SLC_BLS_CLIENT_PPP_AUTHENTICATION, "PAP");
        type_byId(IPF_BLS_CLIENT_PPP_USER_NAME, "AutoClient33");
        type_byId(IPF_BLS_CLIENT_PPP_PASSWORD, "a11111111!");
        type_byId(IPF_RETRY_AFTER, "3000");
     
        clickButtonSave();
		updateMap(RETRIES);
		
        //Check BLS Client modification
		checkTextIsContained_byXPathTable(TBL_LIST_CLIENTS, "AutoTunnel33");
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, "AutoTunnel33", TXT_BLC_HOST_NAME, "AutoHost33");
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, "AutoTunnel33", TXT_BLS_CLIENT_PRIORITY, "40");
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, "AutoTunnel33", TXT_RETRY_AFTER, "3000");
	
		clickButtonSave();
		updateMap(RETRIES);
			
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	@Test (priority = 1)
	public void verifyVoipBLSClientModification() throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
       
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
      
        //Verify BLS Client modification
		checkTextIsContained_byXPathTable(TBL_LIST_CLIENTS, "AutoTunnel33");
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, "AutoTunnel33", TXT_BLC_HOST_NAME, "AutoHost33");
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, "AutoTunnel33", TXT_BLS_CLIENT_PRIORITY, "40");
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, "AutoTunnel33", TXT_RETRY_AFTER, "3000");
		
		//Edit BLS client and verify fields
		clickCheckbox_byText("AutoTunnel33");
		clickButtonEdit();
		updateMap(RETRIES);
	    checkValue_byId(IPF_BLS_CLIENT_TUNNEL_NAME, "AutoTunnel33");
	    checkValue_byId(IPF_BLC_HOST_NAME, "AutoHost33");
	    checkValue_byId(IPF_BLS_CLIENT_PRIORITY, "40");
        checkSelectedValue_inDropDownList(SLC_BLS_CLIENT_PPP_AUTHENTICATION, "PAP");
        checkValue_byId(IPF_BLS_CLIENT_PPP_USER_NAME, "AutoClient33");
        checkValue_byId(IPF_BLS_CLIENT_PPP_PASSWORD, "a11111111!");
        checkValue_byId(IPF_RETRY_AFTER, "3000");
     
	
		clickButtonCancel();
		updateMap(RETRIES);
		
	    clickButtonCancel();
		updateMap(RETRIES);
		
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}