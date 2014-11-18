package com.administration.configuration.logging;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LG03_Logging_Debugging extends SuperHelper implements PropertiesLogging {

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
	
	@Test (alwaysRun = true)
	public void testDebugging() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationLogging();
		
		updateMap(RETRIES);
		//Select TAB debugging
		clickButton(TB_DEBUGGING);
		
		//Enable check boxes
		if(!getCheckboxStatus(CB_ICMP))
			clickCheckbox_byID(CB_ICMP);
		if(!getCheckboxStatus(CB_TRACE_ROUTE))
			clickCheckbox_byID(CB_TRACE_ROUTE);
		if(!getCheckboxStatus(CB_NETWORK_TRACER))
			clickCheckbox_byID(CB_NETWORK_TRACER);
			
		//Type ICMP & trace route
		type_byId(IPF_ICMP, ICMP_TRACEROUTER);
		type_byId(IPF_TRACEROUTE, ICMP_TRACEROUTER);
		
		//Select from drop down menu All interfaces
		selectFromDropDown(SLC_NETWORK_TRACER, readproperties("OpenBranch\\OpenBranchGui", "editLoggingDebuggingTab.allInterfaces"));
		
		//Start
		clickButton(BTN_START);
		
		waitForPageToLoad("15000");
		
		checkText_byId(TXT_ICMP, "Starting ICMP: + ping "+ICMP_TRACEROUTER);
		checkText_byId(TXT_TRACEROUTE, "Starting TRACEROUTE: + traceroute "+ICMP_TRACEROUTER);
		
		clickButton(BTN_STOP);
		waitForPageToLoad("15000");
		
		//Check text
		//checkTextIsContained_byID(TXT_ICMP, "64 bytes from "+ICMP_TRACEROUTER+": icmp_seq=1 ttl=63 time=");
		checkText("64 bytes from "+ICMP_TRACEROUTER+": icmp_seq=1 ttl=63 time=");
		//checkTextIsContained_byID(TXT_TRACEROUTE, OSB_GATEWAY);
		checkText(OSB_GATEWAY);
		
		//Check download Buttons
		checkStatus(BTN_DOWNLOAD_ICMP, "enabled", "Button");
		checkStatus(BTN_DOWNLOAD_TRACEROUTE, "enabled", "Button");
		
		clickButton(BTN_CLEAR_RESULTS);
		//Check that fields after clear are empty
		checkText_byId(TXT_ICMP, "");
		checkText_byId(TXT_TRACEROUTE, "");
		
		clickButtonSave();
		setMethodState();
	}
}