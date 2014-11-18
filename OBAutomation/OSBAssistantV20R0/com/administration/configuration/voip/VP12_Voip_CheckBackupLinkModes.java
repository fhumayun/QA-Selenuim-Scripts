package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP12_Voip_CheckBackupLinkModes extends SuperHelper implements PropertiesVoip {

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
	public void voipCheckBackupLinkModes() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //OpenBranch Mode is SBC Proxy
        checkSelectedValue_inDropDownList(SLC_MODE, TXT_SBC_PROXY);
        //Check that Backup Link Client and Backup Link Server Configuration are allowed for this mode
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_CLIENT);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"enabled","Button Configure Backup Link Mode");
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_SERVER);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"enabled","Button Configure Backup Link Mode");
 
        
		//Change Mode to Branch SBC
        selectFromDropDown(SLC_MODE, TXT_BRANCH_SBC);
        //Check that only Backup Link Client is allowed for this mode
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_CLIENT);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"enabled","Button Configure Backup Link Mode");
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_SERVER);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"disabled","Button Configure Backup Link Mode");
       
        
        //Change Mode to Proxy
        selectFromDropDown(SLC_MODE, TXT_PROXY);
        //Check that Backup Link Client and Backup Link Server Configuration are allowed for this mode
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_CLIENT);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"enabled","Button Configure Backup Link Mode");
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_SERVER);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"enabled","Button Configure Backup Link Mode");
     
		
		//Change Mode to Proxy ACD
        selectFromDropDown(SLC_MODE, TXT_PROXY_ACD);
        //Check that only Backup Link Client is allowed for this mode
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_CLIENT);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"enabled","Button Configure Backup Link Mode");
        selectFromDropDown(SLC_BACKUP_LINK_MODE, TXT_SERVER);
        checkStatus(BTN_CONFIGURE_BACKUP_LINK_MODE,"disabled","Button Configure Backup Link Mode");
       
	    clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	

}