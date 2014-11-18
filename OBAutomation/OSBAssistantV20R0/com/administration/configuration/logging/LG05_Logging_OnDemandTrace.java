package com.administration.configuration.logging;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LG05_Logging_OnDemandTrace extends SuperHelper implements PropertiesLogging {

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
	public void startOnDemandTrace() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationLogging();
		
		updateMap(RETRIES);
		
		//Select TAB debugging
		clickButton(TB_ON_DEMAND_TRACING);
		
		//Select as Log type Sip server
		selectFromDropDown(SLC_LOG_TYPE, readproperties("OpenBranch\\OpenBranchGui", "SIPSERVER"));
		
		//Select as Log level Critical
		selectFromDropDown(SLC_LOG_LEVEL, readproperties("OpenBranch\\OpenBranchGui", "CRITICAL"));
		
		//Insert duration
		type_byId(IPF_DURATION, DURATION);
		
		//Click button start
		clickButton(BTN_DEMAND_TRACE_START);
		
		waitForPageToLoad("10000");
		
		checkMessageWarning("OpenBranch\\OpenBranchGuiError", "common.startOnDemandTraceStarted", null);
		
		updateMap(RETRIES);
		
		//Check that start button is disabled & and stop is enabled
		checkStatus(BTN_DEMAND_TRACE_START, "disabled","button");
		checkStatus(BTN_DEMAND_TRACE_STOP, "enabled","button");
	
		//Check status in Drop-Down lists and Input Fields
		checkStatus(SLC_LOG_TYPE, "disabled", "Drop Down list Log Type");
		checkStatus(SLC_LOG_LEVEL, "disabled", "Drop Down list Log level");
		checkStatus(IPF_DURATION, "disabled", "Input Field Duration");
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		checkStatus(BTN_APPLYCHANGES,  "disabled", "button");
		checkStatus(BTN_CANCELCHANGES, "disabled", "button");
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyOnDemandTraceStart() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationLogging();
		
		updateMap(RETRIES);
		
		checkMessageWarning("OpenBranch\\OpenBranchGuiError", "editLogging.onDemandRunning", null);
		
		updateMap(RETRIES);
		
		//Select TAB debugging
		clickButton(TB_ON_DEMAND_TRACING);
		
		//Verify that start button is disabled & and stop is enabled
		checkStatus(BTN_DEMAND_TRACE_START, "disabled","button");
		checkStatus(BTN_DEMAND_TRACE_STOP, "enabled","button");
		
		//Verify values and status in Drop-Down lists and Input Fields
		checkSelectedValue_inDropDownList(SLC_LOG_TYPE, readproperties("OpenBranch\\OpenBranchGui", "SIPSERVER"));
		checkSelectedValue_inDropDownList(SLC_LOG_LEVEL, readproperties("OpenBranch\\OpenBranchGui", "CRITICAL"));
		checkStatus(SLC_LOG_TYPE, "disabled", "Drop Down list Log Type");
		checkStatus(SLC_LOG_LEVEL, "disabled", "Drop Down list Log level");
		checkValue_byId(IPF_DURATION, DURATION);
		checkStatus(IPF_DURATION, "disabled", "Input Field Duration");
		
		clickButtonCancel();
		
		updateMap(RETRIES);
		
		setMethodState();
		
	}
	
	@Test (priority = 2)
	public void stopOnDemandTrace() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationLogging();

		updateMap(RETRIES);
		
		checkMessageWarning("OpenBranch\\OpenBranchGuiError", "editLogging.onDemandRunning", null);
		
		updateMap(RETRIES);
		
		//Select TAB debugging
		clickButton(TB_ON_DEMAND_TRACING);
		
		//Click button Stop
		clickButton(BTN_DEMAND_TRACE_STOP);
		waitForPageToLoad("10000");
		checkMessageWarning("OpenBranch\\OpenBranchGuiError", "common.stopOnDemandTraceStarted", null);
		
		updateMap(RETRIES);
	
		//Check that start button is enabled & and stop is disabled
		checkStatus(BTN_DEMAND_TRACE_START, "enabled","button");
		checkStatus(BTN_DEMAND_TRACE_STOP, "disabled","button");
	
		clickButtonSave();
		
		updateMap(RETRIES);
		
		checkStatus(BTN_APPLYCHANGES,  "disabled", "button");
		checkStatus(BTN_CANCELCHANGES, "disabled", "button");
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyOnDemandTraceStop() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationLogging();
		
		updateMap(RETRIES);
	
		//Select TAB debugging
		clickButton(TB_ON_DEMAND_TRACING);
		
		//Verify that default settings are restored after stopping On Demand Trace
		//Check Buttons status
		checkStatus(BTN_DEMAND_TRACE_START,"disabled","Button Start On Demand Tracing");
		checkStatus(BTN_DEMAND_TRACE_STOP,"disabled","Button Stop On Demand Tracing");
	
		//Check selected option,status and all possible options in drop-down lists
		checkSelectedValue_inDropDownList(SLC_LOG_TYPE, readproperties("OpenBranch\\OpenBranchGui", "none"));
		checkStatus(SLC_LOG_TYPE, "enabled", "Drop Down list Log Type");
		
		checkSelectedValue_inDropDownList(SLC_LOG_LEVEL, readproperties("OpenBranch\\OpenBranchGui", "common.emergency"));
		checkStatus(SLC_LOG_LEVEL, "enabled", "Drop Down list Log level");
		
		clickButtonCancel();
		
		updateMap(RETRIES);
		
		setMethodState();
		
	}
}