package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP16_Voip_BLSAddClient extends SuperHelper implements PropertiesVoip {

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

	@DataProvider(name = "BLSClient")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"AutoTunnel1","AutoHost1","1","None","","","0"},
				 {"AutoTunnel2","AutoHost2","20","PAP","AutoClient2","LS612dF3","100"},
				 {"AutoTunnel3","AutoHost3","50","MSCHAP-V2","AutoClient3","T@R63dis","3600"},
		};	
	}

	
	@Test (priority = 0,dataProvider = "BLSClient")
	public void voipBLSAddClient(String x1,String x2,String x3,String x4,String x5,String x6,String x7) throws InterruptedException {
		
		classMethodLogger.log(); 
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Create BLS Client (input From Data Provider)
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
       
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_BLS_CLIENT_TUNNEL_NAME, x1);
        type_byId(IPF_BLC_HOST_NAME, x2);
        type_byId(IPF_BLS_CLIENT_PRIORITY, x3);
        selectFromDropDown(SLC_BLS_CLIENT_PPP_AUTHENTICATION, x4);
        type_byId(IPF_BLS_CLIENT_PPP_USER_NAME, x5);
        type_byId(IPF_BLS_CLIENT_PPP_PASSWORD, x6);
        type_byId(IPF_RETRY_AFTER, x7);
     
        clickButtonSave();
		updateMap(RETRIES);
		
        //Check BLS Client creation
		checkTextIsContained_byXPathTable(TBL_LIST_CLIENTS, x1);
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, x1, TXT_BLC_HOST_NAME, x2);
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, x1, TXT_BLS_CLIENT_PRIORITY, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, x1, TXT_RETRY_AFTER, x7);
	
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
	
	@Test (priority = 2,dataProvider = "BLSClient")
	public void verifyVoipBLSClientCreation(String x1,String x2,String x3,String x4,String x5,String x6,String x7) throws InterruptedException {
		
		methodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
       
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
      
        //Verify BLS Client creation
		checkTextIsContained_byXPathTable(TBL_LIST_CLIENTS, x1);
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, x1, TXT_BLC_HOST_NAME, x2);
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, x1, TXT_BLS_CLIENT_PRIORITY, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_CLIENTS, x1, TXT_RETRY_AFTER, x7);
		
		//Edit BLS client and verify fields
		clickCheckbox_byText(x1);
		clickButtonEdit();
		updateMap(RETRIES);
	    checkValue_byId(IPF_BLS_CLIENT_TUNNEL_NAME, x1);
	    checkValue_byId(IPF_BLC_HOST_NAME, x2);
	    checkValue_byId(IPF_BLS_CLIENT_PRIORITY, x3);
        checkSelectedValue_inDropDownList(SLC_BLS_CLIENT_PPP_AUTHENTICATION, x4);
        checkValue_byId(IPF_BLS_CLIENT_PPP_USER_NAME, x5);
        checkValue_byId(IPF_BLS_CLIENT_PPP_PASSWORD, x6);
        checkValue_byId(IPF_RETRY_AFTER, x7);
     
	
		clickButtonCancel();
		updateMap(RETRIES);
		
	    clickButtonCancel();
		updateMap(RETRIES);
		
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 3)
	public void voipBLSAddClientFails() throws InterruptedException {
		
		methodLogger.log(); 
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Create BLS Client with same priority than Existing One fails
        clickButton(BTN_CONFIGURE_BACKUP_LINK_MODE);
        updateMap(RETRIES);
        clickButton_ByXpath(TB_SERVER_MODE_CLIENTS_XPATH);
       
        clickButtonAdd();
        updateMap(RETRIES);
        
        type_byId(IPF_BLS_CLIENT_TUNNEL_NAME, "AutoTunnel4");
        type_byId(IPF_BLC_HOST_NAME,"AutoHost4");
        type_byId(IPF_BLS_CLIENT_PRIORITY, "20");
        selectFromDropDown(SLC_BLS_CLIENT_PPP_AUTHENTICATION, "None");
        type_byId(IPF_RETRY_AFTER, "200");
     
        clickButtonSave();

        //The action fails
		checkMessageFailed("OpenBranch\\OpenBranchGuiError", "editBlsClient.duplicatePriority", null);
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
			
	    clickButtonCancel();
		updateMap(RETRIES);
		
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}