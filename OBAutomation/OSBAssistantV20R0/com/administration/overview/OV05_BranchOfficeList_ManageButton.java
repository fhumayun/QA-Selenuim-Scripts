package com.administration.overview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class OV05_BranchOfficeList_ManageButton extends SuperHelper implements PropertiesOverview {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToBranchOfficeList()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
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
	public void checkManageButton() throws InterruptedException {
		
		classMethodLogger.log(); 
		
	    clickCheckbox_byText("OB2LAN");
		
		clickButton(BTN_MANAGE_OSB);
	   
	    checkText(TXT_SYSTEM_INFO);
	    checkText(TXT_STATISTICS);
	    checkText(TXT_LICENSING_INFO);
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_alarmSettings_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_logging_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_mediaServer_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_networkServices_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_security_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_survivability_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_system_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_voip_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_acd_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_autoAttendant_styleSwitch']/table/tbody/tr/td[3]/div");
	    checkElement_isVisible("//div[@id='Applications.Operation.OpenBranch.configuration_phoneSwMngmt_styleSwitch']/table/tbody/tr/td[3]/div");
	    setMethodState();
	}
}