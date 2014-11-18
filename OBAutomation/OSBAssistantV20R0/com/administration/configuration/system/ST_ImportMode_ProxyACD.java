package com.administration.configuration.system;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.administration.configuration.voip.PropertiesVoip;
import com.helper.SuperHelper;


public class ST_ImportMode_ProxyACD extends SuperHelper implements PropertiesVoip {

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
	public void importModeProxyACD() throws InterruptedException {
		
		classMethodLogger.log();
		importXMLFile("C:\\OB_XmlFiles\\OB2LAN-ProxyACD-config.xml");
		checkOBStatusAfterRestart(OpenBranch);	
	
		//Verify mode through voip
		goToAdministrationVoip();
		updateMap(RETRIES);
		checkSelectedValue_inDropDownList(SLC_MODE, TXT_PROXY_ACD);
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
		
	}
	

	
}