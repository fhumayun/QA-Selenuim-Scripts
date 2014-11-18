package com.administration.configuration.logging;



public interface PropertiesLogging {
	
	/*
	 * BTN_ := Button ID
	 * IPF_ := Input Field ID 
	 * TB_:= Tab ID
	 * CB_:= Checkbox ID
	 * SLC_:= Selector ID
	 * TEXT_:= Generic Error messages
	 * ARW_:= Arrow ID
	 * LBL_:= Label ID
	 * BD_:= Body ID
	 * TBL_:= Table ID
	 * DIV_ := Div ID
	 * FRN_ := Frame Name
	 * IFR_ := IFrame ID
	 * TD_ := Tabel td ID
	 * XPATH_ := XPath
	 * INF_:= Info Bar
	 * CLM_ := Column Name
	 * TBN:_=Table Name
	 */
	
	//TAB Settings
	String SLC_SIP_SERVER = "editLogging:sipServerCombobox";
	String SLC_MEDIA_SERVER = "editLogging:mediaServerCombobox";
	String SLC_PROCESS_MANAGER = "editLogging:processManagerCombobox";
	String SLC_ALARM_MANAGER = "editLogging:alarmManagerCombobox";
	String SLC_BACKUP_LINK_CLIENT = "editLogging:blcCombobox";
	String SLC_CONTINUOUS_TRACING = "editLogging:ctraceCombobox";
	String SLC_CAS = "editLogging:casCombobox";
	String SLC_B2BUA = "editLogging:b2buaCombobox";
	String SLC_CDR = "editLogging:cdrCombobox";
	String SLC_SURVIVABILITY_PROVIDER = "editLogging:survivabilityProviderCombobox";
	String SLC_RTP_PROXY = "editLogging:rtpProxyCombobox";
	String SLC_ISDN = "editLogging:isdnCombobox";
	String SLC_SSM = "editLogging:ssmCombobox";
	String SLC_BACKUP_LINK_SERVER = "editLogging:blsCombobox";
    String IPF_LOG_SIZE = "editLogging:logSizeField";
	String IPF_LOG_SERVER = "editLogging:logServerField";
	String CB_FALLBACK_DEFAULT = "editLogging:entry11";
	String IPF_FALLBACK_TIME_HOURS_XPATH = "//input[contains(@id,'hours')]";
	String IPF_FALLBACK_TIME_MINUTES_XPATH = "//input[contains(@id,'minutes')]";
	//TAB Debugging
	String TB_DEBUGGING = "editLogging:debuggingTab_tab1";
	String CB_ICMP = "editLogging:debuggingTab:enableIcmp";
	String CB_TRACE_ROUTE = "editLogging:debuggingTab:enableTraceroute";
	String CB_NETWORK_TRACER = "editLogging:debuggingTab:enableNetworkTracer";
	String IPF_ICMP = "editLogging:debuggingTab:optionsToolIcmpField";
	String IPF_TRACEROUTE = "editLogging:debuggingTab:optionsToolTracerouteField";
	String SLC_NETWORK_TRACER = "editLogging:debuggingTab:interfaceCombobox";
	String BTN_START = "editLogging:debuggingTab:startButton";
	String BTN_STOP = "editLogging:debuggingTab:stopButton";
	String BTN_CLEAR_RESULTS = "editLogging:debuggingTab:clearResult";
	String TXT_ICMP = "editLogging:debuggingTab:textAreaIcmp1";
	String TXT_TRACEROUTE = "editLogging:debuggingTab:textAreaTraceroute1";
	String BTN_DOWNLOAD_ICMP = "editLogging:debuggingTab:downloadButton1";
	String BTN_DOWNLOAD_TRACEROUTE = "editLogging:debuggingTab:downloadButton2";
	String BTN_DOWNLOAD_NETWORK_TRACER ="//*/div[@id='debuggingTab']/table[@id='resultsGroup']/tbody/tr[3]/td/table/tbody/tr/td[2]//*/table/tbody/tr/td[2]/input";
	
	//TAB Continious Tracing
	String TB_PROFILES_CONTINIOUS_TRACING = "editLogging:tracingTab_tab1";
	String TB_CONTINIOUS_TRACING = "editLogging:tracingTab_tab2";
	String CB_ENABLE = "editLogging:tracingTab:entryTest";
	String IPF_SERVER = "editLogging:tracingTab:entry2" ;
	String IPF_FILE_SIZE = "editLogging:tracingTab:entry3";
	String IPF_TIME_INTERVAL = "editLogging:tracingTab:entry4";
	String CB_SIP = "editLogging:tracingTab:entry5";
	String CB_MGCP = "editLogging:tracingTab:entry6";
	String IPF_SFTP_SYSTEM = "editLogging:tracingTab:entry8";
	String IPF_SFTP_USERNAME = "editLogging:tracingTab:entry9";
	String IPF_SFTP_PASSWORD = "editLogging:tracingTab:entry10";
	
	//TAB On Demand Trace
	String TB_ON_DEMAND_TRACING = "editLogging:OnDemandTab_tab3";
	String SLC_LOG_TYPE = "editLogging:onDemandTab:onDemandLogTypeCombobox";
	String SLC_LOG_LEVEL = "editLogging:onDemandTab:onDemandLogLevelCombobox";
	String IPF_DURATION = "editLogging:onDemandTab:onDemandDurationEntry";
	String BTN_DEMAND_TRACE_START = "editLogging:onDemandTab:startButtonOnDemand";
	String BTN_DEMAND_TRACE_STOP = "editLogging:onDemandTab:stopButtonOnDemand";
	
	//User Input data
	String LOG_SIZE = "512";
	String LOG_SERVER = "10.1.252.100";
	String HOURS = "10";
	String MINUTES = "15";
	String ICMP_TRACEROUTER = "10.11.212.10";
	String DURATION = "5";
	String OSB_GATEWAY = "192.168.108.1";
	
}
