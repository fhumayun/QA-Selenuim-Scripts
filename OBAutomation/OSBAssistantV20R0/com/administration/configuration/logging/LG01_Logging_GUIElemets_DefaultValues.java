package com.administration.configuration.logging;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class LG01_Logging_GUIElemets_DefaultValues extends SuperHelper implements PropertiesLogging {

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

	@AfterSuite(alwaysRun = true)
	public void act_CloseBrowser() throws InterruptedException {
		closeBrowser();
    }
	
	@Test (priority = 0)
	public void loggingSettings_CheckDefaultValues() throws InterruptedException {
		 
		classMethodLogger.log(); 
		String[] logLevels = { readproperties("OpenBranch\\OpenBranchGui", "common.emergency"),
				               readproperties("OpenBranch\\OpenBranchGui", "common.alert"),
				               readproperties("OpenBranch\\OpenBranchGui", "common.critical"),
				               readproperties("OpenBranch\\OpenBranchGui", "common.error"),
				               readproperties("OpenBranch\\OpenBranchGui", "common.warning"),
				               readproperties("OpenBranch\\OpenBranchGui", "common.notice"),
				               readproperties("OpenBranch\\OpenBranchGui", "common.info"),
				               readproperties("OpenBranch\\OpenBranchGui", "common.debug") };
		
		String[] casOptions = { readproperties("OpenBranch\\OpenBranchGui", "none"),
	                            readproperties("OpenBranch\\OpenBranchGui", "common.error"),
	                            readproperties("OpenBranch\\OpenBranchGui", "common.warning"),
	                            readproperties("OpenBranch\\OpenBranchGui", "common.notice"),
	                            readproperties("OpenBranch\\OpenBranchGui", "common.debug"),
	                            readproperties("OpenBranch\\OpenBranchGui", "cas_mf_trace"),
	                            readproperties("OpenBranch\\OpenBranchGui", "cas_stack_trace"),
	                            readproperties("OpenBranch\\OpenBranchGui", "cas_trace"),
	                            readproperties("OpenBranch\\OpenBranchGui", "cas_all") };

		
		goToAdministrationLogging();
		updateMap(RETRIES);
		
		//Check selected option,status and all possible options in drop-down lists
		checkSelectedValue_inDropDownList(SLC_SIP_SERVER, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_SIP_SERVER, "enabled", "Drop Down list Sip Server");
		getPossibleValuesOfDropDown(SLC_SIP_SERVER, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_MEDIA_SERVER, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_MEDIA_SERVER, "enabled", "Drop Down list Media Server");
		getPossibleValuesOfDropDown(SLC_MEDIA_SERVER, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_PROCESS_MANAGER, readproperties("OpenBranch\\OpenBranchGui", "common.notice"));
		checkStatus(SLC_PROCESS_MANAGER, "enabled", "Drop Down list Process Manager");
		getPossibleValuesOfDropDown(SLC_PROCESS_MANAGER, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_ALARM_MANAGER, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_ALARM_MANAGER, "enabled", "Drop Down list Alarm Manager");
		getPossibleValuesOfDropDown(SLC_ALARM_MANAGER, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_CONTINUOUS_TRACING, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_CONTINUOUS_TRACING, "enabled", "Drop Down list Continious Tracing");
		getPossibleValuesOfDropDown(SLC_CONTINUOUS_TRACING, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_CAS, readproperties("OpenBranch\\OpenBranchGui", "none"));
		checkStatus(SLC_CAS, "enabled", "Drop Down list CAS");
		getPossibleValuesOfDropDown(SLC_CAS, casOptions);
		
		checkSelectedValue_inDropDownList(SLC_B2BUA, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_B2BUA, "enabled", "Drop Down list B2BUA");
		getPossibleValuesOfDropDown(SLC_B2BUA, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_CDR, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_CDR, "enabled", "Drop Down list CDR");
		getPossibleValuesOfDropDown(SLC_CDR, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_SURVIVABILITY_PROVIDER, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_SURVIVABILITY_PROVIDER, "enabled", "Drop Down list Survivability Provider");
		getPossibleValuesOfDropDown(SLC_SURVIVABILITY_PROVIDER, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_RTP_PROXY, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_RTP_PROXY, "enabled", "Drop Down list Rtp Proxy");
		getPossibleValuesOfDropDown(SLC_RTP_PROXY, logLevels);
		
		checkSelectedValue_inDropDownList(SLC_SSM, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_SSM, "enabled", "Drop Down list SSM");
		getPossibleValuesOfDropDown(SLC_SSM, logLevels);
		
		//Check value and status in input fields
		checkValue_byId(IPF_LOG_SIZE, "256");
		checkStatus(IPF_LOG_SIZE, "enabled", "Input Field Log Size");
		
		checkValue_byId(IPF_LOG_SERVER, "");
		checkStatus(IPF_LOG_SIZE, "enabled", "Input Field Log Server");
		
		//Check checkBoxes status
		checkStatus(CB_FALLBACK_DEFAULT, "enabled", "Checkbox Fallback to Default Log Level");
		checkStatus(CB_FALLBACK_DEFAULT, "checked", "Checkbox Fallback to Default Log Level");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 1)
	public void loggingDebugging_CheckDefaultValues() throws InterruptedException {
		 
		methodLogger.log();
		String[] networkTracerOptions = { readproperties("OpenBranch\\OpenBranchGui", "editLoggingDebuggingTab.allInterfaces"),
				                          readproperties("OpenBranch\\OpenBranchGui", "SIPSERVER"),
				                          readproperties("OpenBranch\\OpenBranchGui", "editLoggingDebuggingTab.sipServerTls"),
				                          readproperties("OpenBranch\\OpenBranchGui", "editLoggingDebuggingTab.ms"),
				                          readproperties("OpenBranch\\OpenBranchGui", "editLoggingDebuggingTab.msAdapter"),
				                          readproperties("OpenBranch\\OpenBranchGui", "editLoggingDebuggingTab.sipmgcptrace")};
		
		goToAdministrationLogging();
		updateMap(RETRIES);
		
		//Go to Debugging tab
		clickButton(TB_DEBUGGING);
		
		//Check Buttons status
		checkStatus(BTN_START,"enabled","Button Start Tracing");
		checkStatus(BTN_STOP,"disabled","Button Stop Tracing");
		checkStatus(BTN_DOWNLOAD_ICMP,"disabled","Button Download ICMP Results");
		checkStatus(BTN_DOWNLOAD_TRACEROUTE,"disabled","Button Download TraceRoute Results");
		checkStatus(By.xpath(BTN_DOWNLOAD_NETWORK_TRACER),"disabled","Button Download Network Tracer Results");
		checkStatus(BTN_CLEAR_RESULTS,"disabled","Button Clear Results");
		
		//Check selected option,status and all possible options in drop-down lists
		checkSelectedValue_inDropDownList(SLC_NETWORK_TRACER, readproperties("OpenBranch\\OpenBranchGui", "editLoggingDebuggingTab.allInterfaces"));
		checkStatus(SLC_NETWORK_TRACER, "enabled", "Drop Down list Network Tracer");
		getPossibleValuesOfDropDown(SLC_NETWORK_TRACER, networkTracerOptions);
		
		
		//Check value and status in input fields
		checkValue_byId(IPF_ICMP, "");
		checkStatus(IPF_ICMP, "enabled", "Input Field ICMP");
		
		checkValue_byId(IPF_TRACEROUTE, "");
		checkStatus(IPF_TRACEROUTE, "enabled", "Input Field TraceRoute");
		
		//Check checkBoxes status
		checkStatus(CB_ICMP, "enabled", "Checkbox ICMP");
		checkStatus(CB_ICMP, "unchecked", "Checkbox ICMP");
		
		checkStatus(CB_TRACE_ROUTE, "enabled", "Checkbox TraceRoute");
		checkStatus(CB_TRACE_ROUTE, "unchecked", "Checkbox TraceRoute");
		
		checkStatus(CB_NETWORK_TRACER, "enabled", "Checkbox Network Tracer");
		checkStatus(CB_NETWORK_TRACER, "unchecked", "Checkbox Network Tracer");
		
		//Check Text Areas
		checkValue_byId(TXT_ICMP, "");
		checkValue_byId(TXT_TRACEROUTE, "");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void loggingContinuousTracing_CheckDefaultValues() throws InterruptedException {
		 
		methodLogger.log();
		goToAdministrationLogging();
		updateMap(RETRIES);
		
		//Go to Continuous Tracing tab
		clickButton(TB_CONTINIOUS_TRACING);
			
		//Check value and status in input fields
		checkValue_byId(IPF_SERVER, "0.0.0.0");
		checkStatus(IPF_SERVER, "disabled", "Input Field Server");
		
		checkValue_byId(IPF_FILE_SIZE, "256");
		checkStatus(IPF_FILE_SIZE, "disabled", "Input Field File Size Threshold");
		
		checkValue_byId(IPF_TIME_INTERVAL, "5");
		checkStatus(IPF_TIME_INTERVAL, "disabled", "Input Field Time Interval Threshold");
		
		checkValue_byId(IPF_SFTP_SYSTEM, "systemName");
		checkStatus(IPF_SFTP_SYSTEM, "disabled", "Input Field SFTP System Name");
		
		checkValue_byId(IPF_SFTP_USERNAME, "username");
		checkStatus(IPF_SFTP_USERNAME, "disabled", "Input Field SFTP UserName");
		
		checkStatus(IPF_SFTP_PASSWORD, "disabled", "Input Field SFTP password");
		
		//Check checkBoxes status
		checkStatus(CB_ENABLE, "enabled", "Checkbox Enable Continuous Tracing");
		checkStatus(CB_ENABLE, "unchecked", "Checkbox Enable Continuous Tracing");
		
		checkStatus(CB_SIP, "disabled", "Checkbox SIP/Q931 Trace");
		checkStatus(CB_SIP, "unchecked", "Checkbox SIP/Q931 Trace");
		
		checkStatus(CB_MGCP, "disabled", "Checkbox MGCP Trace");
		checkStatus(CB_MGCP, "unchecked", "Checkbox MGCP Trace");
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 3)
	public void loggingOnDemandTrace_CheckDefaultValues() throws InterruptedException {
		 
		methodLogger.log();
		//Missing one key
		String[] logTypeOptions = { readproperties("OpenBranch\\OpenBranchGui", "none"),
                                    readproperties("OpenBranch\\OpenBranchGui", "ALARMMGR"),
                                    readproperties("OpenBranch\\OpenBranchGui", "B2BUA"),
                                    readproperties("OpenBranch\\OpenBranchGui", "editVoip.BLC"),
                                    readproperties("OpenBranch\\OpenBranchGui", "editVoip.BLS"),
                                    readproperties("OpenBranch\\OpenBranchGui", "editLoggingOnDemandTab.cdr"),
                                    readproperties("OpenBranch\\OpenBranchGui", "CONTINUOUSTRACING"),
                                    readproperties("OpenBranch\\OpenBranchGui", "editLoggingOnDemandTab.ms"),
                                    readproperties("OpenBranch\\OpenBranchGui", "editLoggingOnDemandTab.pm"),
		                            readproperties("OpenBranch\\OpenBranchGui", "editLoggingOnDemandTab.rtp"),
                                    readproperties("OpenBranch\\OpenBranchGui", "redundancy"),
                                    readproperties("OpenBranch\\OpenBranchGui", "SIPSERVER"),
                                    readproperties("OpenBranch\\OpenBranchGui", "SSM"),
                                    readproperties("OpenBranch\\OpenBranchGui", "SURVIVABILITYPROVIDER")};

		String[] logLevels = { readproperties("OpenBranch\\OpenBranchGui", "common.emergency"),
	                           readproperties("OpenBranch\\OpenBranchGui", "common.alert"),
	                           readproperties("OpenBranch\\OpenBranchGui", "common.critical"),
	                           readproperties("OpenBranch\\OpenBranchGui", "common.error"),
	                           readproperties("OpenBranch\\OpenBranchGui", "common.warning"),
	                           readproperties("OpenBranch\\OpenBranchGui", "common.notice"),
	                           readproperties("OpenBranch\\OpenBranchGui", "common.info"),
	                           readproperties("OpenBranch\\OpenBranchGui", "common.debug") };

		goToAdministrationLogging();
		updateMap(RETRIES);
		
		//Go to Continuous Tracing tab
		clickButton(TB_ON_DEMAND_TRACING);
			
		//Check Buttons status
		checkStatus(BTN_DEMAND_TRACE_START,"disabled","Button Start On Demand Tracing");
		checkStatus(BTN_DEMAND_TRACE_STOP,"disabled","Button Stop On Demand Tracing");
	
		//Check selected option,status and all possible options in drop-down lists
		checkSelectedValue_inDropDownList(SLC_LOG_TYPE, readproperties("OpenBranch\\OpenBranchGui", "none"));
		checkStatus(SLC_LOG_TYPE, "enabled", "Drop Down list Log Type");
		getPossibleValuesOfDropDown(SLC_LOG_TYPE, logTypeOptions);
		
		checkSelectedValue_inDropDownList(SLC_LOG_LEVEL, readproperties("OpenBranch\\OpenBranchGui", "common.error"));
		checkStatus(SLC_LOG_LEVEL, "enabled", "Drop Down list Log level");
		getPossibleValuesOfDropDown(SLC_LOG_LEVEL, logLevels);
		
		//Check value and status in input fields
		checkValue_byId(IPF_DURATION, "5");
		checkStatus(IPF_DURATION, "enabled", "Input Field Duration");
	
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
}