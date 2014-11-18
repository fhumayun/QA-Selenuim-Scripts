package com.administration.configuration.survivability;

import com.Seleniumhelper.SeleniumWebdriver;


public interface PropertiesSurvivability {
	
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
	
	//TAB Multi line hunt groups
	String TB_MULTI_LINE_HG = "editSurvivability:huntingGroups_tab0";
	String TBL_LIST_MLHG = "editSurvivability:multiLineHundingGrid";
	String ITEMS_MULTI_LINE_HG = "editSurvivability:multiLineHundingGrid:multiLineHundingGrid_paging_pagingFirstElementLabel";
	String BTN_MULTI_LINE_HG_ADD = "editSurvivability:multiLineHundingGrid:addButton";
	String BTN_MULTI_LINE_HG_EDIT = "editSurvivability:multiLineHundingGrid:editButton";
	String BTN_MULTI_LINE_HG_DELETE = "editSurvivability:multiLineHundingGrid:deleteButton";
	String CB_MULTI_LINE_HG = "editSurivivabilityMultiLineHuntingGroupForm:enabled";
	String IPF_MULTI_LINE_HG_PILOT = "editSurivivabilityMultiLineHuntingGroupForm:pilotNumberValue";
	String SLC_MULTI_LINE_HG_PILOT_TYPE = "editSurivivabilityMultiLineHuntingGroupForm:pilotTypeField";
	String SLC_MULTI_LINE_HG_PILOT_HUNT_TYPE = "editSurivivabilityMultiLineHuntingGroupForm:huntTypeField";
	String IPF_MULTI_LINE_HG_NO_ANSWER = "editSurivivabilityMultiLineHuntingGroupForm:noAnswerAdvanceTimerField";
	String IPF_MULTI_LINE_HG_OVERFLOW = "editSurivivabilityMultiLineHuntingGroupForm:overflowDestinationField";
	String IPF_MULTI_LINE_HG_MEMBERS = "editSurivivabilityMultiLineHuntingGroupForm:membersField";
	//Texts (in Drop-Down Lists Pilot Type and Hunt Type) retrieved from property files
	String TXT_PILOT_TYPE_PILOT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "PILOT");
	String TXT_PILOT_TYPE_NON_PILOT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "NONPILOT");
	String TXT_HUNT_TYPE_PARALLEL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "PARALLEL");
	String TXT_HUNT_TYPE_LINEAR = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "LINEAR");
	String TXT_HUNT_TYPE_CYCLIC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "CYCLIC");
	String TXT_HUNT_TYPE_UCD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "UCD");
	//Texts (in list MLHG) retrieved from property files
	String TXT_LIST_MLHG_PILOT_NUMBER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.pilotName");
	String TXT_LIST_MLHG_PILOT_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.pilotType");
	String TXT_LIST_MLHG_HUNT_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.huntType");
	String TXT_LIST_MLHG_NO_ANSWER_TIMER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.noAnswerAdvanceTimer");
	String TXT_LIST_MLHG_OVERFLOW_DESTINATION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.overflowDest");
	String TXT_LIST_MLHG_MEMBERS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.members");
	String TXT_LIST_MLHG_ENABLED = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.enabled");

	
	//TAB EMERGENCY_ CALLING
	String TB_EMERGENCY_CALLING = "editSurvivability:emergencyCalling_tab1";
	String TBL_LIST_EMERGENCY_CALLING = "editSurvivability:emenrgencyTab:emergencyCallingGrid";
	String ITEMS_EMERGENCY_CALLING = "editSurvivability:emenrgencyTab:emergencyCallingGrid:emergencyCallingGrid_paging_pagingFirstElementLabel";
	String BTN_EMERGENCY_ADD = "editSurvivability:emenrgencyTab:emergencyCallingGrid:addButtonEmergency";
	String BTN_EMERGENCY_EDIT = "editSurvivability:emenrgencyTab:emergencyCallingGrid:editButtonEmergency";
	String BTN_EMERGENCY_DELETE = "editSurvivability:emenrgencyTab:emergencyCallingGrid:deleteButtonEmergency";
	String IPF_GENERAL_IP = "surivivabilityEmergencyCallingForm:ipAddressField";
	String IPF_GENERAL_SUBNET = "surivivabilityEmergencyCallingForm:subnetMaskField";
	String IPF_GENERAL_DEFAULT_DEST = "surivivabilityEmergencyCallingForm:callBackNumberField";
	String SLC_GENERIC_ROUTING_PREFIX = "surivivabilityEmergencyCallingForm:routingprefixvalue";
	String CB_GENERAL_LIN = "surivivabilityEmergencyCallingForm:sendLinValue";
	String TAB_LIN = "surivivabilityEmergencyCallingForm:linList_tab1";
	String TBL_LIST_LIN = "surivivabilityEmergencyCallingForm:linTab:linGrid";
	String BTN_LIN_EDIT = "surivivabilityEmergencyCallingForm:linTab:linGrid:editButtonLin";
	String IPF_LIN_FIELD = "linForm:linField";
	String IPF_LIN_CALLBACK = "linForm:callBackNumberField";
	String IPF_LIN_DEFAULT_CALLBACK = "linForm:defaultCallbackNumberField";
	String CB_LIN_USE_DEFAULT = "linForm:useDefaultCallbackNumberValue";
	//Texts (in list Emergency Calling) retrieved from property files
	String TXT_LIST_EMERGENCY_CALLING_IP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.ipaddress");
	String TXT_LIST_EMERGENCY_CALLING_SUBNET_MASK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.subNetMask");
	//String TXT_LIST_EMERGENCY_ROUTING_PREFIX = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.huntType");
	String TXT_LIST_EMERGENCY_ROUTING_DEFAULT_DESTINATION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.defaultDestination");
	String TXT_LIST_EMERGENCY_ROUTING_SEND_LIN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.linCpnCheckbox");
	//Texts (in list LIN) retrieved from property files
	String TXT_LIST_LIN_LIN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.lin");
	String TXT_LIST_LIN_CALLBACK_NUMBER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.callbackNumber");
	String TXT_LIST_LIN_DEFAULT_CALLBACK_NUMBER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.defaultCallbackNumber");
	String TXT_LIST_LIN_USE_DEFAULT_CALLBACK_NUMBER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.useDefaultCallbackNumber");

	
	//TAB Emergency number
	String TB_EMERGENCY_NUMBER = "editSurvivability:emergencyNumbers_tab2";
	String IPF_EMERGENCY_NUMBER_FIELD = "editSurvivability:emergencyNumberTab:emergencyNumberField";
	String ITEMS_EMERGENCY_NUMBER = "editSurvivability:emergencyNumberTab:emergencyNumbersGrid:emergencyNumbersGrid_paging_pagingFirstElementLabel";
	String BTN_EMERGENCY_NUMBER_ADD = "editSurvivability:emergencyNumberTab:addButton";
	String BTN_EMERGENCY_NUMBER_DELETE = "editSurvivability:emergencyNumberTab:emergencyNumbersGrid:deleteButton";
	
	//TAB Call detailed Records
	String TB_PROFILES_CALL_DETAILED_RECORDS = "editSurvivability:callDetailRecord_tab0";
	String TB_CALL_DETAILED_RECORDS_ACDmode = "editSurvivability:callDetailRecord_tab2";
	String TB_CALL_DETAILED_RECORDS = "editSurvivability:callDetailRecord_tab3";
	String CB_TICKET_GENERATION = "editSurvivability:callDetailRecordTab:enableCdr";
	String IPF_PRIMARY_HOSTNAME = "editSurvivability:callDetailRecordTab:hostnamevalue1";
	String IPF_PRIMARY_PASSWORD = "editSurvivability:callDetailRecordTab:passwordvalue1";
	String IPF_PRIMARY_USERNAME = "editSurvivability:callDetailRecordTab:usernamevalue1";
	String IPF_PRIMARY_CONFIRM_PASSWORD = "editSurvivability:callDetailRecordTab:confirmvalue1";
	String IPF_SECOND_HOSTNAME = "editSurvivability:callDetailRecordTab:hostnamevalue2";
	String IPF_SECOND_PASSWORD = "editSurvivability:callDetailRecordTab:passwordvalue2";
	String IPF_SECOND_USERNAME = "editSurvivability:callDetailRecordTab:usernamevalue2";
	String IPF_SECOND_CONFIRM_PASSWORD = "editSurvivability:callDetailRecordTab:confirmvalue2";
	String IPF_MAX_RECORD_VALUE = "editSurvivability:callDetailRecordTab:maxRecordvalue1";
	String IPF_MAX_TIME_INTERVAL = "editSurvivability:callDetailRecordTab:maxTimevalue1";
	String IPF_MAX_FILE_SIZE = "editSurvivability:callDetailRecordTab:maxFileSizeValue1";
	String SLC_TRANSFER_METHOD = "editSurvivability:callDetailRecordTab:transferMethodCombobox";
	String IPF_PORT = "editSurvivability:callDetailRecordTab:portValue";
	String IPF_RE_ATTEMPT = "editSurvivability:callDetailRecordTab:reattemptvalue";
	String CB_E164 = "editSurvivability:callDetailRecordTab:e164TranslationEnable";
	String CB_ALLOW_OVERWRITE = "editSurvivability:callDetailRecordTab:allowFile";
	String IPF_MATCH_DIGIT = "editSurvivability:callDetailRecordTab:e164MatchDigitvalue1";
	String IPF_TRNSLATION = "editSurvivability:callDetailRecordTab:e164Translationvalue1";
	String BTN_CONFIGURE_TRANSLATION = "editSurvivability:callDetailRecordTab:digitTranslationConfigure";
    //Digit Translation
	String BTN_ADD_DIGIT_TRANSLATION = "form:grid:addButton";
	String BTN_EDIT_DIGIT_TRANSLATION = "form:grid:editButton";
	String BTN_DELETE_DIGIT_TRANSLATION = "form:grid:deleteButton";
	String IPF_MATCHING_DIGITS = "form:e01";
	String IPF_TRANSLATION = "form:e02";
	
	//Texts (in Drop-Down List Transfer Method) retrieved from property files
	String TXT_TRANSFER_METHOD_PUSH = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.push");
	String TXT_TRANSFER_METHOD_PULL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSurvivability.pull");

	//TAB Music on hold
	String TB_PROFILES_MUSIC_ON_HOLD = "editSurvivability:musicOnHoldTab_tab1";
	String TB_MUSIC_ON_HOLD = "editSurvivability:musicOnHoldTab_tab4";
	String CB_ENABLE_MOH = "editSurvivability:musicOnHoldTab:musicOnHold";
	String CB_ENABLE_MOH_SUB = "editSurvivability:musicOnHoldTab:musicOnHoldSuscrb";
	
}
