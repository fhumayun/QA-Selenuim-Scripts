package com.administration.configuration.alarms;



public interface PropertiesAlarms {
	
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
	 * IMG:_=Image(GIF)
	 * CLS_ := Column Span ID
	 */
	
	//ALARMS_SETTINGS
	String TBL_LIST_ALARMS = "editAlarmSettings:alarmGrid";
	String TBL_ALARMS_ALL_ITEMS = "alarmGrid_gridTableHelpBar";
	String BTN_ALARMS_EDIT = "editAlarmSettings:alarmGrid:edit";
	String CB_ALARMS_SET_ACTIVE = "alarmSettingsAlarmPopUp:activeCheckbox";
	String SLC_ALARMS_SEVERITY = "alarmSettingsAlarmPopUp:severityCombobox";
	String SLC_ALARMS_ITEMS_PER_PAGE = "editAlarmSettings:alarmGrid:rowPerPageForGrid";
	String IPF_ALARMS_FLOW_TIMER="alarmSettingsAlarmPopUp:flawtimerField";
	String IPF_ALARMS_REPORTING_CLASS="alarmSettingsAlarmPopUp:reportingClassField";
	String IPF_ALARMS_GROUP_ID = "alarmSettingsAlarmPopUp:groupIdField";
	String IPF_ALARMS_GROUP_NAME = "alarmSettingsAlarmPopUp:groupNameField";
	String IPF_ALARMS_EVENT_ID = "alarmSettingsAlarmPopUp:eventIdField";
	String IPF_ALARMS_EVENT_NAME = "alarmSettingsAlarmPopUp:eventNameField";   
	String IPF_ALARMS_FAULTY_OBJECT = "alarmSettingsAlarmPopUp:faultObjectField";
	String IPF_ALARMS_EVENT_TYPE = "alarmSettingsAlarmPopUp:eventTypeField";
	String IPF_ALARMS_THRESHOLD_TRIGGER = "alarmSettingsAlarmPopUp:triggerField";
	String IPF_ALARMS_THRESHOLD = "alarmSettingsAlarmPopUp:thresholdField";
	String CLS_ALARMS_LIST_1st_ALARM_TRIGGER = "editAlarmSettings:alarmGrid:0:trigger";
	String CLS_ALARMS_LIST_1st_ALARM_SEVERITY = "editAlarmSettings:alarmGrid:0:severity";
	String CLS_ALARMS_LIST_1st_ALARM_REPORTING_CLASS = "editAlarmSettings:alarmGrid:0:reportClass";
    String DIV_ALARMS_THRESHOLD_VALIDATION = "threshold_messages_id1";
    String DIV_ALARMS_FLOW_TIMER_VALIDATION = "flawtimer_messages_id1";
    String DIV_ALARMS_REPORTING_CLASS_VALIDATION = "reportingClass_messages_id1";
	
	
	//ALARMS_TRAP DESTINATIONS
    String TB_PROFILES_ALARMS_TRAP_DESTINATIONS = "editAlarmSettings:tabSnmp_tab0";
	String TB_ALARMS_TRAP_DESTINATIONS = "editAlarmSettings:tabSnmp_tab1";
	String TBL_ALARMS_LIST_TRAP_DESTINATIONS = "editAlarmSettings:snmpTab:snmpGrid";
	String TBL_ALARMS_TRAP_DEST_ALL_ITEMS = "snmpGrid_gridTableHelpBar";
	String TD_NUMBER_OF_SELECTED_ITEMS_IN_TRAP_DESTINATIONS_LIST = "editAlarmSettings:snmpTab:snmpGrid:selectedItemsNumberId";
	String IPF_ALARMS_TRAP_DEST_IP_ADDRESS = "utilitiesSnmpPopUp:ipAddressField";
	String IPF_ALARMS_TRAP_DEST_PORT = "utilitiesSnmpPopUp:portField";
	String IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET = "utilitiesSnmpPopUp:snmpCommunicationField";
	String IMG_ALARMS_TRAP_DEST_BLOCKED="editAlarmSettings:snmpTab:snmpGrid:0:enabledImage"; //VERIFY IF CHECKED IMG APPEAR
	String BTN_ALARMS_TRAP_DEST_ADD_BUTTON = "editAlarmSettings:snmpTab:snmpGrid:addButton";
	String BTN_ALARMS_TRAP_DEST_EDIT_BUTTON = "editAlarmSettings:snmpTab:snmpGrid:editButton";	
    String BTN_ALARMS_TRAP_DEST_DELETE_BUTTON = "editAlarmSettings:snmpTab:snmpGrid:deleteButtonSnmp";
    String CB_ALARMS_TRAP_DEST_BLOCKED = "utilitiesSnmpPopUp:blocked";
    String SLC_ALARMS_TRAP_DEST_ITEMS_PER_PAGE = "editAlarmSettings:snmpTab:snmpGrid:rowPerPageForGrid";
    String DIV_ALARMS_TRAP_DEST_IP_VALIDATION = "ipAddressComposite_messages_id1";
    String DIV_ALARMS_TRAP_DEST_PORT_VALIDATION = "portComposite_messages_id1";
    String DIV_ALARMS_TRAP_DEST_REPORTING_CLASS_VALIDATION = "snmpCommunicationComposite_messages_id1";
	
}
