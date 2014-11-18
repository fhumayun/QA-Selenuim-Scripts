package com.administration.cmp.nodes;

import com.Seleniumhelper.SeleniumWebdriver;


public interface PropertiesNodes  {

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
	
	//Dashboard pop-up
	String TBL_LIST_ALARMS = "formName:testGri";
	String BTN_EDIT_NODE_COMMENT = "formName:addComment";
	String BTN_SHOW_ACTIVE_ALARMS = "formName:showActiveAlarmsButton";
	String BTN_SHOW_RAPID_STAT = "formName:actionsGrid:0:statusleftTitle";
	String BTN_SHOW_VERSION = "formName:actionsGrid:1:statusleftTitle";
	String BTN_SHOW_SERVICES_STATUS = "formName:actionsGrid:2:statusleftTitle";
	String BTN_SHOW_LOG_FILES = "formName:actionsGrid:3:statusleftTitle";
	String SLC_NODES_ITEMS_PER_PAGE = "systemStatusForm:systemStatusGrid:rowPerPageForGrid";
	String LBL_CRITICAL_ALARMS = "formName:testGri:0:criticalAlarms";
	
	//Alarms pop-up
	//Texts retrieved from property files
	String TXT_ALARM_ID = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.alarmId");
	String TXT_SEVERITY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.severity");
	String TXT_MANAGED_RESOURCE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.managedResource");
	String TXT_ALARM_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.alarmType");
	String TXT_LAST_OCCURED = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.lastOccured");
	String TXT_ACKNOWLEDGED_STATUS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.acknowledgedStatus");
	String TXT_USER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.user");
	String TXT_HIT_COUNT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAlarms.hitCount");
	
	//Show version pop-up
	String SLC_OB_VERSION = "editGeneral:combobox1";
	String BTN_SHOW_OB_VERSION = "editGeneral:showButton";
	//Texts retrieved from property files
	String TXT_OB_CURRENT_VERSION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editGeneral.currentVersion");
	String TXT_OB_BACKUP_VERSION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editGeneral.backup");

	//Show Log Files pop-up
	String SLC_LOG = "editLog:logfilelist";
	String BTN_SHOW_OB_LOG_FILE = "editLog:logfilelist";
	String BTN_EXPORT_OB_LOG_FILE = "editLog:exportButton";
	String BTN_CLEAR_OB_LOG_FILE = "editLog:clearAction";
	String BTN_CLEAR_ALL_OB_LOG_FILE = "editLog:clearAllButton";
	
	//Services pop-up
	//Texts retrieved from property files
	String TXT_MEDIA_SERVER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "MEDIASERVER");
	String TXT_MS_ADAPTER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "MSADAPTER");
	String TXT_MS_CONVERTER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "MGCPCONVERTER");
	String TXT_DHCP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "DHCP");
	String TXT_DNS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "DNS");
	String TXT_NTP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "NTP");
	String TXT_SNORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SNORT");
	String TXT_VPN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "VPN");
	String TXT_IPsec = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "IPSEC");
	String TXT_BLC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "BLC");
	String TXT_BLS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "BLS");
	String TXT_SSM = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SSM");
	String TXT_SSDP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SSDP");
	String TXT_WEB_SERVER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "WEBSERVER");
	String TXT_B2BUA = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "B2BUA");
	String TXT_SIP_SERVER= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SIPSERVER");
	String TXT_SNMP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SNMP");
	String TXT_PROCCESS_MANAGER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "PROCESSMGR");
	String TXT_RTP_PROXY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "RTPPROXY");
	String TXT_SURVIVABILITY_PROVIDER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SURVIVABILITYPROVIDER");
	String TXT_INTERFACE1 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "INTERFACE1");
	String TXT_INTERFACE2 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "INTERFACE2");
	String TXT_SSH = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SSH");
	String TXT_SYSLOG = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SYSLOG");
	String TXT_ALARM_MANAGER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ALARMMGR");
	String TXT_DBMS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "DBMS");
	String TXT_CHRON = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "CRON");
	String TXT_AUDIT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "AUDIT");
	String TXT_CDR = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "CDR");
	String TXT_REDUDANCY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "REDMNG");
	String TXT_CONTINIOUS_TRACING = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "CONTINUOUSTRACING");

	
	
	
}
