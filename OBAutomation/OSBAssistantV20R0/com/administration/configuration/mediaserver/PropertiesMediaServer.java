package com.administration.configuration.mediaserver;



public interface PropertiesMediaServer {
	
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
	
	String CB_ENABLED = "editMediaServerForm:msCheckbox";
	
	//General
	String IPF_MS_LISTEN_PORT = "editMediaServerForm:mediaListentPortField";
	String SLC_LANGUAGE_SELECTION = "editMediaServerForm:languageCombobox";
	String BTN_CONFIGURE = "editMediaServerForm:advancedButton";
	String CB_USE_FQDN = "editMediaServerForm:useFqdnCheckbox";
	
	//Conference
	String IPF_CONFERENCE_PORT = "editMediaServerForm:conferencePortField";
	String IPF_MAX_CONFERENCE_TIME = "editMediaServerForm:maxInactiveConnperiodField";
	String CB_UNLIMITED_MAX_CONFERENE = "e05";
	String IPF_PAC = "editMediaServerForm:prefixAccessCodeField";
	
	//Announcement
	String IPF_CONFERENCE_ANNOUNCEMENT = "editMediaServerForm:announcementsConferencePortField";
	String IPF_MAX_ANNOUNCE_TIME = "editMediaServerForm:announcementsmaxInactiveConnperiodField";
	String CB_UNLIMITED_MAX_ANNOUNCEMENT = "e06";
	String CB_STOP_ANNOUNCEMENT = "editMediaServerForm:stopAnnouncementCheckbox";
	
	
	//Advanced Adapter
	String IPF_EXTERNAL_PORT = "editMediaServerAdvancedForm:externalPortField";
	String IPF_TIME_TO_LIVE = "editMediaServerAdvancedForm:adapterTimeToLiveField";
	String IPF_INTERNAL_PORT = "editMediaServerAdvancedForm:internalPortField";
	
	//Advanced Converter
	String IPF_SIP_PORT = "editMediaServerAdvancedForm:sipPortField";
	String IPF_MGCP = "editMediaServerAdvancedForm:mgcpPortField";
	
	String IPF_FILE = "editMediaServerAdvancedForm:language";
	String BTN_ADD = "editMediaServerAdvancedForm:addLanguageButton";
}
