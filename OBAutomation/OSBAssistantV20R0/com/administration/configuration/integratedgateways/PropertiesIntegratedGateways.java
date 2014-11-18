package com.administration.configuration.integratedgateways;

import com.Seleniumhelper.SeleniumWebdriver;

public interface PropertiesIntegratedGateways {

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

	//INTEGRATED GATEWAYS CONFIGURATION (PRI 1 PORT CARD) 
	//INTEGRATED GATEWAYS CONFIGURATION -- TAB GENERAL
	String TB_IGWGENERAL = "editConfigureForm:voip_tab0";
	String SLC_COUNTRY = "editConfigureForm:countryCombobox";
	String BTN_COUNTRY_CONF_INFO = "editConfigureForm:countryInfo";
	String BTN_PRI1_CONFIGURE = "editConfigureForm:bri1";
	String BTN_PRI1_TRUNK_GROUP = "editConfigureForm:trunkGroup1";
	String CB_ENABLE_FAX_T38 = "editConfigureForm:faxT38Entry";
	String CB_ENABLE_CNG_DETECTION = "editConfigureForm:cngDetectionEntry";
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 -- (CONFIGURE BUTTON)
	String TB_PRI1_GENERAL = "priConfigurationForm:basicGroups_tab0";
	String TB_CAS_SETTINGS = "priConfigurationForm:casSettings_tab1";
	String IPF_METHOD = "priConfigurationForm:methodEntry"; 									
	String BTN_EDIT_PORT_CONF_PRI = "priConfigurationForm:priConfigurationListGrid:editButton";
	//TEXTS (IN LIST PORT CONFIGURATION) -- PRI1 retrieved from property files
	String TXT_LIST_PRI1_PHYSICAL_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "priConfiguration.physicalPort");
	String TXT_LIST_PRI1_ENABLED = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.enabled");
	String TXT_LIST_PRI1_FRAMING = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "priConfigurationModifyPri");
	String TXT_LIST_PRI1_CLOCK_SOURCE_PRIORITY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "priConfiguration.clockSourcePriority");
	String TXT_LIST_PRI1_CODING_ = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "priConfigurationModifyPri.coding");
	String TXT_LIST_PRI1_SWITCH_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "priConfigurationModifyPri.switchType");
	String TXT_LIST_PRI1_LINE_BUILD_OUT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "priConfigurationModifyPri.lbo");
	String TXT_LIST_PRI1_TERMINAL_MODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "priConfiguration.terminalMode");
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 CONFIGURATION -- (EDIT PORT 1 IN LIST PORT CONFIGURATION)
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 CONFIGURATION -- (EDIT PORT 1 IN LIST PORT CONFIGURATION) -- TAB GENERAL
	String CB_ENABLE_PRI1_CONF = "priConfigurationModifyPriForm:enabledEntry";
	String SLC_PRI1_PORT = "priConfigurationModifyPriForm:portEntry";
	String SLC_PRI1_SWITCH_TYPE = "priConfigurationModifyPriForm:switchTypeEntry";
	String SLC_PRI1_FRAMING = "priConfigurationModifyPriForm:framingEntry";
	String CB_PRI1_EXCLUSIVE_CHANNEL = "priConfigurationModifyPriForm:framingEntry";
	String CB_PRI1_TERMINAL_MODE = "priConfigurationModifyPriForm:signalingEntry";
	String IPF_PRI1_IDLE_RESET_INT = "priConfigurationModifyPriForm:priIdleResetIntervalStrEntry";
	String SLC_PRI1_LINE_BUILD_OUT = "priConfigurationModifyPriForm:lboEntry";
	String IPF_PRI1_RECEIVE_GAIN = "priConfigurationModifyPriForm:receiveGainEntry";
	String SLC_PRI1_CODING = "priConfigurationModifyPriForm:codingEntry";
	String IPF_PRI1_TRANSMIT_GAIN = "priConfigurationModifyPriForm:transmitGainEntry";
	String CB_PRI1_CRC = "priConfigurationModifyPriForm:crcEntry";
	String IPF_PRI1_DEFAULT_DEST = "priConfigurationModifyPriForm:defaultDestEntry";
	String SLC_PRI1_CLOCK_SOURCE_PRIO = "priConfigurationModifyPriForm:clockSourcePriorityEntry";
	String CB_PRI1_ECHO_CANCEL = "priConfigurationModifyPriForm:echoCancelEntry";
	String CB_PRI1_FAR_END_DISC_INBAND_ANNOUNC = "priConfigurationModifyPriForm:disconAnnEntry";
	String CB_PRI1_CALLING_NAME_DELAY = "priConfigurationModifyPriForm:callingNameDelayEntry";
	String CB_PRI1_SEC_SCREENING_INDIC = "priConfigurationModifyPriForm:secondScreeningIndEntry";
	String CB_PRI1_DISABLE_FAR_END_RESTART = "priConfigurationModifyPriForm:disableFarEndRestartEntry";
	String CB_PRI1_SENDING_COMPLETE = "priConfigurationModifyPriForm:sendingCompleteEntry";
	String SLC_PRI1_SETUP_PROG_INDICATOR = "priConfigurationModifyPriForm:sendingCompleteEntry";
	String CB_PRI1_RESTART_LINK_STARTUP = "priConfigurationModifyPriForm:restartLinkEntry";
	String CB_PRI1_DATA_CALLS_ALLOWED = "priConfigurationModifyPriForm:restrictedDigitalInfoEntry";
	String CB_PRI1_SEND_CALLING_PARTY_NAME = "priConfigurationModifyPriForm:sendCallingPartyNameEntry";
	String SLC_PRI1_L3TRUNK_RESTART_TYPE = "priConfigurationModifyPriForm:sendCallingPartyNameEntry";
	String CB_PRI1_SEND_REDIRECTING_NUMBER = "priConfigurationModifyPriForm:redirectNumberEntry2";
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 CONFIGURATION -- (EDIT PORT 1 IN LIST PORT CONFIGURATION) -- TAB TIMERS
	String IPF_PRI1_T302_TIMER = "priConfigurationModifyPriForm:t302TimerStrEntry";
	String IPF_PRI1_T305_TIMER = "priConfigurationModifyPriForm:t305TimerStrEntry";
	String IPF_PRI1_T308_TIMER = "priConfigurationModifyPriForm:t308TimerStrEntry";
	String IPF_PRI1_T309_TIMER = "priConfigurationModifyPriForm:t309TimerStrEntry";
	String IPF_PRI1_T313_TIMER = "priConfigurationModifyPriForm:t313TimerStrEntry";
	// // INTEGRATED GATEWAYS CONFIGURATION -- PRI1 CONFIGURATION -- (EDIT PORT 1 IN LIST PORT CONFIGURATION) -- TAB CHANNELS
	String BTN_PRI1_ENABLE_ALL = "priConfigurationModifyPriForm:optionsTab:priChannelsListGrid:enableAll";
	String BTN_PRI1_DISABLE_ALL = "priConfigurationModifyPriForm:optionsTab:priChannelsListGrid:disableAll";
	String BTN_PRI1_EDIT = "priConfigurationModifyPriForm:optionsTab:priChannelsListGrid:editButton";
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 -- (CONFIGURE BUTTON) -- TAB CAS SETTINGS
	String BTN_PRI1_CAS_PROFILE = "priConfigurationForm:casAdvancedSettingsTab:casProfileButton";
	String CB_PRI1_ENABLE_CAS_ADVANCED_SETTINGS = "priConfigurationForm:casAdvancedSettingsTab:enableCasAdvancedSettings";
	String IPF_PRI1_TIMEOUT_MF_BACK_CYCLE = "priConfigurationForm:casAdvancedSettingsTab:mfBackResumeCycleEntry";
	String IPF_PRI1_CALL_FORWARD_SAFETY = "priConfigurationForm:casAdvancedSettingsTab:mfFwdSafetyEntry";
	String IPF_PRI1_WAIT_SEIZURE_ACKNOWLEDGEMENT = "priConfigurationForm:casAdvancedSettingsTab:r2SeizeEntry";
	String IPF_PRI1_WAIT_FOR_ANSWER = "priConfigurationForm:casAdvancedSettingsTab:r2AnswerEntry";
	String IPF_PRI1_DOUBLE_ANSWER = "priConfigurationForm:casAdvancedSettingsTab:r2DoubleAnswerEntry";
	String IPF_PRI1_ANSWER_DELAY = "priConfigurationForm:casAdvancedSettingsTab:r2AnswerDelayEntry";
	String IPF_PRI1_PERSISTENCE_CHECK = "priConfigurationForm:casAdvancedSettingsTab:casPersistenceCheckEntry";
	String IPF_PRI1_DTMF_START_DIAL = "priConfigurationForm:casAdvancedSettingsTab:dtmfStartDialEntry";
	String IPF_PRI1_MF_THRESHOLD_TIME = "priConfigurationForm:casAdvancedSettingsTab:mfThresholdTimeEntry";
	String IPF_PRI1_SPARE_TIMER1 = "priConfigurationForm:casAdvancedSettingsTab:spareTimer1Entry";
	String IPF_PRI1_SPARE_TIMER2 = "priConfigurationForm:casAdvancedSettingsTab:spareTimer2Entry";
	String IPF_PRI1_SPARE_TIMER3 = "priConfigurationForm:casAdvancedSettingsTab:spareTimer3Entry";
	String IPF_PRI1_SPARE_TIMER4 = "priConfigurationForm:casAdvancedSettingsTab:spareTimer4Entry";
	String IPF_PRI1_SPARE_TIMER5 = "priConfigurationForm:casAdvancedSettingsTab:spareTimer5Entry";
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI -- (CONFIGURE BUTTON) -- TAB CAS SETTINGS -- CAS PROFILE LIST
	String SLC_PRI1_DEFAULT_CAS_PROFILES = "casProfileListForm:casProfileEntry";
	String BTN_PRI1_ADD_PROFILE = "casProfileListForm:addCasProfileButton";
	String BTN_PRI1_ADD_BUTTON = "casProfileListForm:casProfileListGrid:addButton";
	String BTN_PRI1_EDIT_BUTTON = "casProfileListForm:casProfileListGrid:editButton";
	String BTN_PRI1_DELETE_BUTTON = "casProfileListForm:casProfileListGrid:deleteButton";
	//TEXTS (IN CAS PROFILES LIST) -- PRI1 retrieved from property files
	String TXT_CASPROFILELIST_PRI1_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.Name");
	String TXT_CASPROFILELIST_PRI1_MAXIMUM_AMOUNT_OF_ANI = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "casProfileList.maxAmountOfAni");
	String TXT_CASPROFILELIST_PRI1_MAXIMUM_AMOUNT_AMOUNT_OF_DNIS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "casProfileList.maxAmountDnis");
	String TXT_CASPROFILELIST_PRI1_MAXIMUM_WAITING_TIME_MF_BACK_TONE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "casProfileList.maxWaitingTime");
	String TXT_CASPROFILELIST_PRI1_METERING_PULSE_TIMEOUT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "casProfileList.meteringPulse");
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 -- (CONFIGURE BUTTON) -- TAB CAS SETTINGS -- CAS PROFILE BUTTON POP-UP -- ADD CAS PROFILE
	String IPF_PRI1_NAME = "casProfileEditForm:nameEntry";
	String CB_PRI1_ANI_BEFORE_DNIS = "casProfileEditForm:aniBeforeDnisEntry";
	String SLC_PRI1_MAXIMUM_AMOUNT_ANI = "casProfileEditForm:maxAniEntry";
	String SLC_PRI1_MAXIMUM_AMOUNT_DNIS = "casProfileEditForm:maxDnisEntry";
	String IPF_PRI1_MAXIMUM_WAIT_TIME_MF_BACK_TONE = "casProfileEditForm:mfbackTimeoutEntry";
	String IPF_PRI1_METERING_PULSE_TIMEOUT = "casProfileEditForm:meteringPulseTimeoutEntry";
	String CB_PRI1_IMMEDIATE_ACCEPT = "casProfileEditForm:skipGroupSignEntry";
	String CB_PRI1_FORCED_RELEASE = "casProfileEditForm:forcedReleaseEntry";
	String CB_PRI1_SKIP_CATEGORY = "casProfileEditForm:skipCategoryEntry";
	String CB_PRI1_CHARGE_CALLS = "casProfileEditForm:chargeCallEntry";
	//INTEGRATED GATEWAYS CONFIGURATION -- PRI1 -- TRUNK GROUP CONFIGURATION -- (TRUNK GROUP BUTTON)
	String BTN_PRI1_TRUNK_ADD = "form:grid:addButton";
	String BTN_PRI1_TRUNK_EDIT = "form:grid:editButton";
	String BTN_PRI1_TRUNK_DELETE = "form:grid:deleteButton";
	//TEXTS (IN TRUNK GROUP CONFIGURATION LIST) -- PRI1 retrieved from property files
	String TXT_TRUNKGROUPCONFIGURATION_PRI1_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "trunkGroupConfiguration.type");
	String TXT_TRUNKGROUPCONFIGURATION_PRI1_FQDN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "trunkGroupConfiguration.fqdn");
	String TXT_TRUNKGROUPCONFIGURATION_PRI1_TRUNK_GROUP_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "trunkGroupConfiguration.tgName");
	String TXT_TRUNKGROUPCONFIGURATION_PRI1_TRUNK_GROUP_SELECTION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "trunkGroupConfiguration.tgSelection");
	String TXT_TRUNKGROUPCONFIGURATION_PRI1_HUNT_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "trunkGroupConfiguration.huntType");
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 -- (ADD BUTTON) -- GENERAL TAB
	String IPF_PRI1_TRUNK_FQDN = "form:fqdnEntry";
	String IPF_PRI1_TRUNK_TRUNK_GROUP_NAME = "form:tgNameEntry";
	String SLC_PRI1_TRUNK_TRUNK_GROUP_SELECTION = "form:tgSelectionEntry";
	String SLC_PRI1_TRUNK_HUNT_TYPE = "form:huntTypeEntry";
	String SLC_PRI1_TRUNK_DIRECTION = "form:directionEntry";
	String CB_PRI1_TRUNK_MARK_SRTP_CALL_LEG_SECURE = "form:callLegSecureCheckbox";
	String IPF_PRI1_TRUNK_INTERNATIONAL_PNAC = "form:e6";
	String IPF_PRI1_TRUNK_INTERNATIONAL_PREFIX = "form:e7";
	String IPF_PRI1_TRUNK_NATIONAL_PNAC = "form:e8";
	String IPF_PRI1_TRUNK_NATIONAL_PREFIX = "form:e9";
	String IPF_PRI1_TRUNK_SUBSCRIBER_PNAC = "form:e10";
	String IPF_PRI1_TRUNK_SUBSCRIBER_PREFIX = "form:e11";
	String IPF_PRI1_TRUNK_COUNTRY_CODE = "form:e12";
	String IPF_PRI1_TRUNK_LOCAL_AREA_CODE = "form:e13";
	String IPF_PRI1_TRUNK_EXCHANGE_CODE = "form:e14";
	String CB_PRI1_TRUNK_TON_LENGTH_CHECK = "form:e15";
	String IPF_PRI1_TRUNK_NATIONAL_NUMBER_LENGTH = "form:natPnacLengthEntry";
	String IPF_PRI1_TRUNK_SUBSCRIBER_NUMBER_LENGTH = "form:subPnacLengthEntry";
	String SLC_PRI1_TRUNK_VOICE_TRANSFER_CAPABILITY = "form:voiceTransferCapabilityEntry";
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 -- (ADD BUTTON) -- CHANNELS LIST TAB
	String SLC_PRI1_TRUNK_AVAILABLE_CHANNELS = "form:interfaceEntry";
	String BTN_PRI1_TRUNK_AVAILABLE_CHANNELS_ADD = "form:addButton";
	String BTN_PRI1_TRUNK_AVAILABLE_CHANNELS_DELETE = "form:grid:deleteButton";
	//TEXTS (IN TRUNK GROUP CONFIGURATION LIST -- CHANNELS LIST) -- PRI1 retrieved from property files
	String TXT_TRUNKGROUPCONFIGURATION_PRI1_CHANNEL_LIST = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "trunkGroupConfiguration.priChannelsSelected");
	// INTEGRATED GATEWAYS CONFIGURATION -- PRI1 -- (ADD BUTTON) -- NUMBER MODIFICATION TAB
	String SLC_PRI1_TRUNK_MOD_EXCEPT_CALLED_PARTY_NUMBER_SURV_MODE = "form:e17";
	String SLC_PRI1_TRUNK_CALLED_NUMBER_TYPE_NUMBER_SURV_MODE = "form:incCalledTypeOfNumberField";
	String IPF_PRI1_TRUNK_MAX_LENGTH_OVERLAPPING_DIGITS = "form:maxOverlapDigitLengthEntry";
	String CB_PRI1_TRUNK_UKNOWN_PREFIXED_NUMBERS_FROM_PSTN = "form:e16";
	String SLC_PRI1_TRUNK_CALLING_PARTY_NUMBER_TYPE = "form:e18";
	String CB_PRI1_TRUNK_CALLING_PARTY_NUMBER_SET_TON_UKNOWN = "form:e19";
	String CB_PRI1_TRUNK_CALLING_PARTY_NUMBER_ADD_PREFIX = "form:e20";
	String SLC_PRI1_TRUNK_CALLED_PARTY_NUMBER_TYPE = "form:e21";
	String CB_PRI1_TRUNK_CALLED_PARTY_NUMBER_SET_TON_UKNOWN = "form:e22";
	String CB_PRI1_TRUNK_CALLED_PARTY_NUMBER_ADD_PREFIX = "form:e23";
	String IPF_PRI1_TRUNK_CALLED_PARTY_NUMBER_PRE_DIAL_DELAY_DTMF = "form:preDialDelayDtmfEntry";
	String SLC_PRI1_TRUNK_COLLECT_CALL_CONTROL = "form:collectCallControlEntry";
	String CB_PRI1_TRUNK_PERMISSION_COLLECT_CALLS_CATEGORY = "form:allowCollectCallsentry";
	String CB_PRI1_TRUNK_PERMISSION_COLLECT_CALLS_DOUBLE_ANSWER = "form:doubleAnswerEntry";
	String SLC_PRI1_TRUNK_CAS_PROFILE = "form:casProfileEntry";
	
	//INTEGRATED GATEWAYS CONFIGURATION -- TAB QOS MONITORING
	
	
	
}